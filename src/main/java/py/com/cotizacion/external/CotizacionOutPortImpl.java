package py.com.cotizacion.external;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import py.com.cotizacion.domain.port.out.CotizacionOutPort;
import py.com.cotizacion.external.model.BearerExternal;
import py.com.cotizacion.external.model.CotizacionExternal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CotizacionOutPortImpl implements CotizacionOutPort {

    // ::: path

    private static final String BEARER_TOKEN_PATH = "https://apibanking-gw.bancontinental.com.py/autenticarServicio/v1/realms/interno";
    private static final String COTIZACION_CONTINETAL_PATH = "https://apibanking-gw.bancontinental.com.py/divisas/v1/api/monedas/cotizaciones";

    // ::: apr

    @Override
    public BearerExternal findBearerToken() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BEARER_TOKEN_PATH))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Client-Id", "webinstitucional")
                .header("Client-Secret", "006f7995-3d33-4afe-8c56-e3b47377092c")
                .header("Subscription-Key", "3c35bb9e5fa948adb8d64c123d9d1a45")
                .header("Grant-Type", "client_credentials")
                .header("Scope", "profile")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            BearerExternal bearerDto = objectMapper.readValue(response.body(), BearerExternal.class);
            return bearerDto;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CotizacionExternal> findCotizacion() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(COTIZACION_CONTINETAL_PATH))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + findBearerToken().getAccessToken())
                .header("Subscription-Key", "3c35bb9e5fa948adb8d64c123d9d1a45")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            List<CotizacionExternal> cotizacionExternal = objectMapper.readValue(response.body(),
                    new TypeReference<>() {
                    });
            return cotizacionExternal;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }

    }
}
