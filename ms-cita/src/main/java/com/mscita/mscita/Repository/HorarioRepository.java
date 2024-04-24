package com.mscita.mscita.Repository;

import com.mscita.mscita.Entity.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    //Mostrar todos los horarios disponibles
    @Query("SELECT h FROM Horario h WHERE h.status = true And h.disponibilidad = true")
    public Page<Horario> findAllHorarios(Pageable pageable);

    //Mostrar todos los horarios de un doctor
    @Query("SELECT h FROM Horario h WHERE h.doctorIdDoctor = ?1 And h.status = true And h.disponibilidad = true")
    public Page<Horario> findAllHorariosByDoctorId(Integer doctorId, Pageable pageable);

}
