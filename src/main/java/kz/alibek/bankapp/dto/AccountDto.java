package kz.alibek.bankapp.dto;

import kz.alibek.bankapp.bank.account.AccountType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {
    Long clientId;
    String accountType;

    public String getClientId() {
        return clientId.toString();
    }

    public AccountType getAccountType() {
        AccountType ans = switch (this.accountType) {
            case "FIXED"    -> AccountType.FIXED;
            case "SAVING"   -> AccountType.SAVING;
            case "CHECKING" -> AccountType.CHECKING;
            default -> null;
        };
        return ans;
    }

    @Override
    public String toString() {
        return String.format("%d %s", clientId, accountType);
    }
}
