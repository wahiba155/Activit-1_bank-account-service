package org.moussaoui.activitepratique01_ms.repositories;


import org.moussaoui.activitepratique01_ms.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankAccountRepository extends JpaRepository<BankAccount, String> {



}
