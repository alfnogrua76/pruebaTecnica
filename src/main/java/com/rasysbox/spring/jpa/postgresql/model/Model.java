package com.rasysbox.spring.jpa.postgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "email")
	private String email;

	@Column(name = "estado")
	private boolean estado;

	public Model() {
	}

	public Model(String nombre, String email, boolean estado) {
		this.nombre = nombre;
		this.email = email;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean isEstado) {
		this.estado = isEstado;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", email=" + email + ", estado=" + estado + "]";
	}

}
