package com.iexpress.android.dicee;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class DiceeUtil {
    private static final String TAG = "DiceUtil.class";

    private static final String[] diceImages = {"dice1", "dice2", "dice3", "dice4", "dice5", "dice6"};

    private static final Random random = new Random(System.currentTimeMillis());

    public static void blitImage(AssetManager assetManager, ImageView imageView, String imageResourceName,
                          String imageFileSuffix) {
        try (InputStream stream = assetManager.open(imageResourceName + imageFileSuffix)) {
            Drawable drawable = Drawable.createFromStream(stream, imageResourceName);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            Log.e(TAG, "Error loading " + imageResourceName + imageFileSuffix, e);
        }
    }

    public static void randomizeDices(AssetManager assetManager, ImageView... imageViews) {
        for (ImageView iv : imageViews) {
            blitImage(assetManager, iv, diceImages[random.nextInt(diceImages.length)], ".png");
        }
    }

}
