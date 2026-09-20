package com.ucompensar.dispositivos.controller;

  public class LoginResponse {
      private int id;
      private String email;
      private String nombre;
      private boolean esAdmin;
      private String mensaje;

      public LoginResponse() {
      }

      public int getId() {
          return id;
      }

      public void setId(int id) {
          this.id = id;
      }

      public String getEmail() {
          return email;
      }

      public void setEmail(String email) {
          this.email = email;
      }

      public String getNombre() {
          return nombre;
      }

      public void setNombre(String nombre) {
          this.nombre = nombre;
      }

      public boolean isEsAdmin() {
          return esAdmin;
      }

      public void setEsAdmin(boolean esAdmin) {
          this.esAdmin = esAdmin;
      }

      public String getMensaje() {
          return mensaje;
      }

      public void setMensaje(String mensaje) {
          this.mensaje = mensaje;
      }
  }