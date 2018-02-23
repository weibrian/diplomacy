public class Unit {
    public Country owner;
    public boolean isFleet;    //true=fleet, false=army
    public Territory location;
    public boolean hasOrder;

    /**
     * Basic constructor for units
     * @param owner Country for who owns the unit
     * @param type boolean for type: true=fleet, false=army
     * @param init Territory for initial location
     */
    public Unit(Country owner, boolean type, Territory init) {
        this.owner = owner;
        this.isFleet = type;
        this.location = init;
        this.hasOrder=false;
    }


    public Unit(){
        owner=new Country();
        isFleet=false;
        location=new Territory();
        hasOrder=false;
    }

    /**
     * Moves unit from one territory to another
     * @param location2 Territory representing intended destination
     */
    public void move(Territory location2) {
        if(isFleet) if(location.touchF(location2)) location = location2;
        else if(location.touchA(location2)) location = location2;
    }

    /**
     * toString returns whether it is a fleet or an army, the location,
     * and the country that owns the unit
     */
    public String toString() {
        String str = "";
        if(isFleet) str += "F "; else str += "A ";
        str += location.toString() + " ";
        str += "(" + owner.name + ")";
        return str;
    }
}
