package py.com.cotizacion.domain.port.out;

import py.com.cotizacion.external.model.BearerExternal;
import py.com.cotizacion.external.model.CotizacionExternal;

import java.util.List;

public interface CotizacionOutPort {

    BearerExternal findBearerToken();

    List<CotizacionExternal> findCotizacion();

}
