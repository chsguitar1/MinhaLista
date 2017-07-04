package br.com.minhalista.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import br.com.minhalista.R;

/**
 * Created by cristiano on 03/07/17.
 */

public class MeuItensHolder extends RecyclerView.ViewHolder {
    public TextView descricao;
    public CheckBox status;

    public MeuItensHolder(View itemView) {
        super(itemView);
        descricao = (TextView) itemView.findViewById(R.id.tv_descr_item);
        status = (CheckBox) itemView.findViewById(R.id.chk_status);

    }
}
