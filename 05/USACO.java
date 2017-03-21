import java.util.*;
import java.io.*;

public class USACO{

    private int[][] lake;
    private int elevation;
    private int[][] directions;

    private int[][] pasture;
    private int seconds;
    private int r1;
    private int c1;
    private int r2;
    private int c2;
    private int[][] pasture2;

    public USACO(){
	

    }
    //BRONZE PROBLEM ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private  void fillDataBronze (String filename){
	try {
	    Scanner s = new Scanner (new File(filename));
	    int row = s.nextInt();
	    int col = s.nextInt();
	    elevation = s.nextInt();
	    int num = s.nextInt();
	    
	    lake = new int [row][col];
	    for (int i = 0; i < row; i++){
		for (int j = 0; j <col; j++){
		    lake[i][j]=s.nextInt();}
	    }
	    directions = new int[num][3];
	    for (int i =0; i< num; i++){
		for (int j = 0; j < 3; j++){
		    directions[i][j]= s.nextInt();
		}}  
	}catch(FileNotFoundException e){
    	    System.out.println("File not found");
    	    System.exit(1);
	}
    }

    private String makeString(int[][] x){
	String fin = "";
	for (int i = 0; i < x.length ; i++) {
	    for (int j=0; j < x[0].length; j++) {	
		fin += x[i][j] + " " ;
	    }
	    fin += "\n";}
	return fin;
    }

      private String makeString(char[][] x){
	String fin = "";
	for (int i = 0; i < x.length ; i++) {
	    for (int j=0; j < x[0].length; j++) {	
		fin += x[i][j] + " " ;
	    }
	    fin += "\n";}
	return fin;
    }

    private int isHigher (int r, int c, int highest){
	if (r < 0 || c < 0) { return highest;}
	if (lake[r][c] > highest) {return lake[r][c];}
	else { return highest;}
    }

    private void replace (int r, int c, int high){
	if (r < 0 || c < 0){return;}
	if (lake[r][c] > high){
	    lake[r][c] = high;}
	
    }

    private void getStompy (int row, int col, int stomp){
	
	int highest = 0;
	highest = isHigher(row-1, col-1, lake[row-1][col]);
	highest = isHigher(row-1, col+1, highest);
	highest = isHigher(row, col-1, highest);
	highest = isHigher(row, col, highest);
	highest = isHigher(row, col+1, highest);
	highest = isHigher(row+1, col-1, highest);
	highest = isHigher(row+1, col, highest);
	highest = isHigher(row+1, col+1, highest);
	
	int high = highest - stomp;
	replace(row-1, col-1, high);
	replace(row-1, col, high);
	replace(row-1, col+1, high);
	replace(row, col, high);
	replace(row, col+1, high);
	replace(row, col-1, high);
	replace(row+1, col-1, high);
	replace(row+1, col, high);
	replace(row+1, col+1, high);
    
    }

    private void drownCows(){
	for (int i = 0; i < lake.length; i++){
	    for (int j = 0; j < lake[0].length; j++){
		lake[i][j] -= elevation;}
	}

	for (int i = 0; i < lake.length; i++){
	    for (int j = 0; j < lake[0].length; j++){
		if (lake[i][j]<0){
		    lake[i][j] = lake[i][j] * -1;}
		else { lake[i][j] = 0;}
	    }
	}
	
    }

    private int findVol(){
	int clumpyDepth = 0;
	for (int i = 0; i < lake.length; i++){
	    for (int j = 0; j < lake[0].length; j++){
		clumpyDepth += lake[i][j];}}

	return clumpyDepth * 72 * 72;	
    }
		

    public int  bronze (String filename){
   	fillDataBronze(filename);
	for (int i = 0; i < directions.length; i++){
	    getStompy(directions[i][0], directions[i][1], directions[i][2]);
	}
	drownCows();
	return findVol();
    }

    private String readAnswer (String filename){
	try {
	    Scanner t = new Scanner (new File(filename));
	    return t.nextLine();
	}catch(FileNotFoundException e){
    	    
    	    System.exit(1);
	    return ("File not found");
	}
    }

	
	
    //SILVER PROBLEM :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void fillDataSilver (String filename){
	try {
	    Scanner x = new Scanner(new File(filename));
	    int row = x.nextInt();
	    int col = x.nextInt();
	    seconds = x.nextInt();
	    //System.out.println(row+ " " + col + " " + seconds);
	    
	    char[][] prepasture = new char[row][col];
	   
	    
	    for (int i = 0; i < row; i++){
		String line = x.next();
		for (int j = 0; j < col; j++){
		    prepasture[i][j]= line.charAt(j);}
	    }
	     r1 = x.nextInt();
	     c1 = x.nextInt();
	     r2 = x.nextInt();
	     c2 = x.nextInt();

	     //System.out.println(makeString(prepasture));
	     //System.out.println( r1 + " " + c1 + " " + r2 + " " + c2);
	    
	    pasture = new int[row][col];
	    pasture2 = new int[row][col];
	     for (int i = 0; i < pasture.length; i++){
		 for (int j = 0; j < pasture[0].length; j++){
		    if (prepasture[i][j]=='.'){
			pasture[i][j] = 0;
			pasture2[i][j] = 0;
		    }
		    if (prepasture[i][j] == '*'){
			pasture[i][j]= -1;
			pasture2[i][j]=-1;}
		}
	     }

	     // System.out.println(makeString(pasture));
	
			       
		
	}catch(FileNotFoundException e){
    	    System.out.println("File not found");
    	    System.exit(1);
	}
	    
	    
    }

    private void countWays (int row, int col, int[][]p1, int[][] p2) {
	if ((row < p1.length && row >= 0)&&(col < p1[0].length && col >= 0)&& (p2[row][col]!=-1)){
		if (row > 0){
		    if (p1[row-1][col]!=-1){p2[row][col] += p1[row-1][col];}}
		if (col > 0){
		    if (p1[row][col-1]!=-1){p2[row][col] += p1[row][col-1];}}
		if (row < p1.length -1){
		    if (p1[row+1][col]!=-1){p2[row][col] += p1[row+1][col];}}
		if (col < p1[0].length -1){
		    if (p1[row][col+1]!=-1){p2[row][col] += p1[row][col+1];}}
	    }
	return;    
    }

    public int silver (String filename){
	fillDataSilver(filename);
	
	pasture[r1-1][c1-1]=1;
	for (int h = 0; h < seconds; h++){
	    
	    for (int i = 0; i < pasture.length; i++){
		for (int j = 0; j < pasture[0].length; j++){
		    if (pasture2[i][j]!=-1){countWays(i,j, pasture, pasture2);}
		}
	    }
	    //System.out.println(makeString(pasture));
	    for (int i = 0; i < pasture.length; i++){
		for (int j = 0; j < pasture[0].length; j++){
		    pasture[i][j] = pasture2[i][j];
		}
	    }
	    //System.out.println(makeString(pasture));
	    for (int i = 0; i < pasture2.length; i++){
		for (int j = 0; j < pasture2[0].length; j++){
		    if (pasture2[i][j]!=-1){
			pasture2[i][j]= 0;}
		}
	    }
	    //System.out.println(makeString(pasture));
	    
	}
	//System.out.println(makeString(pasture));
	return pasture[r2-1][c2-1];
    }
	

    //MAIN :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public static void main (String[]args){
	
	USACO u = new USACO();

	for (int i = 1; i <= 10; i++){
	    System.out.println("--------------------------makelake." + i + ".in");   
	    System.out.println(u.bronze("makelake." + i + ".in"));
	    System.out.println("ANSWER: " + u.readAnswer("makelake." + i + ".out"));
	}

	for (int i = 1; i <= 10; i++){
	    System.out.println("--------------------------- ctravel." + i + ".in");   
	    System.out.println(u.silver("ctravel." + i + ".in"));
	    System.out.println("ANSWER: " + u.readAnswer("ctravel." + i + ".out"));
	}

	    
	
    }

}  
	    




	    
	    

