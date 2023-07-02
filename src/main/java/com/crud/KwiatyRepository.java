package com.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface KwiatyRepository extends JpaRepository<Kwiaty, Long> {
    List<Kwiaty> findAllByNazwa(String nazwa);
    Kwiaty findByNazwa(String nazwa);
}
