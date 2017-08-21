package com.pitch.deck.shopeasy.scanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pitch.deck.shopeasy.R;

/**
 * Created by sangeetha on 21/8/17.
 */

public class BarCodeScannerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bar_code_scanner, container, false);
        return view;
    }
}
