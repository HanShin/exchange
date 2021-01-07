package io.hanshin.exchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Builder
@AllArgsConstructor
public class CurrencyCalculateResponse {

    private BigDecimal USDPHP;
    private BigDecimal USDJPY;
    private BigDecimal USDKRW;

    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    @JsonProperty("USDJPY")
    public String getUSDJPY() {
        return decimalFormat.format(this.USDJPY);
    }

    @JsonProperty("USDKRW")
    public String getUSDKRW() {
        return decimalFormat.format(this.USDKRW);
    }

    @JsonProperty("USDPHP")
    public String getUSDPHP() {
        return decimalFormat.format(this.USDPHP);
    }
}
