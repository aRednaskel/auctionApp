package com.auction.auctionApp.api;

import com.auction.auctionApp.domain.auction.AuctionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/auctions")
public class AuctionController {

    private final AuctionFacade auctionFacade;

    @PostMapping(path = "/create")
    public void createAuction(@RequestBody AuctionDto auction) {
        auctionFacade.createAuction(auction.getAccountId(), auction.getAccountNumber(),auction.getTitle(),auction.getItemsCount(),auction.getCostOfAnItem());
    }


}
