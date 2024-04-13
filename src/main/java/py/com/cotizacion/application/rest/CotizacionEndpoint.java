package py.com.cotizacion.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.com.cotizacion.domain.port.in.CotizacionInPort;

@RestController
@RequestMapping("/cotizacion/v1")
public class CotizacionEndpoint {

    // ::: inyects

    @Autowired
    private CotizacionInPort action;

    // ::: requests

    @GetMapping
    public ResponseEntity cotizaciones(){
        return ResponseEntity.ok(action.findCotizacionResponse());
    }

}
