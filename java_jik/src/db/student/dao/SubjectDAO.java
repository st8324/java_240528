package db.student.dao;

import org.apache.ibatis.annotations.Param;

public interface SubjectDAO {

	int selectCountSubject(@Param("subject")String subject);

	boolean insertSubject(@Param("subject")String subject);

}
