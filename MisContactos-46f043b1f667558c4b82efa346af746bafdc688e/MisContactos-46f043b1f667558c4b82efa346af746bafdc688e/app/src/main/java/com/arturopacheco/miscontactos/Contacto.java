package com.arturopacheco.miscontactos;

/**
 * Created by arturopacheco on 17/03/17.
 */

public class Contacto {



    private long Id;

    private String Nombre;
    private String Telefono;
    private String Email;

    public Contacto(String nombre, String telefono, String email) {
        Nombre = nombre;
        Telefono = telefono;
        Email = email;
    }



    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
