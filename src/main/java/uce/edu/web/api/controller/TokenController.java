package uce.edu.web.api.controller;

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
        return Jwt.issuer("http://uce.edu.ec").upn(semilla).groups("admin").expiresIn(Duration.ofSeconds(tiempo)).sign();
    }
}
