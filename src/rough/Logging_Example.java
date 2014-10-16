package rough;
import org.apache.log4j.Logger;


public class Logging_Example {

	public static void main(String[] args) {
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		APPLICATION_LOGS.debug("Starting");
		APPLICATION_LOGS.debug("Executing");
		APPLICATION_LOGS.debug("Ending");
	}

}
