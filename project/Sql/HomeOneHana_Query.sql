select * from managerinfo;
-----------------------------------------------------------------------
-- ��������
-----------------------------------------------------------------------
select * from userinfo;
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('ryu94','0000','������','aaa@gmail.com','9412341555555','01012345578','12345','��⵵ ������ ��ȱ� ������','����Ÿ��','U','N');
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('ann94','0000','������','aaa@gmail.com','9412341555777','01012345676','12345','��� ������ �д籸 �Ǳ����� 235','����ġ������ ���� 8��','U','N');
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('goo95','0000','������','aaa@gmail.com','9512341555555','01012343678','12345','��⵵ ������ ��ȱ� ������','����Ÿ��','U','N');
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('lee95','0000','��ȭ��','aaa@gmail.com','9501342555555','01012445678','12345','��� ������ �д籸 �Ǳ����� 235','����Ÿ��','U','N');
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('chu95','0000','�߹ΰ�','aaa@gmail.com','9510341555555','01077345678','12345','��⵵ ������ ��ȱ� ������','����ġ������ ���� 8��','U','N');
commit;

-----------------------------------------------------------------------
-- ���� ���ã��
-----------------------------------------------------------------------
CREATE SEQUENCE SEQ_FAVSEQ;
CREATE TABLE FAVORITE
(
    ENROLLDT    DATE DEFAULT SYSDATE NOT NULL,
    ID          VARCHAR2(15) NOT NULL,
    HSMPSN      NUMBER(13) NOT NULL,
    FAVSEQ      NUMBER(20) NOT NULL
);

COMMENT ON COLUMN FAVORITE.ENROLLDT IS '�߰���¥';
COMMENT ON COLUMN FAVORITE.ID IS '�����̵�';
COMMENT ON COLUMN FAVORITE.HSMPSN IS '�����ڵ�';
COMMENT ON COLUMN FAVORITE.FAVSEQ IS '������';
COMMENT ON TABLE FAVORITE IS '�������ã��';
ALTER TABLE FAVORITE
 ADD CONSTRAINT FORIGN_FAVORITE_ID FOREIGN KEY ( ID )
 REFERENCES USERINFO (ID);
 ALTER TABLE FAVORITE
 ADD CONSTRAINT FAVORITE_ID_PK PRIMARY KEY ( FAVSEQ );
 
 select * from favorite;
 INSERT INTO FAVORITE(ENROLLDT,ID,HSMPSN,FAVSEQ)
    VALUES('','',0,SEQ_FAVSEQ.nextval);
delete from favorite where id='onehana' and hsmpsn=31125790;
commit;
desc homelist;
select * from homelist where brtccode=11 and signgucode=140;
select f.id, f.hsmpsn, to_char(f.enrolldt,'YYYY-MM-DD') as enrolldt, h.rnadres, h.suplytynm, h.housetynm, h.insttnm
from favorite f, homelist h
where f.hsmpsn = h.hsmpsn and f.id='onehana';
 
 
 SELECT * FROM USERINFO;
 INSERT INTO USERINFO(ID, PASSWORD, NAME, EMAIL, RESCODE, TEL, POST, ADDR1, ADDR2,KAKAO_YN)
    VALUES('onehana', 'aaaa', '���ҿ�', 'soyo1228@naver.com', '9512284558789', '01078952121','12345','��⵵ ����� ������ 904','�ѱ������ش��� 4�� �����ͺм���','N');
 commit;
 
 -----------------------------------------------------------------------
 -- �������ã��
 -----------------------------------------------------------------------
 CREATE SEQUENCE SEQ_NOTI_FAVSEQ;
 CREATE TABLE FAVORITENTICE
(
    ENROLLDT    DATE DEFAULT SYSDATE NOT NULL,
    ID    VARCHAR2(15) NOT NULL,
    NOTICECODE    VARCHAR2(100) NOT NULL,
    FAVNOTISEQ    NUMBER(20) NOT NULL,
    NOTICEEND    DATE NOT NULL,
    NOTICETITLE    VARCHAR2(500) NOT NULL
);

