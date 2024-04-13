package py.com.cotizacion.domain.port.out.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class CotizacionResponse {

    // ::: vars

    @JsonProperty(value = "divisa")
    private String exchangeRate;

    @JsonProperty(value = "codigo")
    private String currencyCode;

    @JsonProperty(value = "compra")
    private BigDecimal buyRate;

    @JsonProperty(value = "venta")
    private BigDecimal sellRate;

    // ::: fields


    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(BigDecimal buyRate) {
        this.buyRate = buyRate;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }
}
