package io.hanshin.exchange.service;

import io.hanshin.exchange.exception.CurrencyExchangeException;
import io.hanshin.exchange.model.CurrencyCalculateResponse;

public interface CurrencyCalculateService {
    CurrencyCalculateResponse currencyCalculate(Integer USD) throws CurrencyExchangeException, Exception;
}
