package com.noah.floodfill.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by HuyLV-CT on 19-Aug-16.
 */
public abstract class BaseActivityToolbar extends BaseActivity {
    @Nullable
    protected Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        toolBar = (Toolbar)findViewById(R.id.toolbar);
//        if(toolBar == null){
//            Log.e("cxz","toolbar null");
//        }else {
//            setSupportActionBar(toolBar);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
