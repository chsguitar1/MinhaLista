package br.com.minhalista.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.minhalista.R;
import br.com.minhalista.adapters.MeuItemAdapter;
import br.com.minhalista.model.ItensLista;
import br.com.minhalista.model.Lista;

public class ItemAcitivity extends AppCompatActivity {
    RecyclerView rcItensDaLista;
    List<ItensLista> meusItens;
    MeuItemAdapter adapter;
    Lista minhaLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_acitivity);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            minhaLista = (Lista) extras.getSerializable("lista");
            if(minhaLista.getItensDaLista().isEmpty()){
                meusItens = new ArrayList<>();
            }else{
                meusItens = minhaLista.getItensDaLista();
            }

        }
        rcItensDaLista = (RecyclerView) findViewById(R.id.rcv_itens);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcItensDaLista.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        adapter = new MeuItemAdapter(meusItens);
        rcItensDaLista.setAdapter(adapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        rcItensDaLista.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("additem").setIcon(R.drawable.ic_add_white_24px).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.getTitle().equals("additem")) {
            dialog();
        }

        return super.onOptionsItemSelected(item);
    }


    private void dialog() {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(ItemAcitivity.this);
        mensagem.setTitle("Novo Item");
        mensagem.setMessage("Insira um nome para o novo item");
        // DECLARACAO DO EDITTEXT
        final EditText input = new EditText(this);
        mensagem.setView(input);
        mensagem.setNeutralButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                addItem(input.getText().toString());

            }

        });


        mensagem.show();
    }
    void addItem(String nomeItem){

        ItensLista lItem = new ItensLista();
        lItem.setDescricaoItem(nomeItem);
        lItem.setStatusLista(false);
        lItem.setLista(minhaLista);
        minhaLista.getItensDaLista().add(lItem);

        adapter.atualizaLista(lItem);


    }
}
