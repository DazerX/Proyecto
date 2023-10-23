package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Nomina {

    private Tecnico tecnico;
    private double pago;
    private ArrayList<Factura> listaFacturas;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private ArrayList<Servicio> serviciosTecnico;
    private ArrayList<LocalDate> fechaRealizaciones;

    public Nomina(Tecnico tecnico, ArrayList<Factura> listaFacturas, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.tecnico = tecnico;
        this.pago = 0;
        this.listaFacturas = listaFacturas;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.serviciosTecnico = new ArrayList();
        this.fechaRealizaciones = new ArrayList();
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public ArrayList<Servicio> getServiciosTecnico() {
        return serviciosTecnico;
    }

    public void setServiciosTecnico(ArrayList<Servicio> serviciosTecnico) {
        this.serviciosTecnico = serviciosTecnico;
    }

    public void addServicios(Servicio s) {
        this.serviciosTecnico.add(s);
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public ArrayList<Factura> rangoFacturas() {
        ArrayList<Factura> facturasRango = new ArrayList();
        for (Factura factura : this.getListaFacturas()) {
            if (factura.getFecha().isAfter(this.getFechaInicio()) && factura.getFecha().isBefore(this.getFechaFinal())) {
                facturasRango.add(factura);
            }
        }
        return facturasRango;
    }

    public ArrayList<LocalDate> getFechaRealizaciones() {
        return fechaRealizaciones;
    }

    public void setFechaRealizaciones(ArrayList<LocalDate> fechaRealizaciones) {
        this.fechaRealizaciones = fechaRealizaciones;
    }

    public void addFechasRealizacion(LocalDate fecha) {
        this.fechaRealizaciones.add(fecha);
    }

    public void calcularPago() {
        double comision = 0;
        ArrayList<Factura> rangoFactura = this.rangoFacturas();
        if (rangoFactura == null) {
            System.out.println("No existen facturas creadas");
        } else {
            for (Factura f : rangoFactura) {
                if (this.getTecnico().getCedula().equals(f.getTech().getCedula())) {
                    comision += f.getPrecio();
                    this.addServicios(f.getServicio());
                    this.addFechasRealizacion(f.getFecha());
                }
                for (Tecnico t : f.getTecnicos()) {
                    if (this.getTecnico().getCedula().equals(t.getCedula())) {
                        comision += f.getPrecio();
                        this.addServicios(f.getServicio());
                        this.addFechasRealizacion(f.getFecha());
                    }
                }
            }
            this.setPago(this.getPago() + comision);
        }
    }

    public void ImprimirNomina() {

        ArrayList<Factura> rangoFactura = this.rangoFacturas();
        if (rangoFactura == null) {
            System.out.println("No existen facturas creadas");
        } else {
            System.out.printf("Nomina de empleado\n "
                    + this.getTecnico().toString() + "\n"
                    + "valor a pagar= " + this.getPago() + "\n"
                    + "Servicios realizados " + this.fechaInicio + "-" + this.fechaFinal + "= ");
            for (Factura f : rangoFactura) {
                if (this.tecnico.getCedula().equals(f.getTech().getCedula())) {
                    System.out.println(f.getServicio().getNombreServicio() + f.getFecha().toString());
                }
                for (Tecnico t : f.getTecnicos()) {
                    if (this.getTecnico().getCedula().equals(t.getCedula()));
                        System.out.println(f.getServicio().getNombreServicio() + f.getFecha().toString());
                    }
                }
            }
        }
    }

    /*
Tareas
Completar nomina 
Completar factura
     */
