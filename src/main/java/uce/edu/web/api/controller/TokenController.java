package uce.edu.web.api.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/generate")
public class TokenController {
    @GET
    @Path("")
    public String generar(@QueryParam("semilla")String semilla, @QueryParam("tiempo")Integer tiempo) {
        try {
            // Usar la semilla como nombre del archivo de clave privada
            String keyLocation = semilla != null && !semilla.isEmpty() ? semilla : "privateKey-pkcs8.pem";
            
            // Leer la clave privada desde el archivo
            String privateKey = new String(Files.readAllBytes(
                Paths.get(getClass().getClassLoader().getResource(keyLocation).toURI())
            ));
            
            return Jwt.issuer("http://uce.edu.ec")
                    .upn("fcfiallos@uce.edu.ec")
                    .groups("admin")
                    .expiresIn(Duration.ofSeconds(tiempo))
                    .sign(privateKey);
        } catch (Exception e) {
            return "Error generando token: " + e.getMessage();
        }
    }
}
