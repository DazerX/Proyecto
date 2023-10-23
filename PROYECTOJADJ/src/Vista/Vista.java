package Vista;

import java.time.LocalDate;
import Entidades.*;
import Logica.*;
import java.util.ArrayList;

public class Vista {

    private LogicaFactura logicaFactura;
    private LogicaServicio logicaServicio;
    private LogicaEmpleado logicaTecnico;

    public Vista() {
        this.logicaFactura = new LogicaFactura();
        this.logicaServicio = new LogicaServicio();
        this.logicaTecnico = new LogicaEmpleado();
    }

    public void Menu() {
        System.out.println(" \n ");
        System.out.println("----------Software Taller------------");
        System.out.println("1. Factura");
        System.out.println("2. Tecnico");
        System.out.println("3. Servicio");
        System.out.println("4. Nomina");
        System.out.println("5. Salir");
    }

    public void ejecutarMenu() {
        char Op = 'S';
        while (Op == 'S') {
            this.Menu();
            int op = Entrada.leerInt("Seleccione una opcion");
            switch (op) {
                case 1:
                    this.ejecutarMenuFactura();
                    break;
                case 2:
                    this.ejecutarMenuTecnico();
                    break;
                case 3:
                    this.ejecutarMenuServicio();
                    break;
                case 4:
                    this.Nomina();
                case 5:
                    System.out.println("Aplicacion finalizada");
                    Op = 'N';
            }
        }
    }

