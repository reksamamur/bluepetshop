package com.example.bluepetshop.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.example.bluepetshop.R;
import com.example.bluepetshop.activities.AboutUsActivity;
import com.example.bluepetshop.activities.DetailActivity;
import com.example.bluepetshop.activities.LoginActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class BottomSheetDialogMenu extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottomsheet_main, container, false);

        AppCompatButton btnAbout = v.findViewById(R.id.btnAboutUs);
        AppCompatButton btnSignOut = v.findViewById(R.id.btnSignOut);

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AboutUsActivity.class));
                dismiss();
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = Objects.requireNonNull(getActivity()).getSharedPreferences("UsernameBluepet", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
                dismiss();
            }
        });
        return v;
    }

    public interface BottomSheetListener{
        void onBottomSheetClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            BottomSheetListener bottomSheetListener = (BottomSheetListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "Implemet BottomSheetListener interface");
        }
    }

}
