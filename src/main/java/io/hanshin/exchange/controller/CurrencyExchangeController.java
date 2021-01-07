package io.hanshin.exchange.controller;

import io.hanshin.exchange.exception.CurrencyExchangeException;
import io.hanshin.exchange.model.CurrencyCalculateResponse;
import io.hanshin.exchange.service.CurrencyCalculateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
public class CurrencyExchangeController {

    private final CurrencyCalculateService currencyCalculateService;

    @GetMapping("/currency-calculate")
    @ResponseBody
    public CurrencyCalculateResponse getCurrencyCalculate(@RequestParam("USD")@Min(0) @Max(10000) Integer  USD) throws CurrencyExchangeException {
        CurrencyCalculateResponse currencyCalculateResponse = currencyCalculateService.currencyCalculate(USD);
        return currencyCalculateResponse;

    }

}
