package db.student.dao;

import org.apache.ibatis.annotations.Param;

import db.student.model.vo.ScoreVO;

public interface ScoreDAO {

	ScoreVO selectScore(@Param("st_key")int st_key, @Param("su_key")int su_key);

	boolean insertScore(@Param("score")ScoreVO score);

	boolean deleteScore(@Param("st_key")int st_key, @Param("su_key")int su_key);

	boolean updateScore(@Param("score")ScoreVO score);

}
