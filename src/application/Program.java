package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto | Room number: ");
        int numberRoom = sc.nextInt();

        System.out.print("Data de entrada | Check-in date --> [dd/MM/yyyy]: ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Data de saída | Check-out date  --> [dd/MM/yyyy]: ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Erro na reserva: Data de saída é antes da data de entrada!");
            System.out.println("Error in reservation: Check-out date must be after check-in date!");
        }
        else {
            Reservation reservation = new Reservation(numberRoom,checkIn,checkOut);
            System.out.println(reservation);

            System.out.print("\nData de entrada | Check-in date --> [dd/MM/yyyy]: ");
            checkIn = sdf.parse(sc.next());

            System.out.print("Data de saída | Check-out date  --> [dd/MM/yyyy]: ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println(error);
            }else{
                System.out.println(reservation);
            }
        }

        sc.close();
    }
}
