package mx.edu.uaz.GymNutrition2.modelos;

import java.io.Serializable;
import java.time.LocalDate;

import mx.uaz.edu.GymNutrition2.utils.Hash;

public class Usuario extends Object implements Serializable{
	
	public Usuario(){
		
	}
	private int idUsuario;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return nombre+" "+apellidos;
	}
	private String nombre;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public int getImc() {
		return imc;
	}
	public void setImc(int imc) {
		this.imc = imc;
	}
	public String getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}
	private String apellidos;
	private String correo;
	private String telefono;
	private String password;
	private LocalDate fecha;
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	private String peso;
	private String altura;
	private int imc;
	private String tipoUser;

}
