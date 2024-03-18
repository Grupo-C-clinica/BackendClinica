package com.msregistro.msregistro.Bl;

import com.msregistro.msregistro.Dto.PacienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msregistro.msregistro.Dao.PacienteRepository;

@Service
public class PacienteBl {
    @Autowired
    private PacienteRepository pacienteRepository;

    public void crearPaciente(PacienteDto nuevoPaciente) throws Exception {
        
    }
}
