import java.io.*;
import java.util.LinkedList;
import java.util.*;


public class Main {

	public static void terminate(String message){
		System.out.println(message);
		System.exit(0);
	}

	public static int difference(String word1, String word2, int desiredDiff){

		int shorter = Math.min(word1.length(), word2.length());
		int longer = Math.max(word1.length(), word2.length());
		int diffCount = longer - shorter;
		int charDifference = 0;

		for(int i = 0; i < shorter; i++){
			if(word1.charAt(i) != word2.charAt(i)){
				diffCount++;
				if(diffCount > desiredDiff){
					return -1;
				}
				int difference = (int) word2.charAt(i) - (int) word1.charAt(i);
				charDifference += (difference > 0 ? difference : (difference*-1));
			}
		}

		return charDifference;
	}

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();
		String inputFileName = new String();
		String word1 = new String();
		String word2 = new String();
		try{
			inputFileName = args[0]; // dictionary
			word1 = args[1].toLowerCase(); // first word
			word2 = args[2].toLowerCase(); // second word

			if(word1.equals(word2)){
				terminate("Both words are same!");
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			terminate("usage: [file] start_word end_word ...\n");
		}

		LinkedList<String> dictionary = new LinkedList<String>();
		try{
			FileReader reader = new FileReader(inputFileName);
			Scanner in = new Scanner(reader);

			while(in.hasNextLine()){
				dictionary.add(in.nextLine().toLowerCase());
			}
			reader.close();

			if((dictionary.indexOf(word1) == -1) || (dictionary.indexOf(word2) == -1)){
				terminate("Mentioned word(s) do not exist in dictionary!");
			}
		}
		catch(FileNotFoundException e){
			terminate("The specified file could not be found.");
		}

		Graph G = new Graph(dictionary.size());
		int idx = 0;
		for(String i : dictionary){
			int jdx = 0;
			for(String j : dictionary){
				if(i.equals(j)){
					break;
				}
				int dist = difference(i,j,1);
				if(dist > 0){
					G.getVertex(idx).addToAdjList(jdx, dist);
					G.getVertex(jdx).addToAdjList(idx, dist);
				}
				jdx++;
			}
			idx++;
		}

		LinkedList<Vertex> path = G.getPath(dictionary.indexOf(word1),dictionary.indexOf(word2));
		int transformations = path.size() - 1;
		int weight = 0;
		for(Vertex v : path){
			System.out.print(dictionary.get(v.getIndex()) + ((path.indexOf(v) < transformations) ? " -> " : ((weight = v.getDist()) > 0) ? "\n" : "?"));
		}

		System.out.println((!path.isEmpty() ? "\nTransformations: " + transformations + "\nWeight: " + weight : "Could not find a path from " + word1 + " to " + word2));

		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time: " + (end - start) + " milliseconds");

	}

}
