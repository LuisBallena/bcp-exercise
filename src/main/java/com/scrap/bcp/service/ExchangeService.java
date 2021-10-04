package com.scrap.bcp.service;

import com.scrap.bcp.api.dto.ResultDTO;
import com.scrap.bcp.api.dto.input.ExchangeRateDTO;
import com.scrap.bcp.domain.entity.ExchangeRate;
import com.scrap.bcp.repository.ExchangeRateRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rx.Single;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * ExchangeService.
 *
 * @author Luis Alonso Ballena Garcia
 */
@Service
@Slf4j
public class ExchangeService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public Single<ResultDTO> applyExchangeRate(ExchangeRateDTO exchangeRateDTO) {
        return Single.create(s -> s.onSuccess(getResultDTO(exchangeRateDTO)));
    }

    private ResultDTO getResultDTO(ExchangeRateDTO exchangeRateDTO) {
        ResultDTO resultDTO = new ResultDTO();
        List<String> currencies = List.of(exchangeRateDTO.getSourceCurrency(), exchangeRateDTO.getTargetCurrency());
        Optional<ExchangeRate> optional = exchangeRateRepository.getExchangeRateBySourceCurrencyInAndTargetCurrencyIn(currencies, currencies);
        if (optional.isPresent()) {

            ExchangeRate exchangeRate = optional.get();

            resultDTO.setSourceCurrency(exchangeRateDTO.getSourceCurrency());
            resultDTO.setTargetCurrency(exchangeRateDTO.getTargetCurrency());
            resultDTO.setAmount(exchangeRateDTO.getAmount());
            boolean multiply = exchangeRateDTO.getSourceCurrency().equalsIgnoreCase(exchangeRate.getSourceCurrency());
            resultDTO.setExchangeRateAmount(multiply
                    ? exchangeRateDTO.getAmount().multiply(BigDecimal.valueOf(exchangeRate.getValue())).setScale(4, RoundingMode.HALF_UP)
                    : exchangeRateDTO.getAmount().divide(BigDecimal.valueOf(exchangeRate.getValue()), 4, RoundingMode.HALF_UP));
            double newExchangeRate = multiply ? exchangeRate.getValue() : 1.0 / exchangeRate.getValue();
            resultDTO.setExchangeRate(BigDecimal.valueOf(newExchangeRate).setScale(4, RoundingMode.HALF_UP).doubleValue());
        }
        return resultDTO;
    }

}
