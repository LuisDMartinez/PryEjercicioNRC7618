package com.martinez.ejercicio.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="semestres")
public class Semestre implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_semestre")
	private Integer idsemestre;
	
	@Column(name="fecha_inicio")
	private Calendar fechaInicio;
	
	@Column(name="fecha_unidad_i")
	private Calendar fechaUnidadI;
	
	@Column(name="fecha_unidad_ii")
	private Calendar fechaUnidadII;
	
	@Column(name="fecha_unidad_iii")
	private Calendar fechaUnidadIII;
	
	@Column(name="fecha_fin")
	private Calendar fechaFin;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="descripcion")
	private String descripcion;

	public Semestre() {
		super();
	}
	
	public Semestre(Integer id) {
		super();
		this.idsemestre = id;
	}

	public Integer getIdsemestre() {
		return idsemestre;
	}

	public void setIdsemestre(Integer idsemestre) {
		this.idsemestre = idsemestre;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Calendar getFechaUnidadI() {
		return fechaUnidadI;
	}

	public void setFechaUnidadI(Calendar fechaUnidadI) {
		this.fechaUnidadI = fechaUnidadI;
	}

	public Calendar getFechaUnidadII() {
		return fechaUnidadII;
	}

	public void setFechaUnidadII(Calendar fechaUnidadII) {
		this.fechaUnidadII = fechaUnidadII;
	}

	public Calendar getFechaUnidadIII() {
		return fechaUnidadIII;
	}

	public void setFechaUnidadIII(Calendar fechaUnidadIII) {
		this.fechaUnidadIII = fechaUnidadIII;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	/*Anotacion de relacion*/
	/*Se crea un nombre que luego va a ser un atributo en la clase materia*/
	@OneToMany(mappedBy = "semestre", fetch=FetchType.LAZY)
	//mappedBy debe ser un atributo en la clase relacionada
	private List<Materia> materias;

	@Override
	public String toString() {
		return this.getCodigo() + " " + this.getDescripcion();
	} 
	
	
}
