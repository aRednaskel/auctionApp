package com.auction.auctionApp.domain.model.order;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_sequence")
    private long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private long clientId;
    private long auctionId;
    private long auctionOwnerId;
    private long quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    public static Order createOrder(long clientId, long auctionId,long auctionOwnerId, long quantity, BigDecimal unitPrice) {
        return Order.builder()
                .clientId(clientId)
                .auctionId(auctionId)
                .auctionOwnerId(auctionOwnerId)
                .quantity(quantity)
                .unitPrice(unitPrice)
                .totalPrice(unitPrice.multiply(BigDecimal.valueOf(quantity)))
                .status(OrderStatus.PENDING)
                .build();
    }

    public static Order createOrder(long clientId, long auctionId,long auctionOwnerId, BigDecimal unitPrice, BigDecimal totalPrice) {
        return Order.builder()
                .clientId(clientId)
                .auctionId(auctionId)
                .auctionOwnerId(auctionOwnerId)
                .quantity(totalPrice.divide(unitPrice).longValue())
                .unitPrice(unitPrice)
                .totalPrice(totalPrice)
                .status(OrderStatus.PENDING).build();
    }
}
