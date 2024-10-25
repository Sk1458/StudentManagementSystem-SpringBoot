package com.example.demo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StuMgmtRepo extends CrudRepository<StuMgmtEntity, Serializable> {
	
	List<StuMgmtEntity> findByName(String name);

    List<StuMgmtEntity> findByCity(String city);

    List<StuMgmtEntity> findByBranch(String branch);

    List<StuMgmtEntity> findByAge(int age);

    List<StuMgmtEntity> findByCourse(String course);
    
    List<StuMgmtEntity> findByRollno(String rollno);
    
    

}
