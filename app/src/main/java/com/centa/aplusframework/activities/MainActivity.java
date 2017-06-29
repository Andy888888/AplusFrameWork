package com.centa.aplusframework.activities;

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
import com.centa.centacore.utils.WLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A login screen that offers login via email/password.
 */
public class MainActivity extends BaseActivity implements ISingleRequest, MainContract.View {
    // UI references.
    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.login_progress)
    View mProgressView;
    @BindView(R.id.login_form)
    View mLoginFormView;
    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;
    @BindView(R.id.button_test)
    Button mTestButton;

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
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                login_click();
            }
        });
        mTestButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("你好！");
            }
        });
    }

    /**
     * 登录点击事件
     */
    private void login_click() {
        loadingDialog("我的数据已提交，请耐心等待...");

        WLog.setDebug(true);
        WLog.p("tt");
        WLog.nativeLog("tt");
        WLog.p("sss", "ggggg", 5);
        WLog.p("还原");

        presenter.login();

        mEmailSignInButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                cancelLoadingDialog();
            }
        }, 2000);
    }

    @Override
    protected void initComplete() {

    }


    @Override
    public String getStaffNo() {
        return null;
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    public void request() {
        presenter.login();
    }

}