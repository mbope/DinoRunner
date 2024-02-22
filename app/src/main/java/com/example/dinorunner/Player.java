package com.example.dinorunner;

public class Player {
    public int pX, pY, pYInitial, currentFrame, velocity;

    public Player(){
        pX = AppConstants.SCREEN_WIDTH / 3 - AppConstants.getBitmapBank().getPlayerWidth();
        pYInitial = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathheight() - AppConstants.getBitmapBank().getPlayerHeight();
        pY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathheight() - AppConstants.getBitmapBank().getPlayerHeight();
        currentFrame = 0;
        velocity = 0;
    }

    public int getpX() {
        return pX;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public int getpY() {
        return pY;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }

    public int getpYInitial() {
        return pYInitial;
    }

    public void setpYInitial(int pYInitial) {
        this.pYInitial = pYInitial;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
