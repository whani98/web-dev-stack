/*
-데이터베이스 : 데이터(data)+베이스(base)
-DBMS : Database Management System의 약자, 데이터베이스 관리 시스템
-관계형(Relational) 데이터베이스
 1. 가장 대표적인 데이터베이스 시스템
 2. 데이터를 테이블 형태(행과 열)로 저장하고, 여러 테이블 간 관계를 설정하고 , 데이터의 관계를 표현 및 분석
 3. 데이터의 중복을 최소화하고 무결성, 트랜잭션 관리 등 뛰어난 데이터 관리 성능을 제공
 
-SQL(Structured Query Language)
: 관계형 데이터베이스에서 데이터를 조회하거나 조작하기 위해 사용하는 표준 언어
-SQL 종류
 1. DML(Data Manifulation Language) : 데이터 조작어
    -데이터를 조작하기 위한 언어 
     (INSERT : 추가, SELECT :  조회, UPDATE : 수정, DELETE : 삭제)
     (CRED | Create : 추가, Read : 조회, Update : 수정, Delete : 삭제)
    -SELECT는 데이터 조회를 의미하여 일부에서는 DQL(Data Query Language)로 분류하기도 함
 2. DDL (Data Definition Language) : 데이터 정의어
    -DB의 구조를 정의하거나 변경, 삭제하기 위한 언어
     (CREATE : 생성, ALTER : 수정, DROP : 삭제)
    -테이블 변경과 관련
 3. DCL (Date Control Language) :  데이터 제어어
    -DB의 보안, 권한 관리 , 무결성 제어를 위한 언어
      (GRANT : 권한 부여, REVOKE :  권한 회수)
 4. TCL (Transaction Control Lanuage) : 트랜잭션 제어어
    -트랜잭션 처리 및 제어를 위한 언어
    (COMMIT  : 실행, ROLLBACK : 취소, SAVEPOINT : 임시저장)
*/
/*
SELECT 컬럼1, 컬럼2,...
FROM 테이블명;

-테이블에서 데이터를 조회할 때 사용하는 SQL문
-SELECT 실행 걀과를 Result Set이라고 한다.
-조회하고자 하는 컬럼은 반드시 from절에 지정한 테이블에 존재해야한다
-테이블의 모든 컬럼을 조회 하려면 * 기호를 사용
*/
--USER_INFO 테이블 전체 조회
SELECT * FROM USER_INFO;

-- USER_INFO 이름(NAME), 나이(AGE), 취미(HOBBY)조회
SELECT name, age, hobby 
FROM user_info;--MySQL

SELECT NAME, AGE, HOBBY 
FROM USER_INFO;--오라클

--EMPLOYEE 테이블의 직원명(EMP_NAME), 이메일(EMAIL) 조회
SELECT EMP_NAME, EMAIL 
FROM EMPLOYEE;

/*
컬럼 산술 연산
-SELECT절에서 컬럼명 입력 부분에 산술연산자를 사용하여 결과 조회

 컬럼 별칭
 - 산술 연산을 하게 되면 컬럼명이 지저분해진다.
   이때 컬렴명에 별칭을 부여하면 깔끔하게 보일 수 있다.
 컬럼 AS 별칭 / 컬럼 AS "별칭" / 컬럼 별칭 / 컬림 "별칭"
*/
--USER_INFO에서 나이(AGE)에 10년 후를 계산
SELECT 
   NAME, 
   AGE, 
   AGE+10 AS "10년 후" 
FROM USER_INFO;

--EMPLOYEE에서 직원명(EMP_NAME), 월급(SALARY),연봉 조회
SELECT 
   EMP_NAME 직원명, 
   SALARY 월급, 
   SALARY*12 연봉 
FROM EMPLOYEE;

/*
리터럴(문자열)
-SELECT 절에 리터럴을 사용하면 테이블에 존재하는 데이터처럼 조회가능
-즉, 리터럴을 RESULT SET의 모든 행에 반복적으로 출력

 연결 연산자: ||
 -여러 컬럼값들을 마치 하나의 컬럼인 것 처럼 연결
 -컬럼값과 리터럴도 연결할 수 있음
*/
--USER_INFO에서 이름(NAME), 나이(AGE), 단위(살)조회
SELECT 
  NAME,
  AGE||'살' "나이"
FROM USER_INFO;

--USER_INFO에서 이름(NAME)의 MBTI는 XXXX입니다. 조회
SELECT 
NAME||'의 MBTI는'||MBTI||'입니다.' 
FROM USER_INFO;

/*
DISTINCT
-컬럼에 중복된 값들을 한 번씩만 표시하고자 할 때
-주의사항 : DISTINCT는 SELECT절에서 한 번만 기술 가능
--SELECT DISTINCT AGE, DISTINCT MBTI FROM USER_INFO; X
*/
-- USER_INFO에서 나이(AGE)가 중복되지 않게 조회
SELECT DISTINCT AGE FROM USER_INFO;

