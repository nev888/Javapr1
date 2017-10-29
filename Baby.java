import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.time.Year;

public class Baby {

    private Date birthday;
    private String name;
    private char gender;

     DateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Baby() {
    }

    public Baby(String birthday, String name, char gender) {

        try {

            this.birthday = parser.parse(birthday);
        }
        catch (ParseException e) {
            System.out.println(e.toString());
        }

        this.name = name;
        this.gender = gender;
    }//end constructor

    public Baby(Date birthday, String name, char gender) {

        this.birthday=birthday;
        this.name = name;
        this.gender = gender;
    }

    public Date getBirthday() {

        return birthday;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public void setBirthday(Date birthday) {

        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    boolean isOlder(Baby baby) {
        if (birthday.compareTo(baby.birthday) < 0) {
            return true;
        } else {
            return false;
        }
    }

    int howOld() {
        Date date2 = new Date();
        long diff = date2.getTime()-birthday.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() { //new SimpleDateFormat("dd/mm/yyyyy hh:mm").format(
        return "Baby{" + "birthday=" + birthday + ", name=" + name + ", gender=" + gender + '}';
    }
}
