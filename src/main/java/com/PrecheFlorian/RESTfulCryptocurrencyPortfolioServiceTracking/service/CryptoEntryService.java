package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.service;

import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.dto.CryptoEntryRequest;
import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.model.CryptoEntry;

import java.util.List;

public interface CryptoEntryService{
  List<CryptoEntry> findAll();
  CryptoEntry findById(int id);
  void deleteById(int id);
  void addCryptoEntry(CryptoEntryRequest request);
  void updateCryptoEntry( CryptoEntry cryptoEntry);
  double getTotalAmountEur();
}
