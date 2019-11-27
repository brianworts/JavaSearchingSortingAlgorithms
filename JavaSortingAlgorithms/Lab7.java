	
public class Lab7{
	public static void tower(int n, char t1, char t2, char t3){
		if (n>0){
			tower(n-1, t1, t3, t2);
			System.out.println("Move disk from "+ t1+ " to "+t2);
			tower(n-1, t3, t2, t1);
			}
		}
	public static void main(String args[]){
		tower(5, 'A', 'C', 'B');
	}
}