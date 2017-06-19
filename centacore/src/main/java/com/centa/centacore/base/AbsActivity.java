package com.centa.centacore.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.centa.centacore.R;
import com.centa.centacore.widgets.LoadingDialog;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by yanwenqiang on 2017/6/18
 * <p>
 * 描述:Activity基类,规范了初始化顺序,在{@link #onCreate(Bundle)}中会依次调用
 * {@link #setContentView(int)}、{@link #preInit(Bundle)}、{@link #findViews()}、{@link #initViews()}、
 * {@link #initComplete()}
 * <p>
 * 返回按钮和标题设置,{@link #setUniversalToolbar()}、{@link #setContentView(int)}、{@link
 * #setUniversalToolbar(CharSequence)}
 * 只需要调用一次,将会设置页面的返回按钮和标题
 * <p>
 * 使用阻塞式加载对话框,{@link #loadingDialog()}显示,{@link #cancelLoadingDialog()}取消
 */

public abstract class AbsActivity extends RxAppCompatActivity {

    public static final String TITLE_ACTIVITY = "TITLE_ACTIVITY";//页面标题

    private AlertDialog loadingDialog;

    @SuppressWarnings("deprecation")
    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId());
        preInit(savedInstanceState);
        findViews();
        initViews();
        initComplete();
    }

    /**
     * 布局id
     */
    @LayoutRes
    protected abstract int layoutResId();

    /**
     * 初始化view前的内容
     */
    protected void preInit(Bundle savedInstanceState) {

    }

    /**
     * findViewById
     */
    protected abstract void findViews();

    /**
     * view初始化
     */
    protected abstract void initViews();

    /**
     * 初始化完成
     */
    protected abstract void initComplete();

    /**
     * 设置通用的toolbar,设置返回按钮,setUniversalToolbar只需调用一次
     */
    protected void setUniversalToolbar() {
        setUniversalToolbar("");
    }

    /**
     * 设置通用的toolbar，设置标题、默认添加返回按钮,setUniversalToolbar只需调用一次
     *
     * @param id 标题
     */
    protected void setUniversalToolbar(@StringRes int id) {
        setUniversalToolbar(getString(id));
    }

    /**
     * 设置通用的toolbar，设置标题、默认添加返回按钮,setUniversalToolbar只需调用一次
     *
     * @param title 标题
     */
    protected void setUniversalToolbar(CharSequence title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String activityTitle = getIntent().getStringExtra(TITLE_ACTIVITY);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(
                    TextUtils.isEmpty(activityTitle) ? title : activityTitle);
        }
    }

    /**
     * 设置ToolbarTitle
     *
     * @param title CharSequence
     */
    protected void setToolbarTitle(CharSequence title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    /**
     * 添加默认返回事件，finish当前页面
     *
     * @param item MenuItem
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//返回键关闭页面
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void loadingDialog() {
        loadingDialog("");
    }

    /**
     * 自定义加载框
     */
    protected void loadingDialog(String message) {
        loadingDialog(message, false);
    }

    /**
     * 自定义加载框
     *
     * @param message    内容
     * @param cancelable 是否取消
     */
    protected void loadingDialog(String message, boolean cancelable) {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }

        loadingDialog.setMessage(message);
//        if (!TextUtils.isEmpty(message)) {
//            loadingDialog.showMsgText().setMessage(message);
//        } else {
//            loadingDialog.hideMsgText();
//        }
        loadingDialog.setCancelable(cancelable);
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    /**
     * 取消加载框
     */
    protected void cancelLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.cancel();
            loadingDialog = null;
        }
    }

    /**
     * 网络不可用
     */
    protected void netWorkUnable(Throwable e) {
        Logger.e(e, "netWorkUnable");
        toast(R.string.network_unable);
    }

    /**
     * {@link Snackbar}统一显示入口
     */
    protected void snack(@StringRes int id) {
        View coordinatorLayout = findViewById(R.id.coordinatorLayout);
        if (coordinatorLayout == null) {
            Logger.e("cannot find coordinatorLayout");
        } else {
            Snackbar.make(coordinatorLayout, id, Snackbar.LENGTH_SHORT).show();
        }
    }

    /**
     * {@link Snackbar}统一显示入口
     *
     * @param text 显示内容
     */
    protected void snack(CharSequence text) {
        View coordinatorLayout = findViewById(R.id.coordinatorLayout);
        if (coordinatorLayout == null) {
            Logger.e("cannot find coordinatorLayout");
        } else {
            Snackbar.make(coordinatorLayout, text, Snackbar.LENGTH_SHORT).show();
        }
    }

    /**
     * Toast统一显示入口
     */
    protected void toast(@StringRes int id) {
        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast统一显示入口
     */
    protected void toast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 隐藏软键盘
     */
    protected void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
