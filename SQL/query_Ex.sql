--board

--select
select * from BOARD;
select * from member;

--delete
delete FROM BOARD WHERE NO=12;
delete from member where no=4 and password='1234';

 --update
 UPDATE BOARD SET ORDER_NO = ORDER_NO +1 WHERE GROUP_NO = 1 and ORDER_NO >= 2;
 
 --insert & reply
 insert into board values(BOARD_NO_SEQ.NEXTVAL,'abc','abc',14,0,SYSDATE,BOARD_NO_SEQ.CURRVAL,1,0);
 
 insert into board values(1,'ddd','ddd',14,0,1,2,1);


--file_path
--select
 
 --insert
 
 --select
 