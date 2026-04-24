package org.example.coworkhub.repository;

import org.example.coworkhub.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address , Long> {
    boolean existByManzil(String Manzil);
}
