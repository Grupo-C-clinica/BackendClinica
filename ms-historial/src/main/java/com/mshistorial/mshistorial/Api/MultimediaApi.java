package com.mshistorial.mshistorial.Api;

import com.mshistorial.mshistorial.Bl.MultimediaBl;
import com.mshistorial.mshistorial.Bl.MultipartFileDto;
import com.mshistorial.mshistorial.Dto.MultimediaDto;
import com.mshistorial.mshistorial.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ResponseDto<String>> createMultimedia(@PathVariable Integer historialId, @RequestParam("file") List<MultipartFile> files){
        multimediaBl.createMultimedia(historialId, files);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, "Multimedia creado correctamente", "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    // Mostrar todas las imagenes de un historial
    @GetMapping("/all/{historialId}")
    public ResponseEntity<ResponseDto<List<MultipartFileDto>>> findAllByHistorialId(@PathVariable Integer historialId) {
        try {
            List<MultipartFileDto> multimedia = multimediaBl.findAllByHistorialId(historialId);
            if (multimedia.isEmpty()) {
                return ResponseEntity.ok(new ResponseDto<>(204, multimedia, "No Content")); // Código 204 para indicar que no hay contenido
            }
            return ResponseEntity.ok(new ResponseDto<>(200, multimedia, "Success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(500, null, "Error"));
        }
    }
}
