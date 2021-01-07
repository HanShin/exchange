package io.hanshin.exchange.model;

import lombok.Getter;

@Getter
public class CurrencyExchangeModel {

    private boolean success;
    private String terms;
    private String privacy;
    private Integer timestamp;
    private String source;
    private Quotes quotes;
}
