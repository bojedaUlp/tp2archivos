package com.example.tp2archivos.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp2archivos.model.Usuario;
import com.example.tp2archivos.request.ApiClient;
import com.example.tp2archivos.ui.login.MainActivity;

public class ViewModelActivityRegistro extends AndroidViewModel {
    private Context context;
    private Usuario us;
    private MutableLiveData<Usuario> usuario;
    public ViewModelActivityRegistro(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();

    }

    public LiveData<Usuario> getUsuario(){
        if (usuario == null){
            usuario = new MutableLiveData<>();
        }
        return usuario;
    }

    public void leerUsuario(int bandera){
        if(bandera==1){
            us=ApiClient.leer(context);
            usuario.setValue(us);
        }
    }

    public void guardarU(Usuario u){
        ApiClient.guardar(context,u);
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}
