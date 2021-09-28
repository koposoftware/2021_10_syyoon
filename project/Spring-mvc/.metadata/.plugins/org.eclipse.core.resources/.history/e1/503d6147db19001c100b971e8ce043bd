package kr.co.hana.schedule.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.hana.schedule.vo.FavoriteScheduleVO;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
	 * 즐겨찾기 추가
	 */
	public int addFavoriteNotice(FavoriteScheduleVO fsvo) {
		int result = sqlSessionTemplate.insert("search.dao.ScheduleDAO.addFavoriteNotice", fsvo);
		return result;
	}
	
	/**
	 * 즐겨찾기 삭제
	 */
	public int delFavoriteNotice(FavoriteScheduleVO fsvo) {

		int result = sqlSessionTemplate.delete("search.dao.ScheduleDAO.delFavoriteNotice", fsvo);
		return result;
	}
	
	/**
	 * 즐겨찾기 있는지 확인용
	 */
	public FavoriteScheduleVO getFavoriteNoticeOne(FavoriteScheduleVO fsvo) {
		
		FavoriteScheduleVO result = sqlSessionTemplate.selectOne("search.dao.ScheduleDAO.getFavoriteNoticeOne", fsvo);
		return result;
		
		
	}

}
