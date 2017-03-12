import java.util.*;
public class Quiz2Redux{

    


    
    public Quiz2Redux() {
    }
   
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words , s, "");
	Collections.sort(words);
	System.out.println(makeString(words));
	return words;
    }

    //permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length())); }

    
    private static void help( ArrayList<String> words, String s, String input){
	if (s.length() < 0){return;}

	words.add(input);

	
	for (int i = 0; i < s.length(); i++){
	    help(words, s.substring(0,i)+s.substring(i+1, s.length()), input+s.charAt(i));}
	
    }

	

    private static String makeString(ArrayList words){
	String fin = "";
	for(int i = 0; i < words.size(); i++){
	    fin += words.get(i) + "\n";
	}
	return fin;
    }

    public static void main (String[]args){
	Quiz2Redux q = new Quiz2Redux();
	q.combinations("pen");
	
    }
}
