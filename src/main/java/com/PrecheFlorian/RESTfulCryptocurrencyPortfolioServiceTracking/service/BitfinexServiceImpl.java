package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.service;

import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.dto.TickerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class BitfinexServiceImpl implements BitfinexService{
  @Autowired
private RestTemplate restTemplate;

  @Value("${bitfinex_api_url}")
private String apiUrl;

  public double getCurrentMarketValue(String symbol){
    String[] object = restTemplate.getForObject(
      apiUrl + symbol, String[].class);
    assert object != null;
    TickerDto tickerDto = TickerDto.CreateTickerDtoFromObjectArray(object);
    return tickerDto.getBid();
  }

  @Bean
public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}
