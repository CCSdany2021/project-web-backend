package com.ucompensar.dispositivos.controller;

import com.ucompensar.dispositivos.dao.UsuarioDAO;
import com.ucompensar.dispositivos.model.Usuario;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/login")
public class LoginController {
    
    private UsuarioDAO UsuarioDAO = new UsuarioDAO();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest request) {
        
        // Validar que vengan email y password
        if (request.getEmail() == null || request.getPassword() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"Email y contraseña requeridos\"}")
                    .build();
        }
        
        // Buscar usuario en BD
        Usuario usuario = UsuarioDAO.buscarPorEmail((String) request.getEmail());
        
        // Validar que exista
        if (usuario == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\":\"Usuario no encontrado\"}")
                    .build();
        }
        
        // Validar contraseña (comparación simple)
        if (!usuario.getPassword().equals(request.getPassword())) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\":\"Contraseña incorrecta\"}")
                    .build();
        }
        
        // LOGIN EXITOSO
        LoginResponse response = new LoginResponse();
        response.setId(usuario.getId());
        response.setEmail(usuario.getEmail());
        response.setNombre(usuario.getNombre());
        response.setEsAdmin(usuario.isEsAdmin());
        response.setMensaje("Login exitoso");
        
        return Response.ok(response).build();
    }
}