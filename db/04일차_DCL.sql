# CREATE USER '아이디'@'호스트명' IDENTIFIED BY '비밀번호';
# 호스트명
#   - localhost : 내부에서만 사용 가능(다른 PC에서 해당 DB에 접근 불가능)
#   - % : 외부에서도 사용 가능(다른 PC에서도 아이디와 비번이 맞으면 접근 가능) 
# cgv DB 관리를 위한 cgv_admin 계정을 추가(비번 : admin123)
CREATE USER 'cgv_admin'@'%' IDENTIFIED BY 'admin123';

# 계정 조회
SELECT USER, HOST FROM MYSQL.USER;

# 계정 비번 변경
# SET PASSWORD FOR '아이디'@'호스트명' = '새비밀번호';
SET PASSWORD FOR 'cgv_admin'@'%' = 'admin1234';

# 계정 삭제
# DROP USER '아이디'@'호스트명'
DROP USER 'cgv_admin'@'%';

# 계정 조회
SELECT USER, HOST FROM MYSQL.USER;

# 권한 부여 
# 사용자에게 DB에 대한 권한을 부여. 데이터 추가, 수정, 삭제, 테이블 추가 수정 삭제 등 
# SELECT/INSERT/UPDATE/DELETE/CREATE/ALTER/DROP/REFERENCES/ALL PRIVILEGES(모든 권한)
# GRANT 권한 ON DB명.테이블명 TO '아이디'@'호스트명';
# cgv_admin 계정에 cgv DB는 모든 권한을 부여하고, 다른 DB에는 조회 권한을 부여 
GRANT ALL PRIVILEGES ON CGV.* TO 'cgv_admin'@'%';
GRANT SELECT ON PRODUCT.* TO  'cgv_admin'@'%';
GRANT SELECT ON STUDENT.* TO  'cgv_admin'@'%';
GRANT SELECT ON UNIVERSITY.* TO  'cgv_admin'@'%';

# 권한 제거
# 사용자에게 부여했던 DB에 대한 권한을 제거 
# REVOKE 권한 ON DB명.테이블명 FROM '아이디'@'호스트명';
# PRODUCT DB에 SELECT 권한을 제거
REVOKE SELECT ON PRODUCT.* FROM 'cgv_admin'@'%';

 
