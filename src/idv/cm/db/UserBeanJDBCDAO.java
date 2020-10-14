package idv.cm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserBeanJDBCDAO implements UserBeanImp{
	
	private static final String INSERT_STMT="INSERT INTO USER (USER,PASSWORD,EMAIL) VALUES(?,?,?)";
	private static final String GET_ALL_STMT="SELECT * FROM USER ORDER BY -ID";
	private static final String GET_ONE_STMT="SELECT * FROM USER WHERE ID = ?";
	private static final String DELETE_STMT="DELETE FROM USER WHERE ID =?";
	private static final String UPDATE_STMT="UPDATE USER SET USER=?, PASSWORD=?,EMAIL=? WHERE ID=?";
	
	public static Logger getLogger(String name,String msg) {
		//consloe log
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		String timeStamp = sdf.format(new java.util.Date());
		Logger log = Logger.getLogger(name);
		log.setLevel(Level.INFO);
		log.info(timeStamp+"=\t"+msg);
		return log;
	}
	
	@Override
	public int insert(Connection con, UserBean user) {
		int updateCount=0;
		String name = user.getName();
		String passwrod = user.getPassword();
		String email = user.getEmail();
		try(PreparedStatement ptmt = con.prepareStatement(INSERT_STMT)){
			ptmt.setString(1, name);
			ptmt.setString(2, passwrod);
			ptmt.setString(3, email);
			updateCount = ptmt.executeUpdate();
		}catch(java.sql.SQLException ex) {
			getLogger(this.getClass().getSimpleName().toString(),ex.toString());
		}
		return updateCount;
	}
	@Override
	public int update(Connection con, int id, UserBean user) {
		int updateCount=0;
		String name = user.getName();
		String passwrod = user.getPassword();
		String email = user.getEmail();
		try(PreparedStatement ptmt = con.prepareStatement(UPDATE_STMT)){
			ptmt.setString(1, name);
			ptmt.setString(2, passwrod);
			ptmt.setString(3, email);
			ptmt.setInt(4, id);
			updateCount = ptmt.executeUpdate();
		}catch(java.sql.SQLException ex) {
			getLogger(this.getClass().getSimpleName().toString(),ex.toString());
		}
		return updateCount;
	}
	@Override
	public int delete(Connection con, int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public UserBean findByIndex(Connection con, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashSet<UserBean> findAll(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
