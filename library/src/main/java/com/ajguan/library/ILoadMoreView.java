package com.ajguan.library;

import android.view.View;

/**
 * Created by guanaj on 16/9/22.
 */

public interface ILoadMoreView {
    void reset();

    void loading();

    void loadComplete();

    void loadFail();

    void loadNothing();

    View getCanClickFailView();


}
