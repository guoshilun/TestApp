package com.test.appe;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class RippleBackground extends RelativeLayout {

    private static final int DEFAULT_RIPPLE_COUNT = 5;
    private static final int DEFAULT_DURATION_TIME = 5000;
    private static final float DEFAULT_SCALE = 6.0f;
    private static final int DEFAULT_FILL_TYPE = 0;

    private int rippleColor;
    private float rippleStrokeWidth;
    private float rippleRadius;
    private int rippleDurationTime;
    private int rippleAmount;
    private int rippleDelay;
    private float rippleScale;
    private int rippleType;
    private Paint paint;
    private boolean animationRunning = false;
    private AnimatorSet animatorSet;
    private ArrayList<Animator> animatorList;
    private LayoutParams rippleParams;
    private ArrayList<RippleView> rippleViewList = new ArrayList<RippleView>();

    public RippleBackground(Context context) {
        super(context);
    }

    public RippleBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RippleBackground(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, final AttributeSet attrs) {
        if (isInEditMode()) return;

        if (null == attrs) {
            throw new IllegalArgumentException("Attributes should be provided to this view,");
        }

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RippleBackground);
        rippleColor = typedArray.getColor(R.styleable.RippleBackground_rb_color, getResources().getColor(R.color
                .rippelColor));
        rippleStrokeWidth = typedArray.getDimension(R.styleable.RippleBackground_rb_strokeWidth, getResources()
                .getDimension(R.dimen.rippleStrokeWidth));
        rippleRadius = typedArray.getDimension(R.styleable.RippleBackground_rb_radius, getResources().getDimension(R
                .dimen.rippleRadius));
        rippleDurationTime = typedArray.getInt(R.styleable.RippleBackground_rb_duration, DEFAULT_DURATION_TIME);
        rippleAmount = typedArray.getInt(R.styleable.RippleBackground_rb_rippleAmount, DEFAULT_RIPPLE_COUNT);
        rippleScale = typedArray.getFloat(R.styleable.RippleBackground_rb_scale, DEFAULT_SCALE);
        rippleType = typedArray.getInt(R.styleable.RippleBackground_rb_type, DEFAULT_FILL_TYPE);
        typedArray.recycle();

        rippleDelay = rippleDurationTime / rippleAmount;
        Log.e("tag", rippleDelay + "");
        paint = new Paint();
        paint.setAntiAlias(true);
        if (rippleType == DEFAULT_FILL_TYPE) {
            rippleStrokeWidth = 2;
            paint.setStyle(Paint.Style.FILL);
        } else paint.setStyle(Paint.Style.STROKE);
        paint.setColor(rippleColor);

        int w = new Double(Math.ceil(2 * (rippleRadius + rippleStrokeWidth))).intValue();
        rippleParams = new LayoutParams(w, w);
        rippleParams.addRule(CENTER_IN_PARENT, TRUE);

        animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorList = new ArrayList<>();

        for (int i = 0; i < rippleAmount; i++) {
            RippleView rippleView = new RippleView(getContext());
            addView(rippleView, rippleParams);
            rippleViewList.add(rippleView);
            final ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(rippleView, "ScaleX", 1.0f, rippleScale);
            scaleXAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            scaleXAnimator.setRepeatMode(ObjectAnimator.RESTART);
            scaleXAnimator.setStartDelay(i * rippleDelay);
            scaleXAnimator.setDuration(rippleDurationTime);
            animatorList.add(scaleXAnimator);
            final ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(rippleView, "ScaleY", 1.0f, rippleScale);
            scaleYAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            scaleYAnimator.setRepeatMode(ObjectAnimator.RESTART);
            scaleYAnimator.setStartDelay(i * rippleDelay);
            scaleYAnimator.setDuration(rippleDurationTime);
            animatorList.add(scaleYAnimator);
            final ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(rippleView, "Alpha", 1.0f, 0f);
            alphaAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            alphaAnimator.setRepeatMode(ObjectAnimator.RESTART);
            alphaAnimator.setStartDelay(i * rippleDelay);
            alphaAnimator.setDuration(rippleDurationTime);
            animatorList.add(alphaAnimator);
        }

        animatorSet.playTogether(animatorList);
        startRippleAnimation();
    }

    private class RippleView extends View {

        //        private Paint p;
        private PaintFlagsDrawFilter pfd;

//        public void setColor(int color) {
//            if (p != null) {
//        p.setColor(color);
//            }
//        }

        public RippleView(Context context) {
            super(context);
//            this.setVisibility(View.INVISIBLE);
//            p = new Paint();
//            p.setStyle(Paint.Style.STROKE);
//            p.setColor(rippleColor);
//            p.setAntiAlias(true);
//            pfd = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.setDrawFilter(pfd);
            int radius = (Math.min(getWidth(), getHeight())) / 2;
            canvas.drawCircle(radius, radius, radius - rippleStrokeWidth, paint);
//            canvas.drawCircle(radius, radius, radius - rippleStrokeWidth, p);
        }
    }

    public void startRippleAnimation() {
//        if (!isRippleAnimationRunning()) {
        for (RippleView rippleView : rippleViewList) {
            rippleView.setVisibility(VISIBLE);
//            rippleView. setColor(rippleColor);
        }
        animatorSet.start();
        animationRunning = true;
//        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void stopRippleAnimation() {
        if (isRippleAnimationRunning()) {
            animatorSet.pause();
            for (RippleView rippleView : rippleViewList) {
                rippleView.setVisibility(INVISIBLE);
            }
            animationRunning = false;
        }
    }

    public void setColor(int color) {
//        this.color = color;
        this.rippleColor = getContext().getResources().getColor(color);
//        Log.e("color", "" + this.color);
        paint.setColor(this.rippleColor);
//        invalidate();
    }

    public void setSize(float radius) {
        int w = new Double(Math.ceil(2 * (radius + rippleStrokeWidth))).intValue();
        rippleParams = new LayoutParams(w, w);
        rippleParams.addRule(CENTER_IN_PARENT, TRUE);

        for (RippleView rippleView : rippleViewList) {
            RelativeLayout.LayoutParams params = (LayoutParams) rippleView.getLayoutParams();
            params.width = w;
            params.height = w;
            rippleParams.addRule(CENTER_IN_PARENT, TRUE);
            rippleView.setLayoutParams(params);
//            rippleView. setColor(rippleColor);
        }
    }

    public boolean isRippleAnimationRunning() {
        return animationRunning;
    }
}
