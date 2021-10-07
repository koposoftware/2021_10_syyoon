select * from managerinfo;
-----------------------------------------------------------------------
-- 유저정보
-----------------------------------------------------------------------
select * from userinfo;
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('ryu94','0000','류영규','aaa@gmail.com','9412341555555','01012345578','12345','경기도 수원시 장안구 조원동','한일타운','U','N');
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('ann94','0000','안재훈','aaa@gmail.com','9412341555777','01012345676','12345','경기 성남시 분당구 판교역로 235','에이치스퀘어 엔동 8층','U','N');
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('goo95','0000','구본성','aaa@gmail.com','9512341555555','01012343678','12345','경기도 수원시 장안구 조원동','한일타운','U','N');
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('lee95','0000','이화정','aaa@gmail.com','9501342555555','01012445678','12345','경기 성남시 분당구 판교역로 235','한일타운','U','N');
insert into userinfo (id, password, name, email, rescode, tel, post, addr1, addr2, type, kakao_yn)
values('chu95','0000','추민경','aaa@gmail.com','9510341555555','01077345678','12345','경기도 수원시 장안구 조원동','에이치스퀘어 엔동 8층','U','N');
commit;

-----------------------------------------------------------------------
-- 주택 즐겨찾기
-----------------------------------------------------------------------
CREATE SEQUENCE SEQ_FAVSEQ;
CREATE TABLE FAVORITE
(
    ENROLLDT    DATE DEFAULT SYSDATE NOT NULL,
    ID          VARCHAR2(15) NOT NULL,
    HSMPSN      NUMBER(13) NOT NULL,
    FAVSEQ      NUMBER(20) NOT NULL
);

COMMENT ON COLUMN FAVORITE.ENROLLDT IS '추가날짜';
COMMENT ON COLUMN FAVORITE.ID IS '고객아이디';
COMMENT ON COLUMN FAVORITE.HSMPSN IS '주택코드';
COMMENT ON COLUMN FAVORITE.FAVSEQ IS '시퀀스';
COMMENT ON TABLE FAVORITE IS '주택즐겨찾기';
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
    VALUES('onehana', 'aaaa', '윤소영', 'soyo1228@naver.com', '9512284558789', '01078952121','12345','경기도 광명시 오리로 904','한국폴리텍대학 4층 데이터분석과','N');
 commit;
 
 -----------------------------------------------------------------------
 -- 공고즐겨찾기
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

COMMENT ON COLUMN FAVORITENTICE.ENROLLDT IS '추가날짜';
COMMENT ON COLUMN FAVORITENTICE.ID IS '고객아이디';
COMMENT ON COLUMN FAVORITENTICE.NOTICECODE IS '공고코드';
COMMENT ON COLUMN FAVORITENTICE.FAVNOTISEQ IS '시퀀스';
COMMENT ON COLUMN FAVORITENTICE.NOTICEEND IS '공고마감일';
COMMENT ON COLUMN FAVORITENTICE.NOTICETITLE IS '공고제목';
COMMENT ON TABLE FAVORITENTICE IS '공고즐겨찾기';

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
-- 대출상품코드
-----------------------------------------------------------------------
select name, changedt, baserate, addrate, finalrate from hana_loan where name='하나 청년전세론';
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

COMMENT ON COLUMN HANA_LOAN.CODE IS '상품코드';
COMMENT ON COLUMN HANA_LOAN.NAME IS '상품명';
COMMENT ON COLUMN HANA_LOAN.TYPE IS '상품유형';
COMMENT ON COLUMN HANA_LOAN.LINK IS '상세정보링크';
COMMENT ON COLUMN HANA_LOAN.CHANGEDT IS '금리변동주기';
COMMENT ON COLUMN HANA_LOAN.BASERATE IS '기준금리';
COMMENT ON COLUMN HANA_LOAN.ADDRATE IS '가산금리';
COMMENT ON COLUMN HANA_LOAN.FINALRATE IS '최종금리';
COMMENT ON TABLE HANA_LOAN IS '하나상품코드';
ALTER TABLE HANA_LOAN
 ADD CONSTRAINT 엔터티1_PK7 PRIMARY KEY ( CODE );
 
 INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK)
    VALUES('A','하나원큐신용대출','신용대출','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080204/1462446_115200.jsp?_menuNo=98786');
 INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK)
    VALUES('B','하나 전세금안심대출','전세대출','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080204/1462446_115200.jsp?_menuNo=98786');
 INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK,CHANGEDT,BASERATE,ADDRATE,FINALRATE)
    VALUES('C','하나 청년전세론','전세대출','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080201/1462744_115194.jsp?_menuNo=98786','6개월','0.880','1.04','1.920');
 INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK)
    VALUES('D','신혼부부전세론','전세대출','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080204/1462446_115200.jsp?_menuNo=98786');
INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK,CHANGEDT, BASERATE, ADDRATE, FINALRATE)
    VALUES('E','우량주택전세론','전세대출','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080201/1420276_115194.jsp?_menuNo=98786','6개월', '1.118','3.110','3,328~4.4228');
INSERT INTO HANA_LOAN(CODE,NAME,TYPE,LINK)
    VALUES('K','Young하나통장','일반예금','https://www.kebhana.com/cont/mall/mall08/mall0802/mall080204/1462446_115200.jsp?_menuNo=98786');

COMMIT;
select * from hana_loan;




-----------------------------------------------------------------------
-- 계약로그데이블
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

COMMENT ON COLUMN LOANCONTRACT.USERID IS '고객아이디';
COMMENT ON COLUMN LOANCONTRACT.CONTRACTCODE IS '계약코드';
COMMENT ON COLUMN LOANCONTRACT.MANAGERID IS '상담원아이디';
COMMENT ON COLUMN LOANCONTRACT.STRATDT IS '계약시작일';
COMMENT ON COLUMN LOANCONTRACT.LOANCODE IS '상품코드';
COMMENT ON COLUMN LOANCONTRACT.PRINCIPAL IS '원금';
COMMENT ON TABLE LOANCONTRACT IS '대출계약';

ALTER TABLE LOANCONTRACT
 ADD CONSTRAINT 엔터티1_PK8 PRIMARY KEY ( CONTRACTCODE );

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
-- 대출파일테이블
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

COMMENT ON COLUMN LOANFILE.NO IS '파일번호';
COMMENT ON COLUMN LOANFILE.ENROLLDT IS '업로드일시';
COMMENT ON COLUMN LOANFILE.FILE_ORI_NAME IS '파일원본명';
COMMENT ON COLUMN LOANFILE.FILE_SAVE_NAME IS '파일저장명';
COMMENT ON COLUMN LOANFILE.FILESIZE IS '파일사이즈';
COMMENT ON COLUMN LOANFILE.CONTRACTCODE IS '계약코드';
COMMENT ON TABLE LOANFILE IS '대출심사파일';

ALTER TABLE LOANFILE
 ADD CONSTRAINT primarykey_fileno PRIMARY KEY ( NO );
alter table loanfile
    add constraint foreignkey_contractcode foreign key(contractcode) references LOANCONTRACT(contractcode);
    
--INSERT INTO LOANFILE(NO,FILE_ORI_NAME,FILE_SAVE_NAME,FILESIZE,CONTRACTCODE)
--    VALUES(seq_loanfile.nextval,'ddd','aaa',10.3,1);
select * from loanfile;

-----------------------------------------------------------------------
-- 대출 진행 이력
-----------------------------------------------------------------------
create sequence loanseq;
CREATE TABLE LOANRECORD
(
    LOANSEQ    NUMBER(20) NOT NULL,
    STATUS    varchar2(100) NOT NULL,
    CONTRACTDT    DATE DEFAULT SYSDATE NOT NULL,
    CONTRACTCODE    NUMBER(20) NOT NULL
);

COMMENT ON COLUMN LOANRECORD.LOANSEQ IS '시퀀스';
COMMENT ON COLUMN LOANRECORD.STATUS IS '계약단계';
COMMENT ON COLUMN LOANRECORD.CONTRACTDT IS '날짜';
COMMENT ON COLUMN LOANRECORD.CONTRACTCODE IS '계약코드';
COMMENT ON TABLE LOANRECORD IS '대출진행이력';

ALTER TABLE LOANRECORD
 ADD CONSTRAINT 엔터티1_PK6 PRIMARY KEY ( LOANSEQ );
alter table LOANRECORD
    add constraint foreignkey_contractcode2 foreign key(contractcode) references LOANCONTRACT(contractcode);

select * from loancontract;
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'심사중',22);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'심사중',23);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'대출거절',25);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'심사중',23);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'심사중',26);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'대출거절',28);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'대출거절',27);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'대출승인',29);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'대출승인',30);
INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
    VALUES(loanseq.nextval,'심사중',31);

commit;

select * from loanrecord;
select * from loancontract;
select * from hana_loan;



