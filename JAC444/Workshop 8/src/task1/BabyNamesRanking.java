package task1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;


public class BabyNamesRanking {

	static List<String> boys = new ArrayList<String>();
	static List<String> girls = new ArrayList<String>();
	static Scanner input = new Scanner(System.in);
	
	public static void start() {
		System.out.print("Enter a file name for baby name ranking: ");
		String fname = input.next();
		File file = new File(fname);

		try {
			Scanner names = new Scanner(file);
			while (names.hasNext()) {
				names.next();
				boys.add(names.next());
				names.next();
				girls.add(names.next());
				names.next();
			}
			names.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		};
			display();
			
	}

	





	public static void display() {
		CommonName();
		System.out.println("\n[ O r i g i n a l   L i s t ]***************************************************************************************************************************-->");
		System.out.println("*");
		System.out.println("*  The number of the boys' names is: "+ boys.size());
		System.out.println("*  The boy's names are: ");
		System.out.println("*          " + boys);
		System.out.println("*");
		System.out.println("*\n*  The number of the girls' names is: "+ girls.size());
		System.out.println("*  The girl's names are: ");
		System.out.println("*          " + girls);
		System.out.println("*");
		System.out.println("**********************************************************************************************************************************************************-->");
		
		

		
		System.out.println("\n\n[ S o r t e d   L i s t ]*******************************************************************************************************************************-->");
		System.out.println("*");
		System.out.println("*  The boy's list sorted in alphabatical order: " );
		System.out.println("*          " + sortNames(boys));
		System.out.println("*");
		System.out.println("*  The girl's list sorted in alphabatical order: " );
		System.out.println("*          " + sortNames(girls));
		System.out.println("*");
		System.out.println("**********************************************************************************************************************************************************-->");
		
		
		
		System.out.println("\n\n[ R e m o v e   D u p l i c a t e s ]*******************************************************************************************************************************-->");
		System.out.println("*");
			List<String> modifiedList = removeDuplicates(boys, girls);
		System.out.println("*  List size after reomiving duplicates (List - (68 + 68)) = " + modifiedList.size() );
		System.out.println("*  The list after removing duplicates: ");
		System.out.print("*          ");
		System.out.print("[");
		for (String s: modifiedList)
			System.out.print(s + ", ");
		System.out.print("]\n");
		System.out.println("*");		
		System.out.println("*");
		System.out.println("**********************************************************************************************************************************************************-->");
		
	}

	
	
	/****public methods****/
	
	public static List<String> CommonName() {
		List<String> common = new ArrayList<String>(girls);
		common.retainAll(boys);
		System.out.println("\n\n[ C o m m o n   N a m e s ]*******************************************************************************************************************************-->");
		System.out.println("*");
		System.out.println("*  The number of the common names in two lists is: " + common.size() );
		System.out.println("*  The common names:");
		System.out.println("*          " + common);
		System.out.println("*");
		System.out.println("**********************************************************************************************************************************************************-->");
		return common;
	}

	
	public static List<String> removeDuplicates(List<String> boys, List<String> girls) {
		
		List<String> fullList= new ArrayList<String>(boys);
		List<String> common = new ArrayList<String>(boys);
		
		fullList.addAll(girls);
		common.retainAll(girls);
		fullList.removeAll(common);
		
		System.out.println("*  The size of the name list that was removed: " +common.size());
    	System.out.println("*  The removed names: " );
    	System.out.println("*          " + common);
		System.out.println("*");
		
		return fullList;
	}
	
	public static List<String> sortNames(List<String> names){
		Collections.sort(names);
		return names;
	}
	
	/****main method****/
	
	public static void main(String[] args) {	

		start();
	}
	
}
