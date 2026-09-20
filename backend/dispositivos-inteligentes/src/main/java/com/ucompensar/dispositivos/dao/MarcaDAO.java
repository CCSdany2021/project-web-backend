package com.ucompensar.dispositivos.dao;                                                                                                                    
  import com.ucompensar.dispositivos.util.Conexion;                                                                                                             import com.ucompensar.dispositivos.model.Marca;
  import java.sql.Connection;
  import java.sql.ResultSet;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.List;

  public class MarcaDAO {

      public List<Marca> obtenerTodos() {
          List<Marca> marcas = new ArrayList<>();
          String sql = "SELECT * FROM marcas";

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);

              while (rs.next()) {
                  Marca m = new Marca();
                  m.setId(rs.getInt("id"));
                  m.setNombre(rs.getString("nombre"));
                  marcas.add(m);
              }

              rs.close();
              stmt.close();
              conn.close();

          } catch (Exception e) {
              e.printStackTrace();
          }

          return marcas;
      }

      public Marca obtenerPorId(int id) {
          Marca m = null;
          String sql = "SELECT * FROM marcas WHERE id = " + id;

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);

              if (rs.next()) {
                  m = new Marca();
                  m.setId(rs.getInt("id"));
                  m.setNombre(rs.getString("nombre"));
              }

              rs.close();
              stmt.close();
              conn.close();

          } catch (Exception e) {
              e.printStackTrace();
          }

          return m;
      }

      public boolean crear(Marca m) {
          String sql = "INSERT INTO marcas (nombre) VALUES ('" + m.getNombre() + "')";

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              stmt.executeUpdate(sql);
              stmt.close();
              conn.close();
              return true;
          } catch (Exception e) {
              e.printStackTrace();
              return false;
          }
      }

      public boolean actualizar(Marca m) {
          String sql = "UPDATE marcas SET nombre='" + m.getNombre() + "' WHERE id=" + m.getId();

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              stmt.executeUpdate(sql);
              stmt.close();
              conn.close();
              return true;
          } catch (Exception e) {
              e.printStackTrace();
              return false;
          }
      }

      public boolean eliminar(int id) {
          String sql = "DELETE FROM marcas WHERE id=" + id;

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              stmt.executeUpdate(sql);
              stmt.close();
              conn.close();
              return true;
          } catch (Exception e) {
              e.printStackTrace();
              return false;
          }
      }
  }