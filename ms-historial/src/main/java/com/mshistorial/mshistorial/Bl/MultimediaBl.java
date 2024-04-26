package com.mshistorial.mshistorial.Bl;

import com.mshistorial.mshistorial.Dao.MultimediaRepository;
import com.mshistorial.mshistorial.Entity.Historial;
import com.mshistorial.mshistorial.Entity.Multimedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            multimediaRepository.save(multimediaEntity);
        }
    }
}
