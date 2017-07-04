package br.com.minhalista.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.minhalista.R;
import br.com.minhalista.model.ItensLista;

/**
 * Created by cristiano on 03/07/17.
 */

public class MeuItemAdapter extends  RecyclerView.Adapter<MeuItensHolder> {
    List<ItensLista> itensLista;

    public MeuItemAdapter(List<ItensLista> lista) {
        this.itensLista = lista;
    }

    @Override
    public MeuItensHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeuItensHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itens_lista, parent, false));
    }

    @Override
    public void onBindViewHolder(MeuItensHolder holder, int position) {
        holder.descricao.setText(itensLista.get(position).getDescricaoItem());
        holder.status.setSelected(itensLista.get(position).getStatusLista());

    }

    @Override
    public int getItemCount() {
        //return itensLista != null ? itensLista.size() : 0;
        if(itensLista != null){
            return itensLista.size();
        }else{
            return 0;
        }
    }
    public void atualizaLista(ItensLista novoItem){

        itensLista.add(novoItem);
        notifyItemInserted(getItemCount());
    }
}
