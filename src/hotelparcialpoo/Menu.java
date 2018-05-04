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
                        //mostrarSubmenu();
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
    }
        

