package com.ling.sku.skuapp;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * ***************************************
 * statement: 封装自定义View的dialog,只需在initView 中加载自定义的布局
 * author: LingGuiQin
 * date created : 2017/3/7 0007
 * ***************************************
 */

public abstract class BaseCustomDialog {

    public Activity mActivity;
    private Dialog mDialog;
    private double widthPercentage = 0.8; // 设置dialog窗口宽度占屏幕总宽度的百分比（1表示与手机屏幕宽度一样大小，0.6 表示宽度是屏幕的0.6）
    private double heightPercentage = -1; // 设置dialog窗口高度占屏幕总高度的百分比 -1表示包裹内容
    private int dialogStyle = R.style.Dialog;  // dialog 显示的样式
    private boolean isCanceledOnTouchOutside = true; // 点击外部是否可以关闭dialog
    private int mGravity = Gravity.CENTER;  // 默认显示屏幕中间
    public LayoutInflater mInflater;

    public BaseCustomDialog(Activity activity) {
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(activity);
        initDialog(initView());
    }

    /**
     * 可定制显示dialog样式、大小的 构造器
     *
     * @param activity
     * @param style                    显示的样式
     * @param widthPercentage          显示的宽度占屏幕的百分比
     * @param heightPercentage         显示的高度占屏幕的百分比，如果只是需要包裹内容 传 -1 即可
     * @param isCanceledOnTouchOutside 点击dialog外部是否可以关闭
     * @param gravity                  显示的位置
     */
    public BaseCustomDialog(Activity activity,
                            int style,
                            double widthPercentage,
                            double heightPercentage,
                            int gravity,
                            boolean isCanceledOnTouchOutside) {

        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.dialogStyle = style;
        this.widthPercentage = widthPercentage;
        this.heightPercentage = heightPercentage;
        this.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
        this.mGravity = gravity;
        initDialog(initView());
    }


    public abstract View initView();

    /**
     * 初始化dialog、设置窗口大小、样式
     *
     * @param view dialog 需要显示的界面
     */
    private void initDialog(View view) {

        mDialog = new Dialog(mActivity, dialogStyle);
        mDialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = mDialog.getWindow();
        final WindowManager m = (WindowManager) mActivity.getSystemService(mActivity.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = (int) (d.getWidth() * widthPercentage);
        if (heightPercentage > 0) {
            lp.height = (int) (d.getHeight() * heightPercentage);
        }
        window.setAttributes(lp);
        window.setGravity(mGravity);
        mDialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
        window.setAttributes(lp);
    }

    public void show() {
        if (mDialog != null
                && !mDialog.isShowing()
                && !mActivity.isFinishing()) {
            mDialog.show();
        }
    }


    public void cancel() {
        if (mDialog != null
                && mDialog.isShowing()) {
            mDialog.cancel();
        }
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
