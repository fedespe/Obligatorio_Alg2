package Clases;

import Tads.AristaLista;

public class Empresa {
	private String nombre;
	private String direccion;
	private String pais;
	private String email_contacto;
	private String color;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEmail_contacto() {
		return email_contacto;
	}
	public void setEmail_contacto(String email_contacto) {
		this.email_contacto = email_contacto;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Empresa(String nombre, String direccion, String pais, String email_contacto, String color) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.pais = pais;
		this.email_contacto = email_contacto;
		this.color = color;
	}
	@Override
    public boolean equals(Object obj) {
        Empresa o=(Empresa)obj;
        if(this.nombre==o.getNombre())
            return true;
        return false;
    }
	
}
