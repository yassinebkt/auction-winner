package services;

import Exceptions.AuctionException;
import business.Bid;
import business.Buyer;
import business.ObjectToAuction;
import business.AuctionResult;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AuctionServiceImpl implements AuctionService {


    @Override
    public AuctionResult getResult(ObjectToAuction objectToAuction) throws AuctionException {
        List<Bid> effectiveBids = getEffectiveBids(objectToAuction);

        if(effectiveBids.size()<2) throw new AuctionException("You need to provide more bids above reserve !");

        long distinctBuyers = getBuyersCountWithAnEffectiveBid(effectiveBids);

        if (distinctBuyers < 2) throw new AuctionException("You need to provide more buyers !");

        Bid highestBid = getHighestBid(effectiveBids);
        Buyer highestBuyer = highestBid.getBuyer();
        Bid secondHighestBid = getSecondHighestBid(effectiveBids, highestBuyer);

        return new AuctionResult(objectToAuction, highestBid, secondHighestBid.getPrice());

    }



    private List<Bid> getEffectiveBids(ObjectToAuction objectToAuction) {
        return objectToAuction.getBids().stream()
                .filter((b) -> b.getPrice() > objectToAuction.getReservedPrice())
                .collect(Collectors.toList());
    }

    private long getBuyersCountWithAnEffectiveBid(List<Bid> effectiveBids) {
        return effectiveBids.stream()
                .map(Bid::getBuyer)
                .distinct()
                .count();
    }

    private Bid getHighestBid(List<Bid> effectiveBids) {
        return effectiveBids.stream()
                .max(Comparator.comparingInt(Bid::getPrice))
                .get();
    }

    private Bid getSecondHighestBid(List<Bid> effectiveBids, Buyer highestBuyer) {
        return effectiveBids.stream()
                .filter((b) -> !b.getBuyer().equals(highestBuyer))
                .max(Comparator.comparingInt(Bid::getPrice))
                .get();
    }
}
