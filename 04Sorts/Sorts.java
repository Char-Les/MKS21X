import java.util.*;

public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "10.Weng.Charles"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	if(data.length == 0){
	    return;
	}
	for (int a = 0; a < data.length - 1; a ++){
	    int min = a;
	    for (int b = a; b < data.length; b ++){
		if (data[min] > data[b]){
		    min = b;
		}
	    }
	    int temp = data[min];
	    data[min] = data[a];	
	    data[a] = temp;
	}
    }
    /**Insertion sort of an int array.
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void insertionSort(int[] data){
	if(data.length == 0){
	    return;
	}
	for(int thingToPutInPlace = 1; thingToPutInPlace < data.length; thingToPutInPlace ++){
	    int temp = data[thingToPutInPlace];
	    int check = thingToPutInPlace;
	    for(; check > 0 && temp < data[check - 1]; check --){
		data[check] = data[check - 1];
	    }
	    data[check] = temp;
 	}
    }
    
    
    /**Insertion sort of an int array.
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void bubbleSort(int[] data){
	if(data.length == 0){
	    return;
	}
	boolean swap = true;
	for (int a = 0; a < data.length - 1 && swap; a ++){
	    swap = false;
	    for (int b = 0; b < data.length - a - 1; b++){
		if (data[b] > data[b + 1]){
		    int temp = data[b + 1];
		    data[b + 1] = data[b];
		    data[b] = temp;
		    swap = true;
		}
	    }
	}
    }



    public static void print(int[] a){
	for(int b = 0; b < a.length; b ++){
	    System.out.print(a[b] + " ");
	}
	System.out.println();
    }

    public static void checkCase(int x, int[] ary){
	if (x == 0){
	    System.out.print("select: ");
	    print(ary);
	    selectionSort(ary);
	    print(ary);
	}else if(x == 1){
	    System.out.print("insert: ");
	    print(ary);
	    insertionSort(ary);
	    print(ary);
	}else if(x == 2){
	    System.out.print("bubble: ");
	    print(ary);
	    bubbleSort(ary);
	    print(ary);
	}
    }

    public static void main(String[] args){
	int[] zero = {1,8,0,1,4,3,9,8,5,0,9,4,8,1,9,8,4};
	int[] one = {};
	int[][] cases = {zero, one};
	for(int type = 0; type < 3; type ++){
	    for(int casee = 0; casee < 2; casee ++){
		checkCase(type, cases[casee]);
	    }
	    System.out.println();
	}
 

	System.out.println("Custom");
	long start, end;
	if (args.length < 3){
	    System.out.println("java Sorts arraySize [0sort/1sel/2ins/3bub] [0rand/1up/2down/3lim]");
	    System.exit(1);
	}

	Random rand = new Random();
	int[] data = new int[Integer.parseInt(args[0])];
	for(int count = 0; count < Integer.parseInt(args[0]); count ++){
	    if (args[2].compareTo("0") == 0){
		data[count] = rand.nextInt(Integer.parseInt(args[0]));
	    }
	    if (args[2].compareTo("1") == 0){
		data[count] = count;
	    }
	    if (args[2].compareTo("2") == 0){
		data[count] = Integer.parseInt(args[0]) - count;
	    }
	    if (args[2].compareTo("3") == 0){
		data[count] = rand.nextInt(10);
	    }
	}
	int[] temp = new int[Integer.parseInt(args[0])];
	for (int a = 0; a < data.length; a ++){
	    temp[a] = data[a]; 
	}
	
	start = System.currentTimeMillis();
	if(args[1].compareTo("0") == 0){
	    Arrays.sort(data);
	}
	if(args[1].compareTo("1") == 0){
	    selectionSort(data);
	}
	if(args[1].compareTo("2") == 0){
	    insertionSort(data);
	}
	if(args[1].compareTo("3") == 0){
	    bubbleSort(data);
	}

	end = System.currentTimeMillis();
	Arrays.sort(temp);
	if (temp == data){
	    System.out.println(end - start);
	}else{
	    System.out.println(end-start);
	}
    }
    
}
