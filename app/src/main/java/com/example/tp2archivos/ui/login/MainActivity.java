package com.example.tp2archivos.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tp2archivos.R;
import com.example.tp2archivos.ui.registro.MainActivityRegistro;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail, etPass;
    private Button btnLogin, btnRegistrarse;
    private ViewModelMainActivity vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm= ViewModelProviders.of(this).get(ViewModelMainActivity.class);
        inicializar();

    }

    public void inicializar(){
        etEmail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegistrarse=findViewById(R.id.btnRegistrarse);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.verificar(etEmail.getText().toString(),etPass.getText().toString());
            }
        });
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivityRegistro.class);
                i.putExtra("bandera", 0);
                startActivity(i);
            }
        });
    }

}
