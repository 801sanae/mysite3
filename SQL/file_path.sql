drop table file_path;
drop sequence file_no_seq;

CREATE TABLE file_path
( 
no          NUMBER(8) not null,
path        VARCHAR2(200),
board_no    NUMBER(8)
);

ALTER TABLE file_path
ADD ( CONSTRAINT file_no_pk PRIMARY KEY ( no ) );

CREATE SEQUENCE file_no_seq
 START WITH     1
 INCREMENT BY   1
 MAXVALUE       99999999
 NOCACHE
 NOCYCLE;
 
 --select
 select * from file_path;
 
 --insert
 insert into file_path values(FILE_NO_SEQ.NEXTVAL,'abc',1);
 