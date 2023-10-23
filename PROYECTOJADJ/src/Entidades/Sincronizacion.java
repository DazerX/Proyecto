package Entidades;

public class Sincronizacion extends Servicio{
    
    private int numCilindros;
    private double precio1;
    private double precio2;
    private double precio3;
    
    public Sincronizacion( String descripcion, double porcentaje,double precio1,double precio2,double precio3) {
        super("Sincronizacion", descripcion, porcentaje);
        this.numCilindros=0;
        this.precio1=precio1;
        this.precio2=precio2;
        this.precio3=precio3;
    }

    public int getNumCilindros() {
        return numCilindros;
    }

    public void setNumCilindros(int numCilindros) {
        this.numCilindros = numCilindros;
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

    public double getPrecio3() {
        return precio3;
    }

    public void setPrecio3(double precio3) {
        this.precio3 = precio3;
    }
    
    
    
    
    @Override
    public void calcularCosto(int noCilindros) {
        switch(noCilindros){
            case 3 -> super.setCosto(this.precio1);
            case 4 -> super.setCosto(this.precio1);
            case 6 -> super.setCosto(this.precio2);
            case 8 -> super.setCosto(this.precio3);
            default -> System.out.println("Error... numero de cilindros invalidos");
        }
    }
    
    @Override
    public String toString() {
        return super.toString()+
                "precio del servicio= "+super.getCosto();
        
    }


}
