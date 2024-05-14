package com.mshistorial.mshistorial.Bl;

import com.mshistorial.mshistorial.Dao.MultimediaRepository;
import com.mshistorial.mshistorial.Dto.MultimediaDto;
import com.mshistorial.mshistorial.Entity.Historial;
import com.mshistorial.mshistorial.Entity.Multimedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultimediaBl {

    @Autowired
    private MultimediaRepository multimediaRepository;

    //Crear multimeda de un hostorial
    public void createMultimedia(Integer historialId, List<String> multimedia){
        for (String multimediaDto : multimedia){
            Multimedia multimediaEntity = new Multimedia();
            Historial historial = new Historial();
            historial.setIdHistorial(historialId);
            multimediaEntity.setHistorial(historial);
            multimediaEntity.setMultimedia(multimediaDto);
            multimediaEntity.setStatus(true);
            multimediaRepository.save(multimediaEntity);
        }
    }

    //Mostrar multimedia de un historial
    public List<MultimediaDto> findAllByHistorialId(Integer historialId){
        List<Multimedia> multimedia = multimediaRepository.findAllByHistorialId(historialId);
        List<MultimediaDto> multimediaDto = new ArrayList<>();
        // convertir todos los multimedia en multimedia dto en un for
        for (Multimedia multimedia1 : multimedia){
            MultimediaDto multimediaDtos = new MultimediaDto();
            multimediaDtos.setIdMultimedia(multimedia1.getIdMultimedia());
            multimediaDtos.setMultimedia(multimedia1.getMultimedia());
            multimediaDto.add(multimediaDtos);
        }
        return multimediaDto;
    }
}
