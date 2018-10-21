package com.iexpress.android.dicee;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
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

    private ImageView backgroundImageView;

    public DiceeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_dicee, container, false);

        backgroundImageView = (ImageView) view.findViewById(R.id.backGroundImageView);
        AssetManager am = getActivity().getAssets();
        try (InputStream stream = am.open("newbackgroundLarge.png")) {
            Drawable drawable = Drawable.createFromStream(stream, "newbackgroundLarge");
            backgroundImageView.setImageDrawable(drawable);
        } catch (IOException e) {
            Log.e(TAG, "Error loading " + "newbackgroundLarge.png", e);
        }

        return view;
    }
}
