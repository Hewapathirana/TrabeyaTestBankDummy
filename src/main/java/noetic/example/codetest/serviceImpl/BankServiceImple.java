package noetic.example.codetest.serviceImpl;

import noetic.example.codetest.config.LoadBankData;
import noetic.example.codetest.constant.Constant;
import noetic.example.codetest.dto.BankDto;
import noetic.example.codetest.exceptions.BankException;
import noetic.example.codetest.model.BankData;
import noetic.example.codetest.serviceInterfaces.BankService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by DS hewapathirana.
 * Date:25/02/2020
 * Time: 7:45 PM
 */
@Service
public class BankServiceImple implements BankService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankServiceImple.class);

    @Autowired
    private LoadBankData loadBankData;
    @Autowired
    private TransformServiceImpl transformService;

    @Override
    public String findBalanceByAccountId(String accountId) throws ClassNotFoundException {
        BankData bankData = loadBankData.bankDataMap.get(accountId);
        if (bankData!=null) {

             BankDto bankDto = (BankDto) transformService.convertToDto(bankData, Constant.BANK_DTO_CLASS);
             return bankDto.getBalance();

        } else {
            throw new BankException(Constant.BANK_ACCOUNT_NOT_FOUND);
        }
    }

    @Override
    public String findAllAccountBalance() throws BankException {
        double[] sum = new double[]{0};
        loadBankData.bankDataMap.forEach((k, v) -> {
               sum[0] += Double.parseDouble(v.getBalance());
        });
        return String.valueOf(sum[0]);
    }

    @Override
    public String fundTransfer(String senderAccount, String receiverAccount,
                               boolean isOwnFundTransfer, String amount) throws BankException {

        LOGGER.info(Constant.LOGGER_DEBUG_STRING, "Is Own Fund Transfer =  ", isOwnFundTransfer);
        if(!isOwnFundTransfer && receiverAccount == null){
            throw new BankException("please provide recerver account details");
        }

        if(senderAccount == null){
            throw new BankException("please provide sender account details");
        }

        if(isOwnFundTransfer){
            addAmount(senderAccount,amount);
        }

        else  if(deductAmount(senderAccount,amount)){
                boolean isAdd = addAmount(receiverAccount,amount);
                if(!isAdd){
                    addAmount(senderAccount,amount);
                }
        }

        else {
            LOGGER.error(Constant.LOGGER_ERROR_STRING, "Is Own Fund Transfer = " + isOwnFundTransfer, "error occured while transaction processing");
            throw  new BankException("error occured while transaction processing");
        }

        return "transaction succesfull";
    }

     private boolean addAmount(String account, String amount) throws BankException{
         boolean isAdd = false;
         try {
             BankData bankData = loadBankData.bankDataMap.get(account);
             double totalBalance = Double.parseDouble(bankData.getBalance())+ Double.parseDouble(amount);
             bankData.setBalance(String.valueOf(totalBalance));
             loadBankData.bankDataMap.put(account,bankData);
             return isAdd = true;
         }
         catch (BankException b){
             LOGGER.error(Constant.LOGGER_ERROR_STRING, "addAmount account ", account);
             return isAdd;
         }
     }

    private boolean deductAmount(String account, String amount) throws BankException{
        boolean isDeduct = false;
        try {
            BankData bankData = loadBankData.bankDataMap.get(account);
            double totalBalance = Double.parseDouble(bankData.getBalance()) - Double.parseDouble(amount);
            bankData.setBalance(String.valueOf(totalBalance));
            loadBankData.bankDataMap.put(account,bankData);
            return isDeduct = true;
        }
        catch (BankException b){
            LOGGER.error(Constant.LOGGER_ERROR_STRING, "deductAmount account ", account);
            return isDeduct;
        }
    }
}
