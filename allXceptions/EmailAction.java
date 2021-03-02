package allXceptions;
import java.util.Map;


public class EmailAction implements Action{

	@Override
	public void takeAction(Map<String, String> nvpair) {
		// TODO Auto-generated method stub
		SendEmail.SendMail("anisingh1999bkao@gmail.com");
		/*System.out.println("Email send to " + nvpair.toString());*/
	}
}