package com.noah.floodfill.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.noah.floodfill.R;
import com.noah.floodfill.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by HuyLV-CT on 13-Oct-16.
 */

public class AreaSelectionActivity extends BaseActivity {
    private Bitmap originalBitmap;
    @BindView(R.id.ivImage)
    ImageView ivImage;
    private Bitmap currentBitmap;
    private int currentX,currentY,currentTolerance =50;

    @BindView(R.id.sbTolerance)
    SeekBar sbTolerance;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_area_selection;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inScaled = false;
        originalBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.s3,o);
        ivImage.setImageBitmap(originalBitmap);
        currentBitmap = originalBitmap.copy(originalBitmap.getConfig(),true);

        ivImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        currentX = (int) event.getX()/4;
                        currentY = (int) event.getY()/4;
                        Log.e("cxz","xxx"+currentX+" "+currentY+" "+ originalBitmap.getWidth()+ " "+ originalBitmap.getHeight());

                        currentBitmap = originalBitmap.copy(originalBitmap.getConfig(),true);
                        MainActivity.floodFill(currentBitmap,currentX,currentY, Color.BLUE,currentTolerance);
                        ivImage.setImageBitmap(currentBitmap);
                        break;
                }
                return true;
            }
        });
        sbTolerance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentTolerance = progress;
                currentBitmap = originalBitmap.copy(originalBitmap.getConfig(),true);
                MainActivity.floodFill(currentBitmap,currentX,currentY, Color.BLUE,currentTolerance);
                ivImage.setImageBitmap(currentBitmap);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });
    }
}
