package io.hanshin.exchange.service;

import io.hanshin.exchange.model.CurrencyCalculateResponse;

public interface CurrencyCalculateService {
    CurrencyCalculateResponse currencyCalculate(Integer USD) throws Exception;
}
