import java.util.*;

public class StackCalc{

    public static boolean isOp (String s){
	if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("%")){
	    return true;}
	else {return false;}
    }

    public static Double apply(Double a, Double b, String op){
	double x = a.doubleValue();
	double y = b.doubleValue();
	if (op.equals("*")){ 
	    double product = (x * y);
	    return a.valueOf(product);}
	else if (op.equals("/")){
	    double quo = y / x;
	    return a.valueOf(quo);}
	else if (op.equals("+")){
	    double sum = (x + y);
	    return a.valueOf(sum);}
	else if (op.equals("-")){
	    double dif = y - x;
	    return a.valueOf(dif);}
	else {
	    double mod = y % x;
	    return a.valueOf(mod);}
    }



    public static double eval (String  s){
	Stack<Double> t = new Stack <Double>();
	String[]str = s.split(" ");
	for (int i = 0; i < str.length; i++){
	    String temp = str[i] ;
	    if (isOp(temp)){
		Double a = t.pop();
		Double b = t.pop();
		Double y = apply(a,b,temp);
		//System.out.println(y.toString());
		t.push(y);
	    }
	    else{
		Double x = Double.parseDouble(temp);
		t.push(x);}
	}
	double ans = t.pop();
	return ans;
    }

    public static void main (String[]argg){
	System.out.println(StackCalc.eval("10 2 +"));//12.0
	System.out.println(StackCalc.eval("10 2 -"));//8.0
	System.out.println(StackCalc.eval("10 2.0 +"));//12.0
	System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
	System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
