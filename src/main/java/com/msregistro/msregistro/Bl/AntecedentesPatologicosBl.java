package com.msregistro.msregistro.Bl;

import com.msregistro.msregistro.Dao.AntecedentesPatologicosRepository;
import com.msregistro.msregistro.Dto.AntecedentesPatologicosDto;
import com.msregistro.msregistro.Entity.AntecedentesPatologicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AntecedentesPatologicosBl {

    @Autowired
    private AntecedentesPatologicosRepository antecedentesPatologicosRepository;

    //Mostrar antecedentes patologicos de un paciente
    public List<AntecedentesPatologicosDto> findAntecedentesPatologicosByPaciente(Integer idPaciente) {
        List<AntecedentesPatologicos> antecedentesPatologicos = antecedentesPatologicosRepository.findAntecedentesPatologicosByPaciente(idPaciente);
        List<AntecedentesPatologicosDto> antecedentesPatologicosDto = new ArrayList<>();
        for (AntecedentesPatologicos antecedentePatologico : antecedentesPatologicos) {
            antecedentesPatologicosDto.add(new AntecedentesPatologicosDto(antecedentePatologico.getAntecedentesPatologicosId(), antecedentePatologico.getIdPaciente(), antecedentePatologico.getAntecedente(), antecedentePatologico.getStatus()));
        }
        return antecedentesPatologicosDto;
    }

    //Agregar antecedentes patologicos a un paciente
    public void addAntecedentesPatologicosByPaciente(List<AntecedentesPatologicosDto> antecedentesPatologicos,Integer idPaciente) {
        for (AntecedentesPatologicosDto antecedentePatologicoDto : antecedentesPatologicos) {
            AntecedentesPatologicos antecedentePatologico = new AntecedentesPatologicos();
            antecedentePatologico.setIdPaciente(idPaciente);
            antecedentePatologico.setAntecedente(antecedentePatologicoDto.getAntecedente());
            antecedentePatologico.setStatus(true);
            antecedentesPatologicosRepository.save(antecedentePatologico);
        }
    }

    //Eliminar antecedente patologico de un paciente
    public void deleteAntecedentesPatologicosByPaciente(Integer antecedentesPatologicosId) {
        AntecedentesPatologicos antecedentePatologico = new AntecedentesPatologicos();
        antecedentePatologico.setAntecedentesPatologicosId(antecedentesPatologicosId);
        antecedentePatologico.setStatus(false);
        antecedentesPatologicosRepository.save(antecedentePatologico);
    }
}
