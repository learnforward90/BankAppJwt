package kz.alibek.bankapp.requestoutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
@ResponseBody
@Data
public class Messages {
    private String message;
    public static String ACCOUNT_CREATED = "Account created";
    public static String ACCOUNT_NOT_CREATED = "Account not created";
    public static String ACCOUNT_DELETED = "Account deleted";
    public static String ACCOUNT_NOT_DELETED = "Account not deleted";
    public static String ACCOUNT_TRANSACTION_OK = "is done";
    public static String ACCOUNT_TRANSACTION_FAILED = "Transaction failed";
    public static String ACCOUNT_WITHDRAW_NOT_ALLOWED = "Withdraw not allowed";
    public static String ACCOUNT_NOT_FOUNDED = "Account not founded";
}
