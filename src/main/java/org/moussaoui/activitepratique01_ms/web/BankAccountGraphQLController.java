package org.moussaoui.activitepratique01_ms.web;

import org.moussaoui.activitepratique01_ms.dto.BankAccountRequestDTO;
import org.moussaoui.activitepratique01_ms.dto.BankAccountResponseDTO;
import org.moussaoui.activitepratique01_ms.entities.BankAccount;
import org.moussaoui.activitepratique01_ms.entities.Customer;
import org.moussaoui.activitepratique01_ms.repositories.BankAccountRepository;
import org.moussaoui.activitepratique01_ms.repositories.CustomerRepository;
import org.moussaoui.activitepratique01_ms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerRepository customerRepository;


    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById( id).orElseThrow(()->new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }


    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

}
