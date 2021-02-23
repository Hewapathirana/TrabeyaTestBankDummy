package noetic.example.codetest.config;

import noetic.example.codetest.model.BankData;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class LoadBankData {
    public static HashMap<String, BankData> bankDataMap = new HashMap<>();

    @PostConstruct
    private void postConstruct() {


        BankData bankData1 = new BankData();
        bankData1.setUserId("111");
        bankData1.setAccountNo("123123123");
        bankData1.setBalance("1000");
        bankDataMap.put(bankData1.getAccountNo(),bankData1);

        BankData bankData2 = new BankData();
        bankData2.setUserId("111");
        bankData2.setAccountNo("456456456");
        bankData2.setBalance("2000");
        bankDataMap.put(bankData2.getAccountNo(),bankData2);

        BankData bankData3 = new BankData();
        bankData3.setUserId("222");
        bankData3.setAccountNo("789789789");
        bankData3.setBalance("2320");
        bankDataMap.put(bankData3.getAccountNo(),bankData3);

        BankData bankData4 = new BankData();
        bankData4.setUserId("333");
        bankData4.setAccountNo("567567567");
        bankData4.setBalance("1230");
        bankDataMap.put(bankData4.getAccountNo(),bankData4);
    }
}
