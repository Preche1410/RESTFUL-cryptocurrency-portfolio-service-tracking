package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.repository;

import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.model.CryptoEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoEntryRepository extends JpaRepository<CryptoEntry, Integer>{
}
