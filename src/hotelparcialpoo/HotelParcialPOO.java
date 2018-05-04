/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;

import java.text.ParseException;

/**
 *
 * @author Daniel Gómez
 */
public class HotelParcialPOO {

    static ListaHabitacion listaH = new ListaHabitacion();
    static ListaPaquete listaP = new ListaPaquete();
    public static void main(String[] args) throws ParseException {
        listaH.add();
        listaP.add();
        Usuario user = new Usuario();
        user.mostrar();
        
    }
    
}
