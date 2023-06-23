package br.com.pr.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.pr.alura.aluraviagens.R;
import br.com.pr.alura.aluraviagens.model.Pacote;
import br.com.pr.alura.aluraviagens.util.DataUtil;
import br.com.pr.alura.aluraviagens.util.MoedaUtil;
import br.com.pr.alura.aluraviagens.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APP_BAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);
        mostraImagem(pacoteSaoPaulo);
        mostraData(pacoteSaoPaulo);
        mostraPreco(pacoteSaoPaulo);

    }
    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moedaBrasileira = MoedaUtil
                .formataParaMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data_pacote);
        String periodoEmTexto = DataUtil
                .periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }
    private void mostraImagem(Pacote pacoteSaoPaulo) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawableDoPacote = ResourcesUtil
                .devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }
    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}