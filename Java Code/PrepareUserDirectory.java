import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PrepareUserDirectory {

	public static void main(String args[]) throws IOException {
		Arrays.stream(new File("E:\\\\IIT CHICAGO STUDIES\\\\IIT Chicago semester 2\\\\Data Mining\\\\Assignments\\\\Assignment4\\\\hw4.movies").listFiles()).forEach(File::delete);
		getMovieIDOfUsers("ratings.csv","movies.csv");
		/*BufferedReader b = new BufferedReader(new FileReader("movies.csv"));
		for(int i=0;i<10;i++) {
			System.out.println(b.readLine());
		}*/


	}
	private static final String newLine = System.getProperty("line.separator");
	private static void getMovieIDOfUsers(String string, String string2) throws IOException {
		 BufferedReader br = null;
		// System.out.println("Hello");
		 br = new BufferedReader(new FileReader(string));
		 String Line,Line2,HeaderRating;
		 String[] ratingHeaders;
		 String[] linevalues;
		 HeaderRating = br.readLine();
		 ratingHeaders = HeaderRating.split(",");
		 HashMap<String,ArrayList<String>> cc = new HashMap<String,ArrayList<String>>();
		 while ((Line = br.readLine()) != null) {
			 linevalues = Line.split(",");
			 ArrayList<String> val = new ArrayList<>(Arrays.asList(linevalues));
			 BufferedReader br1 = new BufferedReader(new FileReader(string2));
			 br1.readLine();
			 while((Line2 = br1.readLine()) != null) {
				 //System.out.println(val.get(1));
				 String[] linevalues2 = Line2.split(",");
				 ArrayList<String> val2 = new ArrayList<>(Arrays.asList(linevalues2));
				 if(val.get(1).equals(val2.get(0))) {
					// System.out.println(val2.get(0));
					 //System.out.println(val.get(1));
					 String ss1 = "E:\\IIT CHICAGO STUDIES\\IIT Chicago semester 2\\Data Mining\\Assignments\\Assignment4\\hw4.movies\\user"+val.get(0)+".txt";

					 BufferedWriter bw = new BufferedWriter(new FileWriter(ss1,true));
					 //val2.size();
					 StringBuilder stringBuilder = new StringBuilder();
					 for(int k=1;k<val2.size()-1;k++) {
						 stringBuilder.append(val2.get(k));
						 //bw.write(val2.get(k));
						 if(k<val2.size()-2) {
							 stringBuilder.append(",");
						 }
					}
					 if(val2.size()==3) {
						 bw.write(val2.get(1));
					 }else {
						 bw.write(stringBuilder.toString().replaceAll("\"", ""));
					 }
					 bw.write(newLine);
					 bw.close();
					 break;
				 }
			 }
			 
		 }
		 
	}
}
