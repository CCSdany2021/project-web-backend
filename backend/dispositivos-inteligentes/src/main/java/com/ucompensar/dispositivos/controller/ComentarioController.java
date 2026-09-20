package com.ucompensar.dispositivos.controller;

  import com.ucompensar.dispositivos.model.Comentario;
  import com.ucompensar.dispositivos.service.ComentarioService;
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
  import java.util.List;

  @Path("comentarios")
  public class ComentarioController {

      private ComentarioService service = new ComentarioService();

      @GET
      @Produces(MediaType.APPLICATION_JSON)
      public List<Comentario> obtenerTodos() {
          return service.obtenerTodos();
      }

      @GET
      @Path("{id}")
      @Produces(MediaType.APPLICATION_JSON)
      public Comentario obtenerPorId(@PathParam("id") int id) {
          return service.obtenerPorId(id);
      }

      @POST
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)
      public Response crear(Comentario c) {
          boolean resultado = service.crear(c);
          if (resultado) {
              return Response.ok("{\"mensaje\":\"Comentario creado\"}").build();
          } else {
              return Response.status(500).entity("{\"error\":\"Error al crear\"}").build();
          }
      }

      @PUT
      @Path("{id}")
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)
      public Response actualizar(@PathParam("id") int id, Comentario c) {
          c.setId(id);
          boolean resultado = service.actualizar(c);
          if (resultado) {
              return Response.ok("{\"mensaje\":\"Comentario actualizado\"}").build();
          } else {
              return Response.status(500).entity("{\"error\":\"Error al actualizar\"}").build();
          }
      }

      @DELETE
      @Path("{id}")
      @Produces(MediaType.APPLICATION_JSON)
      public Response eliminar(@PathParam("id") int id) {
          boolean resultado = service.eliminar(id);
          if (resultado) {
              return Response.ok("{\"mensaje\":\"Comentario eliminado\"}").build();
          } else {
              return Response.status(500).entity("{\"error\":\"Error al eliminar\"}").build();
          }
      }
  }