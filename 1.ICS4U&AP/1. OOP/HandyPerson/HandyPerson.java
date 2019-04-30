class HandyPerson extends Human implements Electrician, Plumber {
    public        HandyPerson(String name) { super(name); }
    public String changeBulb() { return "HP: Unscrew old, screw in new";}
    public String unplugDrain(){ return "HP: Use plunger"; }
    @Override public String toString() { return "HandyPerson " + getName(); }
}
