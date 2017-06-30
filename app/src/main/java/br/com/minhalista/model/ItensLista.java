package br.com.minhalista.model;

import java.io.Serializable;

/**
 * Created by Usuario on 30/06/2017.
 */

public class ItensLista implements Serializable {
    private String descricaoItem;
    private Boolean statusLista;
    private Lista lista;

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public Boolean getStatusLista() {
        return statusLista;
    }

    public void setStatusLista(Boolean statusLista) {
        this.statusLista = statusLista;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItensLista that = (ItensLista) o;

        if (descricaoItem != null ? !descricaoItem.equals(that.descricaoItem) : that.descricaoItem != null)
            return false;
        if (statusLista != null ? !statusLista.equals(that.statusLista) : that.statusLista != null)
            return false;
        return lista != null ? lista.equals(that.lista) : that.lista == null;

    }

    @Override
    public int hashCode() {
        int result = descricaoItem != null ? descricaoItem.hashCode() : 0;
        result = 31 * result + (statusLista != null ? statusLista.hashCode() : 0);
        result = 31 * result + (lista != null ? lista.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItensLista{" +
                "descricaoItem='" + descricaoItem + '\'' +
                ", statusLista=" + statusLista +
                ", lista=" + lista +
                '}';
    }
}
