package com.example.nbhung.masterial.LoginAppSkin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 9/5/2017.
 */

public class FragmentForgetPassword extends Fragment {
    private Button btnClick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_forgetpassword, container, false);
        btnClick = (Button) view.findViewById(R.id.btnForgetPassWord);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragmentContent();
            }
        });
        return view;
    }
    public void addFragmentContent() {
        FragmentLogin fraLogin = new FragmentLogin();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, fraLogin);
        fragmentTransaction.commit();
    }
}
