package com.scrap.bcp.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ResultDTO.
 *
 * @author Luis Alonso Ballena Garcia
 */

@Getter
@Setter
public class ResultDTO implements Serializable {

    private static final long serialVersionUID = -7808442362723904899L;
    private BigDecimal amount;
    private BigDecimal exchangeRateAmount;
    private String sourceCurrency;
    private String targetCurrency;
    private Double exchangeRate;

}
