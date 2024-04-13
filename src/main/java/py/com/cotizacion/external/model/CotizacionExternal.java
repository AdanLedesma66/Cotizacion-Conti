package py.com.cotizacion.external.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CotizacionExternal {

    // ::: vars

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "divisa")
    private String exchangeRate;

    @JsonProperty(value = "codigo")
    private String currencyCode;

    @JsonProperty(value = "compra")
    private BigDecimal buyRate;

    @JsonProperty(value = "venta")
    private BigDecimal sellRate;

    @JsonProperty(value = "icono")
    private String icono;

    // ::: fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyCode() {
        if (currencyCode != null){
            return currencyCode.trim();
        }
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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
