package HotelReservation;

public enum Discount {

    VIP(20),
    SECOND_VISIT(10),
    NONE(0),
    ;

     private int discount ;

    Discount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
