package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVO;

public class MemberDAO {
	SqlSessionFactory factory;

// single-ton pattern: 
// 객체 1개만 생성해서 지속적으로 서비스하자
	static MemberDAO single = null;

	public static MemberDAO getInstance() {
		// 생성되지 않았으면 생성
		if (single == null)
			single = new MemberDAO();
		// 생성된 객체정보를 반환
		return single;
	}

	public MemberDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}

// 회원 리스트 나열
	public List<MemberVO> select() {
		SqlSession sqlSession = factory.openSession();
		List<MemberVO> list = sqlSession.selectList("m.member_list");
		sqlSession.close();

		return list;
	}

// 회원 등록 - insert는 항상 정수 형태로 반환!, vo 형태로 파라미터 받음
	public int register(MemberVO vo) {
		// sql 세션 생성 / true -> commit을 하자!라는 의미
		SqlSession sqlSession = factory.openSession(true);
		// "m.member_insert" 호출하여 vo를 mapper에 보냄
		int res = sqlSession.insert("m.member_insert", vo);
		// 세션 닫기
		sqlSession.close();

		return res;
	}

// 회원 삭제, 지우고 싶은 회원 번호를 파라미터로 받음
	public int delete(int idx) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("m.member_delete", idx);
		sqlSession.close();

		return res;
	}

// 수정할 회원 정보 조회
	public MemberVO selectOne(int idx) {
		SqlSession sqlSession = factory.openSession();
		MemberVO vo = sqlSession.selectOne("m.member_select_one", idx);
		sqlSession.close();

		return vo;
	}

// 회원 정보 수정
	public int modify(Map<String, Object> map) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("m.member_modify", map);
		sqlSession.close();

		return res;
	}

// 아이디 중복 체크
	public MemberVO selectOne(String id) {
		SqlSession sqlSession = factory.openSession();
		MemberVO vo = sqlSession.selectOne("m.selectOne", id);
		sqlSession.close();

		return vo;
	}
}
