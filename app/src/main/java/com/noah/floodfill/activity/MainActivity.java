package com.noah.floodfill.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.noah.floodfill.R;
import com.noah.floodfill.base.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    static {
        System.loadLibrary("jnibitmap");
    }
    public static native void floodFill(Bitmap bitmap, int x, int y, int color, int tolerance);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }



    @OnClick(R.id.button)
    void openAr(){
        startActivity(new Intent(this,AreaSelectionActivity.class));
    }
}
