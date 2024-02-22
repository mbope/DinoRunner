package com.example.dinorunner;

import java.util.Random;

public class Obstacles {
    public int cX, cY;
    public String type;
    public int velocity;
    public int width;
    Random random;

    public Obstacles(String type){
        this.type = type;
        cX = AppConstants.SCREEN_WIDTH + 1000;
        cY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathheight();
        random = new Random();

        if(type.equalsIgnoreCase("smallEgg")){
            cY -= AppConstants.getBitmapBank().getSmallEggHeight();
            velocity = AppConstants.VELOCITY_WHEN_OBSTACLES + 14 + random.nextInt(5);
            width = AppConstants.getBitmapBank().getSmallEggWidth();
        }
        else if(type.equalsIgnoreCase("mediumEgg")){
            cY -= AppConstants.getBitmapBank().getMediumEggHeight();
            velocity = AppConstants.VELOCITY_WHEN_OBSTACLES + 12 + random.nextInt(5);
            width = AppConstants.getBitmapBank().getMediumEggWidth();
        }
        else if(type.equalsIgnoreCase("bigEgg")){
            cY -= AppConstants.getBitmapBank().getBigEggHeight();
            velocity = AppConstants.VELOCITY_WHEN_OBSTACLES + 11 + random.nextInt(5);
            width = AppConstants.getBitmapBank().getBigEggWidth();
        }
        else if(type.equalsIgnoreCase("rottenEgg")){
            cY -= AppConstants.getBitmapBank().getRottenEggHeight();
            velocity = AppConstants.VELOCITY_WHEN_OBSTACLES + 15 + random.nextInt(5);
            width = AppConstants.getBitmapBank().getRottenEggWidth();
        }
    }

    public void reset(){
        cX = AppConstants.SCREEN_WIDTH + 300;
        if(type.equalsIgnoreCase("smallEgg")){
            this.velocity = AppConstants.VELOCITY_WHEN_OBSTACLES + 14 + random.nextInt(5);
        }
        else if(type.equalsIgnoreCase("mediumEgg")){
            this.velocity = AppConstants.VELOCITY_WHEN_OBSTACLES + 12 + random.nextInt(5);
        }
        else if(type.equalsIgnoreCase("bigEgg")){
            this.velocity = AppConstants.VELOCITY_WHEN_OBSTACLES + 11 + random.nextInt(5);
        }
        else if(type.equalsIgnoreCase("rottenEgg")){
            this.velocity = AppConstants.VELOCITY_WHEN_OBSTACLES + 15 + random.nextInt(5);
        }
    }
}
