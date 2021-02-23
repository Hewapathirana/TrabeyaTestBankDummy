package noetic.example.codetest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by DS hewapathirana.
 * Date: 23/02/2021
 * Time: 2050h
 */
@Getter
@Setter
@Entity
public class BankData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String accountNo;
    private String balance;


}
