package com.formacionbdi.microservicios.app.usuarios.services;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.services.CommonService;

import java.util.List;

public interface AlumnoService extends CommonService<Alumno> {

    public List<Alumno> findByNombreOrApellido(String busqueda);

}
