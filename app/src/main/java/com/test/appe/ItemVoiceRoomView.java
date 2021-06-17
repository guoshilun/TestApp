package com.test.appe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ItemVoiceRoomView extends RelativeLayout {
    private ImageView ivGift0;

//    private ImageView iv1, iv2, iv3, iv4;
    private TextView tvMicroName;

    public ItemVoiceRoomView(Context context) {
        super(context);
        init(context);
    }

    public ItemVoiceRoomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ItemVoiceRoomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private LinearLayout linearRoot;
    private RippleBackground spreadView;
    private RelativeLayout itemRelate;

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_view_voice_room_layout, this, true);
//        iv1 = (ImageView) findViewById(R.id.iv_wave);
//        iv2 = (ImageView) findViewById(R.id.iv_wave_1);
//        iv3 = (ImageView) findViewById(R.id.iv_wave_2);
        tvMicroName = findViewById(R.id.tv_micro);
        spreadView = findViewById(R.id.spreadview);
        ivGift0 = findViewById(R.id.gift0);
        linearRoot = findViewById(R.id.linear_root);
        itemRelate = findViewById(R.id.item_relate);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(DensityUtils.dip2px(88), DensityUtils.dip2px(108));
        linearRoot.setLayoutParams(params);
        tvMicroName.setSelected(true);
    }

    public void setItemSize() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(DensityUtils.dip2px(108), DensityUtils.dip2px(128));
        linearRoot.setLayoutParams(params);

        RelativeLayout.LayoutParams paramsAdd = new RelativeLayout.LayoutParams(DensityUtils.dip2px(60), DensityUtils.dip2px(60));
        paramsAdd.addRule(CENTER_IN_PARENT, TRUE);
        ivGift0.setLayoutParams(paramsAdd);

        RelativeLayout.LayoutParams paramSpread = new RelativeLayout.LayoutParams(DensityUtils.dip2px(88), DensityUtils.dip2px(88));
        paramSpread.addRule(CENTER_IN_PARENT, TRUE);
        spreadView.setLayoutParams(paramSpread);
        spreadView.setSize(getResources().getDimension(R
                .dimen.dp_12));
        LinearLayout.LayoutParams paramRelate = new LinearLayout.LayoutParams(DensityUtils.dip2px(88), DensityUtils.dip2px(88));
        itemRelate.setLayoutParams(paramRelate);
    }

    public void setRippleColor(int color) {
        if (spreadView != null) {
            spreadView.setColor(color);
        }
    }

    public void setMicroName(String name, boolean isSelect) {
        tvMicroName.setSelected(isSelect);
        tvMicroName.setText(name);
    }
}
