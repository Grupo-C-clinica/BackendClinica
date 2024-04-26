package com.mscita.mscita.Service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient("ms-cita")
public interface CitaService {
}
