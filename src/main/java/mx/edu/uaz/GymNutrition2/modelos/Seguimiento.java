package mx.edu.uaz.GymNutrition2.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class Seguimiento extends Object implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Seguimiento(){
		
	}
	
	public String getIdSeguimiento() {
		return idSeguimiento;
	}
	public void setIdSeguimiento(String idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}
	public String getPecho() {
		return pecho;
	}
	public void setPecho(String pecho) {
		this.pecho = pecho;
	}
	public String getEspalda() {
		return espalda;
	}
	public void setEspalda(String espalda) {
		this.espalda = espalda;
	}
	public String getAbdomen() {
		return abdomen;
	}
	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}
	public String getTriceps() {
		return triceps;
	}
	public void setTriceps(String triceps) {
		this.triceps = triceps;
	}
	public String getBiceps() {
		return biceps;
	}
	public void setBiceps(String biceps) {
		this.biceps = biceps;
	}
	public String getCuadriceps() {
		return cuadriceps;
	}
	public void setCuadriceps(String cuadriceps) {
		this.cuadriceps = cuadriceps;
	}
	public String getGemelos() {
		return gemelos;
	}
	public void setGemelos(String gemelos) {
		this.gemelos = gemelos;
	}
	public String getCadera() {
		return cadera;
	}
	public void setCadera(String cadera) {
		this.cadera = cadera;
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getTalla() {
		return talla;
	}
	
	private String idSeguimiento;
	private String pecho;
	private String espalda;
	private String abdomen;
	private String triceps;
	private String biceps;
	private String cuadriceps;
	private String gemelos;
	private String cadera;
	private Usuario idUsuario;
	private String peso;
	private String talla;
	private String edad;
	private LocalDate fecha;
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

}
