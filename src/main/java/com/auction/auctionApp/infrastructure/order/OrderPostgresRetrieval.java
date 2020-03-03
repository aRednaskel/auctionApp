package com.auction.auctionApp.infrastructure.order;

import com.auction.auctionApp.domain.model.order.Order;
import com.auction.auctionApp.domain.order.OrderRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class OrderPostgresRetrieval implements OrderRetrieval {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findByAuctionOwnerId(long auctionOwnerId) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getAuctionOwnerId() == auctionOwnerId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
