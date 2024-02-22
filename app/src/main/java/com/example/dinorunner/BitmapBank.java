package com.example.dinorunner;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {
    Bitmap background;
    Bitmap path;
    Bitmap[] player = new Bitmap[1];
    Bitmap[] playerJump = new Bitmap[1];
    Bitmap[] playerDead = new Bitmap[1];
    Bitmap smallEgg;
    Bitmap mediumEgg;
    Bitmap bigEgg;
    Bitmap rottenEgg;
    Bitmap stone;
    Bitmap tapToStart;

    public BitmapBank(Resources res){
        background = BitmapFactory.decodeResource(res, R.drawable.bg);
        background = scaleImage(background);
        path = BitmapFactory.decodeResource(res, R.drawable.path);
        // TODO: set all player images
        // e.g player[0..10] = BitmapFactory.decodeResource(res, R.drawable.run1...11);
        player[0] = BitmapFactory.decodeResource(res, R.drawable.dino_64);
        // TODO: set all jumping images
        playerJump[0] = BitmapFactory.decodeResource(res,R.drawable.dino_64);
        // TODO: set all dead images
        playerDead[0] = BitmapFactory.decodeResource(res, R.drawable.dino_64);

        // TODO: set bitmaps for eggs
        smallEgg = BitmapFactory.decodeResource(res, R.drawable.egg72);
        mediumEgg = BitmapFactory.decodeResource(res, R.drawable.egg72);
        bigEgg = BitmapFactory.decodeResource(res, R.drawable.egg72);
        rottenEgg = BitmapFactory.decodeResource(res, R.drawable.egg72);
    }

    public Bitmap getBackground() {
        return background;
    }

    public int getBackgroundWidth(){
        return background.getWidth();
    }

    public int getBackgroundHeight(){
        return  background.getHeight();
    }

    public Bitmap getPath() {
        return path;
    }

    public int getPathWidth(){
        return path.getWidth();
    }

    public int getPathheight(){
        return path.getHeight();
    }

    public Bitmap getPlayer(int pFrame){
        return player[pFrame];
    }

    public int getPlayerWidth(){
        return player[0].getWidth();
    }

    public int getPlayerHeight(){
        return player[0].getHeight();
    }

    public Bitmap getPlayerJump(int frame){
        return playerJump[frame];
    }

    public Bitmap getPlayerDead(int frame){
        return playerDead[frame];
    }

    public int getPlayerDeadWidth(){
        return playerDead[0].getWidth();
    }

    public int getPlayerDeadHeight(){
        return playerDead[0].getHeight();
    }

    public Bitmap getSmallEgg() {
        return smallEgg;
    }

    public int getSmallEggWidth(){
        return smallEgg.getWidth();
    }

    public int getSmallEggHeight(){
        return smallEgg.getHeight();
    }

    public Bitmap getMediumEgg() {
        return mediumEgg;
    }

    public int getMediumEggWidth(){
        return mediumEgg.getWidth();
    }

    public int getMediumEggHeight(){
        return mediumEgg.getHeight();
    }

    public Bitmap getBigEgg() {
        return bigEgg;
    }

    public int getBigEggWidth(){
        return bigEgg.getWidth();
    }

    public int getBigEggHeight(){
        return bigEgg.getHeight();
    }

    public Bitmap getRottenEgg() {
        return rottenEgg;
    }

    public int getRottenEggWidth(){
        return rottenEgg.getWidth();
    }

    public int getRottenEggHeight(){
        return rottenEgg.getHeight();
    }

    public Bitmap getTapToStart() {
        return tapToStart;
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap,backgroundScaledWidth,AppConstants.SCREEN_HEIGHT,false);
    }
}
