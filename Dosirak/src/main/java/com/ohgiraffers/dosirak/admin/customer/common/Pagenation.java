package com.ohgiraffers.dosirak.admin.customer.common;

import java.util.HashMap;
import java.util.Map;

public class Pagenation {

    // 검색 O
    public static SelectCriteria getSelectCriteria(int page, int totalCount, int limit, int buttonAmount, Map<String, String> searchMap) {

        /* 총 페이지 수 계산 */
        int maxPage = (int) Math.ceil((double) totalCount / limit);
        // Math.ceil : 소숫점 이하를 올림하는 함수
        // 총 게시글 수 / 한 번에 보여줄 게시물 수

        /* [ 페이징바 시작 숫자 ]
        * - 현재 페이지가 전체 페이지 버튼의 그룹 중 어느 그룹에 속하는지 파악하기
        *   : (double) page / buttonAmount
        * - 위 계산 결과에서 1을 뺌
        *  : (Math.ceil((double) page / buttonAmount) - 1)은 페이지 그룹의 인덱스를 나타냄 (ex. 0일 경우 페이지 1)
        * - 페이지 그룹의 시작 페이지 구하기
        *   : (Math.ceil((double) page / buttonAmount) - 1) * buttonAmount + 1
        *   ex. buttonAmount : 10 / page : 15 ->
        *       1. (Math.ceil((double) page / buttonAmount) - 1) : 1 (따라서 페이지 2)
        *       2. 1 * buttonAmount + 1 : 11
        * */

        /*  페이징바 시작 숫자 */
        int startPage = (int) (Math.ceil((double) page / buttonAmount) - 1) * buttonAmount + 1;
        /* 페이징바 끝 숫자 */
        int endPage = startPage + buttonAmount - 1;

        /* max 페이지가 end 페이지보다 더 작은 경우 end 페이지는 max 페이지이다. */
        if(maxPage < endPage) endPage = maxPage;

        /* 마지막 페이지는 0이 될 수 없으므로 게시물이 아무것도 존재하지 않으면 max, end는 0이 된다. */
        if(maxPage == 0 && endPage == 0) {
            maxPage = startPage;
            endPage = startPage;
        }

        /* [ offset 계산 ]
        * 예를 들어 현재 페이지 : 3, 한 번에 보여줄 게시물의 숫자 : 10
        * 3 - 1 : 2 -> 2 * 10 -> 20
        * 20번째부터 데이터를 불러온다. */

        /* offset 계산 */
        int offset = (page - 1) * limit;

        return new SelectCriteria(page, totalCount, limit, buttonAmount, maxPage, startPage, endPage,
                offset, searchMap.get("searchCondition"), searchMap.get("searchValue"));

    }

    // 검색 X
    public static SelectCriteria getSelectCriteria(int page, int totalCount, int limit, int buttonAmount) {
        return getSelectCriteria(page, totalCount, limit, buttonAmount, new HashMap<>());
    }

}
