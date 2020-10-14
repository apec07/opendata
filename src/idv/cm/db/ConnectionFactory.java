package idv.cm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	
	private String diriverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_morgan?"+"autoReconnect=true&useSSL=false"; 
	private String userName = "root";
	private String password = "1234";
	
	private static ConnectionFactory connectionFactory=null;

	public static Logger getLogger(String name,String msg) {
		//consloe log
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		String timeStamp = sdf.format(new java.util.Date());
		Logger log = Logger.getLogger(name);
		log.setLevel(Level.INFO);
		log.info(timeStamp+"=\t"+msg);
		return log;
	}
	
	private ConnectionFactory() {
		 try {
	           Class.forName(diriverClassName); 
	       } catch (java.lang.ClassNotFoundException e) {
	           getLogger(this.getClass().getSimpleName().toString(),e.getMessage());
	           System.err.println(e.getMessage());
	       }
	}
	public static ConnectionFactory getInstance() {
		if(connectionFactory==null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, password);
	}
	

       
}
