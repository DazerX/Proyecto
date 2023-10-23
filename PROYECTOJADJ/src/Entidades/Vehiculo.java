package Entidades;

public class Vehiculo {
    
    private String placa;
    private String marca;
    private String modelo;
    private int noCilindro;
    private int tamRing;
    private String tVehiculo;

    public Vehiculo(String tVehiculo, String placa, String marca, String modelo, int noCilindro, int tamRing ) {
        this.tVehiculo=tVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.noCilindro = noCilindro;
        this.tamRing=tamRing;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNoCilindro() {
        return noCilindro;
    }

    public void setNoCilindro(int noCilindro) {
        this.noCilindro = noCilindro;
    }

    public int getTamRing() {
        return tamRing;
    }

    public void setTamRing(int tamRing) {
        this.tamRing = tamRing;
    }

    public String gettVehiculo() {
        return tVehiculo;
    }

    public void settVehiculo(String tVehiculo) {
        this.tVehiculo = tVehiculo;
    }
    
}
