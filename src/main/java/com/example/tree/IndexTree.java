package com.example.tree;


// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree{

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	
	// Make your constructor
	// It doesn't need to do anything
	public IndexTree(){

	}
	
	// complete the methods below
	
	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		this.root = add(root,word,lineNumber);

	}
	
	
	
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null){
			return new IndexNode(word,lineNumber);
		}
		int compare = word.compareTo(root.word);
		if(compare==0){
			return root;
		}
		else if (compare<0){
			root.left = add(root.left,word,lineNumber);
			return root;

		}
		else {
			root.right = add(root.right,word,lineNumber);
			return root;
		}
	}




	// returns true if the word is in the index
	public boolean contains(String word){



		return contains(this.root, word);
	}

	private boolean contains(String word){

		if(root == null){
			return false;
		}
		int comparison = word.compareTo(root.word);

		if(comparison == 0){
			return true;
		}

		else if(comparison < 0){
			return contains(root.left, word);
		}

		else{
			return contains(root.right, word);
		}
	}

	// call your recursive method
	// use book as guide
	public void delete(String word){

		this.root = this.delete(this.root, word);
		size--;
	}

	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different then the regular technique.
	private IndexNode delete(IndexNode root, String word){

		//If root is empty then return null
		if(root == null){
			return null;
		}
		int comparison = word.compareTo(root.word);

		//If word is less than the root, remove the left leaf
		if(comparison < 0){
			root.left = delete(root.left, word);
			return root;
		}
		//If word is greater than the root, remove right leaf
		else if(comparison > 0){
			root.right = delete(root.right, word);
			return root;
		}
		//Checks if node has any children
		else{

			//If node has no children then it deletes the node
			if(root.left == null && root.right == null){
				return null;
			}

			//If node has child on the LEFT then has its parent node adopt its child
			//Doing this changes the pointers and has java garbage collector delete the node
			else if(root.left != null && root.right == null){
				return root.left;
			}

			//If node has child on the RIGHT then has its parent node adopt its child
			//Doing this changes the pointers and has java garbage collector delete the node
			else if(root.left == null && root.right != null){
				return root.right;
			}

			else{
				IndexNode current = root.left;
				while(current.right != null){
					current = current.right;
				}
				root.word = current.word;
				root.left = delete(root.left, root.word);
				return root;
			}
		}
	}


	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){

	}

	public static void main(String[] args){

		IndexTree index = new IndexTree();

		//Example from video. Probably not needed
		index.add(15);
		index.add(50);
		index.add(20);
		index.add(10);
		index.add(13);
		index.add(12);
		index.add(7);
		index.add(6);

		System.out.println(index);
		//Example from video END






		// add all the words to the tree

		// print out the index

		// test removing a word from the index


	}
}


IndexNode:

		import java.util.List;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list;



	IndexNode left;
	IndexNode right;




	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1

	public IndexNode(String word, int lineNumber) {

	}




	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line

	public String toString(){

		return toString(this.root);
	}

	private String toString(Node<E> root){

		if(root == null){
			return "";
		}
		StringBuilder builder = new StringBuilder();
		builder.append(toString(root.left));
		builder.append(" ");
		builder.append(root.item);
		builder.append(" ");
		builder.append(toString(root.right));

		return builder.toString();
	}



}
