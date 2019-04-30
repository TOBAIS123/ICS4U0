public class Main {

  public static void main(String[] args) {
    Car c1 = new Car("Mercedes", "S class", 30.0, 50.0); // Car object 1
    //c1 behaviours
    c1.drive(12.0);
    c1.gasUp();
    System.out.println(c1.getInfo());

    Car c2 = new Car("Honda", "Civic", 30.0, 40.0); // Car object 2
    //c2 behaviours
    c2.drive(99.2);
    c2.gasUp();
    System.out.println(c2.getInfo());


    Bank_Account billianBaille = new Bank_Account(2000, 909090.8, "mutal savings", 13.0f); //Bank Account Object 1
    //Bank Account behaviours
    billianBaille.deposit(3333.8);

    if (billianBaille.withdraw(9090))
      System.out.println("Withdrew succesfully");
    else
      System.out.println("Withdrawing Error");
    billianBaille.applyInterest();
    System.out.println(billianBaille.getBalance());
    System.out.println(billianBaille.getType());

    Bank_Account fabio = new Bank_Account(909090, 500000.0, "chequing", 0.01f); //Bank Account Object 2
    //Bank Account behaviours
    fabio.deposit(22222222);
    if (fabio.withdraw(1))
      System.out.println("Withdrew succesfully");
    else
      System.out.println("Withdrawing Error");
    fabio.applyInterest();
    System.out.println(fabio.getBalance());
    System.out.println(fabio.getType());
  }
}