    //Todo lo relacionado con factura
    public void MenuFactura() {
        System.out.println(" \n ");
        System.out.println("----------Factura-------------");
        System.out.println("1. Crear");
        System.out.println("2. Consultar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("5. Lista de Facturas");
        System.out.println("6. Salir");
    }

    public void ejecutarMenuFactura() {
        char Op = 'S';
        while (Op == 'S') {
            this.MenuFactura();
            int op = Entrada.leerInt("Seleccione una opcion");
            switch (op) {
                case 1:
                    this.CrearFactura();
                    break;
                case 2:
                    this.ConsultarFactura();
                    break;

                case 3:
                    this.ModificarFactura();
                    break;

                case 4:
                    this.EliminarFactura();
                    break;
                case 5:
                    this.MostrarLista();
                    break;
                case 6:
                    Op = 'N';
            }
        }
    }

    //Todo lo relacionado con Factura
    public void CrearFactura() {
        int Op = 'S';
        int tVeh;
        String tVehiculo = null;
        int tamRing;
        Factura facturaNueva = null;
        while (Op == 'S') {
            System.out.println("\n");
            System.out.println("------------Crear Factura------------------\n");
            String nombre = Entrada.leerLinea("Ingrese el nombre del Cliente");
            LocalDate fecha = LocalDate.now();//Fecha actual
            do {
                tVeh = Entrada.leerChar("Ingrese el tipo de Vehiculo Automovil->1  Camioneta->2 ");
            } while (tVeh != 1 || tVeh != 2);
            switch (tVeh) {
                case 1:
                    tVehiculo = "Automovil";
                    break;
                case 2:
                    tVehiculo = "Camioneta";
                    break;
            }
            String placa = Entrada.leerString("Ingrese la placa del vehiculo: ");
            String marca = Entrada.leerString("Ingrese la marca del vehiculo: ");
            String modelo = Entrada.leerString("Ingrese el modelo del vehiculo: ");
            int noCilindro = Entrada.leerInt("Ingrese el numero de cilindros: ");
            tamRing = Entrada.leerInt("Ingrese el tamaño del ring: ");
            char opcion = Entrada.leerChar("Servicios realizados Un solo servicio->1 Varios servicios->otro: ");

            //SERVICIOS REALIZADOS
            if (opcion == 1) {
                char OP = 'S', Op2;
                Servicio servicioRealizado = null;
                while (OP == 'S') {
                    String codigo = Entrada.leerString("Ingrese el codigo del servicio realizado al vehiculo");
                    servicioRealizado = this.logicaServicio.buscarServicio(codigo);
                    if (servicioRealizado == null) {
                        System.out.println("No existen coincidencias");
                        do {
                            OP = Entrada.leerChar("Desea volver a intentarlo Si->'S' No->'N' ");
                        } while (OP != 'S' || OP != 'N');
                    } else {
                        System.out.println(servicioRealizado.toString());
                        do {
                            Op2 = Entrada.leerChar("Desea añadirlo Si->'S' No->'N' ");
                        } while (Op2 != 'S' || Op2 != 'N');
                        if (Op2 == 'N') {
                            do {
                                OP = Entrada.leerChar("Desea volver a intentarlo con otro servicio Si->'S' No->'N' ");
                            } while (OP != 'S' || OP != 'N');
                        } else {
                            String cedula = Entrada.leerString("Ingrese la cedula del tecnico que realizo el servicio");
                            Tecnico tecnicoServicio = this.logicaTecnico.buscarTecnico(cedula);
                            if (tecnicoServicio == null) {
                                System.out.println("No existe coincidencias ");
                            } else {
                                System.out.println(tecnicoServicio.toString());
                                String tipoTecnico = tecnicoServicio.getTipoTecnico();

                                //SI EL QUE REALIZO EL SERVICIO ES UN TECNICO MONOSERVICIO
                                if (tipoTecnico.equals("Tecnico monoServicio")) {
                                    TUnico tecnico = (TUnico) tecnicoServicio;
                                    if (tecnico.getOficio().getCodigo().equals(servicioRealizado.getCodigo())) {
                                        facturaNueva = new Factura(nombre, fecha, tVehiculo, placa, marca, modelo, noCilindro, tamRing, tecnico, servicioRealizado);
                                        String nombreServicio = servicioRealizado.getNombreServicio();
                                        if (nombreServicio.equals("Sincronizacion")) {
                                            Sincronizacion servRea = (Sincronizacion) servicioRealizado;
                                            servRea.calcularCosto(noCilindro);
                                            facturaNueva.calcularCostoUnicoServicio();
                                            this.logicaFactura.registrarFactura(facturaNueva);
                                            System.out.println("Factura Registrada con exito");
                                            facturaNueva.ImprimirFactura();
                                            OP = 'N';
                                        }
                                    } else {
                                        do {
                                            OP = Entrada.leerChar("Desea volver a intentarlo Si->'S' No->'N' ");
                                        } while (OP != 'S' || OP != 'N');
                                    }
                                } else {

                                    //SI EL QUE HIZO EL SERVICIO ES TECNICO MULTISERVICIOS
                                    boolean confirmar = false;
                                    int seleccion = 0;
                                    TMultiservicio tecnico = (TMultiservicio) tecnicoServicio;
                                    for (Servicio s : tecnico.getOficios()) {
                                        s.equals(servicioRealizado);
                                        confirmar = true;
                                    }
                                    if (confirmar == true) {
                                        String nombreServicio = servicioRealizado.getNombreServicio();
                                        if (nombreServicio.equals("Sincronizacion")) {
                                            Sincronizacion servRea = (Sincronizacion) servicioRealizado;
                                            servRea.calcularCosto(noCilindro);

                                            //INSTANCIA DE FACTURA Y REGISTRO
                                            facturaNueva = new Factura(nombre, fecha, tVehiculo, placa, marca, modelo, noCilindro, tamRing, tecnico, servicioRealizado);
                                            facturaNueva.ImprimirFactura();
                                            this.logicaFactura.registrarFactura(facturaNueva);
                                            System.out.println("Factura Registrada con exito");
                                            OP = 'N';
                                        }
                                    } else {
                                        do {
                                            OP = Entrada.leerChar("Desea volver a intentarlo Si->'S' No->'N' ");
                                        } while (OP != 'S' || OP != 'N');

                                    }
                                }

                            }
                        }
                    }
                }

            } else {

                //MUCHOS SERVICIOS REALIZADOS
                char eleccion = 'S', op2 = 0;
                boolean encontro = false;
                Servicio servAplicado;
                ArrayList<Servicio> serviciosRealizados = null;
                while (eleccion == 'S') {
                    String codigo = Entrada.leerString("Ingrese el codigo del servicio realizado al vehiculo: ");
                    servAplicado = this.logicaServicio.buscarServicio(codigo);
                    System.out.println(servAplicado.toString());
                    do {
                        op2 = Entrada.leerChar("Desea añadirlo Si->'S' No->'N' ");
                    } while (op2 != 'S' || op2 != 'N');
                    if (op2 == 'S') {
                        String cedula = Entrada.leerString("Ingrese la cedula del empleado que realizo el servicio: ");
                        Tecnico tecnico = this.logicaTecnico.buscarTecnico(cedula);
                        if (tecnico == null) {
                            System.out.println("No existen coincidencias");
                            do {
                                eleccion = Entrada.leerChar("Desa volver a intentar Si->'S' No->'N': ");
                            } while (eleccion != 'S' || eleccion != 'N');
                        } else {
                            String tipoTecnico = tecnico.getTipoTecnico();
                            if (tipoTecnico.equals("Tecnico monoServicios")) {
                                TUnico tecn = (TUnico) tecnico;
                                if (tecn.getOficio().getCodigo().equals(servAplicado.getCodigo())) {
                                    encontro = true;
                                }
                                if (encontro == true) {
                                    serviciosRealizados.add(servAplicado);
                                    do{
                                        eleccion = Entrada.leerChar("Desea registrar otro servicio");
                                    }while(eleccion!='S' || eleccion!='N');
                                } else {
                                    System.out.println("Error el tecnico ingresado no ejerce dicho servicio");
                                }
                            }
                        }
                        ///------------------------
                        serviciosRealizados.add(servAplicado);
                        do {
                            eleccion = Entrada.leerChar("Desea agregar otro servicio Si->'S' No->'N'");
                        } while (eleccion != 'S' || eleccion != 'N');
                    } else {
                        do {
                            eleccion = Entrada.leerChar("Desea intentarlo de nuevo Si->'S' No->'N'");
                        } while (eleccion != 'S' || eleccion != 'N');
                    }
                }
                if (op2 == 'S') {
                    // factura.calcularCosto(serviciosRealizados);
                    System.out.println("Servicios aplicados al vehiculo");
                }
            }

        }
        this.logicaFactura.registrarFactura(facturaNueva);
        System.out.println("Factura registrada");
        do {
            Op = Entrada.leerChar("Desea registrar otra Factura Si->'S'   No->'N' ");
        } while (Op != 'S' || Op != 'N');
    }

    /* 
    Falta Colocar en los servicios si es balanceo, Sincronizacion,Alineacion, Calibrar Valvulas enviarle los argumentos para que hagan el precio
     */
    @SuppressWarnings("empty-statement")
    public void ConsultarFactura() {
        char OP = 'S';
        Factura facturaBuscada = null;
        while (OP == 'S') {
            int consecutivo = Entrada.leerInt("Ingrese el consecutivo de la factura");
            facturaBuscada = this.logicaFactura.buscarFactura(consecutivo);
            if (facturaBuscada == null) {
                System.out.println("No existen coincidencias");
                do {
                    OP = Entrada.leerChar("Desea hacer otra consulta Si->'S' No->'N' ");
                } while (OP != 'S' || OP != 'N');
            } else {
                System.out.println(facturaBuscada.toString());
                OP = Entrada.leerChar("Desea hacer otra consulta Si->'S' No->'N' ");
            }
            while (OP != 'S' || OP != 'N');
        }
    }

    public void ModificarFactura() {
        char OP = 'S', tVehiculo;
        while (OP == 'S') {
            System.out.println("----------Modificar Factura-------------");
            int consecutivo = Entrada.leerInt("Ingrese el consecutivo de la factura");
            Factura facturaBuscada = this.logicaFactura.buscarFactura(consecutivo);
            if (facturaBuscada == null) {
                System.out.println("No existen coincidencias");
            } else {
                System.out.println(facturaBuscada.toString());
                char op = Entrada.leerChar("Que desea modificar "
                        + "Nombre del cliente -> 1"
                        + "Vehiculo  ->2"
                );
                switch (op) {
                    case 1:
                        String nombre = Entrada.leerString("Ingrese el nombre");
                        facturaBuscada.setNomCliente(nombre);
                    case 2:

                        do {
                            tVehiculo = Entrada.leerChar("Seleccione el tipo de vehiculo Automovil->'A' Camioneta->'C'");
                        } while (tVehiculo != 'A' || tVehiculo != 'C');
                        if (tVehiculo == 'A') {
                            Vehiculo a = facturaBuscada.getAuto();
                            String placa = Entrada.leerString("Ingrese la placa");

                        }

                }
            }
        }
    }

    public void MostrarLista() {
        System.out.println("----------Listas de Facturas Registradas----------------");
        ArrayList<Factura> listaFactura = this.logicaFactura.consultarFacturas();
        if (listaFactura == null) {
            System.out.println("No existen servicios registrados");
        } else {
            for (Factura f : listaFactura) {
                System.out.println(f.toString());
                System.out.println("\n");
            }
        }

    }

    public void EliminarFactura() {
        char OP = 'S';
        Factura facturaEliminar;
        while (OP == 'S') {
            int consecutivo = Entrada.leerInt("Ingrese el consecutivo de la placa a eliminar");
            facturaEliminar = this.logicaFactura.buscarFactura(consecutivo);
            if (facturaEliminar == null) {
                System.out.println("No existe coincidencias");
                do {
                    OP = Entrada.leerChar("Quiere volver a intentar Si->'S' No->'N' ");
                } while (OP != 'S' || OP != 'N');
            } else {
                System.out.println(facturaEliminar.toString());
                do {
                    OP = Entrada.leerChar("Esta seguro de eliminar la factura Si->'S' No->'N' ");
                } while (OP != 'S' || OP != 'N');
                if (OP == 'S') {
                    this.logicaFactura.eliminarFactura(consecutivo);
                }
            }
        }
    }

//Todo lo Relacionado con Tecnico
    public void MenuTecnico() {
        System.out.println(" \n ");
        System.out.println("----------Empleados-------------");
        System.out.println("1. Añadir nuevo empleado");
        System.out.println("2. Consultar ");
        System.out.println("3. Modificar ");
        System.out.println("4. Despedir");
        System.out.println("5. Lista de empleados");
        System.out.println("6. Salir");
    }

    public void ejecutarMenuTecnico() {
        char Op = 'S';
        while (Op == 'S') {
            this.MenuTecnico();
            int op = Entrada.leerInt("Seleccione una opcion");
            switch (op) {
                case 1:
                    this.CrearTecnico();
                    break;
                case 2:
                    this.ConsultarEmpleado();
                    break;
                case 3:
                    this.ModificarEmpleado();
                    break;
                case 4:
                    this.DespedirEmpleado();
                    break;
                case 5:
                    this.ListaEmpleados();
                    break;
                case 6:
                    Op = 'N';
            }
        }
    }

    public void CrearTecnico() {
        int OP = 'S';
        int tipoTec;
        while (OP == 'S') {
            System.out.println("----------Contratar Empleado-------------");
            String nombre = Entrada.leerLinea("Ingrese el nombre: ");
            String apellido = Entrada.leerLinea("Ingrese los apellidos: ");
            String cedula = Entrada.leerString("Ingrese la cedula: ");
            LocalDate fechaIngreso = Entrada.leerFecha("Ingrese la fecha de ingreso del empleado");
            String detalle = Entrada.leerLinea("Ingrese especialidad: ");
            //do{
            tipoTec = Entrada.leerInt("El empleado es multiservicios ->1  unico ->2: ");
            //}while (tipoTec != 1 || tipoTec != 2);
            if (tipoTec == 1) {
                String tipoTecnico = "Tecnico multiServicio";
                TMultiservicio empleadoNuevo = new TMultiservicio(tipoTecnico, nombre, apellido, cedula, fechaIngreso, detalle);
                char op = 'S';
                char elegir;
                while (op == 'S') {

                    String codigo = Entrada.leerString("Ingrese el codigo del servicio el cual ofrece el empleado: ");
                    Servicio servicio = this.logicaServicio.buscarServicio(codigo);
                    if (servicio == null) {
                        System.out.println("No existe coincidencias");
                        do {
                            op = Entrada.leerChar("Desea volver a intentarlo Si->'S' No->'N': ");
                        } while (op != 'S' || op != 'N');
                    } else {
                        System.out.println(servicio.toString());

                        do {
                            elegir = Entrada.leerChar("Desea añadirlo Si-'S' No->'N': ");
                        } while (elegir != 'S' || elegir != 'N');
                        if (elegir == 'S') {
                            empleadoNuevo.addServicio(servicio);
                            do {
                                op = Entrada.leerChar("El empleado ofrece mas servicios Si->'S' No->'N': ");
                            } while (op != 'S' || op != 'N');
                        } else {
                            do {
                                op = Entrada.leerChar("Desea volver a intentarlo Si->'S' No->'N': ");
                            } while (op != 'S' || op != 'N');

                        }

                    }
                }
                Tecnico empleado = empleadoNuevo;
                this.logicaTecnico.registrarEmpleado(empleado);
                System.out.println("Tecnico Registrado con exito");
            } else {
                String tipoTecnico = "Tecnico monoServicio";
                Servicio servicio = null;
                char eleccion;
                char opp = 'S';
                while (opp == 'S') {
                    String codigo = Entrada.leerString("Ingrese el codigo del servicio el cual ofrece el empleado: ");
                    servicio = this.logicaServicio.buscarServicio(codigo);
                    if (servicio == null) {
                        System.out.println("No existe coincidencias");
                        do {
                            opp = Entrada.leerChar("Desea volver a intentarlo");
                        } while (opp != 'S' || opp != 'N');
                    } else {
                        System.out.println(servicio.toString());
                        do {
                            eleccion = Entrada.leerChar("Desea añadirlo Si-'S' No->'N': ");
                        } while (eleccion != 'S' || eleccion != 'N');
                        if (eleccion == 'S') {
                            Tecnico empleado = new TUnico(tipoTecnico, servicio, nombre, apellido, cedula, fechaIngreso, detalle);
                            this.logicaTecnico.registrarEmpleado(empleado);
                            System.out.println("Tecnico registrado con exito");
                        } else {
                            do {
                                opp = Entrada.leerChar("Desea volver a intentarlo Si->'S' No->'N': ");
                            } while (opp != 'S' || opp != 'N');
                        }
                    }

                }
            }

        }
    }

    public void ConsultarEmpleado() {
        char OP = 'S';
        while (OP == 'S') {
            System.out.println("----------Consultar Empleado-------------");
            String cedula = Entrada.leerString("Ingrese la cedula del empleado: ");
            Tecnico tecEncontrado = this.logicaTecnico.buscarTecnico(cedula);
            if (tecEncontrado == null) {
                System.out.println("No existen coincidencias");
            } else {
                System.out.println(tecEncontrado.toString());
            }
            do {
                OP = Entrada.leerChar("Desea consultar otro empleado Si->'S'  No-> 'N' ");
            } while (OP != 'S' || OP != 'N');
        }
    }

    public void ModificarEmpleado() {
        char OP = 'S';
        while (OP == 'S') {
            System.out.println("----------Modificar Empleado-------------");
            String cedula = Entrada.leerString("Ingrese la cedula del empleado: ");
            Tecnico tecEncontrado = this.logicaTecnico.buscarTecnico(cedula);
            if (tecEncontrado == null) {
                System.out.println("No existen coincidencias");
            } else {
                System.out.println(tecEncontrado.toString());
                char op = Entrada.leerChar("Que desea modificar "
                        + "Nombre del empleado -> 1"
                        + "Apellido del empleado  ->2"
                        + "Cedula del empleado ->3"
                        + "Detalle-> 4"
                );
                switch (op) {
                    case 1:
                        String nombre = Entrada.leerLinea("Ingrese el nombre: ");
                        tecEncontrado.setNombre(nombre);
                    case 2:
                        String apellido = Entrada.leerLinea("Ingrese el apellido: ");
                        tecEncontrado.setApellido(apellido);
                    case 3:
                        String ced = Entrada.leerString("Ingrese la cedula: ");
                        tecEncontrado.setCedula(ced);
                    case 4:
                        String detalle = Entrada.leerLinea("Ingrese la especializacion: ");
                        tecEncontrado.setDetalle(detalle);

                }
            }
        }
    }

    public void DespedirEmpleado() {
        char op, OP = 'S';
        while (OP == 'S') {
            System.out.println("----------Modificar Empleado-------------");
            String cedula = Entrada.leerString("Ingrese la cedula del empleado: ");
            Tecnico tecEncontrado = this.logicaTecnico.buscarTecnico(cedula);
            if (tecEncontrado == null) {
                System.out.println("No existen coincidencias");
            } else {
                System.out.println(tecEncontrado.toString());
                do {
                    op = Entrada.leerChar("Esta seguro de despedirlo Si->'S'  No->'N' ");
                } while (op != 'S' || op != 'N');
                if (op == 'S') {
                    this.logicaTecnico.eliminarTecnico(cedula);
                }
            }
            do {
                OP = Entrada.leerChar("Desea despedir otro empleado Si->'S'  No->'N' ");
            } while (OP != 'S' || OP != 'N');
        }
    }

    public void ListaEmpleados() {
        System.out.println("----------Lista de Empleados----------------");
        ArrayList<Tecnico> listaTecnico = this.logicaTecnico.consultarTecnico();
        if (listaTecnico == null) {
            System.out.println("No existen empleados registrados");
        } else {
            for (Tecnico t : listaTecnico) {
                System.out.println(t.toString());
                System.out.println("\n");
            }
        }
    }

    //Todo lo relacionado con servicio 
    public void MenuServicio() {
        System.out.println(" \n ");
        System.out.println("----------Servicios-------------");
        System.out.println("1. Crear");
        System.out.println("2. Consultar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("5. Lista de Servicios");
        System.out.println("6. Salir");
    }

    public void ejecutarMenuServicio() {
        char Op = 'S';
        while (Op == 'S') {
            this.MenuServicio();
            int op = Entrada.leerInt("Seleccione una opcion: ");
            switch (op) {
                case 1:
                    this.CrearServicio();
                    break;
                case 2:
                    this.ConsultarServicio();
                    break;
                case 3:
                    this.ModificarServicio();
                    break;
                case 4:
                    this.EliminarServicio();
                    break;
                case 5:
                    this.MostrarListaServicio();
                    break;
                case 6:
                    Op = 'N';
            }
        }
    }

    public void CrearServicio() {
        char op;
        char OP = 'S';
        double porcentaje;
        while (OP == 'S') {
            System.out.println("----------Crear Servicio----------------");
            op = Entrada.leerChar(
                    "Sincronizacion->   'S'\n"
                    + "Alineacion->       'A'\n"
                    + "Balanceo->         'B'\n"
                    + "Calibrar Valvulas->'C'\n"
                    + "Seleccione:  ");

            String descripcion = Entrada.leerString("Descripcion del servicio: ");
            int porc = Entrada.leerInt("Porcentaje de pago a trabajador % : ");
            System.out.println(porc);
            porcentaje = porc / 100;
            switch (op) {
                case 'S':
                    double precio1 = Entrada.leerDouble("Ingrese el precio por rango de numero de cilindros [3 y 4]: ");
                    double precio2 = Entrada.leerDouble("Ingrese el precio por numero de cilindors [6] : ");
                    double precio3 = Entrada.leerDouble("Ingrese el precio por numero de cilindors [8] : ");
                    Servicio sincronizacion = new Sincronizacion(descripcion, porcentaje, precio1, precio2, precio3);
                    this.logicaServicio.registrarServicio(sincronizacion);
                    System.out.println(sincronizacion.toString());
                    break;
                case 'A':
                    /*Servicio alineacion = new Alineacion(descripcion, porcentaje);
                    this.logicaServicio.registrarServicio(alineacion);
                    System.out.println(alineacion.toString());
                    break;*/
                case 'B':
                    precio1 = Entrada.leerDouble("Ingrese el precio por unididad del tamaño de ring [13] : ");
                    precio2 = Entrada.leerDouble("Ingrese el precio por tamaño de ring entre [14-17] : ");
                    Servicio balanceo = new Balanceo(descripcion, porcentaje, precio1, precio2);
                    this.logicaServicio.registrarServicio(balanceo);
                    System.out.println(balanceo.toString());
                    break;
                case 'C':
                    precio1 = Entrada.leerDouble("Ingrese el precio por numero de cilindros igual a [3] y [4]");
                    precio2 = Entrada.leerDouble("Ingrese el precio por numero de cilindros igual a [6]");
                    Servicio calibrarValvulas = new CalibrarValvulas(descripcion, porcentaje, precio1, precio2);
                    this.logicaServicio.registrarServicio(calibrarValvulas);
                    System.out.println(calibrarValvulas.toString());
                    break;
                default:
                    System.out.println("Error... opcion incorrecta");
            }
            do {
                OP = Entrada.leerChar("Desea crear otro Servicio  Si->'S'  No->'N' ");
            } while (OP != 'S' || OP != 'N');
        }

    }

    public void ConsultarServicio() {
        char OP = 'S';

        while (OP == 'S') {
            System.out.println("----------Consultar Servicio----------------");
            String codigo = Entrada.leerString("Ingrese el codigo del servicio a buscar");
            Servicio servicioBuscado = this.logicaServicio.buscarServicio(codigo);
            if (servicioBuscado == null) {
                System.out.println("No existen coincidencias");
            } else {
                System.out.println(servicioBuscado.toString());
            }
            do {
                OP = Entrada.leerChar("Desea consultar otro servicio Si->'S'  No-> 'N' ");
            } while (OP != 'S' || OP != 'N');
        }
    }

    public void ModificarServicio() {
        char OP = 'S';
        while (OP == 'S') {
            System.out.println("----------Modificar Servicio----------------");
            String codigo = Entrada.leerString("Ingrese el codigo del servicio a modificar");
            Servicio servicioBuscado = this.logicaServicio.buscarServicio(codigo);
            if (servicioBuscado == null) {
                System.out.println("No existe coincidencias");
            } else {
                System.out.println(servicioBuscado.toString());
                char op = Entrada.leerChar("Que desea modificar "
                        + "Nombre del servicio -> 1"
                        + "Costo del servicio  ->2"
                        + "Porcentaje de pago al empleado ->3"
                        + "Descripcion del servicio -> 4"
                        + "Codigo del servicio ->5");
                switch (op) {
                    case 1:
                        String nombre = Entrada.leerString("Ingrese el nuevo nombre: ");
                        servicioBuscado.setNombreServicio(nombre);
                    case 2:
                        long costo = Entrada.leerInt("Ingrese el nuevo valor del servicio: ");
                        servicioBuscado.setCosto(costo);
                    case 3:
                        double porcentaje = Entrada.leerDouble("Ingrese el nuevo porcentaje en decimales: ");
                        servicioBuscado.setPorcentaje(porcentaje);
                    case 4:
                        String descripcion = Entrada.leerLinea("Ingrese la nueva descripcion: ");
                        servicioBuscado.setDescripcion(descripcion);
                    case 5:
                        String cod = Entrada.leerString("Ingrese el nuevo codigo: ");
                        servicioBuscado.setCodigo(cod);
                }

            }
            do {
                OP = Entrada.leerChar("Desea modificar otro servicio Si->'S' No->'N' ");
            } while (OP != 'S' || OP != 'N');
        }
    }

    public void EliminarServicio() {
        char op, OP = 'S';
        while (OP == 'S') {
            System.out.println("----------Eliminar Servicio----------------");
            String codigo = Entrada.leerString("Ingrese el codigo a eliminar");
            Servicio servicioBuscado = this.logicaServicio.buscarServicio(codigo);
            if (servicioBuscado == null) {
                System.out.println("No existe coincidencias");
            } else {
                System.out.println(servicioBuscado.toString());
                do {
                    op = Entrada.leerChar("Esta seguro de eliminarlo Si->'S'  No->'N' ");
                } while (op != 'S' || op != 'N');
                if (op == 'S') {
                    this.logicaServicio.borrarServicio(codigo);
                }
            }
            do {
                OP = Entrada.leerChar("Desea eliminar otro Servicio Si->'S'  No->'N' ");
            } while (OP != 'S' || OP != 'N');
        }

    }

    public void MostrarListaServicio() {
        System.out.println("----------Listas de Servicios Registrados----------------");
        ArrayList<Servicio> listaServicios = this.logicaServicio.consultarServicios();
        if (listaServicios == null) {
            System.out.println("No existen servicios registrados");
        } else {
            for (Servicio s : listaServicios) {
                System.out.println(s.toString());
                System.out.println("\n");
            }
        }
    }

    public void Nomina() {
        System.out.println("----------Nomina----------------");
        char OP = 'S';
        while (OP == 'S') {
            String cedula = Entrada.leerString("Ingrese la cedula del tecnico");
            Tecnico tecnicoPagar = this.logicaTecnico.buscarTecnico(cedula);
            if (tecnicoPagar == null) {
                System.out.println("Error... No existen coincidencias");
            } else {
                System.out.println("Periodo de Nomina");
                LocalDate fechaInicio = Entrada.leerFecha("Ingrese la fecha de inicio");
                LocalDate fechaFinal = Entrada.leerFecha("Ingrese la fecha final");
                ArrayList<Factura> listaFacturas = this.logicaFactura.consultarFacturas();
                Nomina nominaTecnico = new Nomina(tecnicoPagar, listaFacturas, fechaInicio, fechaFinal);
                nominaTecnico.ImprimirNomina();
            }

        }

    }
}
