CREATE table MYDEPT ( 
		DEPT_NO CHAR(8),
        DEPT_NAME VARCHAR(100) NOT NULL, 
        DEPT_LOC VARCHAR(100) NOT NULL, 
        DEPT_TEL_NO VARCHAR(100) NOT NULL 
/*		PRIMARY KEY (DEPT_NO) */
        );
alter table MYDEPT add constraint DEPT_PK primary key (DEPT_NO);
INSERT INTO MYDEPT(DEPT_NO, DEPT_NAME, DEPT_LOC , DEPT_TEL_NO) VALUES
('10', 'SALES', 'SEOUL','02-671-1111'),
('20', 'FINANCE', 'SEOUL','02-862-2222'),
('30', 'HR', 'BUSAN','051-111-1111'),
('40', 'PURCHASE', 'BUSAN','051-222-2222'),
('50', 'MANAGEMENT', 'SEOUL','02-383-3333');
        
 CREATE table MYEMP( 
		EMP_NO VARCHAR(8),
        EMP_NAME VARCHAR(100) NOT NULL, 
        EMP_MGE VARCHAR(100) NOT NULL, 
        HIREDATE VARCHAR(100) NOT NULL,
        SAL VARCHAR(100) NOT NULL,
        DEPT_NO CHAR(8) NOT NULL
/*		PRIMARY KEY (DEPT_NO) */
        );      
alter table MYEMP add constraint EMP_PK primary key (EMP_NO);
alter table MYEMP add constraint EMP_FK foreign key (DEPT_NO) references MYDEPT(DEPT_NO);
select *from MYEMP;
select *from MYDEPT;
INSERT INTO MYEMP(EMP_NO, EMP_NAME, EMP_MGE, HIREDATE, SAL,DEPT_NO) VALUES
('1001', 'KIM', '1003','2005-01-15','4750', 20),
('1002', 'LEE', '1003','2008-06-25','3000',30),
('1003', 'PARK', '1003','2007-11-28','3500',10);
/* 부서 통합 */
/*
UPDATE MYDEPT SET DEPT_NAME = "MANAGEMENT" WHERE DEPT_NAME = "HR"; 
UPDATE MYDEPT SET DEPT_NO = 50 where dept_no=30;
*/
/* 위랑 같은거 */
UPDATE myemp SET dept_no = (select dept_no from mydept where dept_name = 'MANAGEMENT') where dept_no = (select dept_no from mydept where dept_name = 'HR');

DELETE from MYDEPT WHERE DEPT_NAME = "HR"; 

select *from MYDEPT where DEPT_NAME = "HR";

INSERT INTO MYEMP(EMP_NO, EMP_NAME, EMP_MGE, HIREDATE, SAL,DEPT_NO) VALUES
('2001', 'chung', '1001', date_format(now(), '%Y-%m-%d'),'4750', 20);
select *from MYEMP;