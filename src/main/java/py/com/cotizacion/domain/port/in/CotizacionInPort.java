package py.com.cotizacion.domain.port.in;

import py.com.cotizacion.domain.port.out.response.CotizacionResponse;

import java.util.List;

public interface CotizacionInPort {

    List<CotizacionResponse> findCotizacionResponse();

}
