package com.msregistro.msregistro.Bl;

import com.msregistro.msregistro.Dao.AlergiaRepository;
import com.msregistro.msregistro.Dto.AlergiaDto;
import com.msregistro.msregistro.Entity.Alergia;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlergiaBl {
    @Autowired
    private AlergiaRepository alergiaRepository;

    //Mostrar alergias de un paciente
    public List<AlergiaDto> findAlergiasByPaciente(Integer idPaciente) {
        List<Alergia> alergias = alergiaRepository.findAlergiasByPaciente(idPaciente);
        List<AlergiaDto> alergiasDto = new ArrayList<>();
        for (Alergia alergia : alergias) {
            alergiasDto.add(new AlergiaDto(alergia.getIdAlergia(), alergia.getIdPaciente(), alergia.getTipoAlergia(), alergia.getCausa(), alergia.getStatus()));
        }
        return alergiasDto;
    }
}
