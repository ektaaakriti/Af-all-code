package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Aforesight.Api.entity.User;
import com.Aforesight.Api.entity.User_Login;

public interface User_login_Repo extends JpaRepository<User_Login, String> {
	@Query("Select a from User_Login a where a.username=?1 ")
	User_Login login(String username);
	 @Transactional
	 @Modifying(clearAutomatically = false) 
	@Query("delete from User_Login a where a.username=?1")
	void logout(String username);
	 @Query("Select a from User_Login a where a.username=?1 and a.Token=?2 ")
		User_Login Validate_token(String username,String Token);
		@Query("Select a.username from User_Login a ")
		List Alllogin();
		 @Transactional
		 @Modifying(clearAutomatically = false) 
		@Query("delete from  User_Login u  where u.username in (?1)")
		public void deleteloggedUsers(List username);
}
