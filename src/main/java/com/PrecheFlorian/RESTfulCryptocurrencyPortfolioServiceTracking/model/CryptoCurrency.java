package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.model;

public enum CryptoCurrency {
  BITCOIN("tBTCHEUR"),
  EOS("tOSEUR"),
  ETHEREUM("tETHEUR"),
  PARKINGO("tGOTEUR"),
  NEO("tNEOEUR"),
  IOTA("tIOTEUR"),
  TRON("tTRXEUR");

  String symbol;
  CryptoCurrency(String symbol){
    this.symbol = symbol;
  }
  public String getSymbol(){
    return symbol;
  }
}
