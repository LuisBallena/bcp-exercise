package com.scrap.bcp.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * ExchangeRateDTO.
 *
 * @author Luis Alonso Ballena Garcia
 */
@Getter
@Setter
public class ExchangeRateDTO implements Serializable {

    private static final long serialVersionUID = 7673782352831845731L;

    private BigDecimal amount;
    private String sourceCurrency;
    private String targetCurrency;

    public ExchangeRateDTO() {
    }

    // practical case
    public ExchangeRateDTO(BigDecimal amount, String sourceCurrency, String targetCurrency) {
        this.amount = Optional.ofNullable(amount).orElse(BigDecimal.ZERO);
        this.sourceCurrency = Optional.ofNullable(sourceCurrency).map(s->s.toUpperCase()).orElse("");
        this.targetCurrency = Optional.ofNullable(targetCurrency).map(s->s.toUpperCase()).orElse("");;
    }
}
