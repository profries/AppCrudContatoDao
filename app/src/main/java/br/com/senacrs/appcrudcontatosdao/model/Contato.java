package br.com.senacrs.appcrudcontatosdao.model;

import java.io.Serializable;

public class Contato implements Serializable{
    private int id;
    private int imagemR;
    private String nome, telefone;

    public Contato(int imagemR, String nome, String telefone) {
        this.imagemR = imagemR;
        this.nome = nome;
        this.telefone = telefone;

    }

    public Contato(int id, int imagemR, String nome, String telefone) {
        this.id = id;
        this.imagemR = imagemR;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public int getImagemR() {
        return imagemR;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
