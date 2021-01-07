package io.hanshin.exchange.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyExchangeControllerTests{

    @Autowired
    protected MockMvc mvc;

    @Test
    public void 수취금액을입력하지않은경우_test() throws Exception {
        //given

        //when
        final ResultActions resultActions = mvc.perform(get("/currency-calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .param("USD", ""))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isBadRequest());
    }

    @Test
    public void 수취금액이0보다작은경우_test() throws Exception {
        //given
        final Integer USD = -1;

        //when
        final ResultActions resultActions = requestCalculate(USD);

        //then
        resultActions
                .andExpect(status().isBadRequest());
    }

    @Test
    public void 수취금액이10000보다큰경우_test() throws Exception {
        //given
        final Integer USD = 10001;

        //when
        final ResultActions resultActions = requestCalculate(USD);

        //then
        resultActions
                .andExpect(status().isBadRequest());
    }

    @Test
    public void 수취금액이숫자가아닌경우_test() throws Exception {
        //given
        Random random = new Random();
        final Integer USD = random.nextInt(10000) + 1;

        //when
        final ResultActions resultActions = requestCalculate(USD);

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("USDPHP").isNotEmpty())
                .andExpect(jsonPath("USDJPY").isNotEmpty())
                .andExpect(jsonPath("USDKRW").isNotEmpty());
    }

    @Test
    public void 정상호출_test() throws Exception {
        //given
        Random random = new Random();
        final Integer USD = random.nextInt(10000) + 1;

        //when
        final ResultActions resultActions = requestCalculate(USD);

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("USDPHP").isNotEmpty())
                .andExpect(jsonPath("USDJPY").isNotEmpty())
                .andExpect(jsonPath("USDKRW").isNotEmpty());
    }

    private ResultActions requestCalculate(Integer USD) throws Exception {
        return mvc.perform(get("/currency-calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .param("USD", USD.toString()))
                .andDo(print());
    }
}
