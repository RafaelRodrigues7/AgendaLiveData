package br.edu.ifspsaocarlos.agendalivedata.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


import br.edu.ifspsaocarlos.agendalivedata.R;
import br.edu.ifspsaocarlos.agendalivedata.viewmodel.ContatoViewModel;
import br.edu.ifspsaocarlos.agendalivedata.model.Contato;


public class CadastroActivity extends AppCompatActivity {

    ContatoViewModel contatoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        contatoViewModel = new ViewModelProvider(this).get(ContatoViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_salvarContato) {


            String nome = ((EditText) findViewById(R.id.editTextNome)).getText().toString();
            String fone = ((EditText) findViewById(R.id.editTextFone)).getText().toString();
            String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();

            final Contato c = new Contato();
            c.setNome(nome);
            c.setFone(fone);
            c.setEmail(email);

            contatoViewModel.insert(c);
            Toast.makeText(this,"Cadastrado com sucesso",Toast.LENGTH_LONG).show();
            finish();

        }

        return super.onOptionsItemSelected(item);
    }


}
