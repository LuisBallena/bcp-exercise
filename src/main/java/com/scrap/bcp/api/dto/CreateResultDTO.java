package com.scrap.bcp.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ResultDTO.
 *
 * @author Luis Alonso Ballena Garcia
 */

@Getter
@Setter
public class CreateResultDTO implements Serializable {

    private static final long serialVersionUID = -7808442362723904899L;
    private Date tradingDate;
    private String sourceCurrency;
    private String targetCurrency;
    private Double exchangeRate;

    public CreateResultDTO() {
    }

    // practical - case
    public CreateResultDTO(Date tradingDate, String sourceCurrency, String targetCurrency, Double exchangeRate) {
        this.tradingDate = tradingDate;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
    }
}
