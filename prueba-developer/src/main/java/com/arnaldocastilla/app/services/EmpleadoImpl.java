package com.arnaldocastilla.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoImpl implements IEmpleado {

	@Override
	public Boolean validarCamposNull(String nombre, String apellido, String tipodedocumento, String numerodedocumento,
			String fechadenacimiento, String fechadevinculacion, String cargo, Double salario) {
		if (nombre.isEmpty() || apellido.isEmpty() || tipodedocumento.isEmpty() || numerodedocumento.isEmpty()
				|| fechadenacimiento.isEmpty() || fechadevinculacion.isEmpty() || cargo.isEmpty()) {
			return true;
		}

		return false;
	}

	@Override
	public Date validarFormatoFecha(String fecha) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.parse(fecha);
	}

	@Override
	public Boolean empleadoMayorEdad(LocalDate fechaNacimiento) {
		Period edad = Period.between(fechaNacimiento, LocalDate.now());

		if (edad.getYears() >= 18) {
			return true;
		}
		return false;
	}

	@Override
	public LocalDate convertirLocalDate(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(fecha, formatter);
		return localDate;
	}

}
