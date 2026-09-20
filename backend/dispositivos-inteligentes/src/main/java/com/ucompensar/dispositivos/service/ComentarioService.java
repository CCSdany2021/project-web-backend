package com.ucompensar.dispositivos.service;

  import java.util.List;
  import com.ucompensar.dispositivos.dao.ComentarioDAO;
  import com.ucompensar.dispositivos.model.Comentario;

  public class ComentarioService {

      private ComentarioDAO dao = new ComentarioDAO();

      public List<Comentario> obtenerTodos() {
          return dao.obtenerTodos();
      }

      public Comentario obtenerPorId(int id) {
          return dao.obtenerPorId(id);
      }

      public boolean crear(Comentario c) {
          return dao.crear(c);
      }

      public boolean actualizar(Comentario c) {
          return dao.actualizar(c);
      }

      public boolean eliminar(int id) {
          return dao.eliminar(id);
      }
  }