package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/candidate")
public class CandidateResource {

    private final CandidateServiceInterface candidateServiceInterface;

    private final CandidateMapper candidateMapper;

    public CandidateResource(CandidateServiceInterface candidateServiceInterface, CandidateMapper candidateMapper) {
        this.candidateServiceInterface = candidateServiceInterface;
        this.candidateMapper = candidateMapper;
    }

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> getCandidateById(@PathVariable("userId") Long userId,
                                                         @PathVariable("accelerationId") Long accelerationId,
                                                         @PathVariable("companyId") Long companyId) {
        return candidateServiceInterface.findById(userId, companyId, accelerationId)
                .map(candidate -> {
                    CandidateDTO dto = candidateMapper.map(candidate);
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> getCandidateByCompanyIdOrAccelerationId(
            @RequestParam(value = "companyId", required = false) Long companyId,
            @RequestParam(value = "accelerationId", required = false) Long accelerationId) {

        if(Objects.nonNull(companyId)) {
            List<Candidate> candidates = candidateServiceInterface.findByCompanyId(companyId);
            return ResponseEntity.ok(candidateMapper.map(candidates));
        }
        if(Objects.nonNull(accelerationId)) {
            List<Candidate> candidates = candidateServiceInterface.findByCompanyId(accelerationId);
            return ResponseEntity.ok(candidateMapper.map(candidates));
        }
        return ResponseEntity.badRequest().build();
    }
}
