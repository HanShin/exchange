package io.hanshin.exchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Builder
@AllArgsConstructor
public class CurrencyCalculateResponse {

    private BigDecimal currencyUSDPHP;
    private BigDecimal currencyUSDJPY;
    private BigDecimal currencyUSDKRW;
    private Integer USD;

    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    @JsonProperty("USDJPY")
    public String getUSDJPY() {
        return decimalFormat.format(this.currencyUSDJPY.multiply(BigDecimal.valueOf(USD)));
    }

    @JsonProperty("USDKRW")
    public String getUSDKRW() {
        return decimalFormat.format(this.currencyUSDKRW.multiply(BigDecimal.valueOf(USD)));
    }

    @JsonProperty("USDPHP")
    public String getUSDPHP() {
        return decimalFormat.format(this.currencyUSDPHP.multiply(BigDecimal.valueOf(USD)));
    }


    @JsonProperty("currencyUSDJPY")
    public String getCurrencyUSDJPY() {
        return decimalFormat.format(this.currencyUSDJPY);
    }

    @JsonProperty("currencyUSDKRW")
    public String getCurrencyUSDKRW() {
        return decimalFormat.format(this.currencyUSDKRW);
    }

    @JsonProperty("currencyUSDPHP")
    public String getCurrencyUSDPHP() {
        return decimalFormat.format(this.currencyUSDPHP);
    }


}
