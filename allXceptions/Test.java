package allXceptions;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			m1();
		}catch(Exception ex)
		{
			MyExceptionHandler.handleException("projName","Module-1", ex);
		}
		
	}

	private static void m1() throws IOException{
		// TODO Auto-generated method stub
		throw new IOException();
		
	}

}
