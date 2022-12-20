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

            System.out.print("Data de entrada | Check-in date --> [dd/MM/yyyy]: ");
            checkIn = sdf.parse(sc.next());

            System.out.print("Data de saída | Check-out date  --> [dd/MM/yyyy]: ");
            checkOut = sdf.parse(sc.next());


            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Erro na reserva: as novas datas devem ser datas futuras!");
                System.out.println("Error in reservation: Reservation dates for update must be future dates!");
            }
            else if(!checkOut.after(checkIn)){
                System.out.println("Erro na reserva: Data de saída é antes da data de entrada!");
                System.out.println("Error in reservation: Check-out date must be after check-in date!");
            }
            else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }
        }

        sc.close();
    }
}
