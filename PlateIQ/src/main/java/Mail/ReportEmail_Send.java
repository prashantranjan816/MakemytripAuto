package Mail;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.Test;


public class ReportEmail_Send {
	
	static String mailid 					= "YOURMAILID@gmail.com"; // please write sender your mail id
	static String mailpwd 					= "YOUR_PWD";			// please write mail password
	static String dateFinal;
	static String DayName;
	static int full;
	int type;
	static String ProjectReportPath		="./target/surefire-reports/ExtendReport/InterCityExtendReport.html";
	
	@Test
	public static void sendMail(String mailaddto1) throws EmailException, MalformedURLException {
		calender();
		Day(full);
		
		String mailSubject="InterCity ProjectReport Mail";
		String HostName="smtp.gmail.com";
		int SmtpPort=465;
		
	
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(HostName);
		email.setSmtpPort(SmtpPort); //smtpPort=465 fix for Gmail.
		email.setAuthenticator(new DefaultAuthenticator(mailid, mailpwd));
		email.setSSLOnConnect(true);
		email.setFrom(mailid);
		email.setSubject(mailSubject+" |[ "+dateFinal+"] : "+DayName + "http://13.233.139.207/#!");
		email.addTo(mailaddto1);
	
		
		email.addReplyTo(mailaddto1);
		

		email.setMsg("Please see the atached screenshot & Report to your browser on ip http://13.233.139.207/#!"
				+ " OR You will get full extend report at location  >> "+ProjectReportPath);
	
		email.send();
		System.out.println("Sent!");
		//master origin branch
	}
	
	public static void calender() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 0);//insted of 0 we can use +-1 to indrease or decrease current date.
		dateFinal = df.format(cal.getTime());
	}
	
	public static void Day(int type) {
		
		
		 Date todayDay = new Date();
		 if (type==full) {
	        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
	        DayName=simpleDateformat.format(todayDay);
		 }else {
	        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EE"); // the day of the week spelled out partial
	        DayName=simpleDateformat.format(todayDay);
		 }
	        
	        System.out.println(DayName);
	}
	

}
