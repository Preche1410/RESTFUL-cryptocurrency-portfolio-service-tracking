package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.service;

import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.dto.CryptoEntryRequest;
import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.model.CryptoCurrency;
import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.model.CryptoEntry;
import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.repository.CryptoEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CryptoEntryServiceImpl implements CryptoEntryService{

  @Autowired
private CryptoEntryRepository cryptoEntryRepository;

  @Autowired
private BitfinexService bitfinexService;

  @Override
public List<CryptoEntry> findAll(){
    return cryptoEntryRepository.findAll();
}

@Override

public CryptoEntry findById(int id){
    Optional<CryptoEntry> result = cryptoEntryRepository.findById(id);
    CryptoEntry cryptoEntry;
    if(result.isPresent()){
      cryptoEntry = result.get();
    }
    else {
      throw new RuntimeException("No entry with id was found" + id);
    }
    return cryptoEntry;

}

@Override

public void deleteById(int id){
  cryptoEntryRepository.deleteById(id);
}
   @Override
   public void addCryptoEntry(CryptoEntryRequest request){
    CryptoCurrency cryptoCurrency = CryptoCurrency.valueOf(request.getCryptocurrency().toUpperCase());
   double currentMarketValue =bitfinexService.getCurrentMarketValue(cryptoCurrency.getSymbol());
   CryptoEntry cryptoEntry = new CryptoEntry(cryptoCurrency, request.getAmount(),
     request.getWalletLocation(),currentMarketValue);
   cryptoEntryRepository.save(cryptoEntry);
  }

  @Override
    public void updateCryptoEntry(CryptoEntry cryptoEntry){
     double currentMarketValue =bitfinexService.getCurrentMarketValue(cryptoEntry.getCryptocurrency().getSymbol());
cryptoEntry.setCurrentMarketValueEur(currentMarketValue);
cryptoEntryRepository.save(cryptoEntry);
  }
  @Override
    public double getTotalAmountEur(){
   List<CryptoEntry> allCryptoEntries =cryptoEntryRepository.findAll();
   return allCryptoEntries.stream()
            .map(CryptoEntry::getCurrentMarketValueEur).mapToDouble(Double::doubleValue).sum();
  }
}

