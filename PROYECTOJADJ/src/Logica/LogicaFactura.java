package Logica;

import Entidades.Factura;
import Persistencia.IListaFactura;
import Persistencia.ListaFactura;
import java.util.ArrayList;

public class LogicaFactura {
    
    private IListaFactura dato;

    public LogicaFactura() {
        this.dato = new ListaFactura();
    }
    
    public void registrarFactura(Factura f){
        this.dato.adicionarFactura(f);
    }
    
    public ArrayList<Factura> consultarFacturas(){
        return this.dato.obtenerfacturas();
    }
    
    public Factura buscarFactura(int noFactura){
        Factura f= this.dato.buscarFactura(noFactura);
        return f;
    }
   public void eliminarFactura(int noFactura){
       this.dato.eliminarFactura(noFactura);
   }
}
