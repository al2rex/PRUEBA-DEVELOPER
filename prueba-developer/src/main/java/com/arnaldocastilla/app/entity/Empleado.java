package com.arnaldocastilla.app.entity;

import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable {

	private String Nombres;
	private String Apellidos;
	private String TipoDeDocumento;
	private String NumeroDeDocumento;
	private Date FechaDeNacimiento;
	private Date FechaDeVinculacion;
	private String Cargo;
	private Double Salario;

	public Empleado() {
	}

	public Empleado(String nombres, String apellidos, String tipoDeDocumento, String numeroDeDocumento,
			Date fechaDeNacimiento, Date fechaDeVinculacion, String cargo, Double salario) {
		super();
		Nombres = nombres;
		Apellidos = apellidos;
		TipoDeDocumento = tipoDeDocumento;
		NumeroDeDocumento = numeroDeDocumento;
		FechaDeNacimiento = fechaDeNacimiento;
		FechaDeVinculacion = fechaDeVinculacion;
		Cargo = cargo;
		Salario = salario;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getTipoDeDocumento() {
		return TipoDeDocumento;
	}

	public void setTipoDeDocumento(String tipoDeDocumento) {
		TipoDeDocumento = tipoDeDocumento;
	}

	public String getNumeroDeDocumento() {
		return NumeroDeDocumento;
	}

	public void setNumeroDeDocumento(String númeroDeDocumento) {
		NumeroDeDocumento = númeroDeDocumento;
	}

	public Date getFechaDeNacimiento() {
		return FechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		FechaDeNacimiento = fechaDeNacimiento;
	}

	public Date getFechaDeVinculacion() {
		return FechaDeVinculacion;
	}

	public void setFechaDeVinculacion(Date fechaDeVinculacion) {
		FechaDeVinculacion = fechaDeVinculacion;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public Double getSalario() {
		return Salario;
	}

	public void setSalario(Double salario) {
		Salario = salario;
	}
	
	public String getTiempoVinculaicionCompania() {
		return null;
	}
	
	public String getEdadActualEmpleado() {
		return null;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
