package com.challenge.service.implementation;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService implements CompanyServiceInterface {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findByAccelerationId(Long accelerationId) {
        return companyRepository.findByAccelerationId(accelerationId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findByUserId(Long userId) {
        return companyRepository.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return companyRepository.save(object);
    }
}
