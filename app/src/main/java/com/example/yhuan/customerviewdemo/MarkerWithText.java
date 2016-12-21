package com.example.yhuan.customerviewdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by yhuan on 2016/12/20.
 */

public class MarkerWithText {

    public static Bitmap getMarkerWithText(String text, Context context) {
        return drawTextToBitmap(context, R.drawable.ic_menu_places, text);
    }

    /**
     * Copied from:
     * http://stackoverflow.com/questions/18335642/how-to-draw-text-in-default-marker-of-google-map-v2?lq=1
     */
    public static Bitmap drawTextToBitmap(Context gContext, int gResId,
                                          String gText) {
        Resources resources = gContext.getResources();
        float scale = resources.getDisplayMetrics().density;
        Bitmap bitmap = BitmapFactory.decodeResource(resources, gResId);

        Bitmap.Config bitmapConfig = bitmap.getConfig();
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(bitmapConfig, true);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setTextSize((int) (30 * scale));
        paint.setShadowLayer(1f, 0f, 1f, Color.WHITE);

        Rect bounds = new Rect();
        paint.getTextBounds(gText, 0, gText.length(), bounds);
        int x = (bitmap.getWidth() - bounds.width()) / 2;
//        int y = (bitmap.getHeight() + bounds.height()) * 5 / 12; // At 5/12 from the top so it stays on the center
        int y = (bitmap.getHeight() - bounds.height()) ; // At 5/12 from the top so it stays on the center
        canvas.drawText(gText, x, y, paint);

        return bitmap;
    }

    public static Bitmap drawBitmapToBitmap(Context gContext, int gResId, int sResId) {
        Resources resources = gContext.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, gResId);
        return drawBitmapToBitmap(gContext, bitmap, sResId);
    }

    public static Bitmap drawBitmapToBitmap(Context gContext, Bitmap bitmap, int sResId) {
        Resources resources = gContext.getResources();

        Bitmap.Config bitmapConfig = bitmap.getConfig();
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(bitmapConfig, true);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Bitmap small = BitmapFactory.decodeResource(resources, sResId);
        canvas.drawBitmap(small, bitmap.getWidth() - small.getWidth(), 0, paint);

        return bitmap;
    }
}
