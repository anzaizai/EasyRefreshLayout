package zaizai.com;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.chad.library.adapter.base.animation.BaseAnimation;

/**
 * Created by guanaj on 2016/10/31.
 */

public class MyAnimation implements BaseAnimation {
    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{(float)view.getMeasuredHeight()-180, 0.0F})};
    }
}
