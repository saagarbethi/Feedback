package com.feedback.app.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.feedback.app.dao.UserDao;
import com.feedback.app.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getUsers() {
		return jdbcTemplate.query("select * from client_reg",
				(rs, rowNum) -> new User(rs.getString("FIRST_NAME"), rs.getString("MIDDLE_NAME"),
						rs.getString("LAST_NAME"), rs.getString("MOBILE"), rs.getString("EMAILID"),
						rs.getString("USERID")));
	}

	@Override
	public User getUserById(String userid) {
		String sql = "select * from client_reg where userid = ?";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { userid });
		if (rows.size() > 0) {
			return new User((String) rows.get(0).get("FIRST_NAME"), (String) rows.get(0).get("MIDDLE_NAME"),
					(String) rows.get(0).get("LAST_NAME"), (String) rows.get(0).get("MOBILE"),
					(String) rows.get(0).get("EMAILID"), (String) rows.get(0).get("USERID"));

		} else {
			return null;
		}

	}

	@Override
	public int save(User user) {
		String sql = "insert into client_reg (first_name,middle_name,last_name,mobile,emailid,userid,password) values "
				+ "(?,?,?,?,?,?,?)";
		int res = jdbcTemplate.update(sql,
				user.getFirst_name(),
				user.getMiddle_name(),
				user.getLast_name(),
				user.getMobile(),
				user.getEmailid(),
				user.getUserid(),
				user.getPassword()
				);
		return res;
	}

	@Override
	public String generateUserId() {
		return jdbcTemplate.queryForObject("select CLIENT_REG_SEQ.nextval from dual", String.class);
	}

	@Override
	public User login(String userid, String password) {
		String sql = "select * from client_reg where upper(userid) = ? and password = ?";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { userid.toUpperCase(),password });
		if (rows.size() > 0) {
			return new User((String) rows.get(0).get("FIRST_NAME"), (String) rows.get(0).get("MIDDLE_NAME"),
					(String) rows.get(0).get("LAST_NAME"), (String) rows.get(0).get("MOBILE"),
					(String) rows.get(0).get("EMAILID"), (String) rows.get(0).get("USERID"));

		} else {
			return null;
		}
	}

	@Override
	public int update(User user) {
		String sql = "update client_reg set first_name=?,middle_name=?,last_name=?,mobile=?,emailid=?  "
				+ " where userid = ?";
		return jdbcTemplate.update(sql,user.getFirst_name(),user.getMiddle_name(),user.getLast_name(),user.getMobile(),user.getEmailid(),user.getUserid());
	}

}
