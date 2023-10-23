package Persistencia;

import Entidades.Servicio;
import java.util.ArrayList;

public class ListaServicio implements IListaServicio {
    private  ArrayList<Servicio> ListaServicio;

    public ListaServicio() {
        this.ListaServicio = new ArrayList();
    }

    @Override
    public void adicionarServicio(Servicio s) {
        this.ListaServicio.add(s);
    }

    @Override
    public ArrayList<Servicio> obtenerServicios() {
        ArrayList<Servicio> fact = new ArrayList(this.ListaServicio);
        return fact;
    }

    @Override
    public Servicio buscarServicio(String codigo) {
        Servicio serviBusc = null;
        for(Servicio se: this.ListaServicio){
            if(se.getCodigo().equals(codigo)){
                serviBusc = se;
            }
        }
        return serviBusc;
    }
    @Override
    public void borrarServicio(String codigo){
        Servicio servBorrar=this.buscarServicio(codigo);
        this.ListaServicio.remove(servBorrar);
    }



}
