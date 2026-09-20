package com.ucompensar.dispositivos.service;

  import java.util.List;
  import com.ucompensar.dispositivos.dao.MarcaDAO;
  import com.ucompensar.dispositivos.model.Marca;

  public class MarcaService {

      private MarcaDAO dao = new MarcaDAO();

      public List<Marca> obtenerTodos() {
          return dao.obtenerTodos();
      }

      public Object obtenerPorId(int id) {
          return dao.obtenerPorId(id);
      }

      public boolean crear(Marca m) {
          return dao.crear(m);
      }

      public boolean actualizar(Marca m) {
          return dao.actualizar(m);
      }

      public boolean eliminar(int id) {
          return dao.eliminar(id);
      }
  }