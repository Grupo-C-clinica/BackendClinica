package com.mshistorial.mshistorial.Bl;

import com.mshistorial.mshistorial.Dao.TratamientoRepository;
import com.mshistorial.mshistorial.Dto.TratamientoDto;
import com.mshistorial.mshistorial.Entity.Historial;
import com.mshistorial.mshistorial.Entity.Tratamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TratamientoBl {
    @Autowired
    private TratamientoRepository tratamientoRepository;

    // CREAR TRATAMIENTO POR HISTORIAL
    public void addTratamientoByHistorial(TratamientoDto tratamiendoDto, Integer idHistorial){
        Historial historial = new Historial();
        historial.setIdHistorial(idHistorial);
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setContenido(tratamiendoDto.getContenido());
        tratamiento.setStatus(true);
        tratamiento.setHistorial(historial);
        tratamientoRepository.save(tratamiento);
    }

    //MOSTRAR LISTA DE TRATAMIENTOS POR HISTORIAL

    public List<TratamientoDto> listaTratamientoByHistorial(Integer idHistorial){
        List<Tratamiento> tratamientos = tratamientoRepository.obtenerTratamientoPorIdHistorial(idHistorial);
        List<TratamientoDto> tratamientosDto = new ArrayList<>();
        for(Tratamiento tratamiento: tratamientos){
            tratamientosDto.add(new TratamientoDto(tratamiento.getIdTratamiento(), tratamiento.getHistorial().getIdHistorial(), tratamiento.getContenido(), tratamiento.getStatus()));
        }
        return tratamientosDto;
    }

    //MOSTRAR TRATAMIENTO POR HISTORIA

    public TratamientoDto obtenerTratamientoById(Integer idTratamiento){
        Tratamiento tratamiento = tratamientoRepository.obtenerTratamientoById(idTratamiento);
        if (tratamiento == null){
            throw new IllegalArgumentException("El tratamiento no existe");
        }
        return new TratamientoDto(
                tratamiento.getIdTratamiento(),
                tratamiento.getHistorial().getIdHistorial(),
                tratamiento.getContenido(),
                tratamiento.getStatus()
        );
    }
}
