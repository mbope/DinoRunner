package com.example.dinorunner;

public class Path {
    private int pathX, pathY, pathVelocity;

    public Path(){
        pathX = 0;
        pathY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathheight();
        pathVelocity = 15;
    }

    public int getPathX() {
        return pathX;
    }

    public void setPathX(int pathX) {
        this.pathX = pathX;
    }

    public int getPathY() {
        return pathY;
    }

    public void setPathY(int pathY) {
        this.pathY = pathY;
    }

    public int getPathVelocity() {
        return pathVelocity;
    }

    public void setPathVelocity(int pathVelocity) {
        this.pathVelocity = pathVelocity;
    }
}
