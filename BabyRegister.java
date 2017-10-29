import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.Year;
import java.text.DateFormat;

public class BabyRegister {

    ArrayList<Baby> babies = new ArrayList();
    ArrayList<Gift> gifts = new ArrayList();
    Scanner in = new Scanner(System.in);
    DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH/mm");
    public BabyRegister() {
        Baby b1 = new Baby("2015-10-29 10:10:30", "Anya", 'f');
        Baby b2 = new Baby("2014-02-14 04:23:45", "Yani", 'f');
        Baby b3 = new Baby("2016-07-29 07:12:23", "Shad", 'm');

        Gift g1 = new Gift("Kar", "Food supply", new Date(2017, 02, 21));
        Gift g2 = new Gift("Qas", "clothes", new Date(2017, 11, 21));
        Gift g3 = new Gift("Mass", "Toys", new Date(2017, 07, 21));

        babies.add(b1);
        babies.add(b2);
        babies.add(b3);

        gifts.add(g1);
        gifts.add(g2);
        gifts.add(g3);

        while (true) {

            System.out.println("which operation do you want  to perform:\n1: add new baby \n2: list babies by names \n3: list babies by ages \n4: add gifts \n5: list gifts \n6: Age of the kid in days \n7: compare two babies by ages");
            int i = in.nextInt();
            switch (i) {
                case 1:
                    add_baby();
                    break;
                case 2:
                case 3:
                    list_baby(i);
                    break;
                case 4:
                    add_gift();
                    break;
                case 5:
                    list_gift();
                    break;
                case 6:
                      getAgebyDays();
                      break;
                case 7:
                      compare();
             }//end switch
       System.out.println("----------------------------------------------------------------");
       in=new Scanner(System.in);
			System.out.println("Do you want to continue y/n ?");
			char ch=in.nextLine().charAt(0);
            if(ch=='y')
            continue;
            //continue;
            else break;
        }//end while
    }//end constructor

    public static void main(String[] args) {
        new BabyRegister();
    }//end main method

    public void add_baby() {
        String name, db;
        char g;
        System.out.println("Please Enter Babies name|");
        in=new Scanner(System.in);
        name = in.nextLine();
        in=new Scanner(System.in);
        System.out.println("Please Enter Baby's birthdate in format yyyy-MM-dd HH:mm:ss|");
        db = in.nextLine();
        System.out.println("Please Enter Baby's gender|");
        g = in.nextLine().charAt(0);
        babies.add(new Baby(db, name, g));
    }//end add_baby method

    public void list_baby(int o) {
    Date now=new Date();

      for(Baby elem : babies){
		  if(o==2) {
        System.out.println(elem.getName()+"\t"+formatter.format(elem.getBirthday())+"\t"+elem.getGender());}
        else if(o==3) {
        System.out.println( (Year.now().getValue() - correct(elem.getBirthday().getYear()))+"\t"+elem.getName()+"\t"+elem.getGender());
   }

    }//end for loop
         }//end list_baby method

    public void add_gift() {
        String name, desc,dat;
        Date date=new Date();
        in=new Scanner(System.in);
        System.out.println("Please Enter Person who give the gift");
        name = in.nextLine();
        in=new Scanner(System.in);
        System.out.println("Please Enter a description");
        desc = in.nextLine();
        in=new Scanner(System.in);
        System.out.println("Please Enter the date in format yyyy-MM-dd HH:mm:ss|");
        dat = in.nextLine();
         try {
             date = dt.parse(dat);
        }
        catch (ParseException ex) {
            System.out.println(ex);
        }
        gifts.add(new Gift(name, desc, date));
    }//end add_gift method

    public void list_gift() {
        for(Gift elem : gifts){
		        System.out.println(elem.getName()+"\t"+elem.getDescrip()+"\t"+formatter.format(elem.getDate()));
	}//end for loop
    }//end list_gift method
    public int correct(int c) {
		if(c+1900<(Year.now().getValue())){
		return c+1900;
		}
		else { if(c>(Year.now().getValue())) {
		        return c-1900;}
		   else return c; }
	}//end correct method

	public void getAgebyDays() {
				Baby bb=null;
				in=new Scanner(System.in);
		System.out.println(" Enter baby name to count age in days ");
		String n=in.nextLine();
		for(Baby elem : babies){
					if(n.equals(elem.getName()))
					bb=elem;
		}
		if(bb!=null)
		System.out.println(bb.howOld());
		else
		System.out.println(" The name should be on the baby list");
	}//end getAgeByDays

	public void compare() {
		System.out.println("Enter two names to check their age");
		in=new Scanner(System.in);
		String n1=in.nextLine();
		in=new Scanner(System.in);
		String n2=in.nextLine();
		Baby bb1=null;
		Baby bb2=null;
		boolean checker=true;
		for(Baby elem : babies){
			if(n1.equals(elem.getName()))
			bb1=elem;
			else checker=false;
			if(n2.equals(elem.getName()))
			bb2=elem;
			else checker=false;
		}
		      if(bb1!=null && bb2!=null) {
		                 if(bb1.isOlder(bb2))
		                      System.out.println(bb1.getName()+" is older than "+bb2.getName());
		                 else
                              System.out.println(bb1.getName()+" is not older than "+bb2.getName());
						  }
			  else System.out.println("both names should exist in the baby list");
	}

}//end class
