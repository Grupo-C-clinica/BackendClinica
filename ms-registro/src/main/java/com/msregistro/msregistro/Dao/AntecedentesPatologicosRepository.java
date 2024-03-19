package com.msregistro.msregistro.Dao;

import com.msregistro.msregistro.Entity.AntecedentesPatologicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AntecedentesPatologicosRepository extends JpaRepository<AntecedentesPatologicos, Integer> {
    //Lista de antecedentes patologicos de un paciente
    @Query("SELECT a FROM AntecedentesPatologicos a WHERE a.idPaciente = ?1")
    public List<AntecedentesPatologicos> findAntecedentesPatologicosByPaciente(Integer idPaciente);
}
