# DB 삭제(university)
DROP DATABASE IF EXISTS university;
# DB 생성(university) 
CREATE DATABASE IF NOT EXISTS university;

USE university;

# student 테이블 삭제
DROP TABLE IF EXISTS student;
# student 테이블 추가
# 학번, 이름(30자), 전공(15자), 학년 
CREATE TABLE IF NOT EXISTS student(
	st_num char(10) primary key,
    st_name varchar(30) not null,
    st_major varchar(15) not null,
    st_grade int not null default 1
);

# professor 테이블 삭제
DROP TABLE IF EXISTS professor;
# professor 테이블 추가
# 학번, 이름(30자), 전공(15자), 교수길(100)
CREATE TABLE IF NOT EXISTS professor(
	pr_num char(10) primary key,
    pr_name varchar(30) not null,
    pr_major varchar(15) not null,
    pr_room varchar(100)
);

# lecture 테이블 삭제
DROP TABLE IF EXISTS lecture;
# lecture 테이블 추가
# 강의 번호(PK), 강의명(30자), 강의실(100자), 강의 시간(시간표, 최대 50자), 
# 학점, 시수, 전공 여부(전공 선택, 전공 필수, 교양 선택, 교양 필수), 교수 번호(FK)
CREATE TABLE IF NOT EXISTS lecture(
	le_num int primary key auto_increment, 
    le_title varchar(30) not null,
    le_major char(5) not null,
    le_room varchar(100),
    le_schedule varchar(50), 
    le_point int,
    le_time int,
    le_pr_num char(10),
    foreign key(le_pr_num) references professor(pr_num)
);
# 수강 테이블 삭제
DROP TABLE IF EXISTS course;
# course 테이블 추가
# 수강 번호(PK),중간, 기말, 과제, 학점, 출석, 학번(FK), 강의 번호(FK)
CREATE TABLE IF NOT EXISTS course(

);
# 연락처 테이블 삭제
DROP TABLE IF EXISTS contact;
# contact 테이블 추가
# 연락처 번호(PK), 주소(100자), 상세 주소(100자), 전화 번호(최대 13자)
CREATE TABLE IF NOT EXISTS contact(

);
