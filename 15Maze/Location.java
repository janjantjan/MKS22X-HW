public class Location implements Comparable<Location>{

    private int row;
    private int col;
    private int distToGoal;
    private int distToStart ;
    private Location previous; //(used to trace the solution)
    private boolean aStar; //when this is true, compareTo will use: distToStart + distToGoal
    //when this is false, compareTo will use the distToGoalonly.

    public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){

	r = row;
	c = col;
	this.previous = previous;
	this.distToGoal = distToGoal;
	this.distToStart = distToStrart;
	this.aStar = aStar;
    }

    public int getRow() {
	return row;
    }

    public int getCol(){
	return col;
    }


    
    public compareTo(Location other){

    }



}
