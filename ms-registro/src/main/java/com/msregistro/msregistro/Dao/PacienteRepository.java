package com.msregistro.msregistro.Dao;

import com.msregistro.msregistro.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
