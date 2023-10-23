package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
   
    private String nomCliente; 
    private LocalDate fecha;
    private double precio;
    private int consecutivo;
    private static int noConsecutivo=0;
    private Vehiculo auto;
    
    private String tVehiculo;
    private ArrayList<Tecnico> tecnicos;
    private Tecnico tech;
    private Servicio servicio;
    private ArrayList<Servicio> servicios;
    
    public Factura(){
        noConsecutivo++;
        this.consecutivo = noConsecutivo;
    }


      /*
    Factura multiples tecnicos unico servicio
    */
    public Factura(String nomCliente, LocalDate fecha,String tVehiculo,String placa, String marca, String modelo, int noCilindro,int tamRing,Tecnico tech,Servicio servicio) {
        this.auto=new Vehiculo(tVehiculo, placa, marca, modelo,  noCilindro, tamRing);
        this.nomCliente = nomCliente;
        this.fecha = fecha;
        this.precio = 0;
        noConsecutivo++;
        this.consecutivo = noConsecutivo;
        this.tVehiculo=tVehiculo;
        this.tech=tech;
        this.servicio=servicio;
        this.servicios=null;
    }
    public Factura(String nomCliente, LocalDate fecha,String tVehiculo,String placa, String marca, String modelo, int noCilindro,int tamRing,Tecnico tech,ArrayList<Servicio> servicios) {
        this.auto=new Vehiculo(tVehiculo, placa, marca, modelo,  noCilindro, tamRing);
        this.nomCliente = nomCliente;
        this.fecha = fecha;
        this.precio = 0;
        noConsecutivo++;
        this.consecutivo = noConsecutivo;
        this.tVehiculo=tVehiculo;
        this.tech=tech;
        this.servicio=null;
        this.servicios=servicios;
    }

    public Factura(String nomCliente, LocalDate fecha,String tVehiculo,String placa, String marca, String modelo, int noCilindro,int tamRing,ArrayList<Tecnico> tecnicos,ArrayList<Servicio> servicios) {
        this.auto=new Vehiculo(tVehiculo, placa, marca, modelo,  noCilindro, tamRing);
        this.nomCliente = nomCliente;
        this.fecha = fecha;
        this.precio = 0;
        noConsecutivo++;
        this.consecutivo = noConsecutivo;
        this.tVehiculo=tVehiculo;
        this.tecnicos=tecnicos;
        this.tech=null;
        this.servicios=servicios;
        this.servicio=null;
    }
    public Factura(String nomCliente, LocalDate fecha,String tVehiculo,String placa, String marca, String modelo, int noCilindro,int tamRing,ArrayList<Tecnico> tecnicos,Servicio servicio) {
        this.auto=new Vehiculo(tVehiculo, placa, marca, modelo,  noCilindro, tamRing);
        this.nomCliente = nomCliente;
        this.fecha = fecha;
        this.precio = 0;
        noConsecutivo++;
        this.consecutivo = noConsecutivo;
        this.tVehiculo=tVehiculo;
        this.tecnicos=tecnicos;
        this.tech=null;
        this.servicios=null;
        this.servicio=servicio;
    }

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Tecnico getTech() {
        return tech;
    }

    public void setTech(Tecnico tech) {
        this.tech = tech;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Vehiculo getAuto() {
        return auto;
    }

    public void setAuto(Vehiculo auto) {
        this.auto = auto;
    }
    

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public static int getNoConsecutivo() {
        return noConsecutivo;
    }

    public static void setNoConsecutivo(int noConsecutivo) {
        Factura.noConsecutivo = noConsecutivo;
    }

    public String gettVehiculo() {
        return tVehiculo;
    }

    public void settVehiculo(String tVehiculo) {
        this.tVehiculo = tVehiculo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    
    public void calcularCostoMultiServicios(){
        for(Servicio sec: this.getServicios()){
            this.precio += sec.getCosto();
        }
    }
    //Metodo sobrecargado para unico servicio realizado
     public void calcularCostoUnicoServicio(){
         
            this.setPrecio(this.getServicio().getCosto());
    }
    public void ImprimirFactura() {
        System.out.printf("Factura " +
                "NoFactura= "+this.getConsecutivo()+
                "Nombre Cliente= " + nomCliente +
                "Fecha= " + this.getFecha().toString() + 
                "Precio= " +this.getPrecio() + 
                "Tipo Vehiculo= " + tVehiculo +
                "Vehiculo =" + this.getAuto().toString() + 
                "Servicio=" + servicio+ 
                "Servicios=" + servicios + '}'); 
               if(this.getServicios()==null){
                   System.out.println("Tecnico:  \n"+
                           "Nombre= "+this.getTech().getNombre()+" "+this.getTech().getApellido()+"\n"+
                           "Oficio= "+this.getTech().getDetalle());
               }else{
                   System.out.println("Tecnicos: ");
                   for(Tecnico t : this.getTecnicos()){
                       System.out.println(
                               "Nombre= "+t.getNombre()+" "+t.getApellido()+"\n"+
                               "Oficio= "+t.getDetalle());
                   }
               }
               if(this.getServicios()==null){
                   System.out.println("Servicio Realizado: \n"+
                           "Servicio= "+this.getServicio().getNombreServicio());
               }else{
                   System.out.println("Servicios Realizados: \n ");
                   for(Servicio s: this.getServicios()){
                       System.out.println("Servicio= "+s.getNombreServicio());
                   }
               }
    }

   
    

}
/*
Corregir La factura colocar el ArrayList de Servicios como atributo
O en su defecto solo un unico servicio
*/