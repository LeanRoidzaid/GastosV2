package Persistencia;

import android.content.ContentValues;

import com.e.gastosv2.Usuario;


import java.util.UUID;

public class Campos {
    private Usuario usuario;

    public Campos(Usuario usuario) {
        this.usuario = usuario;
    }


    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(TablaColumnas.LawyerEntry.NAME, Campos.this.usuario.getNombre());
        values.put(TablaColumnas.LawyerEntry.APELLIDO, Campos.this.usuario.getApellido());
        values.put(TablaColumnas.LawyerEntry.MAIL, Campos.this.usuario.getMail());

        return values;
    }


    public Usuario getUsuario() {
        return usuario;
    }

}
