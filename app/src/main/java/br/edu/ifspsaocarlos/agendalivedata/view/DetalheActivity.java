package br.edu.ifspsaocarlos.agendalivedata.view;

import androidx.lifecycle.ViewModelProvider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


import br.edu.ifspsaocarlos.agendalivedata.viewmodel.ContatoViewModel;
import br.edu.ifspsaocarlos.agendalivedata.model.Contato;
import br.edu.ifspsaocarlos.agendalivedata.R;


public class DetalheActivity extends AppCompatActivity {
    private Contato c;

    private ContatoViewModel contatoViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);


        contatoViewModel = new ViewModelProvider(this).get(ContatoViewModel.class);


        if (getIntent().hasExtra("contato"))
        {
            this.c = (Contato) getIntent().getSerializableExtra("contato");
            EditText nameText = findViewById(R.id.editTextNome);
            nameText.setText(c.getNome());
            EditText foneText = findViewById(R.id.editTextFone);
            foneText.setText(c.getFone());
            EditText emailText = findViewById(R.id.editTextEmail);
            emailText.setText(c.getEmail());
            int pos =c.getNome().indexOf(" ");
            if (pos==-1)
                pos=c.getNome().length();
            setTitle(c.getNome().substring(0,pos));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe, menu);
        if (!getIntent().hasExtra("contato"))
        {
            MenuItem item = menu.findItem(R.id.action_excluirContato);
            item.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_alterarContato:
                alterar();
                return true;
            case R.id.action_excluirContato:
                apagar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void apagar()
    {

        contatoViewModel.delete(c);
        Toast.makeText(this,"Removido com sucesso",Toast.LENGTH_LONG).show();
        finish();

    }

    private void alterar()
    {
        String name = ((EditText) findViewById(R.id.editTextNome)).getText().toString();
        String fone = ((EditText) findViewById(R.id.editTextFone)).getText().toString();
        String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();

        c.setNome(name);
        c.setFone(fone);
        c.setEmail(email);

        contatoViewModel.update(c);
        Toast.makeText(this,"Alterado com sucesso",Toast.LENGTH_LONG).show();

        finish();


    }
}

