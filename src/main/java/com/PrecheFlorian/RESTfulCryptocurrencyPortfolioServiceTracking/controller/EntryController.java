package com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.controller;

import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.dto.CryptoEntryRequest;
import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.model.CryptoEntry;
import com.PrecheFlorian.RESTfulCryptocurrencyPortfolioServiceTracking.service.CryptoEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cryptoentries")
public class EntryController {

  @Autowired
private CryptoEntryService cryptoEntryService;

  @GetMapping
public List<CryptoEntry> getAllCryptoEntries() throws Exception {
    return cryptoEntryService.findAll();
  }

  @GetMapping("/{cryptoentryId}")
public CryptoEntry getCryptoEntry(@PathVariable int cryptoentryId){
    CryptoEntry cryptoEntry = cryptoEntryService.findById(cryptoentryId);
    if(cryptoEntry == null){
      throw new RuntimeException("Entry not found with id-" + cryptoentryId);
    }
    return cryptoEntry;
  }
  @GetMapping("/totalamount")
public double getTotalAmountEur(){
    return cryptoEntryService.getTotalAmountEur();
  }

  @GetMapping("/{cryptoentryId}")
public String deleteCryptoEntry(@PathVariable int cryptoentryId){
    CryptoEntry cryptoEntry = cryptoEntryService.findById(cryptoentryId);
    if(cryptoEntry == null){
      throw new RuntimeException("Entry not found with id -" + cryptoentryId);
    }
    cryptoEntryService.deleteById(cryptoentryId);
    return "Delete entry with id -" + cryptoentryId;
  }
  @PostMapping
public List<CryptoEntry> addCryptoEntry(@RequestBody CryptoEntryRequest request){
    cryptoEntryService.addCryptoEntry(request);
  return cryptoEntryService.findAll();
  }
  @PutMapping
      public CryptoEntry updateCryptoEntry(@RequestBody CryptoEntry cryptoEntry) {
      cryptoEntryService.updateCryptoEntry(cryptoEntry);
    return cryptoEntry;
    }

  }

