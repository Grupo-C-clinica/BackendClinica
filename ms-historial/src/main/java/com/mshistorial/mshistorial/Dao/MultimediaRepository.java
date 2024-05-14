package com.mshistorial.mshistorial.Dao;

import com.mshistorial.mshistorial.Entity.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MultimediaRepository extends JpaRepository<Multimedia, Integer> {


    //Mostrar multimedia de un historial
    @Query("SELECT m FROM Multimedia m WHERE m.historial.idHistorial= ?1")
    public List<Multimedia> findAllByHistorialId(Integer historialId);


}
