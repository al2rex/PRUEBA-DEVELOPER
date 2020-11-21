package com.arnaldocastilla.app.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public interface IEmpleado {

	public Boolean validarCamposNull(String nombre, String apellido, String tipodedocumento, String numerodedocumento,
			String fechadenacimiento, String fechadevinculacion, String cargo, Double salario);
	
	public Date validarFormatoFecha(String fecha)throws ParseException;
	
	public Boolean empleadoMayorEdad(LocalDate fechaNacimiento);
	
	public LocalDate convertirLocalDate(String fecha);
	
	public LocalDate ConvertDateALocalDate(Date fecha);

}
