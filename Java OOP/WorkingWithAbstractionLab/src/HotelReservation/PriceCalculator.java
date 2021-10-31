package HotelReservation;

public class PriceCalculator {

        public double calculate(Reservation reservation){
            double basePrice = reservation.getPricePerDay() * reservation.getNumberOfDays() * reservation.getSeasons().getMultiplier();
             double percentDiscount = 1 - (reservation.getDiscount().getDiscount() / 100.0 );
             return  basePrice * percentDiscount;
        }
}
