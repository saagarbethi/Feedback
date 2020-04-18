/**
 * 
 */
package com.feedback.app.dao;

import java.util.List;
import com.feedback.app.model.*;

/**
 * @author sbethi
 *
 */
public interface UserDao {
	List<User> getUsers();
	User getUserById(String userid);
	int save(User user);
	String generateUserId();
	User login(String userid,String password);
	int update(User user);
}
