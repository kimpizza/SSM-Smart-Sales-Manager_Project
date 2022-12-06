package com.mijung.SSM.service;

import java.util.List;
import java.util.Map;

import com.mijung.SSM.entity.Broadcasting;
import com.mijung.SSM.entity.OurCategory;
import com.mijung.SSM.entity.SpeechAnalysis;
import com.mijung.SSM.entity.Users;
import com.mijung.SSM.entity.ViewerReaction;

public interface SsmService {
	Users findByUserId(Users userVO);
	Boolean loginCheck(Users userVO);
	List<OurCategory> OcFindAllByUsersVO(Users userVO);
	List<Broadcasting> BcFindAllByUsersVO(Users user);
	Broadcasting BcFindByBcSeq(Long bcSeq);
	List<ViewerReaction>  VcFindAllByBroadcastingVO(Broadcasting bcVO);
	
	// RestController 서비스
	// 방송 상세정보 -> salesCnt(총 결제 수), salesPred(예상 판매액)
	// 1 ~ 3.
	Map<Object, Object> getSalesInfo(Broadcasting bc);
	
	// 4. 아이템 리스트 -> [{item_seq:, item_name: , starAvg : {카테고리 별 평점}}] 형태 
	List<Object> getStarsAvgGroupBy(Broadcasting bc);
	
	// 5. 실적 가져오기
	Double getPerformRate(Broadcasting bc);
	
	// 6. 해당 하는 방송의 사용자 반응 테이블 가져오기
	List<Object> getViewReactionChart(Broadcasting bc);
	
	// 7.
	List<Object> getKeywordCount(Broadcasting bc);
}
