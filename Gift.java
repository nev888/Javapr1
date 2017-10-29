import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gift {
private String name;
private String descrip;
private Date date;

SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyyy hh:mm");

public Gift(String name,String descrip, Date date){
    this.name=name;
    this.descrip=descrip;

     try {
            this.date = dt.parse(dt.format(date));
        }
        catch (ParseException ex) {
            System.out.println(ex);
        }
}

    public void setName(String name) {
        this.name = name;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDescrip() {
        return descrip;
    }

    public Date getDate() {
		 date.setYear(date.getYear()-1900);
        return date;
    }
    @Override
    public String toString() {
        return "Gifts{" + "Name=" + name + ", Description=" + descrip + ", Date=" + date + '}';
    }

}
