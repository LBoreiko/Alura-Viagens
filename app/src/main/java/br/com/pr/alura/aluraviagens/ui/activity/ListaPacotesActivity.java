package br.com.pr.alura.aluraviagens.ui.activity;

import static br.com.pr.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import java.util.List;
import br.com.pr.alura.aluraviagens.R;
import br.com.pr.alura.aluraviagens.dao.PacoteDao;
import br.com.pr.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;
import br.com.pr.alura.aluraviagens.model.Pacote;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraLista();

    }
    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this ));
        listaDePacotes.setOnItemClickListener((parent, view, position, id) -> {
            Pacote pacoteClicado = pacotes.get(position);
            vaiParaResumoPacote(pacoteClicado);
        });
    }

    private void vaiParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this,
                ResumoPacotesActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}