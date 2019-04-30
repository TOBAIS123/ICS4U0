public class Main {

    public static void main(String [] args){
        Airplane airOne = new Airplane();

        System.out.println(airOne.getGasLevel());
        airOne.fillUp();
        System.out.println(airOne.getDoorStatus());
        airOne.openDoor();
        System.out.println(airOne.getPassengers());
        airOne.loadPass(99);
        airOne.closeDoor();
        System.out.println(airOne.getLandingGear());
        airOne.prepLanding();
        airOne.takeOff();
        airOne.normalFlight(50);
        airOne.doneTakeOff();
        airOne.land();
        airOne.unloadPass();
    }
}
