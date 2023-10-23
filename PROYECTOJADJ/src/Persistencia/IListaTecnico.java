package Persistencia;

import Entidades.Tecnico;
import java.util.ArrayList;

public interface IListaTecnico {
    public void addTecnico(Tecnico t);
    public ArrayList<Tecnico> obbTecnico();
    public Tecnico buscarTecnico(String cedula);
    public void eliminarTecnico(String cedula);
}
