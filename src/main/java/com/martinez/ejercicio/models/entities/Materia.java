package com.martinez.ejercicio.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Code First = primero codificar los modelos y a partir de ahi generar la base de datos
//Las tablas estaran en minusculas en plural, si hay dos palabras se separan con guion bajo
//Clases en singular, 
//anotaciones para convertir clases en modelos, javax.persistence es el ORM => JPA
@Entity
@Table(name="materias")
//las clases que representan modelos y nos abstractos implementan serializable
public class Materia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_materia")
	private Integer idmateria;
	
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="nrc")
	private String nrc;
	
	@Column(name="creditos")
	private Integer creditos;
	
	
	public Materia() {
		super();
	}
	public Materia(Integer id) {
		super();
		this.idmateria = id;
	}
	public Integer getIdmateria() {
		return idmateria;
	}
	public void setIdmateria(Integer idMateria) {
		this.idmateria = idMateria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	
	/*=============== Varios a uno con Area =============*/
	//usar el nombre del mapedBy de la clase con la que se relaciona
	//agregar la columna con la cual se va a unir
	@JoinColumn(name="fk_area", referencedColumnName="pk_area")
	@ManyToOne
	private Area area;
	
	@OneToMany(mappedBy="asignatura", fetch=FetchType.LAZY)
	private List<Aula> aulas;
	
	
	
	@JoinColumn(name="fk_semestre", referencedColumnName="pk_semestre")
	@ManyToOne
	private Semestre semestre;
	
	@OneToMany(mappedBy="curso", fetch=FetchType.LAZY)
	private List<Matricula> matriculas;
	
	
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
	


	public List<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	public Semestre getSemestre() {
		return semestre;
	}
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	@Override
	public String toString() {
		return this.getNombre();
	}
	
	
	
	
	
	


	
	
	
	
	

}
