package com.challenge.service.implementation;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CandidateService implements CandidateServiceInterface {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Candidate> findById(CandidateId id) {
        return candidateRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return candidateRepository.findById(userId, companyId, accelerationId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Candidate> findByCompanyId(Long companyId) {
        return candidateRepository.findByCompanyId(companyId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return candidateRepository.findByAccelerationId(accelerationId);
    }

    @Override
    public Candidate save(Candidate object) {
        return candidateRepository.save(object);
    }
}
