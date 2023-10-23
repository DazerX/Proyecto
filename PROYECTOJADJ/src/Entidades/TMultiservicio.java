package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class TMultiservicio extends Tecnico{

    private ArrayList<Servicio> Oficios;

    public TMultiservicio( String tipoTecnico,String nombre, String apellido, String cedula, LocalDate fechaIngreso, String detalle) {
        super(tipoTecnico,nombre, apellido, cedula, fechaIngreso, detalle);
        this.Oficios = new ArrayList();
    }

    public ArrayList<Servicio> getOficios() {
        return Oficios;
    }

    public void setOficios(ArrayList<Servicio> Oficios) {
        this.Oficios = Oficios;
    }

    public ArrayList<Servicio> addServicio(Servicio servicio){
        this.Oficios.add(servicio);
        return Oficios;
    }

    
    @Override
    public void MostrarTecnico() {
              super.MostrarTecnico();
               System.out.println("Servicios que ofrece: ");
                for(Servicio s: this.getOficios()){
                    System.out.println(s.getNombreServicio());   
                } 
    }
    

    
}
