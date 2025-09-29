package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVO;

public class DeptDAO {
	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		// 생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		// 생성된 객체정보를 반환
		return single;
	}

	public DeptDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
    // 여러개의 정보를 가져올 때는 List, 한 개의 정보를 가져올 때는 VO
	public List<DeptVO> select() {
		SqlSession sqlSession = factory.openSession();
		// d.dept_list mapper 호출
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		sqlSession.close();

		return list;
	}
	
    // 등록 - insert는 반드시 int
	public int register(DeptVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("d.dept_insert", vo);
		sqlSession.close();

		return res;
	}
	
    // 삭제
	public int del(int deptNo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("d.dept_del", deptNo);
		sqlSession.close();

		return res;
	}

    // 수정할 부서 정보 조회
	public DeptVO updateSelect (int deptNo) {
		// 조회이기 때문에 true 안받아도 됨
		SqlSession sqlSession = factory.openSession();	
		// mapper 호출, 하나만 호출하고 싶으면 selectOne
		DeptVO vo = sqlSession.selectOne("d.dept_update_one", deptNo);
	    sqlSession.close();
	    return vo;
	}
	
	// 수정
	public int update(Map<String, Object> map) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("d.dept_update_fin", map);
		sqlSession.close();

		return res;
	}
}
