package services;


import Exceptions.AuctionException;
import business.ObjectToAuction;
import business.AuctionResult;

public interface AuctionService {

    AuctionResult getResult(ObjectToAuction objectToAuction) throws AuctionException;

}
