package db.student.dao;

import org.apache.ibatis.annotations.Param;

import db.student.model.vo.StudentVO;

public interface StudentDAO {

	StudentVO selectStudent(@Param("std")StudentVO std);

	boolean insertStudent(@Param("std")StudentVO std);

}
