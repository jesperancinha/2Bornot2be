package com.steelzack.b2b2bwebapp.repository;

import com.steelzack.b2b2bwebapp.model.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by joao on 15-5-16.
 */
@Repository
public interface DetailRepository extends JpaRepository<DetailEntity, Integer> {

}
