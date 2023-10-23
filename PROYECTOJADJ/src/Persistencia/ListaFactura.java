package Persistencia;

import Entidades.Factura;
import java.util.ArrayList;
import java.util.List;

public class ListaFactura implements IListaFactura{
    
    private List<Factura> ListaFactura;

    public ListaFactura() {
        this.ListaFactura = new ArrayList();
    }

    @Override
    public void adicionarFactura(Factura f) {
        this.ListaFactura.add(f);
    }

    @Override
    public ArrayList<Factura> obtenerfacturas() {
        ArrayList<Factura> fact = new ArrayList(this.ListaFactura);
        return fact;
    }

    @Override
    public Factura buscarFactura(int noFactura) {
        Factura factBus = null;
        for(Factura fa: this.ListaFactura){
            if(fa.getConsecutivo() == noFactura){
                factBus = fa;
            }
        }
        return factBus;
    }
    @Override
    public void eliminarFactura(int noFactura){
        Factura factBorrar=this.buscarFactura(noFactura);
        this.ListaFactura.remove(factBorrar);
    }


}
