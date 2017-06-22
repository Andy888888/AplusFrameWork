package com.centa.centacore.interfaces;

/**
 * Created by yanwenqiang on 2017/6/22.
 * <p>
 * 描述:为桥接Activity的snack
 */
public interface ISnack {

    /**
     * 显示snack
     *
     * @param text 文本
     */
    void showSnack(CharSequence text);
}
