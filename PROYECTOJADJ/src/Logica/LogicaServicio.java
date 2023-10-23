package Logica;

import Entidades.Servicio;
import Persistencia.IListaServicio;
import Persistencia.ListaServicio;
import java.util.ArrayList;


public class LogicaServicio {
    private IListaServicio dato3;
    
    public LogicaServicio() {
    this.dato3= new ListaServicio();
    }
    
    public void registrarServicio(Servicio s){
        this.dato3.adicionarServicio(s);
    }
    
    public ArrayList<Servicio> consultarServicios(){
        return this.dato3.obtenerServicios();
    }
    
    public Servicio buscarServicio(String codigo){
        Servicio t = this.dato3.buscarServicio(codigo);
        return t;
    }
    public void borrarServicio(String codigo){
        this.dato3.borrarServicio(codigo);
    }
}
