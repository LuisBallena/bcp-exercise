package com.scrap.bcp.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CreateExchangeRateDTO implements Serializable {

    private static final long serialVersionUID = -8958193518796822463L;
    @NotBlank
    private String sourceCurrency;
    @NotBlank
    private String targetCurrency;
    @NotNull
    private Double value;

}
