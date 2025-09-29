package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SjVO;

public class SjDAO {
	SqlSessionFactory factory;
	// single-ton pattern:
	// 객체1개만 생성해서 지속적으로 서비스하자
	static SjDAO single = null;

	public static SjDAO getInstance() {
		// 생성되지 않았으면 생성
		if (single == null)
			single = new SjDAO();
		// 생성된 객체 정보를 반환
		return single;
	}

	public SjDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}

	// 학생 목록 가져오기 -> 가져오기면 무조건 VO
	public List<SjVO> select() {
		// mapper로 접근하기 위한 Sqlsession 객체 준비
		SqlSession sqlSession = factory.openSession();
		 // id가 sj_list라는 mapper 호출, 정보 조회
		List<SjVO> list = sqlSession.selectList("s.sj_list");
		sqlSession.close(); // 안쓰면 조회 후에도 정보가 남아있기 때문에 닫아줘야함

		return list; // 가져온 결과 반환
	}

	// 학생 정보 등록
	public int register(SjVO vo) {
		SqlSession sqlSession = factory.openSession(true);// true 대신 sqlSession.commit();도 가능
		// id가 sj_insert라는 mapper 호출, 정보 삽입, vo로 묶어서 보내야함(mapper한테 값을 하나만 보낼 수 있고, 나눠서 보낼 수 없음)
		int res = sqlSession.insert("s.sj_insert", vo); 
		sqlSession.close();
		return res;
	}
	
	// 학생 정보 삭제
	public int del(int no) {
		
		SqlSession sqlSession = factory.openSession(true);
		
		// 삭제를 위한 id=sh_del mapper 호출
		int res = sqlSession.delete("s.sh_del", no);
		sqlSession.close();
		
		return res;
	}
}
