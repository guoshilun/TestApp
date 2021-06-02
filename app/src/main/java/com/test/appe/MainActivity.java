package com.test.appe;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //    private ImageView iv1, iv2, iv3, iv4;
    private VoiceRoomView roomView;
    //    private TextView dot;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
//            setAnim();
            return false;
        }
    });
    private RippleBackground rippleBackground;
    private RippleBackground ripple1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roomView = (VoiceRoomView) findViewById(R.id.room_view);
        rippleBackground = (RippleBackground) findViewById(R.id.ripp);
        rippleBackground.startRippleAnimation();

        ripple1 = (RippleBackground) findViewById(R.id.ripp1);
        ripple1.startRippleAnimation();
//        dot = (TextView) findViewById(R.id.view_dot);
//        iv1 = (ImageView) findViewById(R.id.iv_wave);
//        iv2 = (ImageView) findViewById(R.id.iv_wave_1);
//        iv3 = (ImageView) findViewById(R.id.iv_wave_2);
//        setAnim1();
//        setAnim2();
/*        mWaveView.setDuration(5000);
        mWaveView.setStyle(Paint.Style.STROKE);
        mWaveView.setSpeed(400);
        mWaveView.setColor(Color.RED);
        mWaveView.setInterpolator(new AccelerateInterpolator(1.2f));
        mWaveView.start();*/

//        mWaveView.setDuration(6000);
//        mWaveView.setStyle(Paint.Style.FILL);
//        mWaveView.setColor(Color.RED);
//        mWaveView.setInterpolator(new LinearOutSlowInInterpolator());
//        mWaveView.start();
//        iv4 = (ImageView) findViewById(R.id.iv_gift4);
//        ivCenter = (ImageView) findViewById(R.id.iv_center);
//        ivCenter.setOnClickListener(    new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int[] loc = new int[2];
//                ivCenter.getLocationInWindow(loc);
//
//                int[] loc1 = new int[2];
//                iv1.getLocationInWindow(loc1);
//
//                int[] loc0 = new int[2];
//                iv0.getLocationInWindow(loc0);
//
//                int anim1 = ivCenter.getLeft() - iv1.getLeft() - (ivCenter.getWidth() / 2);
//                int anim2 = ivCenter.getLeft() - iv2.getLeft() - (ivCenter.getWidth() / 2);
//                int anim3 = ivCenter.getLeft() - iv3.getLeft() - (ivCenter.getWidth() / 2);
//                int anim4 = ivCenter.getLeft() - iv4.getLeft() - (ivCenter.getWidth() / 2);
//                int anim0 = ivCenter.getLeft() - iv0.getLeft();
//                setAnim(anim0, anim1, anim2, anim3, anim4);
//                Log.e("tag", loc[0] + " " + loc[1] + "  " + loc1[0] + " " + loc1[1] + " " + loc0[1]);
//            }
//        });
//        Log.e("tag", iv4.getY() + "");

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (isStart) {
//                    rippleBackground.stopRippleAnimation();
//                    ripple1.stopRippleAnimation();
//                } else {
//                    rippleBackground.startRippleAnimation();
//                    ripple1.startRippleAnimation();
//                }
//                isStart = !isStart;


//                int[] loc0 = new int[2];
//                iv4.getLocationInWindow(loc0);
//                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(10, 10);
//                params.setMargins(loc0[0]+ iv1.getWidth() / 2-5, (int) iv4.getY() + iv1.getHeight() / 2-5, 0, 0);
//                dot.setLayoutParams(params);
                roomView.getItem1();
//                Log.e("tag", "loc:" + loc0[0] + "  " + iv1.getWidth() + "  " + iv1.getHeight());
            }
        });
    }

    boolean isStart = false;
    //    private void setAnim(int anim0, int anim1, int anim2, int anim3, int anim4) {
