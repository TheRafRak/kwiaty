package com.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KwiatyRepository extends JpaRepository<Kwiaty, Long> {

}
