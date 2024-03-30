//Developed by:Author Arthvedika dev team
//Date:26/01/2022
//Purpose:This is repository for entity class User.
package com.Aforesight.Api.repository;

import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Aforesight.Api.entity.Agent_msg_dtls;
import com.Aforesight.Api.entity.User;

//import java.util.List;
//import java.util.Optional;

public interface userRepository extends JpaRepository<User, Long> {
  
   
  // @Query("select u from User u where u.Email_ID= ?1 and u.password=?2")
  // User finduserBynameandpassword(String email_ID, String password);
	@Query("select u from User u where u.Delete_status='NO' ")
	   List<User> AllUsers();
   @Query("select u.Email_ID from User u where u.username= ?1 and u.Delete_status='NO' ")
   String findemail(String username);
   @Query("select u from User u where u.username= ?1 and u.Delete_status='NO' ")
   List<User> userByusername(String username);
   @Query("select u.username from User u where u.Email_ID= ?1 and u.Delete_status='NO' ")
   String findusername(String Email); 
   @Query("select u.User_Type from User u where u.Email_ID= ?1 and u.Delete_status='NO' ")
   String findusertype(String Email); 
   @Query("select u from User u where u.Email_ID= ?1 and u.password=?2 and u.Delete_status='NO' ")
   User finduserBynameandpassword(String username,String password);
	//User finduserBynameandpassword(String Email_ID);
   @Query("select u.password from User u where u.Email_ID= ?1 and u.Delete_status='NO' ")
   String Password(String Email);
   @Query("select u from User u where u.username=?1 and u.Delete_status='NO'")
   List<User> findusernamenID(String username); 
   @Transactional
	 @Modifying(clearAutomatically = false) 
   @Query("update  User u set u.Delete_status=?1 where u.username=?2 and u.User_ID=?3 ")
  public void delete_status(String Delete_status,String username,String User_ID  ); 
   @Transactional
	 @Modifying(clearAutomatically = false) 
 @Query("update  User u set u.user_login='Y' where u.username=?1 ")
public void login_status(String username ); 
   @Transactional
	 @Modifying(clearAutomatically = false) 
   @Query("update  User u set u.user_locked='Y' where u.username=?1  ")
   public void user_login_status(String username ); 
   @Query("select a from User a where a.user_locked='Y' and a.username=?1")
   User user_Locked(String username);
   @Query("select u from User u where u.User_ID=?1 and u.username=?2 and u.Delete_status='NO' ")
   List<User> getUserToUpdate(String User_ID,String username);  
   @Transactional
	 @Modifying(clearAutomatically = false) 
 @Query("update  User u set  u.Email_ID=?1,u.First_Name=?2,u.Last_Name=?3,u.Mobile=?4, u.Department=?5,u.Location=?6,u.Manager_Name=?7, u.Manager_User_ID=?8,u.Emp_Code=?9,u.User_Type=?10, u.user_group_id=?11,u.AD_User_login_ID=?12 where u.username=?13 ")
public void update_user(String Email_ID,String First_Name,String Last_Name,String Mobile,String Department,String Location,String Manager_Name,String Manager_User_ID,String Emp_Code,String User_Type,String user_group_id ,String AD_User_login_ID,String username  );

@Query("select distinct u.Department from User u")
List alldepartment();
@Query("select u from User u where u.Department=?1") 
List<User> userByDepartment(String Department);
@Transactional
@Modifying(clearAutomatically = false) 
@Query("update User u set u.user_group_id=?1 where Department=?2")
public void createUserGroup(String user_group_id, String Department);
@Transactional
@Modifying(clearAutomatically = false) 
@Query("update User u set u.user_group_id=?1 where Department=?2")
public void DeleteUserGroup(String user_group_id, String Department);
@Query("select u from User u where u.Delete_status='NO' and u.user_locked='Y' or u.user_login='Y'")
List<User> AllLockedandloggedUser();
@Transactional
@Modifying(clearAutomatically = false) 
@Query("update User u set u.user_locked='N' , u.user_login='N' where u.username in (?1)")
public void unlockmultipleUsers(List username);
}