-----------------------------------------------------------------------
-- 최신상태 가져오기(관리자)
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
-- 내 진행상황 보기(사용자)
select * from
(
    select h.name as loanname, r.status, r.CONTRACTDT, row_number() over(partition by c.contractcode order by loanseq desc) as rowidx
    from loancontract c, loanrecord r , hana_loan h
    where c.contractcode = r.contractcode and c.loancode = h.code and c.userid='onehana'
)a
where rowidx=1;
select * from loancontract;
select * from loanfile;

-- 대출심사상세페이지
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
-- 계좌테이블
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

COMMENT ON COLUMN USERACCOUNT.ACCOUNT IS '계좌번호';
COMMENT ON COLUMN USERACCOUNT.BALANCE IS '잔액';
COMMENT ON COLUMN USERACCOUNT.CODE IS '상품코드';
COMMENT ON COLUMN USERACCOUNT.ALIAS IS '계좌별칭';
COMMENT ON COLUMN USERACCOUNT.ID IS '고객아이디';
COMMENT ON COLUMN USERACCOUNT.enrolldt IS '개설일';
COMMENT ON TABLE USERACCOUNT IS '고객계좌';
select * from useraccount;
ALTER TABLE USERACCOUNT
 ADD CONSTRAINT 엔터티1_PK3 PRIMARY KEY ( ACCOUNT );
 alter table USERACCOUNT
    add constraint foreignkey_userid foreign key(id) references userinfo(id);
select * from useraccount;
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('2222222222456',90800,'K','생활비','onehana');
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('2222789406457',908000,'K','공과금','onehana');
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('8888456745602',2300000,'K','여행계모임','onehana');
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('6666789130548',1990800,'K','목돈마련','onehana');
INSERT INTO USERACCOUNT(ACCOUNT,BALANCE,CODE,ALIAS,ID)
    VALUES('7894567201478',190800,'K','대출이자','onehana');
commit;
select * from hana_loan;

update hana_loan set duedate = NULL where code = 'C';
update hana_loan set duedate = NULL where code = 'E';
ALTER TABLE hana_loan ADD ( duedate number(4));
ALTER TABLE HANA_LOAN MODIFY DUEDATE number(4);
update hana_loan set duedate = 1 where code = 'C';
update hana_loan set duedate = 3 where code = 'E';
commit;



-- 대출계좌 db
CREATE TABLE loanaccount
(
    LOANACCOUNT    VARCHAR2(14) NOT NULL,
    ACCOUNT    VARCHAR2(14) NOT NULL,
    CONTRACTCODE    NUMBER(20) NOT NULL,
    REPAYAMOUNT    NUMBER(20) DEFAULT 0 NOT NULL,
    ACCOUNTDT    DATE DEFAULT SYSDATE NOT NULL
);

COMMENT ON COLUMN loanaccount.LOANACCOUNT IS '대출계좌';
COMMENT ON COLUMN loanaccount.ACCOUNT IS '이자계좌';
COMMENT ON COLUMN loanaccount.CONTRACTCODE IS '계약코드';
COMMENT ON COLUMN loanaccount.REPAYAMOUNT IS '상환금액';
COMMENT ON COLUMN loanaccount.ACCOUNTDT IS '계좌생성일';
COMMENT ON TABLE loanaccount IS '대출계좌';
alter table loanaccount add (duedate date ); -- 만기일
alter table loanaccount modify duedate date default sysdate not null;
ALTER TABLE loanaccount
 ADD CONSTRAINT 엔터티1_PK10 PRIMARY KEY ( CONTRACTCODE );
alter table loanaccount
    add constraint fk_CONTRACTCODE foreign key(CONTRACTCODE) references loancontract(contractcode);  
SELECT * FROM LOANACCOUNT;
    
-- 계좌 정보 가져오기
select u.id, u.account, u.balance, u.code, h.name, u.alias, to_char(u.enrolldt, 'YYYY-MM-DD') as enrolldt
from useraccount u, userinfo i, hana_loan h
where i.id=u.id and h.code = u.code and u.id = 'onehana';

-- 해당 대출금액, 이율, 만기일, 기산일, 
select * from LOANCONTRACT;

select l.name, c.principal, l.finalrate
from loancontract c, hana_loan l
where c.loancode = l.code and c.contractcode = 39;
-----------------------------------------------------------------------
-- 파일 업로드시 대출 로그저장 프로시저
-----------------------------------------------------------------------
SET SERVEROUTPUT ON
CREATE OR REPLACE function LOANCONTRACT_LOG(
    V_USERID            IN VARCHAR2, -- 유저아이디
    V_MANAGER_ID        IN VARCHAR2, -- 담당자아이디
    V_LOANNAME          IN VARCHAR2, -- 대출상품명
    V_PRINCIPAL         IN NUMBER    -- 대출 한도

) RETURN LOANCONTRACT.CONTRACTCODE%TYPE
IS
    CONTRACT_SEQ LOANCONTRACT.CONTRACTCODE%TYPE;
