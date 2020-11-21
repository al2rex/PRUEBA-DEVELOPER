package com.arnaldocastilla.app.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnaldocastilla.app.entity.Empleado;
import com.arnaldocastilla.app.services.IEmpleado;

@RestController
public class EmpleadoController {

	@Autowired
	private IEmpleado empleado;

	@GetMapping("/empleado")
	public ResponseEntity<?> empleado(@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "apellido", required = false, defaultValue = "") String apellido,
			@RequestParam(name = "tipodedocumento", required = false, defaultValue = "") String tipodedocumento,
			@RequestParam(name = "numerodedocumento", required = false, defaultValue = "") String numerodedocumento,
			@RequestParam(name = "fechadenacimiento", required = false, defaultValue = "") String fechadenacimiento,
			@RequestParam(name = "fechadevinculacion", required = false, defaultValue = "") String fechadevinculacion,
			@RequestParam(name = "cargo", required = false, defaultValue = "") String cargo,
			@RequestParam(name = "salario", required = false, defaultValue = "") Double salario) {

		Map<String, Object> response = new HashMap<>();
		Empleado empl = new Empleado();

		// Validamos que los atributos no vengan vacíos
		if (empleado.validarCamposNull(nombre, apellido, tipodedocumento, numerodedocumento, fechadenacimiento,
				fechadevinculacion, cargo, salario) == true) {
			response.put("Error", "Todos los campos son requeridos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		// validar los formatos de las fechas

		try {
			empl.setFechaDeNacimiento(empleado.validarFormatoFecha(fechadenacimiento));
			empl.setFechaDeVinculacion(empleado.validarFormatoFecha(fechadevinculacion));
		} catch (ParseException e) {
			response.put("Error",
					"Los campos: fecha de nacimiento y fecha de vinculación, deben tener el formato dd-mm-aaaa");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		// validar que el empleado sea mayor de edad

		if (!empleado.empleadoMayorEdad(empleado.convertirLocalDate(fechadenacimiento))) {
			response.put("Error", "El empleado es menor de edad.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		empl.setNombres(nombre);
		empl.setApellidos(apellido);
		empl.setTipoDeDocumento(tipodedocumento);
		empl.setNumeroDeDocumento(numerodedocumento);
		empl.setCargo(cargo);
		empl.setSalario(salario);

		// invocar un servicio web SOAP
		//TODO

		response.put("Mensaje", "Data");
		response.put("empleado", empl);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

}
