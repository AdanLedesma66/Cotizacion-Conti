package py.com.cotizacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CotizacionPizarraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotizacionPizarraApplication.class, args);
	}

}