pragma autonomous_transaction;
BEGIN
    CONTRACT_SEQ   := seq_loancontract.nextval;
    -- 계약시작
    INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE,PRINCIPAL)
        VALUES(V_USERID, CONTRACT_SEQ,V_MANAGER_ID,(select code from hana_loan where name=V_LOANNAME), V_PRINCIPAL );
    -- 심사중으로 상태 추가
    INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
        VALUES(loanseq.nextval,'심사중',CONTRACT_SEQ);
    COMMIT;
    RETURN CONTRACT_SEQ;
    
    EXCEPTION
        WHEN OTHERS THEN
        rollback;  

 END;
/
select * from all_errors where name='LOANCONTRACT_LOG';
exec LOANCONTRACT_LOG('1817729777','admin2','하나 전세금안심대출',123);
select * from loancontract;
SELECT * FROM LOANRECORD;
select * from loanfile;
DELETE FROM LOANRECORD WHERE CONTRACTCODE=38;
DELETE FROM loancontract WHERE USERID='1817729777';
COMMIT;

select LOANCONTRACT_LOG('1817729777','admin2','하나 전세금안심대출',123) from dual;
SELECT l.duedate 
FROM LOANCONTRACT C, hana_loan l 
WHERE c.loancode = l.code and C.CONTRACTCODE=39;

SELECT ADD_MONTHS(SYSDATE, (1*12)) FROM DUAL;

-- 대출신청 후 로그 생성
select * from all_errors where name='FINISH_CONTRACT';
CREATE OR REPLACE PROCEDURE FINISH_CONTRACT(
    V_LOANACCOUNT   IN VARCHAR2,    -- 대출계좌
    V_ACCOUNT       IN VARCHAR2,    -- 이자계좌
    V_CONTRACTCODE  IN NUMBER,      -- 계약코드
    V_ACCOUNTDT     IN VARCHAR2      -- 기산일
)
IS 
    loansq  LOANRECORD.LOANSEQ%TYPE := loanseq.nextval;
    
    DUEDT   NUMBER;
                        
    DUES    DATE ;
BEGIN
    SELECT l.duedate INTO DUEDT FROM LOANCONTRACT C, HANA_LOAN L WHERE c.loancode = l.code and C.CONTRACTCODE = V_CONTRACTCODE;
    SELECT ADD_MONTHS(SYSDATE, (DUEDT*12) ) INTO DUES FROM DUAL;
    
    -- 대출 계좌 생성
    INSERT INTO loanaccount(LOANACCOUNT,ACCOUNT,CONTRACTCODE,ACCOUNTDT, DUEDATE)
    VALUES(V_LOANACCOUNT,V_ACCOUNT,V_CONTRACTCODE,V_ACCOUNTDT,DUES);
    
    -- 대출 상태 업데이트
    INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
   		 VALUES(loansq,'대출완료',V_CONTRACTCODE);
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
update loanrecord set status='심사중' where contractcode=28;
COMMIT;
-- 보유한 대출계좌
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

-- 파일 업로드시 대출 로그저장 프로시저
CREATE OR REPLACE PROCEDURE LOANCONTRACT_LOG(
    V_USERID            IN VARCHAR2, -- 유저아이디
    V_MANAGER_ID        IN VARCHAR2, -- 담당자아이디
    V_LOANNAME          IN VARCHAR2 -- 대출상품명
) IS
    CONTRACT_SEQ        LOANCONTRACT.CONTRACTCODE%TYPE      := seq_loancontract.nextval;   
BEGIN

    dbms_output.put_line(contract_seq);

    -- 계약시작
    INSERT INTO LOANCONTRACT(USERID,CONTRACTCODE,MANAGERID,LOANCODE)
        VALUES(V_USERID, CONTRACT_SEQ,V_MANAGER_ID,(select code from hana_loan where name=V_LOANNAME));
    -- 심사중으로 상태 추가
    INSERT INTO LOANRECORD(LOANSEQ,STATUS,CONTRACTCODE)
        VALUES(loanseq.nextval,'심사중',CONTRACT_SEQ);
    COMMIT;
    
    EXCEPTION
        WHEN OTHERS THEN
        rollback;  
 END;
/
exec LOANCONTRACT_LOG('1817729777','admin2','하나 전세금안심대출');

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




