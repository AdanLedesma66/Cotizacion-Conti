package py.com.cotizacion.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.cotizacion.domain.port.out.response.CotizacionResponse;
import py.com.cotizacion.external.model.CotizacionExternal;

import java.util.List;

@Mapper
public interface CotizacionDomainMapper {

    // ::: instance

    CotizacionDomainMapper INSTANCE = Mappers.getMapper(CotizacionDomainMapper.class);

    // ::: mappers

    CotizacionResponse externalToResponse(CotizacionExternal cotizacionExternal);

    List<CotizacionResponse> externalToListResponse(List<CotizacionExternal> cotizacionExternals);


}
