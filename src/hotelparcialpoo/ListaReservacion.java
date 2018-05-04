/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Daniel Gómez
 */
public class ListaReservacion {
    ListaUsuarios lis = Usuario.lista;
    ListaHabitacion listaH = HotelParcialPOO.listaH;
    private ArrayList<Reservacion> reservations;
    public ListaReservacion(){
        reservations = new ArrayList<>();
    }
    public void add(){
        String IdUsuario;
        Reservacion reservation = new Reservacion();
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el usuario del huesped");
        IdUsuario = leer.nextLine(); 
        if(lis.ifExits(IdUsuario) == 1 /*&& validarMaximo(IdUsuario) <2 */ ){
            
            int last = reservations.size() - 1;
            reservation.setUser(IdUsuario);
            reservation.setId((last + 1));
            System.out.println("Ingrese la fecha de entrada:");
            //System.out.println(fecha.toString());
            String fe = "27/7/199";
            //fecha = format.parse(fe);
            
            reservation.setCheck_in(leer.nextLine());
            System.out.println("Ingrese la fecha de salida:");
            reservation.setCheck_out(leer.nextLine());
            System.out.println("Ingrese ID de habitacion");
            String idHab = leer.nextLine();
            if(listaH.VerificarHabitacion(idHab)==1){
                listaH.CambiarEstado(idHab, 2);
                reservation.setIdRoom(idHab); 
                System.out.println("Paguetes disponibles:\n1.PREMIUM\n2.Basico\n3.NINGUNO");
                int op = leer.nextInt();
                if(op==1){
                    
                }
                reservation.setIdPack(leer.nextLine());
                System.out.println("El precio de la habitacion es:");
                reservations.add(reservation);
            }else{
                System.out.println("\033[31mNo se encuentra disponible esa habitacion");
            }
            
        }else{
            System.out.println("\033[31mEl usuario Ingresado no esta previamente agregado, o tiene dos reservaciones hechas. Intentelo de nuevo");
        }
    }
    public void add(Reservacion reservation) throws Exception{
        if(reservation != null){
            if (!reservations.contains(reservation)) {
                reservations.add(reservation);               
            }
            Exception e = new Exception("No se permiten Duplicados");
            throw e;
            
        }else{
            throw new Exception("No se puede agregar un estudiante nulo");
        }
    }
    
    
}
