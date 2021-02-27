package noetic.example.codetest.controller;

import noetic.example.codetest.dto.TransactionDto;
import noetic.example.codetest.serviceImpl.MapValidationErrorService;
import noetic.example.codetest.serviceInterfaces.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by DS hewapathirana.
 * Date: 23/02/2021
 * Time: 2055h
 */

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @GetMapping("/accountBalance/{accountNumber}")
    public ResponseEntity<?> getAccountBalance(@PathVariable String accountNumber) throws ClassNotFoundException {
        return ResponseEntity.ok(bankService.findBalanceByAccountId(accountNumber));
    }

    @GetMapping("/allAccountBalance")
    public ResponseEntity<?> getAllAccountBalance()  {
        return ResponseEntity.ok(bankService.findAllAccountBalance());
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody TransactionDto transactionDto,
                                         BindingResult result) throws ClassNotFoundException {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;
        //String senderAccount, String receiverAccount, boolean isOwnFundTransfer, String amount
        return   ResponseEntity.ok(bankService.fundTransfer(transactionDto.getSenderAccount(),
                transactionDto.getReceiverAccount(), transactionDto.getIsOwnAccount(), transactionDto.getAmount()));

    }
}
