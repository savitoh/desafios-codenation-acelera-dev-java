package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/company")
public class CompanyResource {

    private final CompanyServiceInterface companyServiceInterface;

    public CompanyResource(CompanyServiceInterface companyServiceInterface) {
        this.companyServiceInterface = companyServiceInterface;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable("id") Long id) {
        return companyServiceInterface.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanyByAccelerationIdOrUserId(
            @RequestParam(value = "accelerationId", required = false) Long accelerationId,
            @RequestParam(value = "userId", required = false) Long userId) {

        if(Objects.nonNull(accelerationId)) {
            return ResponseEntity.ok(companyServiceInterface.findByAccelerationId(accelerationId));
        }
        if(Objects.nonNull(userId)) {
            return ResponseEntity.ok(companyServiceInterface.findByUserId(userId));
        }
        return ResponseEntity.badRequest().build();
    }


}
