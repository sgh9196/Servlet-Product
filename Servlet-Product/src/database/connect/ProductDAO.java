package database.connect;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
 
public class ProductDAO {
	
	private DataSource dataFactory;
	
	public ProductDAO() {
		
		try {
			
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public DataSource getDataFactory() {
		return dataFactory;
	}
	
}
