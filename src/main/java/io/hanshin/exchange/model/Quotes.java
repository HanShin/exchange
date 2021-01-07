package io.hanshin.exchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Quotes {
    @JsonProperty("USDKRW")
    private BigDecimal USDKRW;

    public BigDecimal getUSDJPY() {
        return USDJPY.setScale(2, RoundingMode.FLOOR);
    }

    @JsonProperty("USDJPY")
    private BigDecimal USDJPY;

    public BigDecimal getUSDKRW() {
        return USDKRW.setScale(2, RoundingMode.FLOOR);
    }

    @JsonProperty("USDPHP")
    private BigDecimal USDPHP;

    public BigDecimal getUSDPHP() {
        return USDPHP.setScale(2, RoundingMode.FLOOR);
    }
}
