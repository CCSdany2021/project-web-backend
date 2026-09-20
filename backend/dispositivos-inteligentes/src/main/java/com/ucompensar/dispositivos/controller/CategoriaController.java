package com.ucompensar.dispositivos.controller;

  import com.ucompensar.dispositivos.model.Categoria;
  import com.ucompensar.dispositivos.service.CategoriaService;
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

  @Path("categorias")
  public class CategoriaController {

      private CategoriaService service = new CategoriaService();

      @GET
      @Produces(MediaType.APPLICATION_JSON)
      public List<Categoria> obtenerTodos() {
          return service.obtenerTodos();
      }

      @GET
      @Path("{id}")
      @Produces(MediaType.APPLICATION_JSON)
      public Object obtenerPorId(@PathParam("id") int id) {
          return service.obtenerPorId(id);
      }

      @POST
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)
      public Response crear(Categoria c) {
          boolean resultado = service.crear(c);
          if (resultado) {
              return Response.ok("{\"mensaje\":\"Categoria creada\"}").build();
          } else {
              return Response.status(500).entity("{\"error\":\"Error al crear\"}").build();
          }
      }

      @PUT
      @Path("{id}")
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)
      public Response actualizar(@PathParam("id") int id, Categoria c) {
          c.setId(id);
          boolean resultado = service.actualizar(c);
          if (resultado) {
              return Response.ok("{\"mensaje\":\"Categoria actualizada\"}").build();
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
              return Response.ok("{\"mensaje\":\"Categoria eliminada\"}").build();
          } else {
              return Response.status(500).entity("{\"error\":\"Error al eliminar\"}").build();
          }
      }
  }