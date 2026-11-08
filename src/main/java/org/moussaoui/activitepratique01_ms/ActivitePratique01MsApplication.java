package org.moussaoui.activitepratique01_ms;

import org.moussaoui.activitepratique01_ms.entities.BankAccount;
import org.moussaoui.activitepratique01_ms.entities.Customer;
import org.moussaoui.activitepratique01_ms.enums.AccountType;
import org.moussaoui.activitepratique01_ms.repositories.BankAccountRepository;
import org.moussaoui.activitepratique01_ms.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ActivitePratique01MsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitePratique01MsApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("wahiba", "oumima", "med", "aymen").forEach(c -> {
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .balance(10000 + Math.random() * 90000)
                            .createdAt(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });
        };
    }
}


