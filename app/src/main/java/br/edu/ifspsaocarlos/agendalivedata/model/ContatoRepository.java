package br.edu.ifspsaocarlos.agendalivedata.model;

import android.app.Application;
import androidx.lifecycle.LiveData;

import android.os.AsyncTask;

import java.util.List;


public class ContatoRepository {

    private ContatoDAO contatoDAO;
    private LiveData<List<Contato>> todosContatos;

    public ContatoRepository(Application application) {
        ContatoDatabase db = ContatoDatabase.getDatabase(application);
        contatoDAO = db.contatoDAO();
        todosContatos = contatoDAO.buscaTodosContatos();
    }



    public void insert(Contato c) {
        new insertAsyncTask(contatoDAO).execute(c);
    }

    public void delete(Contato c)  {
        new deleteAsyncTask(contatoDAO).execute(c);
    }

    public void update(Contato c)  {
        new updateAsyncTask(contatoDAO).execute(c);
    }

    public LiveData<List<Contato>> getAllContatos() {
        return todosContatos;
    }





    static class insertAsyncTask extends AsyncTask<Contato, Void, Void> {

        private ContatoDAO mAsyncTaskDao;

        insertAsyncTask(ContatoDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contato... params) {
            mAsyncTaskDao.insertContato(params[0]);
            return null;
        }
    }


     static class deleteAsyncTask extends AsyncTask<Contato, Void, Void> {
        private ContatoDAO mAsyncTaskDao;

        deleteAsyncTask(ContatoDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contato... params) {
            mAsyncTaskDao.deleteContato(params[0]);
            return null;
        }
    }


     static class updateAsyncTask extends AsyncTask<Contato, Void, Void> {
        private ContatoDAO mAsyncTaskDao;

        updateAsyncTask(ContatoDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contato... params) {
            mAsyncTaskDao.updateContato(params[0]);
            return null;
        }
    }

}