COMMENT ON COLUMN FAVORITENTICE.ENROLLDT IS '�߰���¥';
COMMENT ON COLUMN FAVORITENTICE.ID IS '�����̵�';
COMMENT ON COLUMN FAVORITENTICE.NOTICECODE IS '�����ڵ�';
COMMENT ON COLUMN FAVORITENTICE.FAVNOTISEQ IS '������';
COMMENT ON COLUMN FAVORITENTICE.NOTICEEND IS '��������';
COMMENT ON COLUMN FAVORITENTICE.NOTICETITLE IS '��������';
COMMENT ON TABLE FAVORITENTICE IS '�������ã��';

select * from FAVORITENTICE;
select to_char(enrolldt,'YYYY-MM-DD') as enrolldt, id, noticecode, 
    to_char(noticeend,'YYYY-MM-DD') as noticeend, noticetitle
from favoritentice
where id='onehana' and noticeend>sysdate;

ALTER TABLE FAVORITENTICE
 ADD CONSTRAINT FORIGN_FAVORITENTICE_ID FOREIGN KEY ( ID )
 REFERENCES USERINFO (ID);
ALTER TABLE FAVORITENTICE
 ADD CONSTRAINT FAVORITENTICE_ID_PK PRIMARY KEY ( FAVNOTISEQ );

insert into favoritentice(id, noticecode, favnotiseq, noticeend, noticetitle)
    values('', SEQ_NOTI_FAVSEQ.nextval, '', '');
delete from favoritentice where id='onehana' and noticecode='062-03-2015122300009566-null-SIL::CLCC_SIL_0060.xfdl-1010203';
commit;

select * from favoritentice ;



-----------------------------------------------------------------------
-- �����ǰ�ڵ�
-----------------------------------------------------------------------
select name, changedt, baserate, addrate, finalrate from hana_loan where name='�ϳ� û��������';
CREATE TABLE HANA_LOAN
(
    CODE    VARCHAR2(30) NOT NULL,
    NAME    VARCHAR2(100) NOT NULL,
    TYPE    VARCHAR2(30) NOT NULL,
    LINK    VARCHAR2(1000) NOT NULL,
    CHANGEDT    VARCHAR2(100),
    BASERATE    VARCHAR2(50),
    ADDRATE    VARCHAR2(50),
    FINALRATE    VARCHAR2(50)
);

COMMENT ON COLUMN HANA_LOAN.CODE IS '��ǰ�ڵ�';
COMMENT ON COLUMN HANA_LOAN.NAME IS '��ǰ��';
COMMENT ON COLUMN HANA_LOAN.TYPE IS '��ǰ����';
COMMENT ON COLUMN HANA_LOAN.LINK IS '��������ũ';
COMMENT ON COLUMN HANA_LOAN.CHANGEDT IS '�ݸ������ֱ�';
COMMENT ON COLUMN HANA_LOAN.BASERATE IS '���رݸ�';
COMMENT ON COLUMN HANA_LOAN.ADDRATE IS '����ݸ�';
COMMENT ON COLUMN HANA_LOAN.FINALRATE IS '�����ݸ�';
COMMENT ON TABLE HANA_LOAN IS '�ϳ���ǰ�ڵ�';
ALTER TABLE HANA_LOAN
 ADD CONSTRAINT ����Ƽ1_PK7 PRIMARY KEY ( CODE );
 
 INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK)
    VALUES('A','�ϳ���ť�ſ����','�ſ����','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080204/1462446_115200.jsp?_menuNo=98786');
 INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK)
    VALUES('B','�ϳ� �����ݾȽɴ���','��������','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080204/1462446_115200.jsp?_menuNo=98786');
 INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK,CHANGEDT,BASERATE,ADDRATE,FINALRATE)
    VALUES('C','�ϳ� û��������','��������','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080201/1462744_115194.jsp?_menuNo=98786','6����','0.880','1.04','1.920');
 INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK)
    VALUES('D','��ȥ�κ�������','��������','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080204/1462446_115200.jsp?_menuNo=98786');
INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK,CHANGEDT, BASERATE, ADDRATE, FINALRATE)
    VALUES('E','�췮����������','��������','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080201/1420276_115194.jsp?_menuNo=98786','6����', '1.118','3.110','3,328~4.4228');
INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK)
    VALUES('K','Young�ϳ�����','�Ϲݿ���','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080204/1462446_115200.jsp?_menuNo=98786');

COMMIT;
select * from hana_loan;




-----------------------------------------------------------------------
-- ���α׵��̺�
-----------------------------------------------------------------------
create sequence seq_loancontract;
CREATE TABLE LOANCONTRACT
(
    USERID    VARCHAR2(15) NOT NULL,
    CONTRACTCODE    NUMBER(20) NOT NULL,
    MANAGERID    VARCHAR2(15) NOT NULL,
    STRATDT    DATE DEFAULT SYSDATE NOT NULL,
    LOANCODE    VARCHAR2(30) NOT NULL,
    PRINCIPAL    NUMBER(20) NOT NULL
);

COMMENT ON COLUMN LOANCONTRACT.USERID IS '�����̵�';
COMMENT ON COLUMN LOANCONTRACT.CONTRACTCODE IS '����ڵ�';
COMMENT ON COLUMN LOANCONTRACT.MANAGERID IS '�������̵�';
COMMENT ON COLUMN LOANCONTRACT.STRATDT IS '��������';
COMMENT ON COLUMN LOANCONTRACT.LOANCODE IS '��ǰ�ڵ�';
COMMENT ON COLUMN LOANCONTRACT.PRINCIPAL IS '����';
COMMENT ON TABLE LOANCONTRACT IS '������';

ALTER TABLE LOANCONTRACT
 ADD CONSTRAINT ����Ƽ1_PK8 PRIMARY KEY ( CONTRACTCODE );

INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('onehana',seq_loancontract.nextval,'admin1','C',150000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('onehana',seq_loancontract.nextval,'admin1','E',45000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('sjin',seq_loancontract.nextval,'admin1','A',15000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('hseok',seq_loancontract.nextval,'admin1','B',50000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('ryu94',seq_loancontract.nextval,'admin1','B',150000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('ann94',seq_loancontract.nextval,'admin1','B',250000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('goo95',seq_loancontract.nextval,'admin1','D',350000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('lee95',seq_loancontract.nextval,'admin1','A',15000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('chu95',seq_loancontract.nextval,'admin1','A',150000000);
INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
    VALUES('test',seq_loancontract.nextval,'admin1','D',170000000);
commit;

select * from LOANCONTRACT;

-----------------------------------------------------------------------
-- �����������̺�
-----------------------------------------------------------------------
create sequence seq_loanfile;
CREATE TABLE LOANFILE
(
    NO    NUMBER(38) NOT NULL,
    ENROLLDT    DATE default sysdate NOT NULL,
    FILE_ORI_NAME    VARCHAR2(500) NOT NULL,
    FILE_SAVE_NAME    VARCHAR2(500) NOT NULL,
    FILESIZE    NUMBER NOT NULL,
    CONTRACTCODE    NUMBER(20) NOT NULL
);

COMMENT ON COLUMN LOANFILE.NO IS '���Ϲ�ȣ';
COMMENT ON COLUMN LOANFILE.ENROLLDT IS '���ε��Ͻ�';
COMMENT ON COLUMN LOANFILE.FILE_ORI_NAME IS '���Ͽ�����';
COMMENT ON COLUMN LOANFILE.FILE_SAVE_NAME IS '���������';
COMMENT ON COLUMN LOANFILE.FILESIZE IS '���ϻ�����';
COMMENT ON COLUMN LOANFILE.CONTRACTCODE IS '����ڵ�';
COMMENT ON TABLE LOANFILE IS '����ɻ�����';

ALTER TABLE LOANFILE
 ADD CONSTRAINT primarykey_fileno PRIMARY KEY ( NO );
alter table loanfile
    add constraint foreignkey_contractcode foreign key(contractcode) references LOANCONTRACT(contractcode);
    
--INSERT INTO LOANFILE(NO,FILE_ORI_NAME,FILE_SAVE_NAME,FILESIZE,CONTRACTCODE)
--    VALUES(seq_loanfile.nextval,'ddd','aaa',10.3,1);
select * from loanfile;

-----------------------------------------------------------------------
-- ���� ���� �̷�
-----------------------------------------------------------------------
create sequence loanseq;
CREATE TABLE LOANRECORD
(
    LOANSEQ    NUMBER(20) NOT NULL,
    STATUS    varchar2(100) NOT NULL,
    CONTRACTDT    DATE DEFAULT SYSDATE NOT NULL,
    CONTRACTCODE    NUMBER(20) NOT NULL
);

COMMENT ON COLUMN LOANRECORD.LOANSEQ IS '������';
COMMENT ON COLUMN LOANRECORD.STATUS IS '���ܰ�';
COMMENT ON COLUMN LOANRECORD.CONTRACTDT IS '��¥';
COMMENT ON COLUMN LOANRECORD.CONTRACTCODE IS '����ڵ�';
COMMENT ON TABLE LOANRECORD IS '���������̷�';

ALTER TABLE LOANRECORD
 ADD CONSTRAINT ����Ƽ1_PK6 PRIMARY KEY ( LOANSEQ );
alter table LOANRECORD
    add constraint foreignkey_contractcode2 foreign key(contractcode) references LOANCONTRACT(contractcode);

select * from loancontract;
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�ɻ���',22);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�ɻ���',23);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�������',25);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�ɻ���',23);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�ɻ���',26);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�������',28);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�������',27);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�������',29);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�������',30);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'�ɻ���',31);

commit;

select * from loanrecord;
select * from loancontract;
select * from hana_loan;



-----------------------------------------------------------------------
-- �ֽŻ��� ��������(������)
select c.userid, u.name , h.name as loanname, r.status, r.CONTRACTDT
from loancontract c, loanrecord r , hana_loan h, userinfo u
where c.contractcode = r.contractcode and c.loancode = h.code and u.id = c.userid and c.managerid = 'admin1'
order by r.contractdt desc;
select * from loanrecord;


select contractcode, userid, name, loanname, status, to_char(CONTRACTDT,'YYYY-MM-DD') as contractdt
from(
    select c.contractcode, c.userid, u.name , h.name as loanname, r.status, r.CONTRACTDT, 
            row_number() over(partition by c.contractcode order by loanseq desc) as rowidx
    from loancontract c, loanrecord r , hana_loan h, userinfo u
    where c.contractcode = r.contractcode and c.loancode = h.code and u.id = c.userid and c.managerid = 'admin1'
) a
where rowidx=1;



select contractcode, userid, name, loanname, status, to_char(CONTRACTDT,'YYYY-MM-DD') as contractdt
		from(
		    select c.contractcode, c.userid, u.name , h.name as loanname, r.status, r.CONTRACTDT, 
		            row_number() over(partition by c.contractcode order by loanseq desc) as rowidx
		    from loancontract c, loanrecord r , hana_loan h, userinfo u
		    where c.contractcode = r.contractcode and c.loancode = h.code and u.id = c.userid and c.managerid ='admin1'
		) a
		where rowidx=1
   order by contractcode desc ;
-- �� �����Ȳ ����(�����)
select * from
(
    select h.name as loanname, r.status, r.CONTRACTDT, row_number() over(partition by c.contractcode order by loanseq desc) as rowidx
    from loancontract c, loanrecord r , hana_loan h
    where c.contractcode = r.contractcode and c.loancode = h.code and c.userid='onehana'
)a
where rowidx=1;
select * from loancontract;
select * from loanfile;

-- ����ɻ��������
select to_char(enrolldt, 'YYYY-MM-DD') as enrolldt, file_ori_name, file_save_name, filesize
from loanfile
where contractcode=1;


select loanname, status, contractdt, stratdt
from(
 select c.contractcode, c.stratdt, r.loanseq, h.name as loanname, r.status, r.CONTRACTDT
    ,row_number() over(partition by c.contractcode order by r.loanseq desc) as rowidx
    from loancontract c, loanrecord r , hana_loan h
    where c.contractcode = r.contractcode and c.loancode = h.code and c.userid='onehana'
)
where rowidx=1;
select * from loanfile;
select * from loanrecord;

-----------------------------------------------------------------------
-- �������̺�
-----------------------------------------------------------------------
CREATE TABLE USERACCOUNT
(
    ACCOUNT    VARCHAR2(14) NOT NULL,
    BALANCE    NUMBER NOT NULL,
    CODE    VARCHAR2(50) NOT NULL,
    ALIAS    VARCHAR2(20),
    ID    VARCHAR2(15) NOT NULL,
    ENROLLDT DATE DEFAULT SYSDATE NOT NULL
);

COMMENT ON COLUMN USERACCOUNT.ACCOUNT IS '���¹�ȣ';
COMMENT ON COLUMN USERACCOUNT.BALANCE IS '�ܾ�';
COMMENT ON COLUMN USERACCOUNT.CODE IS '��ǰ�ڵ�';
COMMENT ON COLUMN USERACCOUNT.ALIAS IS '���º�Ī';
COMMENT ON COLUMN USERACCOUNT.ID IS '�����̵�';
COMMENT ON COLUMN USERACCOUNT.enrolldt IS '������';
COMMENT ON TABLE USERACCOUNT IS '������';
select * from useraccount;
ALTER TABLE USERACCOUNT
 ADD CONSTRAINT ����Ƽ1_PK3 PRIMARY KEY ( ACCOUNT );
 alter table USERACCOUNT
    add constraint foreignkey_userid foreign key(id) references userinfo(id);
select * from useraccount;
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('2222222222456',90800,'K','��Ȱ��','onehana');
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('2222789406457',908000,'K','������','onehana');
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('8888456745602',2300000,'K','��������','onehana');
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('6666789130548',1990800,'K','�񵷸���','onehana');
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('7894567201478',190800,'K','��������','onehana');
commit;
select * from hana_loan;

update hana_loan set duedate = NULL where code = 'C';
update hana_loan set duedate = NULL where code = 'E';
ALTER TABLE hana_loan ADD ( duedate number(4));
ALTER TABLE HANA_LOAN MODIFY DUEDATE number(4);
update hana_loan set duedate = 1 where code = 'C';
update hana_loan set duedate = 3 where code = 'E';
commit;



-- ������� db
CREATE TABLE loanaccount
(
    LOANACCOUNT    VARCHAR2(14) NOT NULL,
    ACCOUNT    VARCHAR2(14) NOT NULL,
    CONTRACTCODE    NUMBER(20) NOT NULL,
    REPAYAMOUNT    NUMBER(20) DEFAULT 0 NOT NULL,
    ACCOUNTDT    DATE DEFAULT SYSDATE NOT NULL
);

COMMENT ON COLUMN loanaccount.LOANACCOUNT IS '�������';
COMMENT ON COLUMN loanaccount.ACCOUNT IS '���ڰ���';
COMMENT ON COLUMN loanaccount.CONTRACTCODE IS '����ڵ�';
COMMENT ON COLUMN loanaccount.REPAYAMOUNT IS '��ȯ�ݾ�';
COMMENT ON COLUMN loanaccount.ACCOUNTDT IS '���»�����';
COMMENT ON TABLE loanaccount IS '�������';
alter table loanaccount add (duedate date ); -- ������
alter table loanaccount modify duedate date default sysdate not null;
ALTER TABLE loanaccount
 ADD CONSTRAINT ����Ƽ1_PK10 PRIMARY KEY ( CONTRACTCODE );
alter table loanaccount
    add constraint fk_CONTRACTCODE foreign key(CONTRACTCODE) references loancontract(contractcode);  
SELECT * FROM LOANACCOUNT;
    
-- ���� ���� ��������
select u.id, u.account, u.balance, u.code, h.name, u.alias, to_char(u.enrolldt, 'YYYY-MM-DD') as enrolldt
from useraccount u, userinfo i, hana_loan h
where i.id=u.id and h.code = u.code and u.id = 'onehana';

-- �ش� ����ݾ�, ����, ������, �����, 
select * from LOANCONTRACT;

select l.name, c.principal, l.finalrate
from loancontract c, hana_loan l
where c.loancode = l.code and c.contractcode = 39;
-----------------------------------------------------------------------
-- ���� ���ε�� ���� �α����� ���ν���
-----------------------------------------------------------------------
SET SERVEROUTPUT ON
CREATE OR REPLACE function LOANCONTRACT_LOG(
    V_USERID            IN VARCHAR2, -- �������̵�
    V_MANAGER_ID        IN VARCHAR2, -- ����ھ��̵�
    V_LOANNAME          IN VARCHAR2, -- �����ǰ��
    V_PRINCIPAL         IN NUMBER    -- ���� �ѵ�

) RETURN LOANCONTRACT.CONTRACTCODE%TYPE
IS
    CONTRACT_SEQ LOANCONTRACT.CONTRACTCODE%TYPE;
pragma autonomous_transaction;
BEGIN
    CONTRACT_SEQ   := seq_loancontract.nextval;
    -- ������
    INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
        VALUES(V_USERID, CONTRACT_SEQ,V_MANAGER_ID,(select code from hana_loan where name=V_LOANNAME), V_PRINCIPAL );
    -- �ɻ������� ���� �߰�
    INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
        VALUES(loanseq.nextval,'�ɻ���',CONTRACT_SEQ);
    COMMIT;
    RETURN CONTRACT_SEQ;
    
    EXCEPTION
        WHEN OTHERS THEN
        rollback;  

 END;
/
select * from all_errors where name='LOANCONTRACT_LOG';
exec LOANCONTRACT_LOG('1817729777','admin2','�ϳ� �����ݾȽɴ���',123);
select * from loancontract;
SELECT * FROM LOANRECORD;
select * from loanfile;
DELETE FROM LOANRECORD WHERE CONTRACTCODE=38;
DELETE FROM loancontract WHERE USERID='1817729777';
COMMIT;

select LOANCONTRACT_LOG('1817729777','admin2','�ϳ� �����ݾȽɴ���',123) from dual;
SELECT l.duedate 
FROM LOANCONTRACT C, hana_loan l 
WHERE c.loancode = l.code and C.CONTRACTCODE=39;

SELECT ADD_MONTHS(SYSDATE, (1*12)) FROM DUAL;

-- �����û �� �α� ����
select * from all_errors where name='FINISH_CONTRACT';
CREATE OR REPLACE PROCEDURE FINISH_CONTRACT(
    V_LOANACCOUNT   IN VARCHAR2,    -- �������
    V_ACCOUNT       IN VARCHAR2,    -- ���ڰ���
    V_CONTRACTCODE  IN NUMBER,      -- ����ڵ�
    V_ACCOUNTDT     IN VARCHAR2      -- �����
)
IS 
    loansq  LOANRECORD.LOANSEQ%TYPE := loanseq.nextval;
    
    DUEDT   NUMBER;
                        
    DUES    DATE ;
BEGIN
    SELECT l.duedate INTO DUEDT FROM LOANCONTRACT C, HANA_LOAN L WHERE c.loancode = l.code and C.CONTRACTCODE = V_CONTRACTCODE;
    SELECT ADD_MONTHS(SYSDATE, (DUEDT*12) ) INTO DUES FROM DUAL;
    
    -- ���� ���� ����
    INSERT INTO loanaccount(LOANACCOUNT,ACCOUNT,CONTRACTCODE,ACCOUNTDT, DUEDATE)
    VALUES(V_LOANACCOUNT,V_ACCOUNT,V_CONTRACTCODE,V_ACCOUNTDT,DUES);
    
    -- ���� ���� ������Ʈ
    INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
   		 VALUES(loansq,'����Ϸ�',V_CONTRACTCODE);
    COMMIT;
    
    EXCEPTION
        WHEN OTHERS THEN
        rollback;  

 END;
/

--exec FINISH_CONTRACT( '1234', '1111', 28, '2021-09-25');
select * from loanaccount;
select * from hana_loan;
select * from LOANRECORD;
select * from LOANcontract;
select * from loanfile;
TRUNCATE TABLE LOANACCOUNT;
delete from loanfile where contractcode=39;
DELETE FROM LOANRECORD WHERE contractcode=23;
DELETE FROM LOANRECORD WHERE contractcode=39;
delete from loancontract where contractcode=23;
delete from loancontract where contractcode=39;
update loanrecord set status='�ɻ���' where contractcode=28;
COMMIT;
-- ������ �������
select a.loanaccount, l.name as loanname,l.finalrate, 
        c.principal, a.REPAYAMOUNT, a.account, u.alias, 
        to_char(a.accountdt,'YYYY-MM-DD') as accountdt, A.DUEDATE
from loanaccount a, loancontract c, hana_loan l, useraccount u
where a.contractcode = c.contractcode and l.code = c.loancode 
    and u.account=a.account and c.userid='onehana';



select l.name as loanname, c.principal, l.finalrate, l.duedate
		from loancontract c, hana_loan l
		where c.loancode = l.code and c.contractcode = 39;
        
        
        
        
SELECT * FROM LOANCONTRACT;
SELECT * FROM LOANFILE;
SELECT * FROM LOANRECORD;
SELECT * FROM HANA_LOAN;

-- ���� ���ε�� ���� �α����� ���ν���
CREATE OR REPLACE PROCEDURE LOANCONTRACT_LOG(
    V_USERID            IN VARCHAR2, -- �������̵�
    V_MANAGER_ID        IN VARCHAR2, -- ����ھ��̵�
    V_LOANNAME          IN VARCHAR2 -- �����ǰ��
) IS
    CONTRACT_SEQ        LOANCONTRACT.CONTRACTCODE%TYPE      := seq_loancontract.nextval;   
BEGIN

    dbms_output.put_line(contract_seq);

    -- ������
    INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE)
        VALUES(V_USERID, CONTRACT_SEQ,V_MANAGER_ID,(select code from hana_loan where name=V_LOANNAME));
    -- �ɻ������� ���� �߰�
    INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
        VALUES(loanseq.nextval,'�ɻ���',CONTRACT_SEQ);
    COMMIT;
    
    EXCEPTION
        WHEN OTHERS THEN
        rollback;  
 END;
/
exec LOANCONTRACT_LOG('1817729777','admin2','�ϳ� �����ݾȽɴ���');

select * from metahomedetail;

desc homedetail;




CREATE TABLE HOMELIST
(
    INSTTNM    VARCHAR2(100) NOT NULL,
    COMPETDE    VARCHAR2(50) NOT NULL,
    HOUSETYNM    VARCHAR2(50) NOT NULL,
    SUPLYTYNM    VARCHAR2(50) NOT NULL,
    BULDSTLENM    VARCHAR2(50) DEFAULT '0' NOT NULL,
    ELVTRINSTLATNM    VARCHAR2(50) DEFAULT '0' NOT NULL,
    BRTCCODE    NUMBER(5) NOT NULL,
    SIGNGUCODE    NUMBER(5) NOT NULL,
    PARKNGCO    NUMBER(10) DEFAULT 0 NOT NULL,
    HSMPSN    NUMBER(13) NOT NULL,
    HSMPNM    VARCHAR2(100) NOT NULL,
    HSHLDCO    NUMBER(5) NOT NULL,
    HEATMTHDDETAILNM    VARCHAR2(50) NOT NULL,
    RNADRES    VARCHAR2(500) NOT NULL,
    LATI    VARCHAR2(40) NOT NULL,
    LONGS    VARCHAR2(40) NOT NULL
);

select * from metahomelist;
DESC METAHOME;

CREATE TABLE HOMEDETAIL
(
    STYLENM    VARCHAR2(50) NOT NULL,
    SUPLYPRVUSEAR    VARCHAR2(50) NOT NULL,
    SUPLYCMNUSEAR    VARCHAR2(50) NOT NULL,
    BASSRENTGTN    NUMBER(20) NOT NULL,
    BASSMTRNTCHRG    NUMBER(20) NOT NULL,
    BASSCNVRSGTNLMT    NUMBER(20) NOT NULL,
    HSMPSN    NUMBER(13) NOT NULL
);




