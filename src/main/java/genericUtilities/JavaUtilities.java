package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	public int getRandomNum()
	{
	Random ran=new Random();
	int random = ran.nextInt();
	return random;
	}

	public String systemDate()
	{
		Date date=new Date();
		String systemdate = date.toString();
		return systemdate;
	}
	public String systemDateFormate()
	{
		SimpleDateFormat dateformate=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date=new Date();
		String systemDateFormate = dateformate.format(date);
		return systemDateFormate;
		
	}
}
