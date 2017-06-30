package br.com.minhalista.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.minhalista.R;

/**
 * Created by Usuario on 30/06/2017.
 */

public class MeuHolder extends RecyclerView.ViewHolder {

    public TextView descricao;

    public MeuHolder(View itemView) {
        super(itemView);
        descricao = (TextView) itemView.findViewById(R.id.tv_descricao_lista);

    }
}
