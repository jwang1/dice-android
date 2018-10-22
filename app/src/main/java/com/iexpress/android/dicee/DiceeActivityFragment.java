package com.iexpress.android.dicee;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * A placeholder fragment containing a simple view.
 */
public class DiceeActivityFragment extends Fragment {
    private static final String TAG = "Dicee Activity Fragment";

    private AssetManager assetManager;

    private ImageView backgroundImageView;

    private ImageView logoImageView;

    private ImageView dice1ImageView;

    private ImageView dice2ImageView;

    private Button rollButton;

    private OnClickListener rollButtonOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // this Toast not showed up yet
            Toast.makeText(getActivity(), "Roll....", Toast.LENGTH_LONG);

            DiceeUtil.randomizeDices(getActivity().getAssets(), dice1ImageView, dice2ImageView);
        }
    };


    public DiceeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        assetManager = getActivity().getAssets();

        View view =  inflater.inflate(R.layout.fragment_dicee, container, false);

        backgroundImageView = view.findViewById(R.id.backGroundImageView);
        DiceeUtil.blitImage(assetManager, backgroundImageView, "newbackgroundLarge", ".png");

        logoImageView = view.findViewById(R.id.logoImageView);
        DiceeUtil.blitImage(assetManager, logoImageView, "diceeLogo", ".png");

        dice1ImageView = view.findViewById(R.id.dice1ImageView);
        dice2ImageView = view.findViewById(R.id.dice2ImageView);

        DiceeUtil.randomizeDices(assetManager, dice1ImageView, dice2ImageView);

        rollButton = view.findViewById(R.id.rollButton);
        rollButton.setOnClickListener(rollButtonOnClickListener);

        return view;
    }

}
