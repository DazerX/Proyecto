package Persistencia;

import Entidades.Servicio;
import java.util.ArrayList;


public interface IListaServicio {
     public void adicionarServicio(Servicio s);
    public ArrayList<Servicio> obtenerServicios();
    public Servicio buscarServicio(String codigo);
    public void borrarServicio(String codigo);
}
