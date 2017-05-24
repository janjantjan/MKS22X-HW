import java.util.*;

public class FrontierPriorityQueue implements Frontier{

    private PriorityQueue<Location> locations;


    public FrontierPriorityQueue() {

	locations = new PriorityQueue<Location>();
    }
	
    
    public void add (Location x){

	locations.add(x);


    }

    public int size(){

	return locations.size();

    }
    
    public Location next(){

	return locations.remove();

    }


}
