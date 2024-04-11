package com.msregistro.msregistro.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient("ms-historial")
public interface HistorialService {
}
