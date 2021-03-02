package allXceptions;
import java.util.Map;

public class AbortAction implements Action{

	@Override
	public void takeAction(Map<String, String> nvpair) {
		// TODO Auto-generated method stub
		System.out.println("Abort mission!Process terminated " + nvpair.toString());
		
	}	
}
