import java.util.*;

public class FrontierQueue implements Frontier {

    private Queue<Location> locations;

    public FrontierQueue(){

	locations = new LinkedList<Location>();
    }

    
    public void add (Location x){
	locations.add(x);

    }

    public Location next(){
	return locations.remove();
    }




}
