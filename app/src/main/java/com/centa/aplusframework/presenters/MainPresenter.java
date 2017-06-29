package com.centa.aplusframework.presenters;

import com.centa.aplusframework.contracts.MainContract;
import com.centa.aplusframework.model.respdo.APlusRespDo;
import com.centa.aplusframework.model.respdo.PermUserInfoDo;
import com.centa.centacore.utils.WLog;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yanwenqiang on 2017/6/28.
 * <p>
 * 描述:首页的Presenter
 */
public class MainPresenter extends MainContract.Presenter {
    public MainPresenter(MainContract.View view, MainContract.Model model) {
        super(view, model);
    }

    @Override
    public void login() {
        selfModel.userPermission(selfView.getStaffNo())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(selfView.<APlusRespDo<ArrayList<PermUserInfoDo>>>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Subscriber<APlusRespDo<ArrayList<PermUserInfoDo>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(APlusRespDo<ArrayList<PermUserInfoDo>> permUserInfoDoAPlusRespDo) {
                        List<PermUserInfoDo> permUserInfoDo = permUserInfoDoAPlusRespDo.getResult();
                        PermUserInfoDo permUserInfoEntity = permUserInfoDo.get(0);
                        String name = permUserInfoEntity.getIdentify().getUName();
                        WLog.p("结果", name);
                        selfView.showUser(name);
                    }
                });

        // TODO: 2017/6/28 亦可使用以下方式，改为Action1

//        selfModel.userPermission(selfView.getStaffNo())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(selfView.<APlusRespDo<ArrayList<PermUserInfoDo>>>bindUntilEvent(ActivityEvent.DESTROY))
//                .subscribe(new Action1<APlusRespDo<ArrayList<PermUserInfoDo>>>() {
//                    @Override
//                    public void call(APlusRespDo<ArrayList<PermUserInfoDo>> arrayListAPlusRespDo) {
//                        List<PermUserInfoDo> permUserInfoDo = arrayListAPlusRespDo.getResult();
//                        PermUserInfoDo permUserInfoEntity = permUserInfoDo.get(0);
//                        String name = permUserInfoEntity.getIdentify().getUName();
//                        WLog.p("结果", name);
//                        selfView.showUser(name);
//                    }
//                });
    }
}
