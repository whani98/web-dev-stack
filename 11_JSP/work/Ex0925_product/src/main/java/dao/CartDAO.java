package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVO;

public class CartDAO {
	
	// single-ton pattern:
	// 객체 1개만 생성해서 지속적으로 서비스하자
	static CartDAO single = null;

	public static CartDAO getInstance() {
		// 생성되지 않았으면 생성
		if (single == null)
			single = new CartDAO();
		// 생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;
	
	public CartDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 회원 별 장바구니 목록
	public List<CartVO> select(int m_idx){
		SqlSession sqlSession = factory.openSession();
		List<CartVO> list =  sqlSession.selectList("c.cart_list", m_idx);
		sqlSession.close();
		
		return list;
	}
	
	// 장바구니에 담긴 상품들의 총합
	public int selectTotalAmount(int m_idx) {
		SqlSession sqlSession = factory.openSession();
		// 총합은 결과가 하나이므로 selectOne
		int total = sqlSession.selectOne("c.cart_total_amount", m_idx);
		sqlSession.close();
		
		return total;
	}
	
	// 이미 장바구니에 등록된 상품인지 조회
	public CartVO selectOne(CartVO vo) {
		SqlSession sqlSession = factory.openSession();
		CartVO resVo = sqlSession.selectOne("c.cart_one", vo);
		sqlSession.close();
		
		return resVo;
	}
	
	// 장바구니에 항목 추가
	public int insert(CartVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("c.cart_insert", vo);
		sqlSession.close();
		
		return res;
	}
	
	// 장바구니 수량 수정
	public int update_cnt(CartVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("c.cart_cnt", vo);
		sqlSession.close();
		
		return res;
	}
	
	
	// 장바구니 상품 삭제
	public int delete(int c_idx) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("c.cart_delete", c_idx);
		sqlSession.close();
		
		return res;
	}
}
