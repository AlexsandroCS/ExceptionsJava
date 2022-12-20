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

    public String updateDates(Date checkin, Date checkout){
        Date now = new Date();

        if(checkin.before(now) || checkout.before(now)){
            return "Erro na reserva: as novas datas devem ser datas futuras!\nError in reservation: Reservation dates for update must be future dates!";
        }
        if(!checkout.after(checkin)){
            return "Erro na reserva: Data de saída é antes da data de entrada!\nError in reservation: Check-out date must be after check-in date!";
        }

        this.checkin = checkin;
        this.checkout = checkout;

        return null;
    }

    @Override
    public String toString() {
        return "\nReserva | Quarto: "+roomNumber+", entrada: "+sdf.format(checkin)+", saída: "+sdf.format(checkout)+", "+duration()+" noites.\n"+"Reservation | Room: "+roomNumber+", check-in: "+sdf.format(checkin)+", check-out: "+sdf.format(checkout)+", "+duration()+" nights.";
    }
}