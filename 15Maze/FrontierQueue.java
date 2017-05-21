import java.util.*;

public class FrontierQueue implements Frontier {

    private Queue<Location> locations;

    public FrontierQueue(){

	
    }

    
    public void add (Location x){
	locations.add(x);

    }

    public Location next(){
	return locations.remove();
    }




}
