package db.day02.ex01.dao;

import org.apache.ibatis.annotations.Param;

public interface StudentDAO {

	boolean insertStudent(
			@Param("grade")int grade, 
			@Param("classNum")int classNum, 
			@Param("num")int num, 
			@Param("name")String name);

}
