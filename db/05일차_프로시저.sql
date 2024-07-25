
USE university;
# 학과 코드, 이름, 전공이 주어졌을 때 신입생을 등록하는 프로시저 
DROP PROCEDURE IF EXISTS INSERT_FRESHMAN;
DELIMITER // 
CREATE PROCEDURE INSERT_FRESHMAN(
	IN _MAJOR_CODE CHAR(3),
    IN _MAJOR VARCHAR(15),
    IN _NAME VARCHAR(30)
)
BEGIN
	DECLARE _YEAR INT;
    DECLARE _NUM CHAR(3);
    DECLARE _ST_NUM CHAR(10);
    # 학번을 생성
    # 년 + 학과코드 + 순서 
    # 프로시저가 실행될 때 년도를 가져옴 
    SET _YEAR = (SELECT YEAR(NOW()));
    SET _NUM = (SELECT LPAD(COUNT(*)+1, 3, '0') FROM STUDENT WHERE ST_MAJOR = _MAJOR);
    SET _ST_NUM = CONCAT(_YEAR, _MAJOR_CODE, _NUM);
    INSERT INTO STUDENT VALUES(_ST_NUM, _NAME, _MAJOR, 1);
END //
DELIMITER ;
# 프로시저 호출 
CALL INSERT_FRESHMAN('160', '컴퓨터공학', '논개');
# 결과 확인 
SELECT * FROM STUDENT;

# 학번, 강의번호, 중간, 기말, 과제, 출석이 주어지면 학점을 계산해서 추가하는 프로시저를 생성해보세요.
DROP PROCEDURE IF EXISTS UPDATE_POINT;
DELIMITER // 
CREATE PROCEDURE UPDATE_POINT(
	IN _ST_NUM CHAR(10), # 학번
    IN _LE_NUM INT, # 강의번호
    IN _MID INT, # 중간 : 40%
    IN _FINAL INT, # 기말 : 40%
	IN _HOMEWORK INT, # 과제 : 10%
    IN _ATTENDANCE INT # 출석 : 10%
)
BEGIN
	# 최종 성적이 95점이상 A+, 90점이상 A, 85점이상 B+, ..., 60미만 F
    # 총점을 저장할 변수를 선언
    DECLARE _TOTAL INT;
    # 학점을 저장할 변수를 선언
    DECLARE _POINT VARCHAR(2);
    # 총점을 계산해서 저장
    SET _TOTAL = _MID * 0.4 + _FINAL * 0.4 + _HOMEWORK * 0.1 + _ATTENDANCE * 0.1;
    # 총점이 95점이상이면 A+ 
    IF _TOTAL >= 95 THEN
		SET _POINT = 'A+';
    # 총점이 90점이상이면 A
    ELSEIF _TOTAL >= 90 THEN
		SET _POINT = 'A';
    # 총점이 85점이상이면 B+ 
    ELSEIF _TOTAL >= 85 THEN
		SET _POINT = 'B+';
    # 총점이 80점이상이면 B
    ELSEIF _TOTAL >= 80 THEN
		SET _POINT = 'B';
    # 총점이 75점이상이면 C+ 
    ELSEIF _TOTAL >= 75 THEN
		SET _POINT = 'C+';
    # 총점이 70점이상이면 C
    ELSEIF _TOTAL >= 70 THEN
		SET _POINT = 'C';
    # 총점이 65점이상이면 D+ 
    ELSEIF _TOTAL >= 65 THEN
		SET _POINT = 'D+';
    # 총점이 60점이상이면 D 
    ELSEIF _TOTAL >= 60 THEN
		SET _POINT = 'D';
    # 아니면 F 
    ELSE
		SET _POINT = 'F';
	END IF;
    # 성적을 업데이트
    UPDATE COURSE
	SET
		CO_MID = _MID,
        CO_FINAL = _FINAL,
        CO_HOMEWORK = _HOMEWORK,
        CO_ATTENDANCE = _ATTENDANCE,
		CO_TOTAL = _POINT
	WHERE
		CO_ST_NUM = _ST_NUM AND CO_LE_NUM = _LE_NUM;
END //
DELIMITER ;

CALL UPDATE_POINT('2024160005', 2, 90, 80, 70, 50);

# 프로시저 확인 
SHOW PROCEDURE STATUS;
# 프로시저 스크립트 확인 
SHOW CREATE PROCEDURE INSERT_FRESHMAN;

USE CGV;
# 예매자 아이디, 예매 상영시간번호, 성인수, 청소년수가 주어지면 티켓을 예매하는 프로시저를 생성하고 테스트 
DROP PROCEDURE IF EXISTS TICKETING;

DELIMITER //
CREATE PROCEDURE TICKETING(
	IN _ID VARCHAR(15), 
    IN _SD_NUM INT,
    IN _ADULT INT,
    IN _TEENAGER INT
)
BEGIN
	DECLARE _ADULT_PRICE INT;
    DECLARE _TEENAGER_PRICE INT;
    DECLARE _MORNING INT;
    
    # 조조영화여부를 가져옴(1:조조, 0:아님)
    SET _MORNING = (SELECT SD_EARYLY FROM SCHEDULE WHERE SD_NUM = _SD_NUM);
    CASE _MORNING 
		WHEN 1 THEN
			SET _ADULT_PRICE = (SELECT PR_PRICE * _ADULT FROM PRICE WHERE PR_TYPE = '조조 성인');
            SET _TEENAGER_PRICE = (SELECT PR_PRICE * _TEENAGER FROM PRICE WHERE PR_TYPE = '조조 청소년');
        ELSE
			SET _ADULT_PRICE = (SELECT PR_PRICE * _ADULT FROM PRICE WHERE PR_TYPE = '성인');
            SET _TEENAGER_PRICE = (SELECT PR_PRICE * _TEENAGER FROM PRICE WHERE PR_TYPE = '청소년');
	END CASE;
	INSERT INTO TICKETING 
    VALUES(NULL, _ADULT, _TEENAGER, _ADULT_PRICE + _TEENAGER_PRICE, _ID, _SD_NUM);
END //
DELIMITER ;

CALL TICKETING('abc123', 3, 3, 0);