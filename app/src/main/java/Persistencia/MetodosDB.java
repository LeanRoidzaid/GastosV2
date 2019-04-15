package Persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MetodosDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Test_DB";

    public MetodosDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TablaColumnas.LawyerEntry.TABLE_NAME + " ("
                + TablaColumnas.LawyerEntry.NAME + " NOT NULL,"
                + TablaColumnas.LawyerEntry.APELLIDO + " NOT NULL,"
                + TablaColumnas.LawyerEntry.MAIL + " NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public long saveLawyer(Campos valores) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                TablaColumnas.LawyerEntry.TABLE_NAME,
                null, valores.toContentValues());

    }

    public Cursor getData(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM "+ TablaColumnas.LawyerEntry.TABLE_NAME,null);
    }


}

