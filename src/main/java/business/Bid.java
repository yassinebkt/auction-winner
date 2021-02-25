package business;

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
}
