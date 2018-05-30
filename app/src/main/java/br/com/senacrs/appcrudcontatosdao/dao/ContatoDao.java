package br.com.senacrs.appcrudcontatosdao.dao;

import java.util.List;

import br.com.senacrs.appcrudcontatosdao.model.Contato;

public interface ContatoDao {
    public void inserir(Contato contato);
    public void excluir(Contato contato);
    public void atualizar(Contato contato);
    public List<Contato> listar();
    public Contato procurarPorId(int id);

}
