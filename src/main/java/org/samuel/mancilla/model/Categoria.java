package org.samuel.mancilla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Especificaciones JPA
@Entity
@Table(name="Categorias") //Se añade el nombre de la tabla con el que se estará trabajando


//Esta clase se conoce como JavaBean o Pojo
public class Categoria {
	/*Variables de clase*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //Hacer que se automatice el ID
	
	private String nombre; //Nombre de la categoria
	private String descripcion; //Descripcion de la categoría
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
