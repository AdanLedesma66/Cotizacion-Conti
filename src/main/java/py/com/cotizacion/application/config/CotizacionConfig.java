package py.com.cotizacion.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.cotizacion.domain.port.in.CotizacionInPort;
import py.com.cotizacion.domain.port.out.CotizacionOutPort;
import py.com.cotizacion.domain.service.CotizacionService;

@Configuration
public class CotizacionConfig {

    // ::: beans

    @Bean
    public CotizacionInPort cotizacionService(CotizacionOutPort cotizacionOutPort){
        return new CotizacionService(cotizacionOutPort);
    }

}
