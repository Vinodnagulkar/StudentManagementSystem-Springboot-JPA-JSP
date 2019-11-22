package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Student;

/**
 * @author vinod.nagulkar
 *
 */
@Repository("myRep")
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByEmail( String email);
	
	  @Transactional
	  @Modifying(clearAutomatically = true)
	  @Query("Update Student SET password=:password where email=:email") 
	  Integer updatePassword(@Param(value="email")String
			  email,@Param(value="password")String password);

}
