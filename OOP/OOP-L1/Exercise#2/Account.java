
public class Account {

  private long account;
  private String type;
  private double balance;
  private float interestRate;

  public Account(long acct, String typ, double bal) {
    account = acct;
    type = typ;
    balance = bal;
    interestRate = 0.0f;
  }

  public void calcInterest() {
    balance = (1 + interestRate) * balance;
  }

  public boolean withdraw(double amt) {
    if (amt <= balance) {
      balance -= amt;
      return true;
    }
    return false;
  }

  public void deposit(double amt) {
    balance += amt;
  }

  public double getBalance() {
    return balance;
  }

  public long getAccount() {
    return account;
  }

  public String getType() {
    return type;
  }

  public void setInterestRate(float i) {
    interestRate = i;
  }
}
