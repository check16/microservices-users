package com.formacionbdi.microservicios.app.usuarios.models.repository;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
