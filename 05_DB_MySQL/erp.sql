/*
DB 모델링 
1. 개념적 모델링
 -엔티티(테이블) 추출
 -엔티티 간의 관계설정
2. 논리적 모델링
 -속성(컬럼) 추출
 -정규화 작업 (1, 2, 3) ---> 이 이상으로 가면 역정규화
3. 물리적 모델링
 -테이블 실질적으로 작성 (CREATE 문 작성)

  * 정규화(Nomalization)
    -불필요한 데이터의 중복을 제거하여 데이터 모델을 구조화 하는 것
    -효율적인 자료 저장 및 데이터 무결성을 보장하고 오류를 최소화하여 안정성을 보장하기 위해 적용함
    
    제 1 정규화 : 복수의 속성값을 갖는 속성을 분리
    제 2 정규화 : 주 식별자에 종속되지 않는 속성을 분리
    제 3 정규화 : 속성에 종속적인 속성을 제거
*/
/*
사용자 or 사원 관련 정보 들어가는 테이블 하나 CREATE 문 작성해서 제출(6/10 까지)
-> PRIMARY KEY : AUTO_INCREMENT 추가! (알아서 증가할 것이라는 뜻!)
MySQL
-데이터 타입
1. 문자
  -CHAR / **VARCHAR** : 고정 및 가변 길이 문자, 반드시 크기 지정
  -**TEXT** : 매우 긴 문자열을 저장하는데 사용
2. 숫자
  -**INT** : 정수값 저장하는데 사용
  -FLOAT / DOUBLE : 부동소수점 저장하는데 사용 
  -DECIMAL : 고정소수점 저장하는데 사용 
3. 날짜 및 시간
  -**DATE** : 날짜 저장하는데 사용
  -TIME : 시간 저장하는데 사용
  -**DATETIME** / TIMESTAMP : 날짜와 시간을 함께 저장 (DEFAULT NOW())
4. 불리언
  -BOOLEAN / BOOL : 참(True) 또는 거짓(False)값을 저장하는데 사용
5. 이진 자료형
  -BLOB : 이진 데이터를 저장하는데 사용, 이미지나 동영상과 같은 이진 파일
          --> 실제로는 이미지나 동영상은 따로 관리(URL만 문자형으로 저장)
*/
CREATE TABLE EMP_INFO (
EMP_ID INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
EMP_NAME VARCHAR(20) NOT NULL,
EMP_NO INT NOT NULL,
AGE int NOT NULL,
GENDER VARCHAR(10) CHECK(GENDER IN ('남', '여')) NOT NULL,
ADDRESS VARCHAR(200) NOT NULL,
PHONE VARCHAR(13) NOT NULL,
EMAIL VARCHAR(100) CHECK(EMAIL LIKE '%@%') NOT NULL,
DEPT_CODE VARCHAR(10) NOT NULL,
JOB_CODE VARCHAR(10) NOT NULL,
SALARY int NOT NULL,
HIRE_DATE DATE DEFAULT NOW()
);


----------------------------------------------
CREATE TABLE USER_INFO (
 USER_NO INT PRIMARY KEY AUTO_INCREMENT ,
 ID VARCHAR(50) UNIQUE NOT NULL,
 PASSWORD VARCHAR(300) NOT NULL,
 EMAIL VARCHAR(100) UNIQUE ,
 NAME VARCHAR(50) NOT NULL,
 PHONE VARCHAR(50) UNIQUE,
 ADDR VARCHAR(200),
 GENDER VARCHAR(10), CHECK(GENDER IN ('남', '여')),
 BIRTH_DATE DATE,
 HIRE_DATE DATE DEFAULT (CURRENT_DATE),
 QUIT_DATE DATE,
 DEPT_NO INT,
 GRADE_NO INT
);
CREATE TABLE DEPARTMENT(
   DEPT_NO INT PRIMARY KEY AUTO_INCREMENT,
   DEPT_NAME VARCHAR(100) NOT NULL /*개발팀*/
);
CREATE TABLE GRADE( 
   GRADE_NO INT PRIMARY KEY AUTO_INCREMENT,
   GRADE_NAME VARCHAR(100) NOT NULL  /*사원*/
);
/*DEPT_NO, GRADE_NO*/
ALTER TABLE USER_INFO ADD
FOREIGN KEY (DEPT_NO) REFERENCES DEPARTMENT (DEPT_NO);
ALTER TABLE USER_INFO ADD
FOREIGN KEY(GRADE_NO) REFERENCES GRADE_NO;
---------------------------------------------------------------



