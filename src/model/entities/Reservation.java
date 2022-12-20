package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    // Atributos.
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    // Modificador de formato data/hora.
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Constructors.
    Reservation(){}
    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    // Getters e Setters.
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    public Date getCheckin() {
        return checkin;
    }
    public Date getCheckout() {
        return checkout;
    }

    // Métodos da Classe.
    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();         // Passando minisegundos para diff.
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);  // Convertendo minisegundos para dias.
    }

    public void updateDates(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "\nReserva | Quarto: "+roomNumber+", entrada: "+sdf.format(checkin)+", saída: "+sdf.format(checkout)+", "+duration()+" noites.\n"+"Reservation | Room: "+roomNumber+", check-in: "+sdf.format(checkin)+", check-out: "+sdf.format(checkout)+", "+duration()+" nights.";
    }
}