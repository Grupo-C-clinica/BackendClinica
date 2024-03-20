package com.msregistro.msregistro.Dao;

import com.msregistro.msregistro.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
