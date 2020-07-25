package br.edu.ifspsaocarlos.agendalivedata.model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContatoDAO {


    @Insert
    long insertContato(Contato contato);

    @Update
    void updateContato(Contato contato);

    @Delete
    void deleteContato(Contato contato);

    @Query("Select * from contatos order by nome")
    LiveData<List<Contato>> buscaTodosContatos();
}
