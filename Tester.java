// James Lin, Columbia University
// jl3782@columbia.edu
// Sapient Global Coding Challenge

import java.util.Scanner;

// contains main method to run the program
public class Tester {
	
	public static void main(String args[]){
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Initial bundles: ");
		int bundleAmount = myScanner.nextInt();
		
		Tree myTree = new Tree(bundleAmount);
		myTree.listBundles();
		
		boolean loop = true;
		while(loop){

			String input = myScanner.nextLine();
			
			// gets rid of whitespace, only uses whitespace to delimit
			String[] strArr = input.split("\\s+");	
			
			// different than what is asked for in only looking for whitespace
			if(strArr[0].equals("Merge")){
				int[] intArray = new int[strArr.length-1];
				for(int i=1; i<strArr.length; i++){
					String temp = strArr[i].substring(1);
					intArray[i-1] = Integer.parseInt(temp);
				}
				myTree.mergeBundle(intArray);
				myTree.listBundles();
			}
			
			if(strArr[0].equals("Split")){
				
				String temp = strArr[1].substring(1);
				int bundleID = Integer.parseInt(temp);
				int n = Integer.parseInt(strArr[3]);
				
				myTree.splitBundle(bundleID, n);;
				myTree.listBundles();
			}
			
			if(strArr[0].equals("Parent")){
				
				String temp = strArr[1].substring(1);
				int bundleID = Integer.parseInt(temp);
				
				myTree.getParent(bundleID);
				
			}
			
			if(strArr[0].equals("Sellable")){
				
				String temp = strArr[1].substring(1);
				int bundleID = Integer.parseInt(temp);
				
				if(myTree.isActive(bundleID))
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			
			if(strArr[0].equals("Derived")){
				
				String temp = strArr[1].substring(1);
				int youngID = Integer.parseInt(temp);
				String temp2 = strArr[2].substring(1);
				int oldID = Integer.parseInt(temp2);
				
				if(myTree.isDerived(youngID, oldID))
					System.out.println("Yes");
				else
					System.out.println("No");
				
			}
			
			if(strArr[0].equals("Quit")){
				loop = false;
			}
		}
		myScanner.close();
	}
}
