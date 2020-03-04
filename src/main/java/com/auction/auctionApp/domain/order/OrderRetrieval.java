package com.auction.auctionApp.domain.order;

import com.auction.auctionApp.domain.model.order.Order;

import java.util.List;

public interface OrderRetrieval {

    List<Order> findByAuctionOwnerId(long auctionOwnerId);

    List<Order> findAll();
}
