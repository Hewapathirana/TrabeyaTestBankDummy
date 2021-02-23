package noetic.example.codetest.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by DS hewapathirana.
 * Date: 23/02/2021
 * Time: 2050h
 */
@Getter
@Setter
public class BankDto {
    private Long id;

    private String userId;
    private String accountNo;
    private String balance;
}
