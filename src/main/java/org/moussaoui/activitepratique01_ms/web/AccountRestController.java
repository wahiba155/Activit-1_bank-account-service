package org.moussaoui.activitepratique01_ms.web;

import org.moussaoui.activitepratique01_ms.entities.BankAccount;
import org.moussaoui.activitepratique01_ms.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;


    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;

    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }


    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Bank account not found")));
    }



}
