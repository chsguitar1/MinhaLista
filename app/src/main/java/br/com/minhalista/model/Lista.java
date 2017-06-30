package br.com.minhalista.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Usuario on 30/06/2017.
 */

public class Lista implements Serializable {

    private String nomeLista;
    private Date dataLista;
    private Boolean statusLista;
    List<ItensLista> itensDaLista;

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public Date getDataLista() {
        return dataLista;
    }

    public void setDataLista(Date dataLista) {
        this.dataLista = dataLista;
    }

    public Boolean getStatusLista() {
        return statusLista;
    }

    public void setStatusLista(Boolean statusLista) {
        this.statusLista = statusLista;
    }

    public List<ItensLista> getItensDaLista() {
        return itensDaLista;
    }

    public void setItensDaLista(List<ItensLista> itensDaLista) {
        this.itensDaLista = itensDaLista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lista lista = (Lista) o;

        if (nomeLista != null ? !nomeLista.equals(lista.nomeLista) : lista.nomeLista != null)
            return false;
        if (dataLista != null ? !dataLista.equals(lista.dataLista) : lista.dataLista != null)
            return false;
        if (statusLista != null ? !statusLista.equals(lista.statusLista) : lista.statusLista != null)
            return false;
        return itensDaLista != null ? itensDaLista.equals(lista.itensDaLista) : lista.itensDaLista == null;

    }

    @Override
    public int hashCode() {
        int result = nomeLista != null ? nomeLista.hashCode() : 0;
        result = 31 * result + (dataLista != null ? dataLista.hashCode() : 0);
        result = 31 * result + (statusLista != null ? statusLista.hashCode() : 0);
        result = 31 * result + (itensDaLista != null ? itensDaLista.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "nomeLista='" + nomeLista + '\'' +
                ", dataLista=" + dataLista +
                ", statusLista=" + statusLista +
                '}';
    }
}
