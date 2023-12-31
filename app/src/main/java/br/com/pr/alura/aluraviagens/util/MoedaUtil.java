package br.com.pr.alura.aluraviagens.util;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_ESPERADO = "R$ ";

    @NonNull
    public static String formataParaMoedaBrasileira(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                new Locale(PORTUGUES, BRASIL));
        return formatoBrasileiro
                .format(valor)
                .replace(FORMATO_PADRAO, FORMATO_ESPERADO);

    }

}
