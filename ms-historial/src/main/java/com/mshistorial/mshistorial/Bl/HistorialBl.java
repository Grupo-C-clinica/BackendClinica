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
import java.util.Optional;

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
            historialesDto.add(new HistorialDto(historial.getIdHistorial(), historial.getPaciente().getIdPaciente(), historial.getFecha(), historial.getObservaciones(), historial.getStatus()));
        }
        return historialesDto;
    }

    //CREAR HISTORIAL NUEVO POR PACIENTE

    public void addHistorialByPaciente(HistorialDto historialDto, Integer idPaciente){
        System.out.println("Received historialDto: " + historialDto); // Agregar esto para depuración

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);
        Historial historial = new Historial();
        historial.setPaciente(paciente);
        historial.setFecha(historialDto.getFecha());
        historial.setObservaciones(historialDto.getObservaciones()); // Asegúrate que esto no es null aquí
        historial.setStatus(historialDto.getStatus());

        historialRepository.save(historial);
    }

    // MOSTRAR CADA HISTORIAL DEPENDIENDO DE LA ID
    public HistorialDto obtnerHistorialById(Integer idHistorial){
        Historial historial = historialRepository.obtenerHistorialById(idHistorial);
        if (historial == null){
            throw new IllegalArgumentException("El historial con no existe");
        }
        return new HistorialDto(
                historial.getIdHistorial(),
                historial.getPaciente().getIdPaciente(),
                historial.getFecha(),
                historial.getObservaciones(),
                historial.getStatus()
        );
    }
}

