import java.util.*;

public class Lab7part2{
	
	public static void linearSearch(int key,Integer[] aList){
		int found = -1;
		for (int i = 0 ; i < 10 ; i++){ 
			if (aList[i] == key){
				found = 1;
				System.out.println("Linear Search: 49 found at " + i);
			}
		}
		if (found == -1) {
			System.out.println("Linear Search: Not found");
		}
	}
	
	public static void selectionSort(Integer[] aList){
		System.out.print("Selection Sort: ");
		for (int i = 0; i < 10; i++)
        {
            int minIndex = i;
			
            for (int j = i+1; j < 10; j++){
                if (aList[j] < aList[minIndex])
                    minIndex = j;
			}
 
            int temp = aList[minIndex]; //Switching arrays
            aList[minIndex] = aList[i];
            aList[i] = temp;
			
			System.out.print(aList[i] + ", ");
        }
		System.out.print("\n");
	}
	
	public static void insertionSort(Integer[] aList){ //compares one element at a time and moves it to the left until it is in least to greatest order
		int temp;
		
        for (int i = 1; i < 10 ; i++) {
			
            for(int j = i ; j > 0 ; j--){
				
                if(aList[j] < aList[j-1]){
                    temp = aList[j];
                    aList[j] = aList[j-1];
                    aList[j-1] = temp;
                }
            }
        }
		System.out.print("Insertion sort: ");
		for (int i = 0 ; i < 10 ; i++){
		System.out.print(aList[i] + ", ");
		}
		System.out.print("\n");
	}
	
	public static void bubbleSort(Integer[] aList, int n){ //Moves elements 1 to the right until greatest is to right. Repeats tog et next highest 
        if (n == 1){
			System.out.print("Bubble sorted: ");
			for (int i = 0 ; i < 10 ; i++){
				System.out.print(aList[i] + ", ");
			}
			System.out.print("\n");
            return;
		}
      
        for (int i=0; i < n-1; i++)
            if (aList[i] > aList[i+1])
            { //Moves value over 1 if greater
                int temp = aList[i];
                aList[i] = aList[i+1];
                aList[i+1] = temp;
            }
      
        bubbleSort(aList, n-1); //Recurses without looking at the element furthest to the right
	}

	
	public static Integer[] quickSort(Integer[] aList){
		
	Integer[] left = null, right = null;
		int numLeft= 0;
		int numRight = 0; 
		int pivot;
		
	if (aList.length <= 1 ) //Stops the code from running
		{
			return aList;
		}
	  
		pivot = aList.length-1;  //Select last element as pivot to begin
		for (int i = 0; i < aList.length-1; i++ ){  //Split the array
			if (aList[i] <= pivot )
				numLeft = numLeft + 1; 
			else
				numRight = numRight + 1;
		}

		left  = new Integer[numLeft]; //turn left and right into arrays
		right = new Integer[numRight];

		int x = 0;
		int y = 0;
		for (int k = 0; k < aList.length-1 ; k++)
		if (aList[k] <= pivot){
			left[x++] = aList[k];
		}
		else{
			right[y++] = aList[k];
		}

		quickSort(left);    //Sort the 2 sides
		quickSort(right); 
          
		int k = 0;
		int j = 0;

		for (int i = 0; i < left.length; i++ ){
			aList[k++] = left[i];
		}
		
		aList[k++] = pivot;

		for (int i = 0; i < right.length; i++ ){
            aList[k++] = right[j];
		}
		
		return aList;
	}
	
	/////////////
	public static void merge(Integer[] aList, Integer[] temp, int Start, int rightEnd){ //Temp array could also be created each iteration
		int leftEnd = (Start + rightEnd) / 2;
		int rightStart = Start + 1;
		int size = rightEnd - Start + 1;
		
		int left = Start; //left index
		int right = rightStart;
		int index = Start; //index of where to copy into temp array
		
		while((left <= leftEnd) && (right <= rightEnd)){
			if (aList[left] <= aList[right]) {
				temp[index] = aList[left];
				index = index + 1;
				left = left + 1; //Move index left
			}
			else {
				temp[index] = aList[right];
				right = right + 1; //Move index right
			}
			index++;
		}
		System.arraycopy(aList,left,temp,index,leftEnd-left+1); //Only one of this or the next line will have an effect
		System.arraycopy(aList,right,temp,index,rightEnd-right+1); //copies elements from one array into another, given specific boundaries
		System.arraycopy(temp,Start,aList,Start,size);
	}
	
	public static void sort(Integer[] aList, Integer[] temp, int leftHand, int rightHand){
		if (leftHand >= rightHand){ //stop running function
			return;
		}
		int middle = (leftHand+rightHand)/2;
		sort(aList, temp, leftHand,middle); //Sort left half
		sort(aList, temp, middle+1,rightHand); //Sort right half
		merge(aList, temp, leftHand,rightHand); //Merges left and right
	}
	
	public static void mergeSort(Integer[] aList){ 

		sort(aList, new Integer[aList.length], 0, aList.length-1);
	}
	//////////////////
	
	
	public static void binarySearch(Integer[] aList){
		int key = 98;
		int result = Arrays.binarySearch(aList,key);
		if (result < 0){
			System.out.println("Binary search: 98 not found!");  
		}
		else  {
			System.out.println("Binary Search: 98 found at index: " + result); 
		}
	}
	
	public static void main(String[] args){
		LinkedList<Integer> lList = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0 ; i < 10 ; i++){
			int input = sc.nextInt();
			
			lList.add(input);
		}
		Integer[] aList = lList.toArray(new Integer[lList.size()]);
		
		
		linearSearch(49, aList);
		selectionSort(aList);
		insertionSort(aList);
		bubbleSort(aList, 10);
		Integer[] returned = quickSort(aList);
		System.out.print("Quicksort: ");
		for (int i = 0 ; i < 10 ; i++){
			System.out.print(returned[i]+ ", ");
		}
		System.out.println("\n");
		binarySearch(aList);
		mergeSort(aList);
		
	}
}

/*Construct a Linked List Data structure. The Linked List structure should contains the following:
a) Get 10 random elements from the user as command line arguments (Using Scanner functions) 
and construct a linked list using next pointer with the elements.
b) Using Linear Search, search the element 49 in the linked list 
(if the element is found in the linked list, then return the respective index otherwise return -1)
c) Perform the following sorting operations in the generated random linked list 
(Using  recursion, do the sorting operations)
a. Selection Sortb. Insertion Sortc. Bubble Sortd. Quick Sorte. Merge Sortd) 
After Sorting, using Binary Search, search the element 98 in the linked list if the element is
 found in the linked list, then  return the respective index otherwise return -1)
 */
 