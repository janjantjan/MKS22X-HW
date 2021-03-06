public class Location implements Comparable<Location>{

    private int row;
    private int col;
    private int distToGoal;
    private int distToStart ;
    private Location previous; //(used to trace the solution)
    private boolean aStar; //when this is true, compareTo will use: distToStart + distToGoal
    //when this is false, compareTo will use the distToGoalonly.

    public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){

	row = r;
	col = c;
	this.previous = previous;
	this.distToGoal = distToGoal;
	this.distToStart = distToStart;
	this.aStar = aStar;
    }

    public Location prev(){
	return previous;}

    public int getRow() {
	return row;
    }

    public int getCol(){
	return col;
    }

    public Location getPrev() {
	return previous;}

    
    
    public int compareTo(Location other){
	if (aStar){
	    int otro = other.distToGoal + other.distToStart;
	    int mio  = distToGoal + distToStart;
	    return otro - mio ;}
	else{
	    return other.distToGoal - distToGoal;
	}
    }
	
	

}
