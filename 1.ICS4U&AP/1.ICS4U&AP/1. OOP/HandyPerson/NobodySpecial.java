class NobodySpecial extends Human {
    public      NobodySpecial(String name) { super(name); }
    public void changeBulb() {System.out.print("NS: Unscrew old, screw in new");}
    public void unplugDrain() {System.out.println("NS: Use plunger"); }
    @Override public String toString() { return "NobodySpecial " + getName(); }
}
