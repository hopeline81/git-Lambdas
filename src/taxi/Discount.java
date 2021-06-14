package taxi;

public class Discount {

    private int discount;

    public Discount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "discount = " + discount +
                '}';
    }
}
