package com.term;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class AnimationUtil {
    /**
     * 渐透+扩大的动画效果+listener
     */
    public static void AlphaScaleAnimator(final View view, Animator.AnimatorListener listener) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 1, 0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX", 1, 1.4f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "scaleY", 1, 1.3f);
        animator1.setDuration(500);
        animator2.setDuration(500);
        animator3.setDuration(500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator1, animator2, animator3);
        // 要求 2： animator2 和 animator3 同时开始
        animatorSet.start();
        if (listener == null) {
            return;
        }
        animatorSet.addListener(listener);
    }
}
