package autocomplete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;



public class AutocompleteProvider {

	
	public AutocompleteProvider() {	}

	// Returns list of candidates ordered by confidence
	public List<Candidate> getWords(String fragment)
	{
		
		// Sets characters to lower-case to normalize input
		fragment = fragment.toLowerCase();
		List<Candidate> matches = new ArrayList<Candidate>();
		
		// Iterates through the keys of the hash map to add values to the Candidate list
		for(String key: candidates.keySet()) 
		{
			// Compares the key to the word fragment lexicographically
			// As an example, if "this" is compared to "thi", the compareTo function will return a positive value
			// since "this" is 'greater than' "thi" 
			
			if(key.compareTo(fragment) > 0 && (key.length() > fragment.length())) 
			{
				//Ensures the word in the keyset begins with the same letters as the fragment
				if(fragment.equals(key.substring(0, fragment.length())))
				{
					matches.add(candidates.get(key));
				}
			}
		}
		
		// Now sort the list by order of confidence level and return it, uses implemented comparison class
		Collections.sort(matches, new sortByConfidence());
		return matches;
	}
	
	// Trains the algorithm with the provided passage
    public void train(String passage) 
    {
    	// Sets all characters to lower-case and splits them into individual words
    	passage = passage.toLowerCase();
    	// Regex to split based off of non-words
    	String words[] = passage.split("\\W+");
    	// Iterate through words in the given passage
    	for(String word : words) 
    	{
    		
    		// If the word is previously contained in the hash map, increment its confidence value
    		if(candidates.containsKey(word)) 
    		{
    			candidates.get(word).increment();
    		}
    		
    		// Else add it to the existing hash map as a new value
    		else 
    		{
    			candidates.put(word, new Candidate(word));
    		}
    	}
    }
    
    // Concurrent hash map with the word as the string and the candidate object as the value
    static private ConcurrentHashMap<String,Candidate> candidates =  
            new ConcurrentHashMap<String,Candidate>();
}


