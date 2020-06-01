package com.example.tp2archivos.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tp2archivos.model.Usuario;
import com.example.tp2archivos.request.ApiClient;
import com.example.tp2archivos.ui.registro.MainActivityRegistro;

public class ViewModelMainActivity extends AndroidViewModel {
    private Context context;
    private Usuario us;
    public ViewModelMainActivity(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public void verificar(String email,String clave){
        us= ApiClient.leerUsuario(context,email,clave);
        if (us != null){
            Intent i = new Intent(context, MainActivityRegistro.class);
            i.putExtra("bandera", 1);
            context.startActivity(i);
        }
        else {
            Toast.makeText(context, "Datos incorrectos, verifique", Toast.LENGTH_LONG).show();
        }
    }
}
