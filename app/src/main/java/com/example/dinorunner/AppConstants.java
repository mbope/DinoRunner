package com.example.dinorunner;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {
    static BitmapBank bitmapBank;
    static GameEngine gameEngine;
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static int VELOCITY_WHEN_JUMPED;
    static int VELOCITY_WHEN_OBSTACLES;
    static Context gameActivityContext;
    static boolean playerGrounded;

    public static void initialize(Context context){
        setScreenSize(context);
        AppConstants.gameActivityContext = context;
        bitmapBank = new BitmapBank(context.getResources());
        setGameConstants();
        gameEngine = new GameEngine();
    }

    public static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        AppConstants.SCREEN_WIDTH = dm.widthPixels;
        AppConstants.SCREEN_HEIGHT = dm.heightPixels;
    }

    public static void setGameConstants(){
        AppConstants.gravity = 3;
        AppConstants.VELOCITY_WHEN_JUMPED = -40;
        AppConstants.VELOCITY_WHEN_OBSTACLES = 45;
        AppConstants.playerGrounded = true;
    }

    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    public static GameEngine getGameEngine(){
        return gameEngine;
    }
}