//        TranslateAnimation translateAnimation0 = new TranslateAnimation(anim0, 0, 1360 - 400, 0);//设置平移的起点和终点
//        TranslateAnimation translateAnimation1 = new TranslateAnimation(anim1, 0, 1360 - 800, 0);//设置平移的起点和终点
//        TranslateAnimation translateAnimation2 = new TranslateAnimation(anim2, 0, 1360 - 800, 0);//设置平移的起点和终点
//        TranslateAnimation translateAnimation3 = new TranslateAnimation(anim3, 0, 1360 - 800, 0);//设置平移的起点和终点
//        TranslateAnimation translateAnimation4 = new TranslateAnimation(anim4, 0, 1360 - 800, 0);//设置平移的起点和终点
//
//
//        translateAnimation0.setDuration(1000);//动画持续的时间为10s
//        translateAnimation1.setDuration(1000);//动画持续的时间为10s
//        translateAnimation2.setDuration(1000);//动画持续的时间为10s
//        translateAnimation3.setDuration(1000);//动画持续的时间为10s
//        translateAnimation4.setDuration(1000);//动画持续的时间为10s
//
//        iv0.startAnimation(translateAnimation0);
//        iv1.startAnimation(translateAnimation1);
//        iv2.startAnimation(translateAnimation2);
//        iv3.startAnimation(translateAnimation3);
//        iv4.startAnimation(translateAnimation4);
//        translateAnimation0.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                iv0.clearAnimation();
////                iv0.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        translateAnimation1.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                iv1.clearAnimation();
////                iv1.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        translateAnimation4.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                iv4.clearAnimation();
////                iv4.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//    }
    private static final int ANIMATION_EACH_OFFSET = 800; // 每个动画的播放时间间隔
    private static final int RIPPLE_VIEW_COUNT = 3;//波纹view的个数
    private static final float DEFAULT_SCALE = 1.8f;//波纹放大后的大小
    private float mScale = DEFAULT_SCALE;
//    private void setAnim1() {
//        AnimationSet as = new AnimationSet(true);
//        ScaleAnimation sa = new ScaleAnimation(1f, mScale, 1f, mScale,
//                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
//                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
//        sa.setDuration(ANIMATION_EACH_OFFSET * 3);
//        sa.setRepeatCount(-1);// 设置循环
//        AlphaAnimation aniAlp = new AlphaAnimation(1, 0.1f);
//        aniAlp.setRepeatCount(-1);// 设置循环
//        as.setDuration(ANIMATION_EACH_OFFSET * 3);
//        as.addAnimation(sa);
//        as.addAnimation(aniAlp);
//
//        android:fillAfter="true"
//        android:fillBefore="false"
//        android:repeatMode="reverse"
//        AnimationSet as = new AnimationSet(true);
//        //缩放动画，以中心从原始放大到1.4倍
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.3f, 1.0f, 1.3f,
//                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
//                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
//        //渐变动画
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
//        scaleAnimation.setDuration(1000);
////        scaleAnimation.setFillAfter(true);
////        scaleAnimation.setFillBefore(false);
//
//        scaleAnimation.setRepeatMode(Animation.INFINITE);
//        alphaAnimation.setRepeatMode(Animation.INFINITE);
//
//
//        scaleAnimation.setRepeatCount(Animation.INFINITE);
//        alphaAnimation.setRepeatCount(Animation.INFINITE);
//
////        alphaAnimation.setFillAfter(true);
////        alphaAnimation.setFillBefore(false);
//
//
//        as.setDuration(1000);
//        as.addAnimation(scaleAnimation);
//        as.addAnimation(alphaAnimation);
//        iv1.startAnimation(as);
//    }

//    private void setAnim2() {
//        AnimationSet as = new AnimationSet(true);
//        //缩放动画，以中心从1.4倍放大到1.8倍
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.6f, 1.3f, 1.6f,
//                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
//                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
//        //渐变动画
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.1f);
//        scaleAnimation.setDuration(1000);
//
//        scaleAnimation.setRepeatCount(Animation.INFINITE);
//        alphaAnimation.setRepeatCount(Animation.INFINITE);
//
//        scaleAnimation.setRepeatMode(Animation.INFINITE);
//        alphaAnimation.setRepeatMode(Animation.INFINITE);
//
//
//        as.setDuration(1000);
//        as.addAnimation(scaleAnimation);
//        as.addAnimation(alphaAnimation);
//        iv2.startAnimation(as);
//    }
}
