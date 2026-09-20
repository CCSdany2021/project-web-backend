 package com.ucompensar.dispositivos.dao;                                                                                                                    
  import java.sql.Connection;                                                                                                                                   import java.sql.ResultSet;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.List;

  import com.ucompensar.dispositivos.model.Dispositivo;
  import com.ucompensar.dispositivos.util.Conexion;

  public class DispositivoDAO {

      public List<Dispositivo> obtenerTodos() {
          List<Dispositivo> dispositivos = new ArrayList<>();
          String sql = "SELECT * FROM dispositivos";

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);

              while (rs.next()) {
                  Dispositivo d = new Dispositivo();
                  d.setId(rs.getInt("id"));
                  d.setNombre(rs.getString("nombre"));
                  d.setMarca_id(rs.getInt("marca_id"));
                  d.setCategoria_id(rs.getInt("categoria_id"));
                  d.setPrecio(rs.getDouble("precio"));
                  d.setDescripcion(rs.getString("descripcion"));
                  d.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));

                  dispositivos.add(d);
              }

              rs.close();
              stmt.close();
              conn.close();

          } catch (Exception e) {
              e.printStackTrace();
          }

          return dispositivos;
      }

      public Dispositivo obtenerPorId(int id) {
          Dispositivo d = null;
          String sql = "SELECT * FROM dispositivos WHERE id = " + id;

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);

              if (rs.next()) {
                  d = new Dispositivo();
                  d.setId(rs.getInt("id"));
                  d.setNombre(rs.getString("nombre"));
                  d.setMarca_id(rs.getInt("marca_id"));
                  d.setCategoria_id(rs.getInt("categoria_id"));
                  d.setPrecio(rs.getDouble("precio"));
                  d.setDescripcion(rs.getString("descripcion"));
                  d.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));
              }

              rs.close();
              stmt.close();
              conn.close();

          } catch (Exception e) {
              e.printStackTrace();
          }

          return d;
      }

      public boolean crear(Dispositivo d) {
          String nombre = d.getNombre() != null ? d.getNombre().replace("'", "''") : "";
          String descripcion = d.getDescripcion() != null ? d.getDescripcion().replace("'", "''") : "";
          String fechaLanzamiento = d.getFecha_lanzamiento() != null ? d.getFecha_lanzamiento().toString() : "2025-01-01";

          String sql = "INSERT INTO dispositivos (nombre, descripcion, precio, marca_id, categoria_id, fecha_lanzamiento) " +
                       "VALUES ('" + nombre + "', '" + descripcion + "', " + d.getPrecio() + ", " +
                       d.getMarca_id() + ", " + d.getCategoria_id() + ", '" + fechaLanzamiento + "')";

          System.out.println("SQL CREAR: " + sql);

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              stmt.executeUpdate(sql);
              stmt.close();
              conn.close();
              return true;
          } catch (Exception e) {
              System.out.println("ERROR EN CREAR: " + e.getMessage());
              e.printStackTrace();
              return false;
          }
      }

      public boolean actualizar(Dispositivo d) {
          String nombre = d.getNombre() != null ? d.getNombre().replace("'", "''") : "";
          String descripcion = d.getDescripcion() != null ? d.getDescripcion().replace("'", "''") : "";
          String fechaLanzamiento = d.getFecha_lanzamiento() != null ? d.getFecha_lanzamiento().toString() : "2025-01-01";

          String sql = "UPDATE dispositivos SET " +
                       "nombre='" + nombre + "', " +
                       "descripcion='" + descripcion + "', " +
                       "precio=" + d.getPrecio() + ", " +
                       "marca_id=" + d.getMarca_id() + ", " +
                       "categoria_id=" + d.getCategoria_id() + ", " +
                       "fecha_lanzamiento='" + fechaLanzamiento + "' " +
                       "WHERE id=" + d.getId();

          System.out.println("SQL ACTUALIZAR: " + sql);

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              stmt.executeUpdate(sql);
              stmt.close();
              conn.close();
              return true;
          } catch (Exception e) {
              System.out.println("ERROR EN ACTUALIZAR: " + e.getMessage());
              e.printStackTrace();
              return false;
          }
      }

      public boolean eliminar(int id) {
          String sql = "DELETE FROM dispositivos WHERE id=" + id;

          System.out.println("SQL ELIMINAR: " + sql);

          try {
              Connection conn = Conexion.getConnection();
              Statement stmt = conn.createStatement();
              stmt.executeUpdate(sql);
              stmt.close();
              conn.close();
              return true;
          } catch (Exception e) {
              System.out.println("ERROR EN ELIMINAR: " + e.getMessage());
              e.printStackTrace();
              return false;
          }
      }
  }