package com.example.bluepetshop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bluepetshop.R;
import com.example.bluepetshop.addition.AlertDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    Bundle bundle;

    TextView textViewName, textViewAge, textViewGender, textViewRace;
    TextInputEditText textInputEditTextPhone;
    TextInputLayout textInputLayout;
    ImageView imageViewItem;
    MaterialButton buttonAdoptD;

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = findViewById(R.id.toolbar_detail);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        onDeclare();
        setupView();
        doingAnimate();
        checkPhoneNum();
    }

    void onDeclare() {
        textViewName = findViewById(R.id.tvNamaItem);
        textViewRace = findViewById(R.id.tvRaceItem);
        textViewAge = findViewById(R.id.tvAgeItem);
        textViewGender = findViewById(R.id.tvGenderItem);
        imageViewItem = findViewById(R.id.imgItemDisplay);
        textInputEditTextPhone = findViewById(R.id.inpPhoneNumber);
        buttonAdoptD = findViewById(R.id.btnAdoptionDetail);
        textInputLayout = findViewById(R.id.tilPhoneNumber);
        alertDialog = new AlertDialog();
    }

    public void doingAnimate(){
        textInputEditTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (textInputEditTextPhone.getText().length() < 10){
                    textInputLayout.setBoxStrokeColor(getResources().getColor(R.color.colorRed));
                    textInputLayout.setHintTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorRed)));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (textInputEditTextPhone.getText().length() > 10){
                    textInputLayout.setBoxStrokeColor(getResources().getColor(R.color.colorPrimary));
                    textInputLayout.setHintTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
                }
            }
        });
    }

    void checkPhoneNum() {
        buttonAdoptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = String.valueOf(textInputEditTextPhone.getText());

                if (phone.isEmpty()) {
                    alertDialog.defaultAlert(getResources().getString(R.string.al_empty), getResources().getString(R.string.error_empty), DetailActivity.this);
                } else if (phone.length() < 10) {
                    alertDialog.defaultAlert(getResources().getString(R.string.al_lessten), getResources().getString(R.string.al_lessten_msg), DetailActivity.this);
                } else {
                    alertDialog.directAlert(getResources().getString(R.string.al_success), getResources().getString(R.string.al_success_msg), DetailActivity.this, new ItemActivity());
                }

            }
        });
    }

    void setupView() {
        bundle = new Bundle();
        bundle = getIntent().getExtras();
        String nameItem = null;
        String genderItem = null;
        String ageItem = null;
        String raceItem = null;
        int imageItem = 0;
        if (bundle != null) {
            nameItem = bundle.getString("namaItem");
            genderItem = bundle.getString("genderItem");
            ageItem = bundle.getString("ageItem");
            imageItem = bundle.getInt("imageItem");
            raceItem = bundle.getString("raceItem");
        }

        textViewName.setText(nameItem);
        textViewGender.setText(genderItem);
        textViewAge.setText(ageItem);
        textViewRace.setText(raceItem);
        imageViewItem.setImageResource(imageItem);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
