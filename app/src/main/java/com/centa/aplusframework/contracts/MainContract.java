package com.centa.aplusframework.contracts;

import com.centa.aplusframework.contracts.base.BaseModel;
import com.centa.aplusframework.contracts.base.BasePresenter;
import com.centa.aplusframework.contracts.base.BaseView;
import com.centa.aplusframework.contracts.interfaces.RxLifeCycle4MVP;
import com.centa.aplusframework.model.respdo.APlusRespDo;
import com.centa.aplusframework.model.respdo.PermUserInfoDo;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by yanwenqiang on 2017/6/28.
 * <p>
 * 描述:首页契约
 */
public interface MainContract {

    // TODO: 2017/6/28 以下的 P-V-M 的声明顺序要一致.(Google官方contract中不包含M.)
    // TODO: 官方mvp地址：https://github.com/googlesamples/android-architecture/tree/todo-mvp/

    /**
     * P
     */
    abstract class Presenter extends BasePresenter<View, Model> {

        public Presenter(View view, Model model) {
            super(view, model);
        }

        /**
         * 登录
         */
        public abstract void login();
    }

    /**
     * V
     */
    interface View extends BaseView, RxLifeCycle4MVP {
        String getStaffNo();

        String getPwd();

        void showUser(String userName);
    }

    /**
     * M
     */
    interface Model extends BaseModel {
        /**
         * 获取用户权限
         *
         * @return 用户权限数据
         */
        Observable<APlusRespDo<ArrayList<PermUserInfoDo>>> userPermission(String staffNo);

    }
}
