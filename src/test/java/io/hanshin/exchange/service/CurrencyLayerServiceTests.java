package io.hanshin.exchange.service;


import io.hanshin.exchange.ExchangeApplication;
import io.hanshin.exchange.model.CurrencyExchangeModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ExchangeApplication.class)
public class CurrencyLayerServiceTests {

    @Autowired
    private CurrencyLayerService currencyLayerService;


    // 환율정보 API 호출이 정상적으로 작동되는지 test
    @Test
    public void 환율정보호출_test() {

        CurrencyExchangeModel currencyExchange = currencyLayerService.getCurrencyExchange();

        assertNotNull(currencyExchange); // 데이터 존재여부
        assertTrue(currencyExchange.isSuccess());
        assertNotNull(currencyExchange.getTerms());
        assertNotNull(currencyExchange.getPrivacy());
        assertNotNull(currencyExchange.getTimestamp());
        assertNotNull(currencyExchange.getSource());
        assertNotNull(currencyExchange.getQuotes());
        assertNotNull(currencyExchange.getQuotes().getUSDJPY());
        assertNotNull(currencyExchange.getQuotes().getUSDKRW());
        assertNotNull(currencyExchange.getQuotes().getUSDPHP());


    }
}
