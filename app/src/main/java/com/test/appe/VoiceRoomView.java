package com.test.appe;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VoiceRoomView extends RelativeLayout {
    private ImageView dot1, dot2, dot3;
    private ImageView dot5, dot4, dot6, dot7, dot8, dot9;
    private ItemVoiceRoomView item1, item2, item6, item9;
    private LinearLayout linearFirst, linearSecond;

    public VoiceRoomView(Context context) {
        super(context);
        init(context);
    }

    public VoiceRoomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VoiceRoomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private int marginLeftRight = DensityUtils.dip2px(0);
    private int marginTop = DensityUtils.dip2px(200);
    private int linarMarginTop = DensityUtils.dip2px(20);

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_voice_room_layout, this, true);
        dot1 = findViewById(R.id.view_dot1);
        dot2 = findViewById(R.id.view_dot2);
        dot3 = findViewById(R.id.view_dot3);
        dot4 = findViewById(R.id.view_dot4);
        dot5 = findViewById(R.id.view_dot5);
        dot6 = findViewById(R.id.view_dot6);
        dot7 = findViewById(R.id.view_dot7);
        dot8 = findViewById(R.id.view_dot8);
        dot9 = findViewById(R.id.view_dot9);


        item9 = findViewById(R.id.gift_0);
        item1 = findViewById(R.id.gift1);
        item2 = findViewById(R.id.gift2);
        item6 = findViewById(R.id.gift6);
        item1.setRippleColor(R.color.colorE94B59);
        item2.setRippleColor(R.color.color_00A1E9);
        item9.setRippleColor(R.color.colorE94B59);

        item9.setItemSize();
//        item6.setRippleColor(R.color.rippelStokenColor);
        linearFirst = findViewById(R.id.linear_first);
        linearSecond = findViewById(R.id.linear_second);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) linearFirst.getLayoutParams();
        params.setMargins(marginLeftRight, marginTop, marginLeftRight, 0);
        linearFirst.setLayoutParams(params);
        RelativeLayout.LayoutParams paramsSecond = (RelativeLayout.LayoutParams) linearSecond.getLayoutParams();
        paramsSecond.setMargins(marginLeftRight, linarMarginTop, marginLeftRight, 0);
        linearSecond.setLayoutParams(paramsSecond);
    }

    public void getItem1() {
        int itemWidth, fisrlineTop, secondlineTop, itemHeight;
        int screenWidth = DensityUtils.SCREEN_WIDTH_PIXELS - marginLeftRight * 2;


        int[] loc6 = new int[2];
        item6.getLocationInWindow(loc6);

        int[] locCenter = new int[2];//小礼物中间飘得
        dot1.getLocationInWindow(locCenter);

        //中间飘得礼物宽高
        int gfitwidth = DensityUtils.dip2px(60);

        //每个item礼物宽和搞
        itemWidth = DensityUtils.dip2px(88);
        itemHeight = DensityUtils.dip2px(88);
        int spaceX = (screenWidth - itemWidth * 4) / 3;

        int[] locItem1 = new int[2];
        item1.getLocationInWindow(locItem1);
        //第一行礼物上边距
        fisrlineTop = locItem1[1];

        //第一行礼物上边距
        secondlineTop = loc6[1];
        //动画基准位移
        int baseX = gfitwidth / 2 + locCenter[0] - itemWidth / 2;
        int baseY = gfitwidth / 2 + locCenter[1] - itemHeight / 2;

        //第一排第一个item
        int anim1X = locItem1[0] - baseX;
        int anim1Y = fisrlineTop - baseY;
        TranslateAnimation anim1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim1X, Animation.RELATIVE_TO_SELF, anim1Y);//设置平移的起点和终点
        anim1.setDuration(1000);
        dot1.startAnimation(anim1);


        //第二 排第一个item
//        int anim5X = loc0[0] - locCenter[0] + itemWidth / 2 - gfitwidth / 2;
        int anim5Y = secondlineTop - baseY;
        TranslateAnimation anim5 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim1X, Animation.RELATIVE_TO_SELF, anim5Y);//设置平移的起点和终点
        anim5.setDuration(1000);
        dot5.startAnimation(anim5);

        //第一排第二个item  gfitwidth / 2 + locCenter[0] - itemWidth / 2
        int anim2X = anim1X + spaceX + itemWidth;
        int anim2Y = fisrlineTop - baseY;
        TranslateAnimation anim2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim2X, Animation.RELATIVE_TO_SELF, anim2Y);//设置平移的起点和终点
        anim2.setDuration(1000);
        dot2.startAnimation(anim2);

        //第二排第二个item
//        int anim6X = locItem1[0] - locCenter[0] + itemWidth / 2 - gfitwidth / 2 + screenWidth / 4;
        int anim6Y = secondlineTop - baseY;
        TranslateAnimation anim6 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim2X, Animation.RELATIVE_TO_SELF, anim6Y);//设置平移的起点和终点
        anim6.setDuration(1000);
        dot6.startAnimation(anim6);

        int anim3X = anim2X + spaceX + itemWidth;
        int anim3Y = fisrlineTop - baseY;
        TranslateAnimation anim3 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim3X, Animation.RELATIVE_TO_SELF, anim3Y);//设置平移的起点和终点
        anim3.setDuration(1000);
        dot3.startAnimation(anim3);


//        int anim7X = locItem1[0] - locCenter[0] + itemWidth / 2 - gfitwidth / 2 + screenWidth / 2;
        int anim7Y = secondlineTop - baseY;
        TranslateAnimation anim7 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim3X, Animation.RELATIVE_TO_SELF, anim7Y);//设置平移的起点和终点
        anim7.setDuration(1000);
        dot7.startAnimation(anim7);


        int anim4X = anim3X + spaceX + itemWidth;
        int anim4Y = fisrlineTop - baseY;
        TranslateAnimation anim4 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim4X, Animation.RELATIVE_TO_SELF, anim4Y);//设置平移的起点和终点
        anim4.setDuration(1000);
        dot4.startAnimation(anim4);


//        int anim8X = locItem1[0] -baseX+ screenWidth / 4 * 3;
        int anim8Y = secondlineTop - baseY;
        TranslateAnimation anim8 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim4X, Animation.RELATIVE_TO_SELF, anim8Y);//设置平移的起点和终点
        anim8.setDuration(1000);
        dot8.startAnimation(anim8);


        int[] loc9 = new int[2];
        item9.getLocationInWindow(loc9);
        int item9Width = DensityUtils.dip2px(108);
        int item9Height = DensityUtils.dip2px(128);
        int anim9X = loc9[0] - locCenter[0] + item9Width / 2 - gfitwidth / 2;
        int anim9Y = loc9[1] - locCenter[1] - gfitwidth / 2 + item9Height / 2;
        TranslateAnimation anim9 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, anim9X, Animation.RELATIVE_TO_SELF, anim9Y);//设置平移的起点和终点
        anim9.setDuration(1000);
        dot9.startAnimation(anim9);
    }
}
