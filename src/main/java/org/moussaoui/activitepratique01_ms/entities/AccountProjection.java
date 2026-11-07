package org.moussaoui.activitepratique01_ms.entities;

import org.moussaoui.activitepratique01_ms.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
