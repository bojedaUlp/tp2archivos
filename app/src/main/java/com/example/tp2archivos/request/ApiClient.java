package com.example.tp2archivos.request;

import android.content.Context;
import android.widget.Toast;

import com.example.tp2archivos.model.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import android.widget.Toast;

public class ApiClient {

    private static Context context;

        public static void guardar(Context context,Usuario us){
            try {
                File archivo = new File(context.getFilesDir(), "archivo.dat");
                FileOutputStream fos = new FileOutputStream(archivo);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);

                oos.writeObject(us);
                bos.flush();
                fos.close();
            } catch (IOException io) {
                Toast.makeText(context, "Error en la conexion", Toast.LENGTH_LONG).show();
            }
        }

        public static Usuario leer(Context context){
            Usuario usuario=null;
            try{
            File archivo = new File (context.getFilesDir(), "archivo.dat");
            FileInputStream fis = new FileInputStream(archivo);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            usuario = (Usuario) ois.readObject();

            fis.close();
            }catch(IOException io){
                Toast.makeText(context, "No se encontro el archivo", Toast.LENGTH_LONG).show();

            }catch(ClassNotFoundException nf){
                Toast.makeText(context, "No se encontro el usuario", Toast.LENGTH_LONG).show();
            }
            return usuario;
        }

        public static Usuario leerUsuario(Context context,String email,String clave){
            Usuario usuario=null;
            try{
                File archivo = new File (context.getFilesDir(), "archivo.dat");
                FileInputStream fis = new FileInputStream(archivo);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);

                usuario = (Usuario) ois.readObject();

                fis.close();
            }catch(IOException io){
                Toast.makeText(context, "No se encontro el archivo", Toast.LENGTH_LONG).show();

            }catch(ClassNotFoundException nf){
                Toast.makeText(context, "No se encontro el usuario", Toast.LENGTH_LONG).show();
            }

            if(email.equals(usuario.getEmail()) && clave.equals(usuario.getClave())){
                return usuario;
            }
            else{usuario=null;}
            return usuario;
        }

}
