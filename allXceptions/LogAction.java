package allXceptions;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

public class LogAction implements Action{

	@Override
	public void takeAction(Map<String, String> nvpair) {
		// TODO Auto-generated method stub
		/*try {
			Log lg = new Log("log.txt");
			lg.logger.setLevel(Level.WARNING);
			lg.logger.info("Info");
			lg.logger.warning("warning msg");
			lg.logger.severe("severe msg");
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("unrecognized" + nvpair.toString());
		*/
		System.out.println("Logging to file");
	}
}