package business;

import java.util.Objects;

public class Bid {

    Buyer buyer;
    int price;

    public Bid(Buyer buyer, int price) {
        this.buyer = buyer;
        this.price = price;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return price == bid.price &&
                Objects.equals(buyer, bid.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer, price);
    }

    @Override
    public String toString() {
        return "Bid{" +
                "buyer=" + buyer +
                ", price=" + price +
                '}';
    }
}
