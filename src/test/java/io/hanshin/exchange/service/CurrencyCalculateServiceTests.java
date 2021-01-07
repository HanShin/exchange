package io.hanshin.exchange.service;

import io.hanshin.exchange.ExchangeApplication;
import io.hanshin.exchange.model.CurrencyCalculateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(classes = ExchangeApplication.class)
public class CurrencyCalculateServiceTests {

    @Autowired
    private CurrencyCalculateService currencyCalculateService;

    @Test
    public void 환율계산성공_test() throws Exception {
        Random random = new Random();
        Integer USD = random.nextInt(10000) + 1;

        CurrencyCalculateResponse calculateResponse = currencyCalculateService.currencyCalculate(USD);
        assertThat(calculateResponse, is(notNullValue()));
        assertThat(calculateResponse.getUSDPHP(), is(notNullValue()));
        assertThat(calculateResponse.getUSDKRW(), is(notNullValue()));
        assertThat(calculateResponse.getUSDJPY(), is(notNullValue()));
        assertThat(calculateResponse.getCurrencyUSDJPY(), is(notNullValue()));
        assertThat(calculateResponse.getCurrencyUSDKRW(), is(notNullValue()));
        assertThat(calculateResponse.getCurrencyUSDPHP(), is(notNullValue()));
    }

}
