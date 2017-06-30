package br.com.minhalista.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.minhalista.R;
import br.com.minhalista.model.Lista;

/**
 * Created by Usuario on 30/06/2017.
 */

public class MeuAdapter extends RecyclerView.Adapter<MeuHolder> {
    List<Lista> lista;

    public MeuAdapter(List<Lista> lista) {
        this.lista = lista;
    }

    @Override
    public MeuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeuHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista, parent, false));
    }

    @Override
    public void onBindViewHolder(MeuHolder holder, int position) {
      holder.descricao.setText(lista.get(position).getNomeLista());

    }

    @Override
    public int getItemCount() {
        //return lista != null ? lista.size() : 0;
        if(lista != null){
            return lista.size();
        }else{
            return 0;
        }
    }
    public void atualizaLista(Lista novalista){

        lista.add(novalista);
        notifyItemInserted(getItemCount());
    }
}
