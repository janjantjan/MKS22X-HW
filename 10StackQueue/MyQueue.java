public class MyQueue {

    private LinkedList x;

    public MyQueue(){
	LinkedList x = new LinkedList();
    }
	
    public void enqueue(int item){
	x.add(0, item);}
    
    public int dequeue(){
	
	x.remove(d-1);
	remove a;
    }

    public int peek(){
	return get(size()-1);

    }
	
    public int size(){
	return x.size();}

    public boolean isEmpty(){ 
	if (x.size() == 0){ return true;}
	else {return false;}
    }

    public static void main (String[]argsssssss){
	MyQueue x = new MyQueue;
	x.enqueue(1);
	x.enqueue(2);
	x.enqueue(3);
	x.enqueue(4);
	x.enqueue(5);
	x.enqueue(7);
	System.out.println(	    x.(MyLinkedList.toString()));
    }


}






