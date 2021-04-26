package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.dto;

import lombok.Data;

@Data
public class TickerDto{
  private double bid;
  private double bidSize;
private double ask;
private double askSize;
private double dailyChange;
private double dailyChangeRelative;
private double lastPrice;
private double volume;
private double Low;
private double high;

public static  TickerDto CreateTickerDtoFromObjectArray(String[] objects) {
  TickerDto tickerDto = new TickerDto();

  tickerDto.setBid(Double.parseDouble(objects[0]));
  tickerDto.setBidSize(Double.parseDouble(objects[1]));
  tickerDto.setAsk(Double.parseDouble(objects[2]));
  tickerDto.setAskSize(Double.parseDouble(objects[3]));
  tickerDto.setDailyChange(Double.parseDouble(objects[4]));
  tickerDto.setDailyChangeRelative(Double.parseDouble(objects[5]));
  tickerDto.setLastPrice(Double.parseDouble(objects[6]));
  tickerDto.setVolume(Double.parseDouble(objects[7]));
  tickerDto.setLow(Double.parseDouble(objects[8]));
  tickerDto.setHigh(Double.parseDouble(objects[9]));

  return tickerDto;
}


}
