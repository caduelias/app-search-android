package com.example.trabalho2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText edtBusca;
    Button btnBusca;
    WebView Site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtBusca = findViewById(R.id.edtBusca);
        btnBusca = findViewById(R.id.btnBusca);
        Site = findViewById(R.id.Site);

        Site.setWebViewClient(new WebViewClient());

        Site.loadUrl("https://github.com/caduelias/app-search-android");

        btnBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtBusca.getText().toString().isEmpty()) {
                    mostrarMensagem("Digite sua Busca!");
                    return;
                }
                Site.loadUrl("https://www.google.com/search?q=" + codificarURL(edtBusca.getText().toString()));
            }
        });
    }
        private String codificarURL (String p){
            try {
                return URLEncoder.encode(p, "utf-8");
            } catch (Exception e) {
                return "";
            }
        }

        private void mostrarMensagem(final String texto){
            // Criando alerta para exibir mensagem na tela
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Alerta");
            alerta.setMessage(texto);
            alerta.setNeutralButton("Ok", null);
            alerta.show();
    }
}
