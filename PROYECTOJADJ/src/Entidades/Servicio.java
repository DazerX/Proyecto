package Entidades;

import java.util.Random;

public abstract class Servicio {
 
    private String nombreServicio;
    private String descripcion;
    private double costo;
    private double porcentaje;
    private String codigo;
    private String caracteresPermitidos = "0123456789";

    public Servicio(String nombreServicio, String descripcion,double porcentaje) {
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.costo = 0;
        this.porcentaje = porcentaje;
        StringBuilder codigoAleatorio = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int indice = random.nextInt(caracteresPermitidos.length());
            char caracterAleatorio = caracteresPermitidos.charAt(indice);
            codigoAleatorio.append(caracterAleatorio);
        }
        this.codigo=codigoAleatorio.toString();
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String Codigo) {
        this.codigo = Codigo;
    }

    @Override
    public String toString() {
        return "Servicio"+
                "nombreServicio= " + nombreServicio+"\n" + 
                ", descripcion= " + descripcion +"\n" + 
                ", costo= " + costo + "\n" +
                ", porcentaje= " + porcentaje +"\n" + 
                ", codigo= " + codigo+"\n" ;
                
    }
    
    public abstract void calcularCosto(int numero);
    
    
}
/*
No debemos inicializar los precios eso lo hace el usuario
*/