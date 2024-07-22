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
)