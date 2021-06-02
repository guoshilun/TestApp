package com.test.appe;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zhaotun on 15/11/3.
 */
public class DensityUtils {

    /**
     * 屏幕宽度(px)
     */
    public static int SCREEN_WIDTH_PIXELS;

    /**
     * 屏幕高度(px)
     */
    public static int SCREEN_HEIGHT_PIXELS;

    /**
     * 屏幕宽度(dp)
     */
    public static int SCREEN_WIDTH_DP;

    /**
     * 屏幕高度(dp)
     */
    public static int SCREEN_HEIGHT_DP;

    /**
     * 屏幕密度
     */
    public static float SCREEN_DENSITY = 0f;

    /**  */
    public static float SCREEN_SCALED_DENSITY = 0f;

    private static boolean mInitialed = false;

    private DensityUtils() {
    }

    public static void init(Context context) {
        if (mInitialed || context == null) {
            return;
        }

        mInitialed = true;
        DisplayMetrics dm = new DisplayMetrics();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            wm.getDefaultDisplay().getRealMetrics(dm);
        } else {
            try {
//                Display display = wm.getDefaultDisplay();
//                Method mGetRawWidth = Display.class.getMethod("getRawWidth");
//                Method mGetRawHeight = Display.class.getMethod("getRawHeight");
//                Integer realWidth = (Integer) mGetRawWidth.invoke(display);
//                Integer realHeight = (Integer) mGetRawHeight.invoke(display);

                wm.getDefaultDisplay().getMetrics(dm);
            } catch (Exception e) {
                dm = context.getResources().getDisplayMetrics();
            }
        }
        SCREEN_WIDTH_PIXELS = dm.widthPixels;
        SCREEN_HEIGHT_PIXELS = dm.heightPixels;
        SCREEN_DENSITY = dm.density;
        SCREEN_SCALED_DENSITY = dm.scaledDensity;
        SCREEN_WIDTH_DP = (int) (SCREEN_WIDTH_PIXELS / dm.density);
        SCREEN_HEIGHT_DP = (int) (SCREEN_HEIGHT_PIXELS / dm.density);
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     *
     * @param dipValue
     * @return
     */
    public static int dip2px(float dipValue) {
        return dip2px(null, dipValue);
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     *
     * @param context  上下文
     * @param dipValue dip的值
     * @return 转换成px的值
     */
    public static int dip2px(Context context, float dipValue) {
        if (SCREEN_DENSITY == 0) {
            init(context);
        }

        final float scale = SCREEN_DENSITY;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dip
     *
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue) {
        return px2dip(null, pxValue);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dip
     *
     * @param context 上下文
     * @param pxValue 待转换的px的值
     * @return 转换成dip的值
     */
    public static int px2dip(Context context, float pxValue) {
        if (SCREEN_DENSITY == 0) {
            init(context);
        }

        final float scale = SCREEN_DENSITY;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        return px2sp(null, pxValue);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param context 上下文
     * @param pxValue 待转换的px的值
     * @return 转换后的sp值
     */
    public static int px2sp(Context context, float pxValue) {
        if (SCREEN_SCALED_DENSITY == 0) {
            init(context);
        }

        final float fontScale = SCREEN_SCALED_DENSITY;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        return sp2px(null, spValue);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param context 上下文
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        if (SCREEN_SCALED_DENSITY == 0) {
            init(context);
        }

        final float fontScale = SCREEN_SCALED_DENSITY;
        return (int) (spValue * fontScale + 0.5f);
    }



}
