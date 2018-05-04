/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Brenda
 * @author Esther
 */
public class Menu {
    private static Menu menu;
    ListaUsuarios lista = Usuario.lista;
    ListaReservacion list = Reservacion.lista;
    ListaPaquete lista2 = HotelParcialPOO.listaP;
    ListaHabitacion listaH = HotelParcialPOO.listaH;
    
    
    private Menu(){
    }
    
    public static Menu getInstance(){
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }
    
    public void opciones() {
            System.out.println("\033[34m----- Menu del Administrador: ADMIN -----");
            System.out.println("1. Manejar habitaciones, pisos, paquetes");
            System.out.println("\033[34m----- Reservaciones -----");
            System.out.println("2. Ver reservaciones");
            System.out.println("3. Modificar reservaciones");
            System.out.println("4. Cancelar reservaciones"); 
            System.out.println("5. Ver listado de todos los huespedes");  
            System.out.println("6. Salir");   
    }
    
    public void mostrar() throws ParseException {
        int opcion = 0;
        Scanner leer = new Scanner(System.in);
            while (opcion != 6) {
                opciones();
            try {
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        mostrarSubmenu();
                        break;
                    case 2:
                        System.out.println("\033[32m|******  Listado de Reservaciones  ******|");
                        list.MostrarReservacion();
                        break;
                    case 3:
                        System.out.println("Ingrese el Id de la reservacion a modificar:");
                        list.modificar(leer.nextInt());
                        break;
                    case 4:
                        System.out.println("Ingrese el Id de la reservacion a cancelar");
                        int idReser;
                        idReser = leer.nextInt();
                        list.cancelarReservacion(idReser);
                        break;
                    case 5:
                        System.out.println("Listado de huespedes");
                        lista.MostrarUsuario();
                        break;
                    case 6:
                        System.out.println("Cerrado de Sesion exitoso");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, ingrese una de las opciones.");
                leer.nextLine();
            }
        }
            }
    
    public void mostrarSubmenu(){
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        int estado,op,precioNuevo,paquete;
        String piso,habitacion, servicio;
        System.out.println("\033[40m----- Menu Habitaciones -----");
        System.out.println("1. Mostrar todas las Habitaciones");
        System.out.println("2. Agregar habitacion");
        System.out.println("3. Habilitar/Deshabilitar habitacion/piso");
        System.out.println("4. Cambiar precio base de las habitaciones");
        System.out.println("5. Precio y servicio de los paquetes");
        System.out.println("6. Regresar");
            try {
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        listaH.MostrarHabitacion();
                        break;

                     case 2:
                        System.out.println("¿Seguro que deseas agregar una nueva habitación?\n1. Si\n2. No");
                        op = leer.nextInt();
                        leer.nextLine();
                        if(op==1){
                            listaH.AgregarHabitacion();
                        }
                        break;
                        
                    case 3:
                        System.out.println("Desea cambiar estado de:\n1. Piso\n2. Habitacion");
                        op = leer.nextInt();
                        leer.nextLine();
                        if(op==1){
                            System.out.println("Ingrese el piso:");
                            piso = leer.nextLine();
                            System.out.println("Seleccione una opcion:\n1. Habilitar\n2. Deshabilitar");
                            estado = leer.nextInt();
                            listaH.CambiarEstadoPiso(piso, estado);
                            
                        }else{
                            System.out.println("Ingrese la habitacion:");
                            habitacion = leer.nextLine();
                            System.out.println("Seleccione una opcion:\n1. Habilitar\n2. Deshabilitar");
                            estado = leer.nextInt();
                            listaH.CambiarEstado(habitacion, estado);
                        }
                        break;
                        
                    case 4:

                        System.out.println("Ingrese el nuevo precio base:");
                        precioNuevo = leer.nextInt();
                        leer.nextLine();
                        listaH.CambiarPrecio(precioNuevo);
                        
                        break;
                        
                    case 5:
                        System.out.println("Desea cambiar:\n1. Precio\n2. Servicios");
                        op = leer.nextInt();
                        leer.nextLine();
                        if(op==1){
                            System.out.println("PAQUETE:\n1. PREMIUM\n2. BASICO");
                            paquete = leer.nextInt();
                            leer.nextLine();
                            System.out.println("Ingrese el nuevo precio:");
                            precioNuevo = leer.nextInt();
                            lista2.CambiarPrecio(paquete, precioNuevo);
                        }else{
                            System.out.println("PAQUETE:\n1. PREMIUM\n2. BASICO");
                            paquete = leer.nextInt();
                            leer.nextLine();
                            System.out.println("Ingrese el nuevo servicio a ofrecer:");
                            servicio = leer.nextLine();
                            lista2.CambiarServicio(paquete, servicio);
                        }
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, vuelva a intentarlo y revise los datos ingresados.");
                
            }
        }
    
    
    }
        

