//Class Bank_Account
public class Bank_Account {
  // Instance variable declaration
  private long acc_num;
  private String type;
  private double balance;
  private float interest_rate;

   /** Class constructor 
    * Aids in constrcuting a Car object and giving its attributes values (literals)
    * @param acct Is the account number of the bank account as a long
    * @param bal Is the balance of the bank account in a double number
    * @param ty Is the type of bank account as a String
    * @param interest Is the annual interest rate as a float number
    */
  public Bank_Account(long acct, double bal, String ty, float interest) {
    acc_num = acct;
    type = ty;
    balance = bal;
    interest_rate = interest;
  }

  /**
  * This method ncreases the balance by the annual interest rate
  */
  public void applyInterest() {
    balance = (1 + interest_rate) * balance;
  }

  /**
  * This method decreases the balance based on the amt
  * @param amt is the amount that is withdrew
  * @return boolean if the withdrawl was succesful
  */
  public boolean withdraw(double amt) {
    if (amt <= balance && amt >= 0) {
      balance -= amt;
      return true;
    }
    return false;
  }

  /**
  * This method increases the balance based on the amt
  * @param amt is the amount that is deposited
  */
  public void deposit(double amt) {
    balance += amt;
  }

  /**
  * This method returns the balance amount
  * @return balanace The balance of the bank account
  */
  public double getBalance() {
    return balance;
  }

  /**
  * This method returns the acc_num
  * @return acc_num The account number
  */
  public long getAccount() {
    return acc_num;
  }

  /**
  * This method returns the type
  * @return type The type of bank account
  */
  public String getType() {
    return type;
  }
}
