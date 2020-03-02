package com.auction.auctionApp.api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AuctionDto {
    private long accountId;
    private String accountNumber;
    private String title;
    private long itemsCount;
    private BigDecimal costOfAnItem;
}
