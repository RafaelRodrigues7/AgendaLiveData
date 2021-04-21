package br.edu.ifspsaocarlos.agendalivedata.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "contatos")
public class Contato implements Serializable{
    private static final long serialVersionUID = 1L;

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nome;
    private String fone;
    private String fone2;
    private String email;

    public Contato()
    {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    public String getFone2() {
        return fone2;
    }
    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals (Object obj){
        Contato c2 = (Contato) obj;
        return this.id == c2.getId();
    }
}

