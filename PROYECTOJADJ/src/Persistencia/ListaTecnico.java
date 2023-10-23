package Persistencia;

import Entidades.Tecnico;
import java.util.ArrayList;


public class ListaTecnico implements IListaTecnico{

    private ArrayList<Tecnico> ListaTecnico;

    public ListaTecnico() {
        this.ListaTecnico = new ArrayList();
    }
    
    
    
    @Override
    public void addTecnico(Tecnico t) {
        this.ListaTecnico.add(t);
    }

    @Override
    public ArrayList<Tecnico> obbTecnico() {
        ArrayList<Tecnico> tech = new ArrayList(this.ListaTecnico);
        return tech;
    }

    @Override
    public Tecnico buscarTecnico(String cedula) {
        Tecnico encontrado = null;
        for(Tecnico tech: this.ListaTecnico){
            if(tech.getCedula().equals(cedula)){
                encontrado = tech;
                break;
            }
        }
        return encontrado;
    }
    
    @Override
    public void eliminarTecnico(String cedula){
        Tecnico tecBorrar = this.buscarTecnico(cedula);
        this.ListaTecnico.remove(tecBorrar);
    }
    
}
