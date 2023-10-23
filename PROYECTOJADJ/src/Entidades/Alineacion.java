/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author USER
 */
public class Alineacion extends Servicio{
    
    private int numRing;
    private double precio1;
    private double precio2;
    private double precio3;

    public Alineacion(  String descripcion, double porcentaje,double precio1,double precio2,double precio3) {
        super("Alineacion", descripcion, porcentaje);
        this.numRing=0;
        this.precio1=precio1;
        this.precio2=precio2;
        this.precio3=precio3;
    }

    public int getNumRing() {
        return numRing;
    }

    public void setNumRing(int numRing) {
        this.numRing = numRing;
    }

    
    
    @Override
    public void calcularCosto(int noRing) {
        if(noRing>12 || noRing<14){
            super.setCosto(100000);
        }else{
            System.out.println("ERROR...numero de ring incorrecto");
        }
    }

    @Override
    public String toString() {
       return super.toString() +
               "precio del servicio= "+super.getCosto();
    }

    

    
   
}
