package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Reserva.
            System.out.print("Número do quarto | Room number: ");
            int numberRoom = sc.nextInt();

            System.out.print("Data de entrada | Check-in date --> [dd/MM/yyyy]: ");
            Date checkIn = sdf.parse(sc.next());

            System.out.print("Data de saída | Check-out date  --> [dd/MM/yyyy]: ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println(reservation);

            // Atualização de reserva.
            System.out.print("\nData de entrada | Check-in date --> [dd/MM/yyyy]: ");
            checkIn = sdf.parse(sc.next());

            System.out.print("Data de saída | Check-out date  --> [dd/MM/yyyy]: ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (ParseException e){
            System.out.println("Data inválida! | Invalid date format!");
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado! | Unexpected Error!");
        }
        sc.close();
    }
}