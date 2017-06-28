package com.centa.aplusframework.contracts.base;

/**
 * Created by yanwenqiang on 2017/6/28.
 * <p>
 * 描述:MVP-Presenter基类
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    /**
     * View
     */
    protected final V selfView;

    /**
     * Modle
     */
    protected final M selfModel;

    public BasePresenter(V view, M model) {
        selfView = view;
        selfModel = model;
    }

}
