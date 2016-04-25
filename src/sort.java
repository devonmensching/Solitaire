import java.io.*;
import java.util.*;

public class sort {

    private static ArrayList<String> lines = new ArrayList<String>(); // File Lines
    private static HashMap<String, String> cLine = new HashMap<String, String>(); // Command Line 
    
    
    /* checkCLine() - fills HashMap when add-ons are called in Command Line */
    private static boolean checkCLine(String[] input) {
    	
    	boolean check = true;
    	
    	// put empty options onto hash map
    	cLine.put("-b", "");
    	cLine.put("-f", "");
    	cLine.put("-r", "");
    	cLine.put("-u", "");
    	cLine.put("file", "");
    
    	// check for options in input and change on HashMap if present
    	int file = 0;
    	for(String i: input) {
    		if(i.contains("-b")) {
    			cLine.put("-b", "true");
    		}
    		if(i.contains("-f")) {
    			cLine.put("-f", "true");
    		}
    		if(i.contains("-r")) {
    			cLine.put("-r", "true");
    		}
    		if(i.contains("-u")) {
    			cLine.put("-u", "true");
    		}
    		if(i.endsWith(".txt")){
    			cLine.put("file", i);
    			file++;
    		}
    	}
    	
    	if(file > 1 || file == 0) {
    		check = false;
    	}
    	return check;
    	
    }
    
    /* replaceBlanks() - replaces leading blank spaces in lines of file */
    private static ArrayList<String> replaceBlanks(ArrayList<String> lines) {
    	
    	ArrayList<String> nLines = new ArrayList<String>();
    	
    	for(String line: lines) {
    		String nLine = line.replaceFirst("^\\s*", "");
    		nLines.add(nLine);
    	}
    	
    	return nLines;
    	
    }
    
    /* ignoreCase() - Ignores case for lines in file */
    private static ArrayList<String> ignoreCase(ArrayList<String> lines) {
    	
    	ArrayList<String> nLines = new ArrayList<String>();
    	
    	for(String line: lines) {
    		String nLine = line.toLowerCase();
    		nLines.add(nLine);
    	}
    	
    	return nLines;
    }
    
    /* makeUnique() - deletes all duplicate lines from file */
    private static ArrayList<String> makeUnique(ArrayList<String> input) {
    	
    	ArrayList<String> nList = new ArrayList<String>();
    	
    	Set<String> sInput = new HashSet<String>();
    	sInput.addAll(input);
    	nList.addAll(sInput);
    	
    	return nList;
    }
    
    /* sortFile() - sorts the file  */
    private static ArrayList<String> sortFile(ArrayList<String> lines) {
    
    	// Check command line for -b
    	if(cLine.get("-b").equals("true")) {
    		lines = replaceBlanks(lines);
   		}
    		
    	// Check command line for -f
    	if(cLine.get("-f").equals("true")) {
    		lines = ignoreCase(lines);
    	}
    	
    	// Check command line for -u
    	if(cLine.get("-u").equals("true")) {
    		lines = makeUnique(lines);
    	}
 
    	// Sort File
    	Collections.sort(lines);
    	
    	// Check command line for -r
    	if(cLine.get("-r").equals("true")) {
    		Collections.sort(lines, Collections.reverseOrder());
    	}
    	
    	return lines;
    	
    }
    
    /* main() - takes a String array  */
    public static void main(String[] args) throws IOException {
        
    	// Read in command line
    	boolean check = checkCLine(args);
    	
    	// Correct command line
    	if(check == true) {
	    	
    		// Read in file
	    	File file = new File(cLine.get("file"));
	    	Scanner fscanner = new Scanner(file);
	    	while(fscanner.hasNext()) {
	    		lines.add(fscanner.nextLine());
	    	}
	    	fscanner.close();
	    	
    		// Print out sorted file if correct
	    	for(String line: sortFile(lines)) {
	    		System.out.println(line);
	    	}
    	}
    	else {
    		System.out.println("Error.");
    	}
    	
    }
    
}