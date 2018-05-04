/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Daniel Gómez
 */
public class ListaReservacion {
    SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
    ListaUsuarios lis = Usuario.lista;
    ListaHabitacion listaH = HotelParcialPOO.listaH;
    ListaPaquete listaP = HotelParcialPOO.listaP;
    private ArrayList<Reservacion> reservations;
    public ListaReservacion(){
        reservations = new ArrayList<>();
    }
    public void add() throws ParseException{
        try{
        int total = 0;
        String IdUsuario;
        Reservacion reservation = new Reservacion();
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el usuario del huesped");
        IdUsuario = leer.nextLine(); 
        if(lis.ifExits(IdUsuario) == 1 && validarMaximo(IdUsuario) <2 ){
            
            int last = reservations.size() - 1;
            reservation.setUser(IdUsuario);
            reservation.setId((last + 1));
            System.out.println("Ingrese la fecha de entrada, posteriormente la de salida con el siguiente formato, dd-MM-yyyy");
            String d1 = leer.nextLine();
            String d2 = leer.nextLine();
            Date date1 = sd.parse(d1);
            Date date2 = sd.parse(d2);
            if (date1.before(date2) == true) {
                reservation.setCheck_in(d1);
                reservation.setCheck_out(d2);
                System.out.println("Ingrese ID de habitacion");
            String idHab = leer.nextLine();
            if(listaH.VerificarHabitacion(idHab)==1){
                listaH.CambiarEstado(idHab, 2);
                reservation.setIdRoom(idHab); 
                System.out.println("Paguetes disponibles:\n1.PREMIUM\n2.Basico\n3.NINGUNO");
                int op = leer.nextInt();
                if(op==1){
                    total = listaP.Buscar(op) + listaH.Buscar(idHab);
                    reservation.setIdPack("PREMIUM");
                    reservation.setPrice(total);
                }else if(op==2){
                    total = listaP.Buscar(op) + listaH.Buscar(idHab);
                    reservation.setIdPack("BASICO");
                    reservation.setPrice(total);
                }else{
                    total = listaH.Buscar(idHab);                    
                    reservation.setIdPack("NINGUNO");
                    reservation.setPrice(total);
                }					
                reservation.setIdPack(leer.nextLine());
                System.out.println("El precio de la habitacion es:");
                reservations.add(reservation);
            }else{
                System.out.println("\033[31mNo se encuentra disponible esa habitacion");
            }
            }else{
                System.out.println("Las fechas ingresadas son invalidas ");
            }            
        }else{
            System.out.println("\033[31mEl usuario Ingresado no esta previamente agregado, o tiene dos reservaciones hechas. Intentelo de nuevo");
        }
       }catch(Exception e){
           System.out.println("\033[31Te has equivocado en algun formato, intentalo de nuevo");
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
    public void MostrarReservacion(){
        for(Reservacion reservacion : reservations) {
            System.out.println("Id ["+reservacion.idReservation+"] Fecha de Entrada:["+reservacion.check_in+"] Fecha de Salida:["+reservacion.check_out+"] Habitacion:["+reservacion.idRoom+"] Paquete:["+reservacion.idPack+"] Costo:["+reservacion.price+"] Huesped:["+reservacion.user+"]");
        }
    }
    public void cancelarReservacion(int idReser){
        int count = 0;
        String mensaje = "";
        for(int i=0; i<reservations.size(); i++) {
            if(reservations.get(count).idReservation == idReser){
                String idHab = reservations.get(count).idRoom;
                listaH.CambiarEstadoPiso(idHab, 2);
                reservations.remove(count);
                mensaje= "La reservacion se cancelo con exito, y la habitacion: ["+idHab+"] se encuentra disponible nuevamente";
            }else{
                mensaje= "\033[31mNo se encontro ese ID Intentelo de nuevo";
            }
            count += 1;
       }
        System.out.println(mensaje);
        
        
    }
    public int validarMaximo(String idUser){
        int count = 0;
        int n =0;
        for(int i=0; i<reservations.size(); i++) {
            if(reservations.get(count).user.equals(idUser)){
                n += 1;
            }
            count += 1;
       }
        return n;
    }
    public void modificar(int idReservacion) throws ParseException{
        Scanner leer = new Scanner(System.in);
        int count = 0;
        String mensaje = "";
        for(int i=0; i<reservations.size(); i++) {
            if(reservations.get(count).idReservation == idReservacion){
                System.out.println("Ingrese la fecha de entrada, posteriormente la de salida con el siguiente formato, dd-MM-yyyy");
                String d1 = leer.nextLine();
                String d2 = leer.nextLine();
                Date date1 = sd.parse(d1);
                Date date2 = sd.parse(d2);
                if (date1.before(date2) == true) {
                    reservations.get(count).setCheck_in(d1);
                    reservations.get(count).setCheck_out(d2);
                }else{
                    System.out.println("Fechas invalidas");
                }
                System.out.println("Ingrese el nuevo id de habitacion o ingrese el mismo");
                reservations.get(count).setIdRoom(leer.nextLine()); 
                System.out.println("Paguetes disponibles:\n1.PREMIUM\n2.Basico\n3.NINGUNO");
                reservations.get(count).setIdPack(leer.nextLine());
                System.out.println("El precio de la habitacion es:");
                mensaje= "La reservacion se modifico de manera exitosa";
            }else{
                mensaje= "\033[31mNo se encontro ese ID Intentelo de nuevo";
            }
            count += 1;
       }
        System.out.println(mensaje);
    }
    
    
}
