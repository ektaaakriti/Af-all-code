package itsm_connection;



import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.python.jline.internal.Log;



public class executeMain {

	public static void main(String[] args) {
		Logger log = LogManager.getLogger(executeMain.class.getName());
		executeMain execagent = new executeMain();
		
		
		log.info("Itsm batch  started");
	
		execagent.waitMethod();
		
			
			log.info("itsm ended");

		}
		public  synchronized void waitMethod() {
			itsmToDatabase utilObj = new itsmToDatabase();
			while (true) {
				System.out.println("always running program  for itsm connection==> " + Calendar.getInstance().getTime());
			try {
			
			utilObj.get_itsmreq();
			utilObj.update_itsmreq();
			
			Log.info("itsm no is received  successfully");
			this.wait(10000);
			
			}
			catch (Exception e){
				Log.error(e);
			}
		
			
			}	
					



	}
}


