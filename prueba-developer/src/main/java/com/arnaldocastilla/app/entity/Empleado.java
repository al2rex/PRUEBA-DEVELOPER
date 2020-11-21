package com.arnaldocastilla.app.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.arnaldocastilla.app.services.IEmpleado;

public class Empleado implements Serializable {

	@Autowired
	public IEmpleado empleado;

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
		LocalDate fechaIngreso = this.FechaDeVinculacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		Period vigencia = Period.between(fechaIngreso, LocalDate.now());

		return String.format("%d años, %d meses y %d días", vigencia.getYears(), vigencia.getMonths(),
				vigencia.getDays());
	}

	public String getEdadActualEmpleado() {
		LocalDate fechaNac = this.FechaDeNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		Period edad = Period.between(fechaNac, LocalDate.now());
		System.out.println(
				String.format("%d años, %d meses y %d días", edad.getYears(), edad.getMonths(), edad.getDays()));

		return String.format("%d años, %d meses y %d días", edad.getYears(), edad.getMonths(), edad.getDays());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
