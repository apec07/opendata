package idv.cm.db;

import java.sql.Connection;
import java.util.HashSet;

public interface UserBeanImp {
	
	int insert(Connection con, UserBean user);
	int update(Connection con,int id, UserBean user);
	int delete(Connection con,int id);
	UserBean findByIndex(Connection con,int id);
	HashSet<UserBean> findAll(Connection con);

}
