drop database if exists student2;

create database if not exists student2;

use student2;

drop table if exists student2.student;

create table if not exists student2.student(
	st_key int primary key auto_increment,
	st_grade int not null,
    st_class int not null,
    st_num int not null,
    st_name varchar(20) not null
);

drop table if exists student2.subject;
CREATE TABLE if not exists student2.subject (
  su_key INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  su_grade INT NOT NULL DEFAULT 1,
  su_semester INT NOT NULL DEFAULT 1,
  su_name VARCHAR(10) NOT NULL
);
  
drop table if exists student2.score;
create table if not exists student2.score(
	sc_key int primary key auto_increment,
    sc_midTerm int not null default 0,
    sc_finalTerm int not null default 0,
    sc_performance int not null default 0,
    sc_st_key int not null,
    sc_su_key int not null,
    foreign key(sc_st_key) references student(st_key) 
		on delete cascade on update cascade,
    foreign key(sc_su_key) references subject(su_key) on delete cascade
);




