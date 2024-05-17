package com.msregistro.msregistro.Api;

import com.msregistro.msregistro.Bl.AuthBl;
import com.msregistro.msregistro.Dto.LoginDto;
import com.msregistro.msregistro.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthApi {

    @Autowired
    private AuthBl authBl;

    //Login
    @PostMapping(path = "/login")
    public ResponseEntity<ResponseDto<String>> login(@RequestBody LoginDto loginDto) {
        try {
            String token = "";
            if (token != null) {
                return ResponseEntity.ok(new ResponseDto<>(200, token, "Login exitoso"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(401, null, "Usuario o contraseña incorrectos"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al hacer login"));
        }
    }
}
