import java.util.*;
public class Quiz2Redux{

    


    
    public Quiz2Redux() {
    }
   
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words , s, "");
	Collections.sort(words);
	//System.out.println(makeString(words));
	return words;
    }

   
    private static void help( ArrayList<String> words, String s, String out){
	
	words.add(out);
        for (int i = 0; i < s.length(); i++){
	    String neu =  out + s.charAt(i);
            help(words,  s.substring(i + 1),neu);}
            
    }
    


    
    private static String makeString(ArrayList words){
	String fin = "";
	for(int i = 0; i < words.size(); i++){
	    fin += words.get(i) + "\n";
	}
	return fin;
    }

    public static void main (String[]args) {
	
	System.out.println(makeString(combinations("ABCDEFGHI")));
    }

}
