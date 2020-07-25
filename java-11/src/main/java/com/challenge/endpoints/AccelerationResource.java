package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationResource {

    private final AccelerationServiceInterface accelerationServiceInterface;

    public AccelerationResource(AccelerationServiceInterface accelerationServiceInterface) {
        this.accelerationServiceInterface = accelerationServiceInterface;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> getAccelerationById(@PathVariable("id") Long id) {
        return accelerationServiceInterface.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Acceleration> getAccelerationByIdCompany(@RequestParam("companyId") Long idCompany) {
        return accelerationServiceInterface.findByCompanyId(idCompany);
    }
}
