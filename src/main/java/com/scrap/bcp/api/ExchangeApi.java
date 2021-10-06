package com.scrap.bcp.api;

import com.scrap.bcp.api.dto.CreateResultDTO;
import com.scrap.bcp.api.dto.ResultDTO;
import com.scrap.bcp.api.dto.input.CreateExchangeRateDTO;
import com.scrap.bcp.api.dto.input.ExchangeRateDTO;
import com.scrap.bcp.domain.entity.ExchangeRate;
import com.scrap.bcp.service.ExchangeService;
import org.springframework.web.bind.annotation.*;
import rx.Observable;
import rx.Single;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

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

    @GetMapping("/filters")
    public Single<ResultDTO> applyExchangeRate(@RequestParam(value = "amount") BigDecimal amount,
                                               @RequestParam(value = "sourceCurrency") String sourceCurrency,
                                               @RequestParam(value = "targetCurrency") String targetCurrency) {
        return exchangeService.applyExchangeRate(new ExchangeRateDTO(amount, sourceCurrency, targetCurrency));
    }

    @PostMapping
    public Single<CreateResultDTO> saveExchangeRate(@RequestBody @Valid CreateExchangeRateDTO createExchangeRateDTO) {
        return exchangeService.saveExchange(createExchangeRateDTO);
    }

    @GetMapping
    public Observable<List<ExchangeRate>> getExchangeRates() {
        return exchangeService.getExchangeRates();
    }

}
