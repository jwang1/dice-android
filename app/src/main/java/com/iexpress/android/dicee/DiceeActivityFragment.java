package com.iexpress.android.dicee;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * A placeholder fragment containing a simple view.
 */
public class DiceeActivityFragment extends Fragment {
    private static final String TAG = "Dicee Activity Fragment";

    private AssetManager assetManager;

    private ImageView backgroundImageView;

    private ImageView logoImageView;

    public DiceeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        assetManager = getActivity().getAssets();

        View view =  inflater.inflate(R.layout.fragment_dicee, container, false);

        backgroundImageView = view.findViewById(R.id.backGroundImageView);
        blitImage(backgroundImageView, "newbackgroundLarge", ".png");

        logoImageView = view.findViewById(R.id.logoImageView);
        blitImage(logoImageView, "diceeLogo", ".png");

        return view;
    }

    public void blitImage(ImageView imageView, String imageResourceName, String imageFileSuffix) {
        try (InputStream stream = assetManager.open(imageResourceName + imageFileSuffix)) {
            Drawable drawable = Drawable.createFromStream(stream, imageResourceName);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            Log.e(TAG, "Error loading " + imageResourceName + imageFileSuffix, e);
        }
    }
}
