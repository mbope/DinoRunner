package com.example.dinorunner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {
    BackgroundImage backgroundImage;
    Path path;
    Player player;
    PlayerDead playerDead;
    Random random;
    int score;
    Paint scorePaint;
    int playerFrame, playerJumpFrame, playerDeadFrame;
    ArrayList<Obstacles> obstaclesList;
    Obstacles obstacles;
    Obstacles obstacles1;
    Obstacles obstacles2;
    Obstacles obstacles3;
    Obstacles obstacles4;
    Bitmap obs;
    boolean obsSpawed;
    int points;
    int gameState;
    final int TEXT_SIZE = 80;
    boolean collision = false;
    MediaPlayer hit;
    boolean hitSound;

    public GameEngine(){
        backgroundImage = new BackgroundImage();
        path = new Path();
        player = new Player();
        playerDead = new PlayerDead();
        gameState = 1;//0;
        obsSpawed = false;
        playerFrame = 0;
        playerDeadFrame = 0;
        playerJumpFrame = 0;
        random = new Random();
        score = 0;
        scorePaint = new Paint();
        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(TEXT_SIZE);
        scorePaint.setTextAlign(Paint.Align.LEFT);
        obstaclesList = new ArrayList<Obstacles>();
        obstacles = new Obstacles("");
        obstacles1 = new Obstacles("smallEgg");
        obstacles2 = new Obstacles("mediumEgg");
        obstacles3 = new Obstacles("bigEgg");
        obstacles4 = new Obstacles("rottenEgg");
        obstaclesList.add(obstacles1);
        obstaclesList.add(obstacles2);
        obstaclesList.add(obstacles3);
        obstaclesList.add(obstacles4);
        points = 0;
        hitSound = false;
        hit = MediaPlayer.create(AppConstants.gameActivityContext,R.raw.jump);
    }

    public void updateAndDrawBackgroundImage(Canvas canvas){
        if(collision == false){
            backgroundImage.setBackgroundImageX(backgroundImage.getBackgroundImageX()- backgroundImage.getBackgroundImageVelocity());
            if(backgroundImage.getBackgroundImageX() < - AppConstants.getBitmapBank().getBackgroundWidth()){
                backgroundImage.setBackgroundImageX(0);
            }
        }
        // Draw the background image on canvas
        canvas.drawBitmap(AppConstants.bitmapBank.getBackground(), backgroundImage.getBackgroundImageX(), backgroundImage.getBackgroundImageY(),null);
        if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBackgroundImageX() + AppConstants.getBitmapBank().getBackgroundWidth(),backgroundImage.getBackgroundImageY(),null);
        }
    }

    public void updateAndDrawPath(Canvas canvas){
        if(collision == false){
            path.setPathX(path.getPathX() - path.getPathVelocity());
            if(path.getPathX() < -AppConstants.getBitmapBank().getPathWidth()){
                path.setPathX(0);
            }
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getPath(),path.getPathX(), path.getPathY(),null);
        if(path.getPathX() < - (AppConstants.getBitmapBank().getPathWidth() - AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX() + AppConstants.getBitmapBank().getPathWidth(),path.getPathY(),null);
        }
    }

    public void updateAndDrawPlayer(Canvas canvas){
        if(gameState == 1){
            if(collision == false && AppConstants.playerGrounded == false){
                player.setVelocity(player.getVelocity() + AppConstants.gravity);
                player.setpY(player.getpY() + player.getVelocity());
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerJump(playerJumpFrame),player.getpX(),player.getpY(),null);
                /*playerJumpFrame++;
                if(playerJumpFrame > 15){
                    playerJumpFrame = 0;
                }*/
                if(player.getpY() >= player.pYInitial){
                    player.setpY(player.pYInitial);
                    AppConstants.playerGrounded = true;
                }
            }
            else if(collision == true && AppConstants.playerGrounded == false){
                playerDead.setVelocity(playerDead.getVelocity() + AppConstants.gravity);
                playerDead.setpY(playerDead.getpY() + playerDead.getVelocity());
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(playerDeadFrame),playerDead.getpX(), playerDead.getpY(),null);
                /*playerDeadFrame++;
                if(playerDeadFrame == 17){
                    gameState = 2; // Game over state
                    // Go to game over activity
                    Context context = AppConstants.gameActivityContext;
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("points",points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }*/
                if(playerDead.getpY() >= playerDead.pYInitial){
                    playerDead.setpY(playerDead.pYInitial);
                    AppConstants.playerGrounded = true;
                }
                if(hitSound == false){
                    hit.start();
                    hitSound = true;
                }
            }
            else if(collision == true && AppConstants.playerGrounded){
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(playerDeadFrame), playerDead.getpX(), playerDead.getpY(),null);
                /*playerDeadFrame++;
                if(playerDeadFrame == 16){
                    gameState = 2; // Game over state
                    // Go to game over activity
                    Context context = AppConstants.gameActivityContext;
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("points",points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }*/
                if(playerDead.getpY() >= playerDead.pYInitial){
                    playerDead.setpY(playerDead.pYInitial);
                    AppConstants.playerGrounded = true;
                }
                if(hitSound == false){
                    hit.start();
                    hitSound = true;
                }
            }
            if(obstacles.cX <= player.pX + AppConstants.getBitmapBank().getPathWidth()
            && obstacles.cX + obstacles.width >= player.pX
            && obstacles.cY > player.pY
            && obstacles.cY <= player.pY + AppConstants.getBitmapBank().getPlayerHeight()){
                collision = true;
                obstacles.reset();
            }
            canvas.drawText("Pt: "+points, 0, TEXT_SIZE, scorePaint);
        }
    }

    public void updateAndDrawObstacles(Canvas canvas){
        if(gameState == 1){
            if(obsSpawed == false){
                int randIndex = random.nextInt(4);
                obstacles = obstaclesList.get(randIndex);
                obsSpawed = true;
            }
            if(collision == false){
                obstacles.cX -= obstacles.velocity;
                if(obstacles.type.equalsIgnoreCase("smallEgg")){
                    obs = AppConstants.getBitmapBank().getSmallEgg();
                }
                else if (obstacles.type.equalsIgnoreCase("mediumEgg")) {
                    obs = AppConstants.getBitmapBank().getMediumEgg();
                }
                else if(obstacles.type.equalsIgnoreCase("bigEgg")){
                    obs = AppConstants.getBitmapBank().getBigEgg();
                }
                else if(obstacles.type.equalsIgnoreCase("rottenEgg")){
                    obs = AppConstants.getBitmapBank().getRottenEgg();
                }
                canvas.drawBitmap(obs, obstacles.cX, obstacles.cY, null);
                if(obstacles.cX <= -AppConstants.getBitmapBank().getSmallEggWidth()){
                    obstacles.reset();
                    points++;
                    obsSpawed = false;
                }
            }
        }
    }

    public void tapTopStart(Canvas canvas){}
}
