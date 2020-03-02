package com.auction.auctionApp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuctionFacade {

    private final AuctionCreator auctionCreator;


    public void createAuction(long accountId, String accountNumber, String title,  long itemsCount, BigDecimal costOfAnItem) {
        auctionCreator.create(accountId, accountNumber,title,itemsCount, costOfAnItem);
    }
}
