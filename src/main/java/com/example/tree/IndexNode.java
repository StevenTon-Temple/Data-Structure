package com.example.tree;

import java.util.ArrayList;
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

	public IndexNode(String word, int linenumber){
		this.word = word;
		this.occurences = 1;
		this.list = new ArrayList<>();

	}
	
	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line
	
	public String toString(){
		String output="";
		output+= "The word is "+ this.word + " the number of occurrences is " + occurences + " the line(s) it appears on " + list;
		return output;
	}
	
	
	
}
