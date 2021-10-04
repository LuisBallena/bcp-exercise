package com.scrap.bcp.repository;

import com.scrap.bcp.domain.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {


    Optional<ExchangeRate> getExchangeRateBySourceCurrencyInAndTargetCurrencyIn(List<String> sourceCurrency,
                                                                                List<String> targetCurrency);

}
