package br.com.minhalista.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.minhalista.R;
import br.com.minhalista.activities.ItemAcitivity;
import br.com.minhalista.model.Lista;

/**
 * Created by Usuario on 30/06/2017.
 */

public class MeuListaAdapter extends RecyclerView.Adapter<MeuListaHolder> {
    List<Lista> lista;
    Context ct;

    public MeuListaAdapter(List<Lista> lista, Context ct) {
        this.lista = lista;
        this.ct = ct;
    }

    @Override
    public MeuListaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeuListaHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista, parent, false));
    }

    @Override
    public void onBindViewHolder(MeuListaHolder holder, final int position) {
      holder.descricao.setText(lista.get(position).getNomeLista());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ct,ItemAcitivity.class);
                it.putExtra("lista",lista.get(position));
                ct.startActivity(it);
            }
        });

    }

    @Override
    public int getItemCount() {
        //return itensLista != null ? itensLista.size() : 0;
        if(lista != null){
            return lista.size();
        }else{
            return 0;
        }
    }
    public void atualizaLista(Lista novaLista){

        lista.add(novaLista);
        notifyItemInserted(getItemCount());
    }
}
