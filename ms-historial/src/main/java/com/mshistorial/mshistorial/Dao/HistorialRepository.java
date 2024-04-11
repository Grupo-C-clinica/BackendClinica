package com.mshistorial.mshistorial.Dao;

import com.mshistorial.mshistorial.Entity.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, Integer> {
    //Obtener historiales dependiendo del paciente
    @Query(value = "SELECT * FROM historial WHERE idPaciente =?1" , nativeQuery = true)
    public List<Historial> obtenerHistorialPorIdPaciente(Integer idPaciente);
}
