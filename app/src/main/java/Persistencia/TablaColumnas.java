package Persistencia;

import android.provider.BaseColumns;

public class TablaColumnas {

    public static abstract class LawyerEntry implements BaseColumns {

        public static final String TABLE_NAME ="Usuarios";
        public static final String NAME = "usu_name";
        public static final String APELLIDO = "usu_apellido";
        public static final String MAIL = "usu_mail";


    }



}
