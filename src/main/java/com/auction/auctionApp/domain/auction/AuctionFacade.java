package com.auction.auctionApp.domain.auction;

import com.auction.auctionApp.domain.model.auction.Auction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionFacade {

    private final AuctionCreator auctionCreator;
    private final AuctionRetrieval auctionRetrieval;

    public void createAuction(long accountId, String accountNumber, String title,  long itemsCount, BigDecimal costOfAnItem) {
        auctionCreator.create(accountId, accountNumber,title,itemsCount, costOfAnItem);
    }

    public List<Auction> findAuctionsWithAccountId(long accountId) {
        return auctionRetrieval.getByAccountId(accountId);
    }

    public List<Auction> findAll() {
        return auctionRetrieval.findAll();
    }


}
