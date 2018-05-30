package br.com.senacrs.appcrudcontatosdao.dao.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDadosOpenHelper extends SQLiteOpenHelper {
    private static String nomeBD = "crudContato.db";
    private static String createTable = "CREATE TABLE contato" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome VARCHAR(30)," +
            "telefone VARCHAR(20))";

    public BancoDadosOpenHelper(Context context) {
        super(context, nomeBD, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE contato");
        db.execSQL(createTable);
    }
}
