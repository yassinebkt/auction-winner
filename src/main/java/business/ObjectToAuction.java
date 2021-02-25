package business;

import java.util.ArrayList;
import java.util.List;

public class ObjectToAuction {

    int reservedPrice;

    List<Bid> bids = new ArrayList<>();


    public ObjectToAuction(int reservedPrice) {
        this.reservedPrice = reservedPrice;
    }

    public int getReservedPrice() {
        return reservedPrice;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void addNewBids(Buyer buyer, int... bidPrices) {
        for (int bidPrice : bidPrices) {
            bids.add(new Bid(buyer, bidPrice));
        }
    }
}
