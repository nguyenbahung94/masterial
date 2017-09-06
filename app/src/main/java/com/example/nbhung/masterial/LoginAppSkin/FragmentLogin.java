package com.example.nbhung.masterial.LoginAppSkin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 9/5/2017.
 */

public class FragmentLogin extends Fragment {
    private TextView tvRegister, tvForgetPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_login, container, false);
        tvRegister = (TextView) view.findViewById(R.id.tvRegister);
        tvForgetPassword = (TextView) view.findViewById(R.id.tvForgetPassWord);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Tv register", Toast.LENGTH_SHORT).show();
                FragmentRegister fraRegister = new FragmentRegister();
                addFragmentContent(fraRegister);
            }
        });
        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Tv forget password", Toast.LENGTH_SHORT).show();
                FragmentForgetPassword fraFrogetPassWord=new FragmentForgetPassword();
                addFragmentContent(fraFrogetPassWord);
            }
        });
        return view;
    }

    public void addFragmentContent(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, fragment);
        fragmentTransaction.commit();
    }
}
