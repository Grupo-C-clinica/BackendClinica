package com.mshistorial.mshistorial.Bl;

import com.mshistorial.mshistorial.Dao.HistorialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialBl {
    @Autowired
    private HistorialRepository historialRepository;


}
