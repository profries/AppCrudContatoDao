package br.com.senacrs.appcrudcontatosdao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.senacrs.appcrudcontatosdao.dao.ContatoDao;
import br.com.senacrs.appcrudcontatosdao.dao.bd.ContatoDaoBd;
import br.com.senacrs.appcrudcontatosdao.model.Contato;


public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrarContato(View view){
        EditText textoNomeCadastro = (EditText) findViewById(R.id.textoNomeCadastro);
        EditText textoTelefoneCadastro = (EditText) findViewById(R.id.textoTelefoneCadastro);
        String nome = textoNomeCadastro.getText().toString();
        String telefone = textoTelefoneCadastro.getText().toString();

        Contato contato = new Contato(R.mipmap.pessoa, nome, telefone);

        ContatoDao dao = new ContatoDaoBd(this);
        dao.inserir(contato);
        Toast.makeText(this,"Cadastro realizada com sucesso!",Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    public void cancelarCadastro(View view){
        finish();
    }
}
