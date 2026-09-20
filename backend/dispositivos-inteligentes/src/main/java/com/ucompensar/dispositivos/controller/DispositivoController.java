//ESTRUCUTRA DE LA API REST 

package com.ucompensar.dispositivos.controller;                             
  import java.util.List;                                                      
  import com.ucompensar.dispositivos.model.Dispositivo;
  import com.ucompensar.dispositivos.service.DispositivoService;

  import jakarta.ws.rs.GET;
  import jakarta.ws.rs.POST;
  import jakarta.ws.rs.PUT;
  import jakarta.ws.rs.DELETE;
  import jakarta.ws.rs.Path;
  import jakarta.ws.rs.PathParam;
  import jakarta.ws.rs.Produces;
  import jakarta.ws.rs.Consumes;
  import jakarta.ws.rs.core.MediaType;
  import jakarta.ws.rs.core.Response;

// RUTA: GET /api/dispositivos
  @Path("api/dispositivos") 
  public class DispositivoController {

      private DispositivoService service = new DispositivoService();

      @GET
      @Produces(MediaType.APPLICATION_JSON)
      public List<Dispositivo> obtenerTodos() {
          return service.obtenerTodos();
      }
 // RUTA: GET /api/dispositivos/{id}
      @GET
      @Path("{id}") 
      @Produces(MediaType.APPLICATION_JSON)
      public Dispositivo obtenerPorId(@PathParam("id") int id) {
          return service.obtenerPorId(id);
      }
        // RUTA: POST /api/dispositivos 
      @POST
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)
      public Response crear(Dispositivo d) {
          boolean resultado = service.crear(d);
          if (resultado) {
              return Response.ok("{\"mensaje\":\"Dispositivo  creado\"}").build();
          } else {
              return Response.status(500).entity("{\"error\":\"Error al  crear\"}").build();
          }
      }
      // RUTA: PUT /api/dispositivos/{id}
      @PUT
      @Path("{id}")
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)
      public Response actualizar(@PathParam("id") int id, Dispositivo d) {
          d.setId(id);
          boolean resultado = service.actualizar(d);
          if (resultado) {
              return Response.ok("{\"mensaje\":\"Dispositivo  actualizado\"}").build();
          } else {
              return Response.status(500).entity("{\"error\":\"Error al  actualizar\"}").build();
          }
      }
      // RUTA: DELETE /api/dispositivos/{id}
      @DELETE
      @Path("{id}")
      @Produces(MediaType.APPLICATION_JSON)
      public Response eliminar(@PathParam("id") int id) {
          boolean resultado = service.eliminar(id);
          if (resultado) {
              return Response.ok("{\"mensaje\":\"Dispositivo  eliminado\"}").build();
          } else {
              return Response.status(500).entity("{\"error\":\"Error al  eliminar\"}").build();
          }
      }
  }