package Persistencia;

import Entidades.Factura;
import java.util.ArrayList;

public interface IListaFactura {

    public void adicionarFactura(Factura f);
    public ArrayList<Factura> obtenerfacturas();
    public Factura buscarFactura(int noFactura);
    public void eliminarFactura(int noFactura);
}
