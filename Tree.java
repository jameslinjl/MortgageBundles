// James Lin, Columbia University
// jl3782@columbia.edu
// Sapient Global Coding Challenge

import java.util.*;

public class Tree {
	
	private ArrayList<TreeNode> roots;
	private int totalCount;
	
	public Tree(int n){
		roots = new ArrayList<TreeNode>(n);
		totalCount = n;
		
		// fill in inputted number of roots
		for(int i=0; i<n; i++){
			roots.add(new TreeNode(i+1));
		}
		
	}
	
	// lists out all active Bundles
	public void listBundles(){
		
		ArrayList<TreeNode> list = getActiveBundles();
		
		// sort the list to get proper order
		Collections.sort(list);
		
		// print each bundle accounting for last ','
		for(int i=0; i<list.size(); i++){
			list.get(i).printBundle();
			if(i != list.size()-1)
				System.out.print(", ");
		}
		System.out.println();
		
	}
	
	// private method called by various Tree methods, calls Node level methods
	private ArrayList<TreeNode> getActiveBundles(){
		
		ArrayList<TreeNode> al = new ArrayList<TreeNode>(10);
		
		for(int j=0; j<roots.size(); j++){
			roots.get(j).getActiveChildren(al);
		}
		
		// get rid of all duplicates while maintaining order
		Set<TreeNode> s = new LinkedHashSet<TreeNode>(al);
		ArrayList<TreeNode> fresh = new ArrayList<TreeNode>(al.size());
		fresh.addAll(s);
		return fresh;
		
	}

	// private method called by various Tree methods, calls Node level methods
	private ArrayList<TreeNode> getAllBundles(){
		
		ArrayList<TreeNode> al = new ArrayList<TreeNode>(10);
		
		for(int j=0; j<roots.size(); j++){
			roots.get(j).getAllChildren(al);
		}
	
		// get rid of all duplicates while maintaining order
		Set<TreeNode> s = new LinkedHashSet<TreeNode>(al);
		ArrayList<TreeNode> fresh = new ArrayList<TreeNode>(al.size());
		fresh.addAll(s);

		return fresh;		
	}
	
	// private method called by various Tree methods, calls Node level methods
	private ArrayList<TreeNode> getAncestorBundles(int id){
		
		ArrayList<TreeNode> list = getAllBundles();
		TreeNode t = findByID(list,id);
		ArrayList<TreeNode> al = new ArrayList<TreeNode>(10);
		
		t.getAllAncestors(al);
		
		// get rid of all duplicates while maintaining order
		Set<TreeNode> s = new LinkedHashSet<TreeNode>(al);
		ArrayList<TreeNode> fresh = new ArrayList<TreeNode>(al.size());
		fresh.addAll(s);

		return fresh;		
		
	}
	
	// checks to see if the bundle with the given id is in the given list
	private TreeNode findByID(ArrayList<TreeNode> list, int id){
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getBundle().getBundleID() == id)
				return list.get(i);
		}
		return null;
	}
	
	// Tree level method for splitting Bundle, needs to call node level method
	public void splitBundle(int id, int splitNumber){
		
		ArrayList<TreeNode> list = getActiveBundles();
		TreeNode t = findByID(list,id);
		
		if(t != null){
			t.splitBundle(id, splitNumber, totalCount+1);
		}
		
		totalCount = totalCount + splitNumber;
		
	}
	
	// Tree level method for merging Bundle
	public void mergeBundle(int[] arrID){
		
		ArrayList<TreeNode> list = getActiveBundles();
		
		TreeNode freshNode = new TreeNode(totalCount+1);
		for(int i=0; i<arrID.length; i++){
			TreeNode t = findByID(list, arrID[i]);
			if(t == null)
				break;
			t.setDeleteFlag();
			t.setChild(freshNode);
			freshNode.setParent(t);
			
		}
		
		totalCount++;
	}
	
	// Tree level method for getting Parents
	public void getParent(int id){
		
		ArrayList<TreeNode> list = getAllBundles();
		
		findByID(list,id).printParents();
	}
	
	// Tree level method for finding ancestry
	public boolean isDerived(int youngID, int oldID){
		
		ArrayList<TreeNode> list = getAncestorBundles(youngID);
		TreeNode t = findByID(list,oldID);
		
		if(t != null)
			return true;
		return false;
		
	}
	
	// Tree level method for seeing if Bundle is active
	public boolean isActive(int id){
		
		ArrayList<TreeNode> list = getActiveBundles();
		TreeNode t = findByID(list,id);
		
		if(t != null)
			return true;
		return false;
	}

}
