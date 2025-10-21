**10_React**
command prompt
npx create-react-app .
npm start

<다운로드>
npm install react-router-dom
npm i axios

192.168.0.35

cd backend
npm init -y
npm i mysql express cors nodemon

**11_JSP**
1) vo 생성 및 내용 추가
2) dao 생성 및 내용 추가
3) mapper에 쿼리 작성
4) servlet 생성 및 내용 추가
5) 포워딩된 데이터를 jsp에서 가공

**12_Spring**
dao --> service --> controller

1. vo 생성 - db 컬럼명과 동일하게
2. dao 생성 (sqlSession을 injection구조로 받을 준비)
3. mapper에 필요한 쿼리 추가
4. context-3-dao.xml에서 DAO 객체화
5. Controller생성(dao를 injection구조로 받을 준비) - 어노테이션(@controller) 필수!
6. serlvlet-context.xml에서 컨트롤러에 메모리 할당

새 프로젝트를 만들었을 때 옮겨와야할 것들
1. src/main/resources -> package 4개
  ㄴ mybatis-config.xml에서 참조하는 mapper이름 변경
  ㄴ mapper이름 변경 및 내용 수정
  ㄴ context-3-dao.xml의 내용 비워두기
  ㄴ servlet-context.xml 비워두기
2. web.xml파일을 webapp->WEB_INF폴더에 복사
3. pom.xml파일 복사
   ㄴ overview Artifact Id, Name 변경
