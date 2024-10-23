package py.com.cotizacion.domain.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import py.com.cotizacion.domain.port.in.CotizacionInPort;
import py.com.cotizacion.domain.port.out.CotizacionOutPort;
import py.com.cotizacion.domain.port.out.response.CotizacionResponse;
import py.com.cotizacion.domain.mapper.CotizacionDomainMapper;
import py.com.cotizacion.external.model.CotizacionExternal;

import java.util.List;
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class CotizacionService implements CotizacionInPort {

    // ::: inyects

    private CotizacionOutPort coreBankingAction;

    @Value("${cotizacion.urlImage.dolar}")
    private String dolarImage;

    @Value("${cotizacion.urlImage.euro}")
    private String euroImage;

    @Value("${cotizacion.urlImage.franco-suizo}")
    private String francoSuizoImage;

    @Value("${cotizacion.urlImage.libra-esterlina}")
    private String libraEsterlinaImage;

    @Value("${cotizacion.urlImage.peso-argentino}")
    private String pesoArgentinoImage;

    @Value("${cotizacion.urlImage.reales}")
    private String realesImage;

    @Value("${cotizacion.urlImage.yen-japones}")
    private String yenJaponesImage;

    public CotizacionService(CotizacionOutPort coreBankingAction) {
        this.coreBankingAction = coreBankingAction;
    }


    // ::: impl

    @Override
    public List<CotizacionResponse> findCotizacionResponse() {
        List<CotizacionExternal> cotizacionExternals = coreBankingAction.findCotizacion();

        var cotizacionList = CotizacionDomainMapper.INSTANCE.externalToListResponse(cotizacionExternals);

        cotizacionList.forEach(cotizacion -> {
            switch (cotizacion.getExchangeRate()) {
                case "DOLAR CHQ./TRANSF.":
                case "DOLAR EFECTIVO":
                    cotizacion.setUrlImage(dolarImage);
                    break;
                case "EURO CHQ./TRANSF.":
                case "EURO EFECTIVO":
                    cotizacion.setUrlImage(euroImage);
                    break;
                case "FRANCO SUIZO":
                    cotizacion.setUrlImage(francoSuizoImage);
                    break;
                case "LIBRA ESTERLINA":
                    cotizacion.setUrlImage(libraEsterlinaImage);
                    break;
                case "PESO ARGENTINO":
                    cotizacion.setUrlImage(pesoArgentinoImage);
                    break;
                case "REALES":
                    cotizacion.setUrlImage(realesImage);
                    break;
                case "YEN JAPONES":
                    cotizacion.setUrlImage(yenJaponesImage);
                    break;
                default:
                    cotizacion.setUrlImage(null);
                    break;
            }
        });

        return cotizacionList;
    }
}
