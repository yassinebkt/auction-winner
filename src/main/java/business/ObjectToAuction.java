package business;

import exceptions.AuctionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            Optional<Bid> result = bids.stream().filter(bid -> bid.getPrice() == bidPrice).findFirst();
            if(result.isPresent()) {
                throw new AuctionException("The bid you are entering : " + result.get().price  + " has already been done by someone else !");
            } else {
                bids.add(new Bid(buyer, bidPrice));
            }
        }
    }

}
