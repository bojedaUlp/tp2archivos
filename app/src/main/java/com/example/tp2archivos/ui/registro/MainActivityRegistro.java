package com.example.tp2archivos.ui.registro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tp2archivos.R;
import com.example.tp2archivos.model.Usuario;
import com.example.tp2archivos.ui.login.ViewModelMainActivity;

public class MainActivityRegistro extends AppCompatActivity {
    private int bandera;
    private Usuario us;
    private ViewModelActivityRegistro vm;
    private EditText etnom_r,etApe_r, etDni_r, etEmail_r, etPass_r;
    private Button btnGuardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        vm= ViewModelProviders.of(this).get(ViewModelActivityRegistro.class);
        vm.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                etnom_r.setText(usuario.getNombre());
                etApe_r.setText(usuario.getApellido());
                etDni_r.setText(usuario.getDni()+"");
                etEmail_r.setText(usuario.getEmail());
                etPass_r.setText(usuario.getClave());
            }
        });
        Intent i = getIntent();
        vm.leerUsuario(i.getIntExtra("bandera",0));
    }

    private void inicializar(){

        etnom_r=findViewById(R.id.etNombre_r);
        etApe_r=findViewById(R.id.etApellido_r);
        etDni_r=findViewById(R.id.etDni_r);
        etEmail_r=findViewById(R.id.etEmail_r);
        etPass_r=findViewById(R.id.etPassword_r);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                us=new Usuario();
                us.setNombre(etnom_r.getText().toString());
                us.setApellido(etApe_r.getText().toString());
                us.setDni(Long.parseLong(etDni_r.getText().toString()));
                us.setEmail(etEmail_r.getText().toString());
                us.setClave(etPass_r.getText().toString());
                vm.guardarU(us);
            }
        });

    }

}
