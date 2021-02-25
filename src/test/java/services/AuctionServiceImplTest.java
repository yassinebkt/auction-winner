package services;

import Exceptions.AuctionException;
import business.AuctionResult;
import business.Buyer;
import business.ObjectToAuction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuctionServiceImplTest {

    AuctionServiceImpl auctionServiceImpl = new AuctionServiceImpl();

    @Test
    public void testGetWinnerShouldSuccess() {

        ObjectToAuction objectToAuction = new ObjectToAuction(100);
        Buyer aBuyer = new Buyer("A");
        Buyer cBuyer = new Buyer("C");
        Buyer dBuyer = new Buyer("D");
        Buyer eBuyer = new Buyer("E");


        objectToAuction.addNewBids(aBuyer, 110, 130);
        objectToAuction.addNewBids(cBuyer, 125);
        objectToAuction.addNewBids(dBuyer, 105, 115, 90);
        objectToAuction.addNewBids(eBuyer, 132, 135, 140);

        AuctionResult result = auctionServiceImpl.getResult(objectToAuction);

        assertEquals(130, result.getPrice());
        assertEquals("E", result.getWinner().getBuyer().getName());

    }

    @Test
    public void testGetShouldRaiseMoreBidException() {

        ObjectToAuction objectToAuction = new ObjectToAuction(100);
        Buyer aBuyer = new Buyer("A");
        objectToAuction.addNewBids(aBuyer, 12);

        AuctionException thrown = assertThrows(
                AuctionException.class,
                () -> auctionServiceImpl.getResult(objectToAuction)
        );

        assertEquals("You need to provide more bids above reserve !", thrown.getMessage());
    }

    @Test
    public void testGetShouldRaiseMoreBuyerException() {

        ObjectToAuction objectToAuction = new ObjectToAuction(100);
        Buyer aBuyer = new Buyer("A");
        objectToAuction.addNewBids(aBuyer, 120, 154);

        AuctionException thrown = assertThrows(
                AuctionException.class,
                () -> auctionServiceImpl.getResult(objectToAuction)
        );

        assertEquals("You need to provide more buyers !", thrown.getMessage());
    }
}