package com.mshistorial.mshistorial.Bl;

import com.mshistorial.mshistorial.Dao.HistorialRepository;
import com.mshistorial.mshistorial.Dto.HistorialDto;
import com.mshistorial.mshistorial.Entity.Historial;
import com.mshistorial.mshistorial.Entity.Paciente;
import com.mshistorial.mshistorial.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialBl {
    @Autowired
    private HistorialRepository historialRepository;
    @Transactional
    public void crearHistorial(HistorialDto historialDto, Integer idPaciente){

    }

    //MOSTRAR HISTORILES DE PACIENTES
    public List<HistorialDto> listaHistorialByPaciente( Integer idPaciente){
        List<Historial> historiales = historialRepository.obtenerHistorialPorIdPaciente(idPaciente);
        List<HistorialDto> historialesDto = new ArrayList<>();
        for(Historial historial: historiales){
            historialesDto.add(new HistorialDto(historial.getIdHistorial(), historial.getPaciente(), historial.getFecha(), historial.getObservaciones(), historial.getStatus()));
        }
        return historialesDto;
    }

    //CREAR HISTORIAL NUEVO

    //public void addHistorialByPaciente
}