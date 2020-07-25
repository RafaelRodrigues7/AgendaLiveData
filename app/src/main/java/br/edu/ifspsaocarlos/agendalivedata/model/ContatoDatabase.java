package br.edu.ifspsaocarlos.agendalivedata.model;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Contato.class}, version = 1)
public abstract class ContatoDatabase extends RoomDatabase {

    public abstract ContatoDAO contatoDAO();
    private static ContatoDatabase INSTANCE;

    public static ContatoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ContatoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ContatoDatabase.class, "agenda")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

 }
