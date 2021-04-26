package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.dto;

import lombok.Data;

@Data
public class CryptoEntryRequest{
  private String cryptocurrency;
  private int amount;
  private String walletLocation;

}
