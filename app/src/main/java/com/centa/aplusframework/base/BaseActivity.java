package com.centa.aplusframework.base;

import android.content.Context;

import com.centa.aplusframework.contracts.base.BaseView;
import com.centa.centacore.base.AbsActivity;

/**
 * Created by yanwenqiang on 2017/6/26.
 * <p>
 * 描述:业务层Activity基类
 */
public abstract class BaseActivity extends AbsActivity implements BaseView {
    // TODO: 2017/6/26 计划加入框架的内容
    // 1.热更新
    // 2.EventBus
    // 3.添加常用的HttpTransformer
    // 4.MVP项目结构
    // 5.FakeInterceptor 的完善
    // 6.BridgeJavaScript
    // 7.Litepal gradle 方式引入最新版本        ok


    @Override
    public Context getContext() {
        return getContext();
    }
}
