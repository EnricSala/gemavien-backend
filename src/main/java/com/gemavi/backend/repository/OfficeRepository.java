package com.gemavi.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.gemavi.backend.domain.Office;

public interface OfficeRepository extends CrudRepository<Office, String> {

}
