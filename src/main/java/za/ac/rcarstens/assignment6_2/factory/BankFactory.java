package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.Bank;

/**
 * Created by student on 2015/05/21.
 */
public class BankFactory {
    public static Bank createBank(
            String bankName,
            String accType,
            Long accNumber,
            int branchCode){

        Bank Bank = new Bank.Builder(bankName)
                .accType(accType)
                .accNumber(accNumber)
                .branchCode(branchCode)
                .build();
        return Bank;
    }
}
