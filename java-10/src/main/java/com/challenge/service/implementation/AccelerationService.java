package com.challenge.service.implementation;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccelerationService implements AccelerationServiceInterface {

    private final AccelerationRepository accelerationRepository;

    public AccelerationService(AccelerationRepository accelerationRepository) {
        this.accelerationRepository = accelerationRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Acceleration> findByCompanyId(Long companyId) {
        return accelerationRepository.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return accelerationRepository.save(object);
    }
}
