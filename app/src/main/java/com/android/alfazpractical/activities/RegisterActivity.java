package com.android.alfazpractical.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.alfazpractical.R;
import com.android.alfazpractical.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.llNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()){
                    Intent intent = new Intent(RegisterActivity.this, InfoActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValid(){
        if (binding.etEmail.getText() != null && binding.etEmail.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, getString(R.string.please_enter_email), Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.etPassword.getText() != null && binding.etPassword.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, getString(R.string.please_enter_password), Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.etPassword.getText().toString().length() < 6) {
            Toast.makeText(this, getString(R.string.password_must_be_long), Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.etConfirmPasssword.getText() != null && binding.etConfirmPasssword.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, getString(R.string.enter_confirm_password), Toast.LENGTH_SHORT).show();
            return false;
        } else if (!binding.etPassword.getText().toString().trim().equals(binding.etConfirmPasssword.getText().toString().trim())) {
            Toast.makeText(this, getString(R.string.password_did_not_match), Toast.LENGTH_SHORT).show();
            return false;
        } else if (!binding.checkbox.isChecked()) {
            Toast.makeText(this, getString(R.string.please_agree_terms_and_conditions), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}