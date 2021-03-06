
public class Main {

  public static void main(String[] args) {
    Person will = new Person("Will", "Smith", "11/29/2222", 30, 9999);
    Person micheal = new Person("Micheal", "Cera", "07/07/2003", 100, 99);

    will.setName("william", "yanovik");
    will.setWeight(99999999999.4);
    will.setHeight(488.8);

    System.out.println(will.getName());
    System.out.println(will.getDOB());
    System.out.println(will.getDOB_year());
    System.out.println(will.getDOB_month());
    System.out.println(will.getDOB_day());
    System.out.println(will.getHeight());
    System.out.println(will.getWeight());

    micheal.setName("jennifer", "vega");
    micheal.setWeight(21.0);
    micheal.setHeight(689.0);

    System.out.println(micheal.getName());
    System.out.println(micheal.getDOB());
    System.out.println(micheal.getDOB_year());
    System.out.println(micheal.getDOB_month());
    System.out.println(micheal.getDOB_day());
    System.out.println(micheal.getHeight());
    System.out.println(micheal.getWeight());

    Wheel coolWheel = new Wheel("Marshmello Co.", "Big Round Wheels", 50, "all year round");
    Wheel badWheel = new Wheel("Bad Wheel Co.", "Ripped Wheel", 2, "only summer");

    coolWheel.update_KM_usage(500);

    System.out.println(coolWheel.getTreadCondition());
    System.out.println(coolWheel.getBrand());
    System.out.println(coolWheel.getModel());
    System.out.println(coolWheel.getSize());
    System.out.println(coolWheel.getSeason());
    System.out.println(coolWheel.getKM());

    badWheel.update_KM_usage(99999);
    
    System.out.println(badWheel.getTreadCondition());
    System.out.println(badWheel.getBrand());
    System.out.println(badWheel.getModel());
    System.out.println(badWheel.getSize());
    System.out.println(badWheel.getSeason());
    System.out.println(badWheel.getKM());

    Course icsAP = new Course("ICS4U0", "AP Computer Science", "Grade 12");
    Course icsG11 = new Course("ICS3U3", "Introduction to Computer Science MaCs", "Grade 10");


    icsAP.addLates((byte) 1);
    icsAP.addAbsences((byte) 25);
    if (icsAP.setStatus("completed"))
	System.out.println("Set successfully");
	else
		System.out.println("Error occured while setting status");

    if (icsAP.setMark(15.1f))
      System.out.println("Set successfully");
    else
      System.out.println("Error occured when setting mark");

    System.out.println(icsAP.getMarkG());
    System.out.println(icsAP.getMark());
    System.out.println(icsAP.getStatus());
    System.out.println(icsAP.getLevel());
    System.out.println(icsAP.getCode());
    System.out.println(icsAP.getName());
    System.out.println(icsAP.getLates());
    System.out.println(icsAP.getAbsences());

    icsG11.addLates((byte) 31);
    icsG11.addAbsences((byte) 2);

    if (icsG11.setStatus("enrolled"))
	System.out.println("Set successfully");
	else
		System.out.println("Error occured while setting status");

    if (icsG11.setMark(-1.0f))
      System.out.println("Set successfully");
    else
      System.out.println("Error occured when setting mark");

    System.out.println(icsG11.getMarkG());
    System.out.println(icsG11.getMark());
    System.out.println(icsG11.getStatus());
    System.out.println(icsG11.getLevel());
    System.out.println(icsG11.getCode());
    System.out.println(icsG11.getName());
    System.out.println(icsG11.getLates());
    System.out.println(icsG11.getAbsences());

    Vehicle ramTruck = new Vehicle("off road truck", "Ram", "4 by 4", (short) 1999, "black", (byte) 4, 2000.0f);
    Vehicle bmwSedan = new Vehicle("sedan", "BMW", "Mx5", (short) 2000, "blue", (byte) 2, 100.5f);

    ramTruck.paint("aquamarine");
    ramTruck.gasUp(200);
    if (ramTruck.drive(1000))
      System.out.println("Drove successfully");
    else
      System.out.println("Did not drive to location successfully");

    System.out.println(ramTruck.getType());
    System.out.println(ramTruck.getManufact());
    System.out.println(ramTruck.getModel());
    System.out.println(ramTruck.getYear());
    System.out.println(ramTruck.getColour());
    System.out.println(ramTruck.getDoors());
    System.out.println(ramTruck.getTankSize());

    bmwSedan.paint("purple");
    bmwSedan.gasUp(1212);
    if (bmwSedan.drive(30000))
      System.out.println("Drove successfully");
    else
      System.out.println("Did not drive to location successfully");

    System.out.println(bmwSedan.getType());
    System.out.println(bmwSedan.getManufact());
    System.out.println(bmwSedan.getModel());
    System.out.println(bmwSedan.getYear());
    System.out.println(bmwSedan.getColour());
    System.out.println(bmwSedan.getDoors());
    System.out.println(bmwSedan.getTankSize());

    Account davidWallace = new Account(2000000, "mutal savings", 999999.0);
    Account frank = new Account(90909090, "chequing", 5000000);

    davidWallace.setInterestRate(0.13f);
    davidWallace.deposit(3333.8);
    davidWallace.calcInterest();

    if (davidWallace.withdraw(9090))
      System.out.println("Withdrew succesfully");
    else
      System.out.println("Withdrawing Error");

    System.out.println(davidWallace.getBalance());
    System.out.println(davidWallace.getAccount());
    System.out.println(davidWallace.getType());

    frank.setInterestRate(0.33f);
    frank.deposit(22222222);
    frank.calcInterest();

    if (frank.withdraw(1))
      System.out.println("Withdrew succesfully");
    else
      System.out.println("Withdrawing Error");

    System.out.println(frank.getBalance());
    System.out.println(frank.getAccount());
    System.out.println(frank.getType());
  }
}
