package io.hanshin.exchange.controller;

import io.hanshin.exchange.model.CurrencyCalculateResponse;
import io.hanshin.exchange.service.CurrencyCalculateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CurrencyViewController {

    private final CurrencyCalculateService currencyCalculateService;

    @GetMapping("/home")
    public String hello(Model model) throws Exception {
        CurrencyCalculateResponse calculateResponse = currencyCalculateService.currencyCalculate(1);
        model.addAttribute("currencyKRW", calculateResponse.getCurrencyUSDKRW());
        model.addAttribute("currencyJPY", calculateResponse.getCurrencyUSDJPY());
        model.addAttribute("currencyPHP", calculateResponse.getCurrencyUSDPHP());
        return "currency";
    }
}
