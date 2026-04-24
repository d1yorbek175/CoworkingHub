package org.example.coworkhub.repository;

import org.example.coworkhub.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepo extends JpaRepository<Zone, Long> {
    boolean existsByName(String name);
}