--USER_INFO에서 MBTI 중복되지 않게 조회
SELECT DISTINCT MBTI FROM USER_INFO;

/*
WHERE 절

SELECT 컬럼, 컬럼,...
FROM 테이블명
WHERE 조건식;

-조회하고자 하는 테이블로부터 "특정 조건'에 만족하는 데이터만 조회하고자 할 때
-이때 WHERE절에 조건식 제시
-조건식에는 다양한 연산자 사용 가능

비교 연산자
= : 같음
!=, <> : 같지 않음
<, >, <=, >= : 대소 비교
*/
-- USER_INFO에서 나이가 30이상인 이름(NAME), 나이(AGE)M, 생년월일(BIRTHDATE) 조회
SELECT AGE, NAME, 0, BIRTHDATE
FROM USER_INFO
WHERE AGE>30;

--EMPLOYEE에서 부서코드(DEPT_CODE)가 'D9'인 사원들 (모든 컬럼) 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE='D9'; 

/*
OR(또는), AND(그리고)
*/
--테이블 : USER_INFO
--성별(GENDER)이 여자이거나 나이(AGE)가 25살 이하인 사람들 조회
SELECT *
FROM USER_INFO
WHERE GENDER='여' OR AGE<=25;

--테이블: EMPLOYEE
--급여(SALARY)가 350만원 이상 600만원 이하를 받는 사원들 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY>=3500000 AND SALARY<=6000000;


/*
BETWEEM AND
-조건식에서 사용되는 구문
-몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 사용

컬럼 BETWEEN 하한값 AND 상한값
*/
SELECT *
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000; 

--USER_INFO에서 나이가 25~30사이인 사람들 조회
SELECT *
FROM USER_INFO
WHERE AGE BETWEEN 25 AND 30;

/*
LIKE
-비교하고자 하는 컬럼값이 특정 패턴에 만족할 경우 조회

컬럼 LIKE '특정 패턴'
-특정 패턴에는 '%', '_'를 와일드 카드로 사용

'_' : 1글자
'_문자' : 앞에 1글자 + 문자
'__문자' : 앞에 2글자 + 문자
'_문자_' : 앞뒤에 1글자씩 +문자

'%' : 0글자 이상
'문자%' : 문자로 시작
'%문자' : 문자로 끝남
'%문자%' : 문자 포함 (키워드 검색)
*/

--테이블 : USER_INFO
--이름이 '은'으로 끝나는 경우 조회
SELECT * FROM USER_INFO
WHERE NAME LIKE '__은';

--성이 '성'씨인 경우 조회
SELECT * FROM USER_INFO
WHERE NAME LIKE '성__';

--MBTI가 'E'면서 'T'인 경우 조회
SELECT * FROM USER_INFO
WHERE MBTI LIKE 'E_T_';

--전화번호가 010-2XXX-XXXX인 경우 조회
SELECT * FROM USER_INFO
WHERE CONTACT LIKE '010-2%';

--나이가 25이하면서 경기도에 사는 사람이거나 MBTI가 INTP인 경우
SELECT * FROM USER_INFO
WHERE AGE <= 25 AND ADDRESS LIKE '경기%' OR MBTI='INTP';

--테이블 : EMPLOYEE
--이메일 중 _앞글자가 3글자인 사원들 조회
--ESCAPE OPTION : 나만의 와일드 카드 만들어서 사용! ESCAPE는 어떤 기호를 써도 상관없음
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '___$_%' ESCAPE '$';

-- 위 사원들 이외의 사원들 조회
--부정연산자 : NOT
SELECT * FROM EMPLOYEE
WHERE NOT EMAIL LIKE '___$_%' ESCAPE '$';
-- NOT은 컬럼 앞에 붙거나 뒤에 붙거나
SELECT * FROM EMPLOYEE
WHERE EMAIL NOT LIKE '___$_%' ESCAPE '$';

/*
IS NULL/IS NOT NULL
-컬럼 값에 NULL이 있을 경우 NULL 값 비교에 사용되는 연산자
IS를 꼭 사용해야한다!
*/
--MBTI가 NULL인 사람들 조회
SELECT * FROM USER_INFO
WHERE MBTI IS NULL;

SELECT * FROM USER_INFO
WHERE MBTI IS NOT NULL;

--EMPLOYEE 에서 보너스(BONUS)를 받지 않는 사원들 조회
SELECT * FROM EMPLOYEE
WHERE BONUS IS NULL;

--부서배치를 아직 받지 않고(DEPT_CODE) 보너스는 받는 사원들 조회
SELECT * FROM EMPLOYEE
WHERE BONUS IS NULL AND DEPT_CODE IS NOT NULL;

