package py.com.cotizacion.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import py.com.cotizacion.domain.port.in.CotizacionInPort;
import py.com.cotizacion.domain.port.out.CotizacionOutPort;
import py.com.cotizacion.domain.port.out.response.CotizacionResponse;
import py.com.cotizacion.domain.mapper.CotizacionDomainMapper;
import py.com.cotizacion.external.model.CotizacionExternal;

import java.util.List;
@Slf4j
public class CotizacionService implements CotizacionInPort {

    // ::: inyects

    @Autowired
    private CotizacionOutPort coreBankingAction;

    // ::: impl

    @Override
    public List<CotizacionResponse> findCotizacionResponse() {
        List<CotizacionExternal> cotizacionExternals = coreBankingAction.findCotizacion();
        return CotizacionDomainMapper.INSTANCE.externalToListResponse(cotizacionExternals);
    }
}
