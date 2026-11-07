package org.moussaoui.activitepratique01_ms.service;

import org.moussaoui.activitepratique01_ms.dto.BankAccountRequestDTO;
import org.moussaoui.activitepratique01_ms.dto.BankAccountResponseDTO;
import org.moussaoui.activitepratique01_ms.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
