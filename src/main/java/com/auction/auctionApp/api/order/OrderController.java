package com.auction.auctionApp.api.order;

import com.auction.auctionApp.api.auction.AuctionDto;
import com.auction.auctionApp.domain.model.order.Order;
import com.auction.auctionApp.domain.model.order.OrderStatus;
import com.auction.auctionApp.domain.order.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/orders")
public class OrderController {

    private final OrderFacade orderFacade;

    @PostMapping(path = "/create")
    public void create(@RequestBody OrderDto orderDto) {
        orderFacade.create(orderDto.getClientId(), orderDto.getAuctionId(), orderDto.getAuctionOwnerId(), orderDto.getQuantity(), orderDto.getUnitPrice());
    }
    @PostMapping(path = "/create/totalprice")
    public void createWithTotalPrice(@RequestBody OrderDto orderDto) {
        orderFacade.createWithTotalPrice(orderDto.getClientId(), orderDto.getAuctionId(), orderDto.getAuctionOwnerId(), orderDto.getUnitPrice(), orderDto.getTotalPrice());
    }

    @GetMapping(path = "/{auctionOwnerId}")
    public List<OrderDto> findByAuctionOwnerId(@PathVariable long auctionOwnerId) {
        return OrderMapper.mapOrderListToDto
                (orderFacade.findByAuctionOwnerId(auctionOwnerId));
    }

    @GetMapping(path = "/all")
    public List<OrderDto> findByAuctionOwnerId() {
        return OrderMapper.mapOrderListToDto
                (orderFacade.findAll());
    }

    @PatchMapping(path = "/changestatus")
    public void changeOrderStatus(@RequestParam long orderId, @RequestParam OrderStatus orderStatus) {
        orderFacade.changeOrderStatus(orderId, orderStatus);
    }

    @DeleteMapping(path = "/delete/{orderId}")
    public void deleteOrderById(@PathVariable long orderId) {
        orderFacade.deleteOderById(orderId);
    }

    private static class OrderMapper {
        private static OrderDto mapToDto(Order order) {
            return OrderDto.builder()
                    .auctionId(order.getAuctionId())
                    .auctionOwnerId(order.getAuctionOwnerId())
                    .clientId(order.getClientId())
                    .quantity(order.getQuantity())
                    .status(order.getStatus())
                    .unitPrice(order.getUnitPrice())
                    .totalPrice(order.getTotalPrice()).build();
        }

        private static List<OrderDto> mapOrderListToDto(List<Order> orders) {
            List<OrderDto> dtoOrders = orders.stream()
                    .map(OrderMapper::mapToDto).collect(Collectors.toList());
            return dtoOrders;
        }
    }



}
