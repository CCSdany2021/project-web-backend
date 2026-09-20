package com.ucompensar.dispositivos.service;

  import java.util.List;
  import com.ucompensar.dispositivos.dao.DispositivoDAO;
  import com.ucompensar.dispositivos.model.Dispositivo;

  public class DispositivoService {

      private DispositivoDAO dao = new DispositivoDAO();

      public List<Dispositivo> obtenerTodos() {
          return dao.obtenerTodos();
      }

      public Dispositivo obtenerPorId(int id) {
          return dao.obtenerPorId(id);
      }

      public boolean crear(Dispositivo d) {
          return dao.crear(d);
      }

      public boolean actualizar(Dispositivo d) {
          return dao.actualizar(d);
      }

      public boolean eliminar(int id) {
          return dao.eliminar(id);
      }
  }
