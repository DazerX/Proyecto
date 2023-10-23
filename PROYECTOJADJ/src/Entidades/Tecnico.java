package Entidades;

import java.time.LocalDate;

public abstract class Tecnico {
    
    private String nombre;
    private String apellido;
    private String cedula;
    private LocalDate fechaIngreso;
    private String detalle;
    private String tipoTecnico;

    public Tecnico(String tipoTecnico,String nombre, String apellido, String cedula, LocalDate fechaIngreso, String detalle) {
        this.tipoTecnico=tipoTecnico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipoTecnico() {
        return tipoTecnico;
    }

    public void setTipoTecnico(String tipoTecnico) {
        this.tipoTecnico = tipoTecnico;
    }

    
    public void MostrarTecnico() {
               System.out.println("Tecnico: + \n"+
                "Nombre= " + this.getNombre() +"\n"+ 
                "Apellido= " + this.getApellido() + "\n"+
                "cedula= " + this.getCedula() + "\n"+
                "fechaIngreso= " + this.fechaIngreso + "\n"+
                "Especialidad= " + this.getDetalle() + "\n"+
                "Tipo Tecnico= " + this.getTipoTecnico() ); 
    }
    



}
