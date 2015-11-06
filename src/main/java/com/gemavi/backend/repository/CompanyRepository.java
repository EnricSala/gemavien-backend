package com.gemavi.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.gemavi.backend.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, String> {

}
