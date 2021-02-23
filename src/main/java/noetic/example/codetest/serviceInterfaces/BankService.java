package noetic.example.codetest.serviceInterfaces;

import noetic.example.codetest.dto.BankDto;
import noetic.example.codetest.dto.EmployeeDto;
import noetic.example.codetest.exceptions.BankException;

/**
 * Created by DS hewapathirana.
 * Date: 23/02/2021
 * Time: 2055h
 */
public interface BankService {
    String findBalanceByAccountId(String accountId) throws ClassNotFoundException;
    String findAllAccountBalance() throws BankException;
    String fundTransfer(String senderAccount, String receiverAccount, boolean isOwnFundTransfer, String amount) throws BankException;
}
