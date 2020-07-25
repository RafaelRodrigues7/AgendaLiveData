package br.edu.ifspsaocarlos.agendalivedata.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import java.util.List;

import br.edu.ifspsaocarlos.agendalivedata.model.Contato;
import br.edu.ifspsaocarlos.agendalivedata.model.ContatoRepository;

public class ContatoViewModel extends AndroidViewModel {


        private ContatoRepository mRepository;
        private LiveData<List<Contato>> mAllContatos;
        private MutableLiveData<List<Contato>> searchResults;

        public ContatoViewModel (Application application) {
            super(application);
            mRepository = new ContatoRepository(application);
            mAllContatos = mRepository.getAllContatos();
        }

        public void insert(Contato c) {mRepository.insert(c); }

        public  void  delete(Contato c){mRepository.delete(c);}

        public  void  update(Contato c){mRepository.update(c);}

        public LiveData<List<Contato>> getAllContatos() { return mAllContatos; }
}
