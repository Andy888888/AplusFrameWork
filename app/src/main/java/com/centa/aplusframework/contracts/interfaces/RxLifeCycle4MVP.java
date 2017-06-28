package com.centa.aplusframework.contracts.interfaces;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.ActivityEvent;

/**
 * Created by yanwenqiang on 2017/6/28.
 * <p>
 * 描述:为MVP模式中的[P]添加RxLifeCycle提供的RxAppcompatActivity中的生命周期绑定方法；最终调用Activity中的方法.
 * 无需手动实现以下接口方法，因为以下方法是从{@link com.trello.rxlifecycle.components.support.RxAppCompatActivity} 中复制而来
 */
public interface RxLifeCycle4MVP {

    /**
     * 生命周期绑定
     */
    <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event);
}
