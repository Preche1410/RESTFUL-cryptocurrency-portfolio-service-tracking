package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="crypto_entry")
@Data
@NoArgsConstructor
public class CryptoEntry{
  @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
  @Enumerated(EnumType.STRING)
@Column(name= "cryptocurrency")
private CryptoCurrency cryptocurrency;

  @Column(name= "amount")
private int amount;

  @CreationTimestamp
@Column(name= "creation_timestamp")
private LocalDateTime creationTimestamp;
  @Column(name="wallet_location")
private String walletLocation;
  @Column(name = "current_market_value_eur")
private double currentMarketValueEur;

  public CryptoEntry(CryptoCurrency cryptocurrency,int amount, String walletLocation,double currentMarketValueEur){
    this.cryptocurrency = cryptocurrency;
    this.amount = amount;
    this.walletLocation = walletLocation;
    this.currentMarketValueEur = currentMarketValueEur;
  }
}
