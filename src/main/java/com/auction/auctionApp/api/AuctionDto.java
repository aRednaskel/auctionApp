package com.auction.auctionApp.api;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class AuctionDto {
    private long accountId;
    private String accountNumber;
    private String title;
    private long itemsCount;
    private BigDecimal costOfAnItem;
}
