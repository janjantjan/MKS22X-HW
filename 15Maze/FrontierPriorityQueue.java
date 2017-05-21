import java.util.*;

public class FrontierPriorityQueue implements Frontier{

    private PriorityQueue<Location> locations;


    public FrontierPriorityQueue() {

	locations = new PriorityQueue();
    }
	
    
    public void add (Location x){

	locations.add(x);


    }


    public Location next(){

	return locations.remove();

    }


}
