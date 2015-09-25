package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/04/20.
 */
@Embeddable
public class Bank implements Serializable{
    
    private String bankName;
    private String accType;
    private Long accNumber;
    private int branchCode;

    private Bank(){

    }

    public Bank(Builder builder) {
        bankName=builder.bankName;
        accType=builder.accType;
        accNumber=builder.accNumber;
        branchCode=builder.branchCode;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccType() {
        return accType;
    }

    public Long getAccNumber() {
        return accNumber;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public static class Builder{
        private String bankName;
        private String accType;
        private Long accNumber;
        private int branchCode;

        public Builder(String bankName) {
            this.bankName = bankName;
        }

        public Builder accType(String value){
            this.accType=value;
            return this;
        }

        public Builder accNumber(Long value){
            this.accNumber=value;
            return this;
        }

        public Builder branchCode(int value){
            this.branchCode=value;
            return this;
        }

        public Builder copy(Bank value){
            this.bankName=value.bankName;
            this.accType=value.accType;
            this.accNumber=value.accNumber;
            this.branchCode=value.branchCode;
            return this;
        }

        public Bank build(){
            return new Bank(this);
        }
    }

}
