package dw317.lib;

public class EmailTest extends Object{
	public static void main(String[] args)
	{
		String segment = ".mmmmmmmmmmmmmmm";

		
		if(segment.length() > 32 || segment.length() < 1){
			System.out.println("length is more than 32 or less than 1");
		}
		if(!segment.matches("^[A-Za-z0-9_.-]+$") || segment.matches("^[.].+") || segment.matches(".+[.]$") || segment.matches("^[.]$") || segment.matches(".*[.][.].*")){
			System.out.println("starts with dot and other letters");
		}
	
		System.out.println("finished");
	}
}
