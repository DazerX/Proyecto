package Logica;

import Entidades.Tecnico;
import Persistencia.IListaTecnico;
import Persistencia.ListaTecnico;
import java.util.ArrayList;


public class LogicaEmpleado {
    
    private IListaTecnico dato2;

    public LogicaEmpleado() {
        this.dato2=new ListaTecnico();
    }
    
    public void registrarEmpleado(Tecnico t){
        this.dato2.addTecnico(t);
    }
    
    public ArrayList<Tecnico> consultarTecnico(){
        return this.dato2.obbTecnico();
    }
    
    public Tecnico buscarTecnico(String cedula){
        Tecnico t = this.dato2.buscarTecnico(cedula);
        return t;
    }
    public void eliminarTecnico(String cedula){
        this.dato2.eliminarTecnico(cedula);
    }
}
