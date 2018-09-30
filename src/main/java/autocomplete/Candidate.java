package autocomplete;

import java.util.Comparator;

public class Candidate {

	// Default constructor, should not be called in the program
	public Candidate() 
	{
		word = "n/a";
		confidence = 0;
	}
	
	// Overloaded constructor, fills word field and sets confidence to 1 (one inclusion in the train)
	public Candidate(String input) 
	{
		word = input;
		confidence = 1;
	}
	
	// Increments the confidence value if the word is seen again in the passage
	public void increment() {
		confidence += 1;
	}
	
	// Getter for the word contained within candidate
	public String getWord() {return word;}
	
	// Getter for confidence value
	public int getConfidence() {return confidence;}
	
	// Outputs candidate in the form --- "word" (confidence) 
	public String toString() 
	{
		return "\"" + word + "\" " + "(" + Integer.toString(confidence) + ")";
	}

	// Member variables for word and confidence value
	private String word;
	private int confidence;
	
}

// Implements comparison function in order to sort Candidate list through Collections.sort()
class sortByConfidence implements Comparator<Candidate>{

	public int compare(Candidate a, Candidate b) 
	{
		return b.getConfidence() - a.getConfidence();
	}
	
	
}
