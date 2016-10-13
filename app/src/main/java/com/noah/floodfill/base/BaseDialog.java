package com.noah.floodfill.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import butterknife.ButterKnife;

/**
 * Created by HuyLV-CT on 07-Sep-16.
 */
public abstract class BaseDialog extends Dialog {
    public BaseDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        ButterKnife.bind(this,this);
    }

    public abstract int getLayoutId();
}
