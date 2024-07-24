# 문자열 함수
# 길이 함수 
# LENGTH(문자열) : 문자열의 바이트수를 반환 
SELECT LENGTH("안녕"); # 6바이트
SELECT LENGTH("12"); # 2바이트 
# CHAR_LENGTH(문자열) : 문자열의 길이를 반환 
SELECT CHAR_LENGTH("안녕"); # 2
SELECT CHAR_LENGTH("12"); # 2

# CONCAT(문자열1, 문자열2, ...) : 문자열들을 이어서 하나의 문자열을 만듬 
SELECT CONCAT('안녕','하','세요','.');

# 탐색 
# FIELD(찾을문자열, 문자열1, 문자열2, ...) : 문자열들에서 찾을 문자열이 몇번째에 있는지 반환 
# 1부터 시작. 없으면 0 
SELECT FIELD("안녕", '안녕하세요.', '안녕1');
# INSTR(문자열1, 문자열2) : 문자열1에서 문자열2가 몇번째부터 시작하는지 반환. 없으면 0
SELECT INSTR("안녕하세요.", "안녕");
SELECT INSTR("안녕하세요.", "안녕1");
# LOCATE(문자열2, 문자열1) : 문자열1에서 문자열2가 몇번째부터 시작하는지 반환. 없으면 0
SELECT LOCATE("안녕", "안녕하세요.");
SELECT LOCATE("안녕1", "안녕하세요.");

# FORMAT(숫자, 소수점자리수) : 숫자를 소수점 자리수까지 표현, 3자리마다 ,를 추가 
SELECT FORMAT(1234567.89012, 2);

# BIN(숫자) : 2진수, OCT(숫자) : 8진수, HEX(숫자) : 16진수 
SELECT BIN(31), OCT(31), HEX(31);

# LPAD(문자열, 자리, 채울문자열) : 문자열이 자리수보다 작으면 왼쪽에 채울문자열을 추가하여 자리수를 맞춤
# RPAD(문자열, 자리, 채울문자열) : 문자열이 자리수보다 작으면 오른쪽에 채울문자열을 추가하여 자리수를 맞춤

# RGB(255,20,3)을 16진수로 변경해서 #FF1403으로 표현하는 쿼리 
SELECT CONCAT('#',LPAD(HEX(255),2,'0'),LPAD(HEX(20),2,'0'),LPAD(HEX(3),2,'0'))'RGB(255,20,3)';

# 문자열 교체 
# INSERT(문자열, 위치, 길이, 대체문자열) : 
# 문자열에서 위치부터 길이만큼 문자열을 제거 후 대체문자열을 추가 
SELECT INSERT('누구나 하는 C', 8, 1, 'JAVA');
# REPLACE(문자열, 교체할문자열, 대체할문자열) 
SELECT REPLACE('C의 정석', 'C', 'JAVA');
# UPPER(문자열) : 대문자로, LOWER(문자열) : 소문자로
SELECT UPPER('hi'), LOWER('HI');
# REVERSE(문자열) : 문자열을 역순으로 
SELECT REVERSE('ABCDEF');
# REPEAT(문자열, 횟수) : 문자열을 횟수만큼 반복 
SELECT REPEAT('HI!', 3);

# 부분 문자열 추출
# LEFT(문자열, 숫자) : 문자열에서 왼쪽부터 숫자만큼 문자열을 반환 
# RIGHT(문자열, 숫자) : 문자열에서 오른쪽부터 숫자만큼 문자열을 반환 
SELECT LEFT('TEST.JPG', 4), RIGHT('TEST.JPG', 3);
# SUBSTRING(문자열, 시작위치, 길이) : 문자열에서 시작위치부터 길이만큼의 문자열을 반환 
SELECT SUBSTRING('TEST.JPG', 1, 4), SUBSTRING('TEST.JPG', 6,3);

# 시간함수
# NOW(), SYSDATE(), CURRENT_TIMESTAMP : 현재 시간을 반환 
# CURRENT_TIMESTAMP는 속성의 타입이 DATETIME인 경우 기본값으로 현재시간을 추가하도록 설정할 수 있음
SELECT NOW(), SYSDATE(), CURRENT_TIMESTAMP;

# ADDDATE(시간, 차이)/SUBDATE(시간, 차이) : 시간에서 차이만큼 일을 더한/뺀 시간을 계산
SELECT ADDDATE(NOW(), 2), SUBDATE(NOW(), 2);

# ADDTIME(시간, 차이)/SUBTIME(시간, 차이) : 시간에서 차이만큼 시간(시,분,초)을 더한/뺀 시간을 계산 
SELECT ADDTIME(NOW(), '2:00:00'), SUBTIME(NOW(), '2:00:00');

# YEAR(시간) : 시간에서 년을 추출
# MONTH(시간) : 시간에서 월을 추출
# DAY(시간) : 시간에서 일을 추출
SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW());

# HOUR(시간), MINUTE(시간), SECOND(시간), MICROSECOND(시간) : 시간에서 시/분/초/밀리초를 추출 
SELECT HOUR(NOW()), MINUTE(NOW()), SECOND(NOW());
SELECT MICROSECOND("2024-07-27 14:10:10.123");

# DATE(시간) : 년-월-일 추출
# TIME(시간) : 시:분:초 추출 
SELECT DATE(NOW()), TIME(NOW());

# DATEDIFF(시간1, 시간2) : 시간1에서 시간2의 차이를 일로 반환. 시간1 - 시간2 
# TIMEDIFF(시간1, 시간2) : 시간1에서 시간2의 차이를 시:분:초로 반환. 시간1 - 시간2 
SELECT DATEDIFF(NOW(), '2024-07-27 10:00:00');
SELECT TIMEDIFF('11:00', '09:00');
SELECT TIMEDIFF(NOW(), '2024-07-27 10:00:00');

# DATE_ADD(시간, INTERVAL) : 시간에서 INTERVAL만큼 더한 시간 
# DATE_SUB(시간, INTERVAL) : 시간에서 INTERVAL만큼 뺀 시간 
/*
INTERVAL 종류 
- 단일 시간 유형 : 한 종류의 단위를 나타냄 
 - YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, MICROSECOND, QUATER(분기), WEEK(주)
- 복합 시간 유형 : 여러 종류의 단위를 한번에 나타냄 
 - YEAR_MONTH : 년 월
 - DAY_HOUR : 일 시간 
 - DAY_MINUTE : 일 시간:분
 - DAY_MICROSECOND : 일 시간:분:초.마이크로초 
*/
SELECT DATE_ADD(NOW(), INTERVAL 1 MONTH);
SELECT DATE_SUB(NOW(), INTERVAL "1 1" YEAR_MONTH);

# 수학 함수
# FLOOR(숫자) : 소수점 첫번째 자리 내림. 
# CEIL(숫자) : 소수점 첫번째 자리 올림. 
# ROUND(숫자) : 소수점 첫번째 자리 반올림. 
# ABS(숫자) : 절대값
SELECT FLOOR(1.23), CEIL(1.23), ROUND(1.23), ABS(-1);