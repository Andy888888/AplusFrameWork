package com.centa.aplusframework.activities;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.centa.aplusframework.R;
import com.centa.aplusframework.base.BaseActivity;
import com.centa.aplusframework.contracts.MainContract;
import com.centa.aplusframework.presenters.MainPresenter;
import com.centa.aplusframework.repository.MainModel;
import com.centa.centacore.interfaces.ISingleRequest;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A login screen that offers login via email/password.
 */
public class MainActivity extends BaseActivity implements ISingleRequest, MainContract.View {
    // UI references.
    @BindView(R.id.actv_account)
    AutoCompleteTextView mAccountTextView;
    @BindView(R.id.et_password)
    EditText mPasswordView;
    @BindView(R.id.btn_sign_in)
    Button mSignInButton;

    private MainContract.Presenter presenter;

    @Override
    protected int layoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        presenter = new MainPresenter(this, new MainModel());
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                login_click();
            }
        });
    }

    /**
     * 登录点击事件
     */
    private void login_click() {
        loadingDialog("我的数据已提交，请耐心等待...");
        mSignInButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.login();
            }
        }, 1000);
    }

    @Override
    protected void initComplete() {

    }


    @Override
    public String getStaffNo() {
        String account = mAccountTextView.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            return "Ceshigzywq";
        } else {
            return account;
        }
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    public void showUser(String userName) {
        cancelLoadingDialog();
        toast(userName);
    }


    @Override
    public void request() {
        presenter.login();
    }

}