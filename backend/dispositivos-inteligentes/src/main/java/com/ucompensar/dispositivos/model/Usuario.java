package com.ucompensar.dispositivos.model;

public class Usuario {
    
    private int id;
    private String email;
    private String password;
    private String nombre;
    private boolean esAdmin;
    
    // Constructor
    public Usuario() {}
    
    public Usuario(String email, String password, String nombre, boolean esAdmin) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.esAdmin = esAdmin;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public boolean isEsAdmin() { return esAdmin; }
    public void setEsAdmin(boolean esAdmin) { this.esAdmin = esAdmin; }
}