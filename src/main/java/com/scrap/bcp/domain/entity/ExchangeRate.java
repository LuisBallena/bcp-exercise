package com.scrap.bcp.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "currency")
public class ExchangeRate implements Serializable {

    private static final long serialVersionUID = 8281205301306248818L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date tradingDate;
    private String sourceCurrency;
    private String targetCurrency;
    private Double value;

}
