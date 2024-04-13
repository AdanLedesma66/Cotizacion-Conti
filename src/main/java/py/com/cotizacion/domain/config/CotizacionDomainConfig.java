package py.com.cotizacion.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.cotizacion.domain.port.out.CotizacionOutPort;
import py.com.cotizacion.external.CotizacionOutPortImpl;

@Configuration
public class CotizacionDomainConfig {

    // ::: beans

    @Bean
    public CotizacionOutPort cotizacionOutPort() {
        return new CotizacionOutPortImpl();
    }

}
