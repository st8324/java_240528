# 데이터베이스 삭제
# drop database if exists DB명;
# drop schema if exists DB명;
# 워크스페이스에서 DB명 우클릭 Drop Schemas... 클릭 후 Drop now 클릭 
drop database if exists student;

# 데이터베이스 생성
# if not exists를 추가하는 이유? 
# => 생성하려는 DB가 이미 있는 경우 건너뛰기 위해서 
# => if not exists가 없는 경우 생성하려는 DB가 있으면 에러가 발생해서 이후 SQL문이 실행되지 않음 
# MySQL에서는 스키마와 DB를 같은 것으로 봄 
# create database if not exists DB명
# create schema if not exists DB명
# 워크벤치에서 Schemas 아래 공백에 우클릭 후 Create Schema 클릭 후 DB명 입력 후 Apply 
create database if not exists world;
create database if not exists sakila;
create database if not exists student;



# 데이터베이스 수정 - 이름은 수정이 안됨. 문자 집합을 수정
# ALTER SCHEMA DB명 기본문자집합 바꿀문자집합 기본COLLATE 바꿀COLLATE;
# 워크스페이스에서 DB명에 호버하고 2번재 아이콘 클릭 후 원하는 문자집합과 collate를 선택 후 apply


/*
# 테이블 추가
create table if not exists 테이블명(
	컬럼명 타입 [zerofill] [unique] [not null | null] [default 기본값] 
      [primary key] [auto_increment],
	컬럼명 타입 ...,
    제약조건, 
    constraint 제약조건명 primary key(컬럼명),
    # primary key(컬럼명),
    constraint 제약조건명 foreign key(컬럼명) references 참조테이블(기본키),
    # foreign key(컬럼명) references 참조테이블(기본키),
    constraint 제약조건명 check(논리식),
    # check(논리식)
);
# 워크벤치에서 Tables 우클릭 create table 클릭 후 속성과 옵션들을 선택해서 apply
# 외래키는 foreign 탭에서 작업 
*/
# auto_increment는 기본키만 적용 가능 
use student;
drop table if exists student.student;
create table if not exists student.student(
	studentNum int primary key auto_increment,
	grade int not null,
    class int not null,
    num int not null,
    name varchar(20) not null,
    check(grade >= 1 and grade <= 3),
    check(class >= 1),
    check(num >= 1),
    check(char_length(name) >= 2)
    # check(논리식)
);
drop table if exists student.subject;
CREATE TABLE if not exists `student`.`subject` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `grade` INT NOT NULL DEFAULT 1,
  `semester` INT NOT NULL DEFAULT 1,
  `name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`num`));
drop table if exists student.score;
create table if not exists student.score(
	num int primary key auto_increment,
    midTerm int not null default 0,
    finalTerm int not null default 0,
    performance int not null default 0,
    studentNum int not null,
    subjectNum int not null,
    foreign key(studentNum) references student(studentNum) 
		on delete cascade on update cascade,
    foreign key(subjectNum) references subject(num) on delete cascade
);

# 테이블 삭제
# drop table if exists 테이블명; 
drop table if exists score2;

# 테이블 수정 - 컬럼 추가
# alter table 테이블명 add 컬럼명 타입 [zerofill] [unique] ... ; 
alter table student.score add test int not null;

# 테이블 수정 - 컬럼 수정
# alter table 테이블명 change 기존컬럼명 새컬럼명 타입 [zerofill] [unique] ... ;
alter table student.score change test totalScore int not null default 0;

# 테이블 수정 - 컬럼 삭제
# alter table 테이블명 drop 컬럼명 
alter table student.score drop totalScore;

# 테이블 수정 - 제약조건 추가
# alter table 테이블명 add constraint 제약조건명 제약조건;
alter table student.score add constraint aa check(midTerm >= 0 and midTerm <= 100);

# 테이블 수정 - 제약조건 삭제
# alter table 테이블명 drop constraint 제약조건명;
alter table student.score drop constraint aa;




