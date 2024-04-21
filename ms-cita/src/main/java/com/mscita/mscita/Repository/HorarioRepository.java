package com.mscita.mscita.Repository;

import com.mscita.mscita.Entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    //Mostrar todos los horarios disponibles
    @Query("SELECT h FROM Horario h WHERE h.status = true And h.disponibilidad = true")
    public List<Horario> findAllHorarios();

    //Mostrar todos los horarios de un doctor
    @Query("SELECT h FROM Horario h WHERE h.doctorIdDoctor = ?1 And h.status = true And h.disponibilidad = true")
    public List<Horario> findAllHorariosByDoctorId(Integer doctorId);

}
