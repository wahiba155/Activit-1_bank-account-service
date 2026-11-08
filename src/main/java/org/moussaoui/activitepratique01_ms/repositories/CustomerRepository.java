package org.moussaoui.activitepratique01_ms.repositories;

import org.moussaoui.activitepratique01_ms.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
