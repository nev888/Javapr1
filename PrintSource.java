import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.util.Scanner;

public class PrintSource {

public static void main(String[] args)
{
File filei = new File("PrintSource.java");
File fileo = new File("PrintSource.txt");
try(  FileReader reader=new FileReader(filei);
BufferedReader br=new BufferedReader(reader);
PrintWriter pw = new PrintWriter(fileo);
) {
String line=br.readLine();
while(!line.equals(null))  {
	System.out.println(line);

	pw.println(line);
    line=br.readLine();
}//end while block
}//end try block
catch(java.io.FileNotFoundException e) {
	System.out.println("File not Found"+e);
}//end catch block
catch(java.io.IOException e) {
	System.out.println("File not Found"+e);
}//end catch block

}//end main method
}//end class