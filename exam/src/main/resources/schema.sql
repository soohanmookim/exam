drop table if exists grade CASCADE
drop table if exists student CASCADE
drop table if exists subject CASCADE
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table grade (id bigint not null, created_at timestamp, score integer default 0, updated_at timestamp, student_id bigint, subject_id bigint, primary key (id))
create table student (id bigint not null, average decimal(19,2) default 0, created_at timestamp, name varchar(32) not null, updated_at timestamp, primary key (id))
create table subject (id bigint not null, average decimal(19,2) default 0, created_at timestamp, name varchar(64) not null, updated_at timestamp, primary key (id))
-- alter table grade add constraint FK5secqnjjwgh9wxk4h1xwgj1n0 foreign key (student_id) references student
-- alter table grade add constraint FKhhw6hbmiyabjlm1jghr00m5d8 foreign key (subject_id) references subject