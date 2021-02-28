package noetic.example.codetest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import noetic.example.codetest.config.LoadBankData;
import noetic.example.codetest.constant.Constant;
import noetic.example.codetest.dto.BankDto;
import noetic.example.codetest.exceptions.BankException;
import noetic.example.codetest.model.BankData;
import noetic.example.codetest.serviceImpl.TransformServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import noetic.example.codetest.serviceImpl.BankServiceImple;
import org.springframework.beans.factory.annotation.Autowired;

public class BankServiceImpleTest {
    @InjectMocks
    BankServiceImple bankServiceImple;
    HashMap<String, BankData> bankDataMap = null;

    @Before
    public void init() {
        new LoadBankData().postConstruct();
        bankDataMap = LoadBankData.bankDataMap;
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findBalanceByAccountId() throws ClassNotFoundException {
        String accountId = "123123123";
        BankData bankData = bankDataMap.get(accountId);
        if (bankData!=null) {
            assertEquals("1000", bankData.getBalance());

        }
    }
    @Test
    public void addAmount() throws BankException{
        String account = "123123123";
        String amount = "100";

            BankData bankData = bankDataMap.get(account);
            double totalBalance = Double.parseDouble(bankData.getBalance())+ Double.parseDouble(amount);
            bankData.setBalance(String.valueOf(totalBalance));
            bankDataMap.put(account,bankData);
        assertEquals("1100.0", bankDataMap.get(account).getBalance());

    }


}
