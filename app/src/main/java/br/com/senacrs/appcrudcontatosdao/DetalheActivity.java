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


public class DetalheActivity extends AppCompatActivity {
    private EditText textoNomeDetalhe, textoTelefoneDetalhe;
    Contato contatoEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = getIntent();
        contatoEditar = (Contato) intent.getSerializableExtra("contato");

        textoNomeDetalhe = (EditText) findViewById(R.id.textoNomeDetalhe);
        textoNomeDetalhe.setText(contatoEditar.getNome());
        textoTelefoneDetalhe = (EditText) findViewById(R.id.textoTelefoneDetalhe);
        textoTelefoneDetalhe.setText(contatoEditar.getTelefone());

    }

    public void editarContato(View v){
        contatoEditar.setNome(textoNomeDetalhe.getText().toString());
        contatoEditar.setTelefone(textoTelefoneDetalhe.getText().toString());

        ContatoDao dao = new ContatoDaoBd(this);
        dao.atualizar(contatoEditar);
        Toast.makeText(this,"Edicao realizada com sucesso!", Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    public void excluirContato(View v){
        ContatoDao dao = new ContatoDaoBd(this);
        dao.excluir(contatoEditar);
        Toast.makeText(this,"Exclusao realizada com sucesso!",Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    public void voltar(View v){
        finish();
    }
}
