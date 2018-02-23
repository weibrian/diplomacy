import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Territory{
	public String name;
	public Territory[] neighborsF;
	public Territory[] neighborsA;
	public int occupied; //-1: unoccupied, otherwise country id
	public boolean supplyCenter; //true=yes
    public int[] takeStrength;

    /**
     * Basic constructor for territory
     * @param name string for the name
     * @param nF Territory[] for neighbors w.r.t. fleets
     * @param nA Territory[] for neighbors w.r.t. armies
     * @param occ int for if it is occupied, 0: unoccupied, 1: army, -1: fleet
     * @param sc boolean for if it is a supplycenter
     */
	public Territory(String name, Territory[] nF, Territory[] nA, int occ, boolean sc) {
        this.name = name;
        this.neighborsF = nF;
        this.neighborsA = nA;
        this.occupied = occ;
        this.supplyCenter = sc;

        this.takeStrength = new int[Diplomacy.numCountries];
    }

    /**
     * Default Territory constructor
     */
    public Territory(){
	    name="";
	    neighborsF=null;
	    neighborsA=null;
	    occupied=-1;
	    supplyCenter=false;
	    takeStrength=null;
    }

    /**
     * Comparison function of Territories
     * @param T territory to which this is compared
     * @return boolean on if they are equal
     */
    public boolean equals(Territory T) {
	    return (this.name).equals(T.name);
    }

    /**
     * Comparison function of Territory and string
     * @param s string representing territory to be compared
     * @return boolean on if they are equal
     */
    public boolean equals(String s){
        return this.name.equals(s);
    }

    /**
     * Check if territory touches w.r.t fleets
     * @param T 2nd territory to be compared
     * @return boolean which is true iff T touches w.r.t fleets
     */
    public boolean touchF(Territory T) {
	    int len = this.neighborsF.length-1;
	    while(len >= 0)
            if(this.neighborsF[len].equals(T))
                return true;
	    return false;
    }

    /**
     * Check if territory touches w.r.t armies
     * @param T 2nd territory to be compared
     * @return boolean which is true iff T touches w.r.t armies
     */
    public boolean touchA(Territory T) {
        int len = this.neighborsF.length-1;
        while(len >= 0)
            if(this.neighborsA[len].equals(T))
                return true;
        return false;
    }

    /**
     * toString returns the name of the territory
     */
    public String toString() {
        return name;
    }

    /**
     * Computes all Neighbors of a territory
     * @return Territory[] containing all neighbors of the Territory
     */
    public Territory[] allNeighbors(){
        List<Territory> union = Arrays.asList(this.neighborsA);
        for(Territory t: neighborsF)
            if(!union.contains(t))
                union.add(t);
        int size=union.size(), i=0;
        Territory[] out= new Territory[size];
        while(!union.isEmpty()) {
            out[i] = union.remove(0);
            i++;
        }
        return out;
    }

}
