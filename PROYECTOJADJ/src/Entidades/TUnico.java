package Entidades;

import java.time.LocalDate;

public class TUnico extends Tecnico{

    private Servicio oficio;

    public TUnico(String tipoTecnico,Servicio oficio, String nombre, String apellido, String cedula, LocalDate fechaIngreso, String detalle) {
        super(tipoTecnico,nombre, apellido, cedula, fechaIngreso, detalle);
        this.oficio = oficio;
    }

    public Servicio getOficio() {
        return oficio;
    }

    public void setOficio(Servicio oficio) {
        this.oficio = oficio;
    }

    @Override
    public void MostrarTecnico() {
        super.MostrarTecnico();
        System.out.println("Servicio que ofrece: "+this.getOficio().getNombreServicio());
    }

   
  
    

}
