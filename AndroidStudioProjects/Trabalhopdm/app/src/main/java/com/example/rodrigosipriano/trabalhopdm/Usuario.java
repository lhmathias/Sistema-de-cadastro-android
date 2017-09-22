package com.example.rodrigosipriano.trabalhopdm;

/**
 * Created by rodrigo.sipriano on 31/08/2017.
 */

public class Usuario {
    private String nome;
    private String senha;
    private int id;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setID(int id) {this.id = id;}

    public int getID() {return this.id;}
}
