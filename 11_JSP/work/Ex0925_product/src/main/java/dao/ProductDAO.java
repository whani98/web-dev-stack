package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVO;

public class ProductDAO {

	// single-ton pattern:
	// 객체 1개만 생성해서 지속적으로 서비스하자
	static ProductDAO single = null;

	public static ProductDAO getInstance() {
		// 생성되지 않았으면 생성
		if (single == null)
			single = new ProductDAO();
		// 생성된 객체정보를 반환
		return single;
	}

	SqlSessionFactory factory;

	public ProductDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 상품 리스트
	public List<ProductVO> selectList(String category){
		SqlSession sqlSession =  factory.openSession();
		List<ProductVO> list = sqlSession.selectList("p.pro_list", category);
		sqlSession.close();
		
		return list;
		
	}
	
	// 상품 등록
	public int insert(ProductVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("p.pro_insert", vo);
		sqlSession.close();
		
		return res;
				
	}
	
	// 상품 삭제
	public int delete(int idx) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("p.pro_delete", idx);
		sqlSession.close();
		
		return res;
	}
	
	// 수정할 제품 정보 조회 및 상세 조회
	public ProductVO selectOne(int idx) {
		SqlSession sqlSession = factory.openSession();
		ProductVO vo = sqlSession.selectOne("p.select_one", idx);
		sqlSession.close();
		
		return vo;
	}

	
	

}
