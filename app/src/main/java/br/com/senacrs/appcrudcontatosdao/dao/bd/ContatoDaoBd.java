package br.com.senacrs.appcrudcontatosdao.dao.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.senacrs.appcrudcontatosdao.R;
import br.com.senacrs.appcrudcontatosdao.dao.ContatoDao;
import br.com.senacrs.appcrudcontatosdao.model.Contato;

public class ContatoDaoBd implements ContatoDao {
    private BancoDadosOpenHelper bdOpenHelper;

    public ContatoDaoBd(Context contexto){
        bdOpenHelper = new BancoDadosOpenHelper(contexto);
    }

    @Override
    public void inserir(Contato contato) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome",contato.getNome());
        valores.put("telefone",contato.getTelefone());
        banco.insert("contato",null,valores);

        banco.close();

    }

    @Override
    public void excluir(Contato contato) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();
        banco.delete("contato","id=?",
                new String[]{String.valueOf(contato.getId())});
        banco.close();
    }

    @Override
    public void atualizar(Contato contato) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome",contato.getNome());
        valores.put("telefone",contato.getTelefone());

        banco.update("contato",valores,"id=?",
                new String[]{String.valueOf(contato.getId())});
        banco.close();
    }

    @Override
    public List<Contato> listar() {
        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();

        Cursor cursor = banco.query("contato",
                new String[]{"id","nome","telefone"},
                null,null,null,null,"nome");

        List<Contato> listaContatos = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            Contato contato = new Contato(id, R.mipmap.pessoa, nome, telefone);
            listaContatos.add(contato);
        }
        return listaContatos;
    }

    @Override
    public Contato procurarPorId(int id) {
        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();

        Cursor cursor = banco.query("contato",
                new String[]{"id","nome","telefone"},
                "id = ?",new String[]{String.valueOf(id)},
                null,null,null);

        if(cursor.moveToNext()){
            int idX = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            Contato contato = new Contato(idX, R.mipmap.pessoa, nome, telefone);
            return contato;
        }
        return null;
    }
}