/*
프로젝트 관리 : 테이블 몇개든 상관없이 짜보시고 FOREIGN KEY 까지 걸어보는 것 까지!
-테이블 필요한 컬럼 짜기 힘드시다면 어떤 기능이 있어야 되는지 정도로 제출해도 괜찮아요!
-내일까지
*/

/*참여자*/
CREATE TABLE USERS (
    USER_ID INT PRIMARY KEY AUTO_INCREMENT,
    USER_NAME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(200) CHECK(EMAIL IN ( %@%))
    );
/*상태(업무 진행상황)*/
CREATE TABLE STATUSES (
    STATUS_ID INT PRIMARY KEY AUTO_INCREMENT,
    STATUS_NAME VARCHAR(100) CHECK(STATUS_NAME IN ( '진행전', '진행중', '완료', '중단')) DEFAULT '대기중'
);
/*우선순위*/
CREATE TABLE PRIORITIES(
    PRIORITY_ID INT PRIMARY KEY AUTO_INCREMENT,
    PRIORITY_NAME VARCHAR(100) NOT NULL
);
CREATE TABLE PROJECT_TASKS (
    TASK_ID VARCHAR(10) PRIMARY KEY AUTO_INCREMENT,
    TASK_NAME VARCHAR(100) NOT NULL,
    MANAGER_ID, /*담당자*/
    START_DATE DATE,
    DUE_DATE DATE,
    TASK_LEVEL VARCHAR(10) CHECK (TASK_LEVEL IN ( '쉬움' , '보통' , '어려움')),
    PROGRAM VARCHAR(100), /*필요한 프로그램*/
    FOREIGN KEY (MANAGER_ID) REFERENCES USERS(USER_ID)
);




-------------------------------------------
/*PROJECT_MEMBERS : USER_NO, PRO_NO*/
CREATE TABLE PROJECT (
   PRO_NO INT AUTO_INCREMENT PRIMARY KEY,
   PRO_NAME VARCHAR(100) NOT NULL,
   PRO_DESC TEXT,
   START_DATE DATE,
   END_DATE DATE,
   STATUS VARCHAR(10) CHECK(STATUS IN ( '진행전', '진행중', '완료', '중단'))
);
CREATE TABLE MEMBERS (
   MEMBER_NO INT AUTO_INCREMENT PRIMARY KEY,
   USER_NO INT,
   PRO_NO INT,
   ROLE VARCHAR(50)
);
/*프로젝트 : 업무들 = 1: M*/
CREATE TABLE PROJECT_TASKS (
   TASK_NO INT AUTO_INCREMENT PRIMARY KEY,
   PRO_NO INT,
   TASK_NAME VARCHAR(100),
   TASK_DESC TEXT,
   STATUS VARCHAR(30) CHECK (TASK_STATUS IN ('진행전', '진행중', '완료', '중단')),
   START_DATE DATE,
   END_DATE DATE
   );
-------------------------------------------
/*PROJECT_MEMBERS : USER_NO, POR_NO*/
ALTER TABLE PROJECT_MEMBERS ADD
FOREIGN KEY (USER_NO) REFERENCES USER_INFO(USER_NO);
ALTER TABLE PROJECT_MEMBERS ADD
FOREIGN KEY (PRO_NO) REFERENCES PROJECT(PRO_NO);
/*PROJECT_TASKS : PRP_NO*/
ALTER TABLE PROJECT_TASKS ADD
FOREIGN KEY (PRO_NO) REFERENCES PROJECT(PRO_NO);

/*일정관리!*/
CREATE TABLE DATE_MANAGE (
TASK_START DATE, --업무별 시작 날짜
TASK_END DATE, --업무별 마지막 날짜
TASK_NO INT,
TASK_NAME VARCHAR(100),
USER_NO INT,

);










