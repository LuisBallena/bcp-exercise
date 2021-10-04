package com.scrap.bcp.api;

import com.scrap.bcp.api.dto.ResultDTO;
import com.scrap.bcp.api.dto.input.ExchangeRateDTO;
import com.scrap.bcp.service.ExchangeService;
import org.springframework.web.bind.annotation.*;
import rx.Single;

import java.math.BigDecimal;

/**
 * ExchangeApi.
 *
 * @author Luis Alonso Ballena Garcia
 */
@RestController("/exchange-rates")
public class ExchangeApi {

    private ExchangeService exchangeService;

    public ExchangeApi(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping
    public Single<ResultDTO> applyExchangeRate(@RequestParam(value = "amount") BigDecimal amount,
                                               @RequestParam(value = "sourceCurrency") String sourceCurrency,
                                               @RequestParam(value = "targetCurrency") String targetCurrency) {
        return exchangeService.applyExchangeRate(new ExchangeRateDTO(amount, sourceCurrency, targetCurrency));
    }

}
