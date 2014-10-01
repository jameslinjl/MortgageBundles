// James Lin, Columbia University
// jl3782@columbia.edu
// Sapient Global Coding Challenge

import java.util.ArrayList;

// Node to perform Node operations, each Node holds a Bundle
public class TreeNode implements Comparable<TreeNode>{
	
	private Bundle element;
	private ArrayList<TreeNode> parents;
	private ArrayList<TreeNode> children;
	private boolean deleteFlag;
	
	public TreeNode(int i){
		element = new Bundle(i);
		deleteFlag = false;
		parents = new ArrayList<TreeNode>(2);
		children = new ArrayList<TreeNode>(2);
	}
	
	public void setParent(TreeNode t){
		parents.add(t);
	}

	public void setChild(TreeNode t){
		children.add(t);
	}
	
	public Bundle getBundle(){
		return element;
	}
	
	public void printBundle(){
		getBundle().printBundleID();
	}
	
	public void setDeleteFlag(){
		deleteFlag = true;
	}
	
	public boolean getDeleteFlag(){
		return deleteFlag;
	}
	
	// splitting Bundle easier to implement at Node level
	public void splitBundle(int id, int splitNumber, int totalCount){
		for(int i=0; i<splitNumber; i++){
			TreeNode t = new TreeNode(totalCount);
			totalCount++;
			t.setParent(this);
			children.add(t);
		}
	}
	
	// Method for grabbing active children
	public ArrayList<TreeNode> getActiveChildren(ArrayList<TreeNode> currentList){
		
		if(!getDeleteFlag())
			currentList.add(this);
		
		for(int i=0; i<children.size(); i++)
			children.get(i).getActiveChildren(currentList);
			
		return currentList;
	}
	
	// Method for grabbing all active and inactive children
	public ArrayList<TreeNode> getAllChildren(ArrayList<TreeNode> currentList){
		
		currentList.add(this);
		
		for(int i=0; i<children.size(); i++)
			children.get(i).getAllChildren(currentList);
			
		return currentList;
	}
	
	// Method for grabbing all ancestors
	public ArrayList<TreeNode> getAllAncestors(ArrayList<TreeNode> currentList){
		
		currentList.add(this);
		
		for(int i=0; i<parents.size(); i++)
			parents.get(i).getAllAncestors(currentList);
			
		return currentList;
	}

	// compareTo method for Comparable interface
	public int compareTo(TreeNode t) {
		
		if(this.getBundle().getBundleID() < ((TreeNode) t).getBundle().getBundleID())
			return -1;
		else if(this.getBundle().getBundleID() > ((TreeNode) t).getBundle().getBundleID())
			return 1;
		return 0;
	}
	
	// print method to sit on top of printBundle()
	public void printParents(){
		if(parents.size() == 0)
			System.out.print("None");
		else{
			for(int i=0; i<parents.size(); i++){
				parents.get(i).printBundle();
				if(i != parents.size()-1)
					System.out.print(", ");
			}
		}
		System.out.println();
	}

}
