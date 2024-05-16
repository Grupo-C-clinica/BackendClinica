package com.mshistorial.mshistorial.Api;

import com.mshistorial.mshistorial.Bl.MultimediaBl;
import com.mshistorial.mshistorial.Dto.MultimediaDto;
import com.mshistorial.mshistorial.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/multimedia")
public class MultimediaApi {

    @Autowired
    private MultimediaBl multimediaBl;

    //Crear una lista demultimedia de un historial
    @PostMapping("/create/{historialId}")
    public ResponseEntity<ResponseDto<String>> createMultimedia(@PathVariable Integer historialId, @RequestParam("files") List<MultipartFile> files){
        multimediaBl.createMultimedia(historialId, files);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, "Multimedia creado correctamente", "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    // Mostrar todas las imagenes de un historial
    @GetMapping("/all/{historialId}")
    public ResponseEntity<ResponseDto<List<MultipartFile>>> findAllByHistorialId(@PathVariable Integer historialId){
            List<MultipartFile> multimedia = multimediaBl.findAllByHistorialId(historialId);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, multimedia, "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }
}
