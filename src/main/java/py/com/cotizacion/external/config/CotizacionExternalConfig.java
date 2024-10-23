package py.com.cotizacion.external.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.cotizacion.domain.port.out.CotizacionOutPort;
import py.com.cotizacion.external.CotizacionOutPortImpl;

@Configuration
public class CotizacionExternalConfig {

    // ::: beans

    @Bean
    public CotizacionOutPort cotizacionOutPort(){
        return new CotizacionOutPortImpl();
    }
}
