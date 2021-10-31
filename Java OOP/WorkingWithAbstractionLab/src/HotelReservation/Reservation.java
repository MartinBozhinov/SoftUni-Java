package HotelReservation;

public class Reservation {

    private double pricePerDay;
    private int numberOfDays;
    private Seasons seasons;
    private Discount discount;

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Seasons getSeasons() {
        return seasons;
    }

    public void setSeasons(Seasons seasons) {
        this.seasons = seasons;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
