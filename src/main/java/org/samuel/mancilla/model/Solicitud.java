package org.samuel.mancilla.model;

import java.time.LocalDate;

public class Solicitud {
	//Variables de clase
	private Integer id;
	private LocalDate fecha; //fehca en la que  aplica para la oferta de trabajo
	private String cometarios;
	private String archivo; //nombre del archivo(PDF,DOCX del C.V.)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getCometarios() {
		return cometarios;
	}
	public void setCometarios(String cometarios) {
		this.cometarios = cometarios;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", cometarios=" + cometarios + ", archivo=" + archivo + "]";
	}
}
