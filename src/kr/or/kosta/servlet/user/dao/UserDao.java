package kr.or.kosta.servlet.user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.kosta.servlet.user.domain.User;

public interface UserDao {
	
	
	/** 사용자 등록 
	 * @throws Exception */
	public void create(User user) throws RuntimeException;
	
	/** 아이디로 사용자 조회 
	 * @throws SQLException */
	public User read(String id) throws RuntimeException;
	
	/** 아이디와 비밀번호를 이용한 회원인증*/
	public User isMember(String id, String passwd) throws RuntimeException;
	
	/** 사용자 이름으로 검색 */
	public List<User> search(String name) throws RuntimeException;
	
	/** 사용자 전체 조회 */
	public List<User> listAll() throws RuntimeException;
	
	/** 사용자 정보 수정 */
	public void update(User user) throws RuntimeException;
	
	/** 사용자 정보 삭제 */
	public void delete(String id) throws RuntimeException;
	
	public List<Map<String, Object>> employeeList();
}

