 package com.ucompensar.dispositivos.service;

  import java.util.List;
  import com.ucompensar.dispositivos.dao.CategoriaDAO;
  import com.ucompensar.dispositivos.model.Categoria;

  public class CategoriaService {

      private CategoriaDAO dao = new CategoriaDAO();

      public List<Categoria> obtenerTodos() {
          return dao.obtenerTodos();
      }

      public Object obtenerPorId(int id) {
          return dao.obtenerPorId(id);
      }

      public boolean crear(Categoria c) {
          return dao.crear(c);
      }

      public boolean actualizar(Categoria c) {
          return dao.actualizar(c);
      }

      public boolean eliminar(int id) {
          return dao.eliminar(id);
      }
  }