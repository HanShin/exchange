package io.hanshin.exchange.service.impl;

import io.hanshin.exchange.model.CurrencyExchangeModel;
import io.hanshin.exchange.service.CurrencyLayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyLayerServiceImpl implements CurrencyLayerService {

    @Value("${currency-layer.base-url}")
    private String currencyLayerBaseUrl;

    @Value("${currency-layer.access-key}")
    private String currencyLayerAccessKey;

    private final String currencies = "KRW,JPY,PHP";

    private final WebClient webClient;

    @Override
    public CurrencyExchangeModel getCurrencyExchange() {
        return webClient.mutate()
                .baseUrl(currencyLayerBaseUrl)
                .build()
                .get()
                // 우선 변수로 처리하는 형태보단 고정값으로 처리하여 최소 요구사항에만 충족하도록 처리하였습니다.
                .uri("/live?access_key={api-key}&currencies={currencies}&format=1", currencyLayerAccessKey,currencies)
                .retrieve()
                .bodyToMono(CurrencyExchangeModel.class)
                .flux()
                .toStream()
                .findFirst()
                .orElse(new CurrencyExchangeModel());
    }
}
