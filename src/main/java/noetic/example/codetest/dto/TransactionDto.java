package noetic.example.codetest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created by DS hewapathirana.
 * Date: 23/02/2021
 * Time: 2050h
 */
public class TransactionDto {
    @NotBlank(message = "sender account  is required")
    private String senderAccount;
    private String receiverAccount;
    @NotBlank(message = "amount is required")
    private String amount;
    private boolean isOwnAccount;

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public boolean getIsOwnAccount() {
        return isOwnAccount;
    }

    public void setIsOwnAccount(boolean ownAccount) {
        isOwnAccount = ownAccount;
    }
}
