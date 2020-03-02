package com.auction.auctionApp.infrastructure;

import com.auction.auctionApp.domain.model.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
