package br.com.senacrs.appcrudcontatosdao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.senacrs.appcrudcontatosdao.adapter.ContatoAdapter;
import br.com.senacrs.appcrudcontatosdao.dao.ContatoDao;
import br.com.senacrs.appcrudcontatosdao.dao.bd.ContatoDaoBd;
import br.com.senacrs.appcrudcontatosdao.model.Contato;

public class MainActivity extends AppCompatActivity implements ContatoAdapter.ContatoOnClickListener{

    List<Contato> listaContatos = new ArrayList<>();
    RecyclerView recyclerView;
    ContatoAdapter contatoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contatoAdapter = new ContatoAdapter(getBaseContext(),listaContatos,this);
        recyclerView.setAdapter(contatoAdapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onResume() {
        super.onResume();
        ContatoDao dao = new ContatoDaoBd(this);
        listaContatos = dao.listar();
        contatoAdapter.setListaContatos(listaContatos);
        contatoAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClickContato(View view, int pos) {
        Intent it = new Intent(this, DetalheActivity.class);
        Contato contato = listaContatos.get(pos);
        it.putExtra("contato",contato);
        startActivity(it);
    }

    public void abrirFormulario(View v){
        Intent it = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(it);

    }


}
