package model.entities;

import model.exceptions.DomainException;

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
    public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
        if(!checkout.after(checkin)){
            throw new DomainException("\nErro na reserva: Data de saída é antes da data de entrada!\nError in reservation: Check-out date must be after check-in date!");
        }
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
    public long duration() throws DomainException{
        long diff = checkout.getTime() - checkin.getTime(); // Passando minisegundos para diff.
        if (diff < 0){
            throw new DomainException("\nErro na reserva: Data de saída é antes da data de entrada!\nError in reservation: Check-out date must be after check-in date!");
        }
        else{
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);  // Convertendo minisegundos para dias.
        }
    }

    public void updateDates(Date checkin, Date checkout) throws DomainException{
        Date now = new Date();

        if(checkin.before(now) || checkout.before(now)){
            throw new DomainException("\nErro na reserva: as novas datas devem ser datas futuras!\nError in reservation: Reservation dates for update must be future dates!");
        }
        if(!checkout.after(checkin)){
            throw new DomainException("\nErro na reserva: Data de saída é antes da data de entrada!\nError in reservation: Check-out date must be after check-in date!");
        }

        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        try {
            return "\nReserva | Quarto: "+roomNumber+", entrada: "+sdf.format(checkin)+", saída: "+sdf.format(checkout)+", "+duration()+" noites.\n"+"Reservation | Room: "+roomNumber+", check-in: "+sdf.format(checkin)+", check-out: "+sdf.format(checkout)+", "+duration()+" nights.";
        }
        catch (DomainException e) {
            throw new RuntimeException(e);
        }
    }
}