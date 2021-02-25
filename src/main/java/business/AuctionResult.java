package business;

public class AuctionResult {
    ObjectToAuction object;
    Bid winner;
    int price;

    public AuctionResult(ObjectToAuction object, Bid winner, int price) {
        this.object = object;
        this.winner = winner;
        this.price = price;
    }

    public ObjectToAuction getObject() {
        return object;
    }

    public Bid getWinner() {
        return winner;
    }

    public int getPrice() {
        return price;
    }
}
