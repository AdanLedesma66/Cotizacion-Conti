package py.com.cotizacion.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.cotizacion.domain.service.CotizacionService;

@Configuration
public class CotizacionConfig {

    // ::: beans

    @Bean
    public CotizacionService cotizacionService(){
        return new CotizacionService();
    }

}
