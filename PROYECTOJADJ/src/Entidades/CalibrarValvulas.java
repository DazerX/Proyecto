/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author USER
 */
public class CalibrarValvulas extends Servicio{
    
    private int numClindros;
    private double precio1;
    private double precio2;

    public CalibrarValvulas( String descripcion, double porcentaje,double precio1,double precio2) {
        super("Calibrar Valvulas", descripcion, porcentaje);
        this.numClindros = 0;
        this.precio1=precio1;
        this.precio2=precio2;
    }

    public int getNumClindros() {
        return numClindros;
    }

    public void setNumClindros(int numClindros) {
        this.numClindros = numClindros;
    }

    public double getPrecio1() {
        return precio1;
    }

    public void setPrecio1(double precio1) {
        this.precio1 = precio1;
    }

    public double getPrecio2() {
        return precio2;
    }

    public void setPrecio2(double precio2) {
        this.precio2 = precio2;
    }

    
    
    @Override
    public void calcularCosto(int noCilindros) {
        if(noCilindros == 3 || noCilindros == 4){
            super.setCosto(this.precio1);
        }
        if(noCilindros == 6){
            super.setCosto(this.precio2);
        }else{
            System.out.println("Error... noCilindros incorrectos");
        }
    }
    
    @Override
    public String toString() {
        return super.toString()+
              "precio del servicio= "+super.getCosto();  
    }
}
