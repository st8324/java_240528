# insert
# 한 행(레코드)의 데이터를 추가할 때 사용 
# 문법
# insert into 테이블명(속성1, ..., 속성n) value(값1, ..., 값n);
# value는 한번에 한 행을 추가할 때 사용. 
# 속성의 개수가 값의 개수가 같아야 함 
insert into student.student(studentNum, grade, class, num, name)
value(null, 1, 1, 1, '홍길동');

# insert into 테이블명(속성1, ..., 속성n) values(값1, ..., 값n),(값1, ..., 값n);
# values는 한번에 한개 이상의 행을 추가할 때 사용. 
# 속성의 개수가 값의 개수가 같아야 함 
insert into student.student(grade, class, num, name)
values(1,1,2,'임꺽정'), (1,1,3, '고길동');
# insert into 테이블명 value(값1, ..., 값n);
# 테이블명 옆에 속성명을 생략한 경우 table 생성시 추가했던 속성 순서대로 값들을 넣어주어야 함.
# 전체 속성 개수만큼 값들을 넣어줘야 함. 
insert into student.student value(null, 1, 1, 4, '둘리');


# update
# 특정 행들의 값들을 변경할 때 사용 
# update 테이블명 set 속성명1 = 값1, ..., 속성명n = 값n where 조건
# = : 같다, != : 다르다, <> : 다르다
# is null : null이면, is not null : null이 아니면
# and : ~하고, or : ~이거나
# and와 or의 우선순위가 다름. and가 높음. 
# 날짜는 'yyyy-MM-dd hh:ss:mm'형태의 문자열과 비교 가능. =, >=, <=, !=를 활용할 수 있다
update student set name = '또치' where student.studentNum = 2;

# 워크 벤치에서는 안전하게 수정/삭제할 수 있게 하기 위해 기본키가 아닌 조건으로 
# 수정/삭제하려고 하면 수정/삭제를 하지 못하도록 막음 
# 해결방법 : Edit > Preferences... > SQL Editor 
#          > Safe updates 체크박스 해제 후 ok 클릭
UPDATE student.student 
SET 
    name = '마이콜'
WHERE
    student.grade = 1 and student.class=1 and student.num = 2;
    

# delete
# 특정 행들을 삭제할 때 사용 
# delete from 테이블명 where 조건; 
delete from student.student where studentNum = 4;

delete from student.student where grade = 1 and class=1 and num = 3;

delete from student.student;

# delete와 truncate의 차이
# delete는 데이터만 지우고 설정은 그대로 유지 - auto_increment 시작 숫자 유지 
# truncate은 데이터 뿐만아니라 설정도 초기로 돌림 - auto_increment 숫자가 1에서 시작
# truncate은 다른 테이블이 참조하고 있는 경우 초기화가 안됨 
# 1학년 1반 1번 홍길동 학생을 추가
insert into student.student(grade, class, num, name) value(1,1,1,'홍길동');
# 1학년 1학기 국어 과목을 추가
insert into student.subject(grade, semester, name) value(1,1,'국어');
# 1학년 1반 1번 홍길동 학생의 1학년 1학기 국어 성적을 중간 100, 기말, 90, 수행 90으로 
# 성적을 추가
insert into student.score(midTerm, finalTerm, performance, studentNum, subjectNum)
	value(100, 90, 90, 1, 1);
delete from score;
insert into student.score(midTerm, finalTerm, performance, studentNum, subjectNum)
	value(100, 90, 90, 1, 1);
# 위 쿼리가 실행되면 기본키가 2(이전 기본키가 1이었다고 가정)인 데이터가 추가 됨 
truncate table score;
insert into student.score(midTerm, finalTerm, performance, studentNum, subjectNum)
	value(100, 90, 90, 1, 1);
# 위 쿼리가 실행되면 기본키가 1인 데이터가 추가 됨 















