package io.hanshin.exchange.service.impl;

import io.hanshin.exchange.model.CurrencyCalculateResponse;
import io.hanshin.exchange.model.CurrencyExchangeModel;
import io.hanshin.exchange.model.Quotes;
import io.hanshin.exchange.service.CurrencyCalculateService;
import io.hanshin.exchange.service.CurrencyLayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyCalculateServiceImpl implements CurrencyCalculateService {

    private final CurrencyLayerService currencyLayerService;

    @Override
    public CurrencyCalculateResponse currencyCalculate(Integer USD) throws Exception {
        CurrencyExchangeModel currencyExchange = currencyLayerService.getCurrencyExchange();

        if(!currencyExchange.isSuccess()){
            throw new Exception();
        }

        Quotes quotes = currencyExchange.getQuotes();


        CurrencyCalculateResponse currencyCalculateResponse = CurrencyCalculateResponse.builder()
                .USDJPY(quotes.getUSDJPY().multiply(BigDecimal.valueOf(USD)))
                .USDKRW(quotes.getUSDKRW().multiply(BigDecimal.valueOf(USD)))
                .USDPHP(quotes.getUSDPHP().multiply(BigDecimal.valueOf(USD)))
                .build();

        return currencyCalculateResponse;
    }
}