/*
IN
-컬럼값이 내가 제시한 목록 중에 일치하는 값이 있는지
컬럼 IN ('값1', '값2', ...)-> 검색 필터
*/
--USER_INFO에서 MBTI가 INFP 또는 INTJ인 사용자 조회
SELECT * FROM USER_INFO
WHERE MBTI='INFP' OR MBTI='INTJ';
--또는
SELECT * FROM USER_INFO
WHERE MBTI IN('INFP', 'INTJ');

--EMPLOYEE에서 부서코드 (DEPT_CODE)가 D5, D6, D8 조회
--IN
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D6','D8');
--OR
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE='D5' 
OR DEPT_CODE='D6' 
OR DEPT_CODE='D8';

--직급 코드 (JOB_CODE)가 J7이거나 J2인 사원들 중 급여가 200만원인 사원들 조회
--AND가 OR보다 우선순위
 --IN 연산자 사용
SELECT * FROM EMPLOYEE
WHERE JOB_CODE IN ('J7', 'J2') AND SALARY>=2000000;
 --OR 연산자 사용
 /*
 연산자 우선순위
 0. ()
 1. 산술연산자 : *, /, +, -
 2. 문자열 연결 : ||
 3. 비교연산자 : =, !=, <>, <, >, <=, >=
 4. IS NULL/LIKE/IN/BETWEEM
 5. NOT
 6. AND
 7. OR
 */
SELECT * FROM EMPLOYEE
WHERE SALARY>=2000000 
       AND (JOB_CODE='J7' OR JOB_CODE='J2');

/*
ORDER BY 
-SELECT문 가장 마자막 줄에 작성 뿐만 아니라 실행순서 또한 마지막
(순서)
3 SELECT 컬럼, 컬럼...
1 FROM 테이블명
2 WHERE 조건식
4 ORDER BY 정렬하고자 하는 컬럼값 [ASC | DESC];

-ASC : 오름차순 정렬(생략 시 기본값)
-DESC : 내림차순 정렬
*/
--USER_INFO에서 나이를 오름차순 정렬
SELECT * FROM USER_INFO
ORDER BY AGE;
--MBTI는 오름차순, 나이는 내림차순 정렬
--조건은 MBTI가 I인 분들 조회
--NULLS LAST는 ORACLE에만 존재!
SELECT NAME, AGE, GENDER, MBTI FROM USER_INFO
ORDER BY MBTI DESC NULLS LAST;
--EMPLOYEE에서 전체 사원의 사원명, 보너스 조회,
--보너스 기준 오름차순 정렬
SELECT EMP_NAME, BONUS FROM EMPLOYEE
--ORDER BY BONUS NULLS FIRST; --오름차순인 경우는 NULL이 맨뒤에
ORDER BY BONUS DESC NULLS LAST; --내림차순인 경우는 NULL이 맨앞에

/*
GROUP BY 
-그룹 기준을 제시할 수 있는 구문
-여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용
*/
--MBTI 별 평균 나이, 나이 합계, 각 인원수
SELECT MBTI, AVG(AGE), SUM(AGE), COUNT(*)
FROM USER_INFO
GROUP BY MBTI, AGE;

--EMPLOYEE : 성별 사원 수 조회
SELECT 
   DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여' ) 성별,
   COUNT(*) 인원수
FROM EMPLOYEE 
GROUP BY SUBSTR(EMP_NO, 8, 1);

/*
HAVING 
-그룹에 대한 조건을 제시할 때 사용하는 구문

-SELECT 실행 순서
  5 SELECT * | 컬럼 | 함수
  1 FROM 테이블명
  2 WHERE 조건식
  3 GROUP BY 그룹 기준에 해당하는 컬럼 | 함수
  4 HAVING 조건식 (그룹 함수)
  6 ORDER BY 컬럼 | 별칭 | 컬럼 순번(숫자) (항상 마지막!)
*/
--EMPLOYEE에서 부서별 평균 급여가 300만원 이상인 직원의 평균 급여(SALARY)를 조회(부서코드-DEPT_CODE)
--DEPT_CODE가 NULL이 아닌 경우
SELECT DEPT_CODE, TO_CHAR(AVG(NVL(SALARY, 0)), '9,999,999')
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE
HAVING AVG(NVL(SALARY, 0))>=3000000;

--직급별(JOB_CODE) 총 급여의 합이 1000만원 이상인 직급만 조회
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY)>=10000000;

--부서별 보너스를 받는 사원이 없는 부서만 조회
SELECT DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS)=0 ; --D2

--USER_INFO에서 MBTI별 평균 나이를 계산하는데 평균 나이가 30 이하인 MBTI만 조회
--단, 나이가 100살 이상인 경우는 제외
SELECT MBTI, AVG(AGE)
FROM USER_INFO
WHERE AGE<=100
GROUP BY MBTI
HAVING AVG(AGE)>30;

SELECT * FROM EMPLOYEE;
