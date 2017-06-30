package br.com.minhalista.activities;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.minhalista.R;
import br.com.minhalista.adapters.MeuAdapter;
import br.com.minhalista.model.Lista;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcLista;
    FloatingActionButton fabAdd;
    List<Lista> minhasListas;
    MeuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcLista = (RecyclerView) findViewById(R.id.rc_lista);
        fabAdd = (FloatingActionButton) findViewById(R.id.fla_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        minhasListas = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcLista.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        adapter = new MeuAdapter(minhasListas);
        rcLista.setAdapter(adapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        rcLista.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void dialog() {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle("Nova Lista");
        mensagem.setMessage("Insira um nome para a lista");
        // DECLARACAO DO EDITTEXT
        final EditText input = new EditText(this);
        mensagem.setView(input);
        mensagem.setNeutralButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                addLista(input.getText().toString());

            }

        });


        mensagem.show();
    }

    void addLista(String nomeLista){

        Lista ladd = new Lista();
        ladd.setDataLista(new Date());
        ladd.setNomeLista(nomeLista);
        ladd.setStatusLista(true);
        adapter.atualizaLista(ladd);

    }
}
