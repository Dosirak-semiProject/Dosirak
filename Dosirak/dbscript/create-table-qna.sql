USE DOSIRAK;
DROP TABLE IF EXISTS QNA CASCADE;

CREATE TABLE IF NOT EXISTS QNA (
QNA_CODE INT AUTO_INCREMENT PRIMARY KEY COMMENT '질문코드',
QNA_TITLE VARCHAR(225) NOT NULL COMMENT '질문제목',
QNA_ANSWER TEXT(1000) NOT NULL COMMENT '답변내용',
ADMIN_ID VARCHAR(20) COMMENT '관리자아이디',
ASK_CATEGORY_CODE INT(5) NOT NULL COMMENT '문의분류코드',
foreign key (ADMIN_ID) references ADMIN (ID),
foreign key (ASK_CATEGORY_CODE) references ask_category (ASK_CATEGORY_CODE)
) ENGINE=INNODB COMMENT '자주묻는질문';

INSERT INTO QNA (QNA_CODE, QNA_TITLE, QNA_ANSWER, ADMIN_ID, ASK_CATEGORY_CODE) VALUES
(1,'아이디, 비밀번호를 잊어버렸습니다','아이디, 비밀번호 찾기 안내\r\n\r\n하기 경로를 통해 아이디 및 비밀번호 찾기가 가능하며, 임시 비밀번호의 경우 회원가입 시 등록한 이메일 주소로 발송 됩니다.\r\n\r\n(PC) 홈페이지 상단 [로그인] > 화면 아래 [아이디 찾기], [비밀번호 찾기]\r\n\r\n[참고]\r\n가입 시 기재한 메일 주소가 기억나지 않으시거나 오류가 발생하는 경우 고객센터로 문의 바랍니다.\r\n상담 시에는 고객님의 개인정보보호를 위해 기존에 사용하시던 비밀번호는 안내가 불가하며, 개인정보 확인 후 임시 비밀번호를 설정해드립니다.','choijihyun7',1),
(2,'개명을 하여 회원정보의 이름을 바꾸고 싶습니다.','개명으로 인한 회원정보 수정 방법\r\n\r\n-개명하신 경우, 홈페이지 로그인 후 [마이페이지]에서 수정하실 수 있습니다.\r\n-마이페이지 > 회원정보 수정 > 재로그인 > 이름 변경\r\n\r\n[참고]\r\n아이디는 변경이 불가합니다.','choijihyun7',1),
(3,'회원정보를 바꾸고 싶습니다.','[회원정보 변경 안내]\r\n\r\n- 아래 경로를 통해 회원정보를 직접 변경하실 수 있습니다.\r\n\r\n- 수정가능 항목 : 비밀번호/이름/이메일주소/휴대폰번호/생년월일/성별 (아이디 불가)\r\n- (PC) 마이페이지 > 회원정보 수정\r\n\r\n[참고]\r\n- 배송지 수정은 [마이페이지>배송지 관리]에서 직접 수정하실 수 있습니다.','choijihyun7',1),
(4,'회원가입에 제한이 있나요?','회원 가입 시, 별도의 조건은 없습니다.\r\n회원가입 후 다양한 혜택과 상품을 만나보세요!','choijihyun7',1),
(5,'회원 탈퇴 후, 재가입이 가능한가요?','회원탈퇴 후, 3개월 이내에는 동일한 연락처로 가입이 불가능합니다.','choijihyun7',1),
(6,'구매하는 방법이 궁금합니다.','희망 상품 클릭 > 수량 체크 > 장바구니 담기 > 장바구니 확인 > 결제\r\n\r\n장바구니에 담지 않고 바로 결제도 가능합니다.','choijihyun7',2),
(7,'전화로 주문할 수 있나요?','전화(유선상) 주문 불가\r\n\r\n- 전화주문은 불가하며, 현재 인터넷으로만 주문 가능합니다.\r\n- 별도의 오프라인 매장을 보유하고 있지 않습니다.','choijihyun7',2),
(8,'주문이 안 됩니다.','시스템 이상으로 주문이 불가한 경우\r\n\r\n모든 인터넷창을 종료 > 홈페이지 재접속 > 재로그인 진행\r\n\r\n[참고]\r\n공용 PC의 경우 높은 방화벽으로 설정되어 있어, 결제가 어려울 수 있습니다.\r\n결제에 필요한 콘텐츠 사용 및 프로그램을 전부 허용해주셔야 합니다.','choijihyun7',2),
(9,'제가 해외에 살고 있는데 주문이 가능한가요?','해외로 주문/배송은 불가한 점 참고 바랍니다.','choijihyun7',2),
(10,'무통장 입금(현금 구매) 가능한가요?','무통장 입금(현금) 구매 불가 안내\r\n\r\n-결제시간과 입금시간이 다를 경우, 구매하시고자 하는 상품의 빠른 품절로 주문한 상품을 받지 못하는 사례가 발생할 수 있어 무통장입금은 미거래하고 있습니다.\r\n-대신 카드결제, 카카오페이 등 간편결제 시스템을 제공하고 있는 점 참고 바랍니다. ','choijihyun7',2),
(11,'배송지역 검색 시, 배송 불가지역으로 조회됩니다.','신도시/신규 지번 등으로 일부 배송 불가지역이 확인될 수 있으며,\r\n이런 경우 1대1 문의하기를 이용하여 문의를 남겨주시면 감사하겠습니다.','choijihyun7',3),
(12,'배송이 지연된다고 알림을 받았어요','먼저 이용에 불편을 드려 죄송합니다.\r\n\r\n고객님께 약속 드린 배송시간을 준수하기 위해 최선을 다하고 있으나 하기와 같은 이유로 간혹, 부득이하게 배송이 지연되는 점 양해 말씀 드립니다.\r\n\r\n-악천후, 예기치 못한 도로교통 상황(ex. 사고, 도로침수, 정체)\r\n\r\n배송이 지연되는 경우, 해당 사실과 도착예정시간을 고객님께 문자로 안내 도와드리고 있으며 최대한 신속하고 안전하게 배송드릴 수 있도록 노력하겠습니다.','choijihyun7',3),
(13,'회사, 관공서, 학교, 기숙사, 시장, 공단 등으로 배송받고 싶은데 가능한가요?','일부 장소는 출입에 제한이 발생하여 원활한 배송이 어렵습니다. \r\n아래 장소 참고 부탁드립니다.\r\n\r\n- 관공서, 학교(기숙사), 회사, 시장, 백화점, 공단지역 등','choijihyun7',3),
(14,'배송 후에 배송완료 문자를 주나요?','배송 직후 문자가 전송됩니다. 홈페이지에서도 배송완료 내역을 확인할 수 있습니다.','choijihyun7',3),
(15,'택배배송 주문마감 시간이 변동될 수도 있나요?','주문마감시간은 변동되지 않고 한동안 그대로 유지됩니다. \r\n이와 관련한 서비스가 확장될 예정이므로 참고 부탁드립니다.','choijihyun7',3),
(16,'교환/반품 어떻게 진행되나요?','받으신 상품을 교환(반품) 하실 경우, \r\n교환 사유+문제가 발생한 부분을 확인할 수 있는 사진과 함께 \r\n1대1 문의하기로 문의 바랍니다.','choijihyun7',4),
(17,'교환/반품 진행 시, 배송비가 부과되나요?','단순변심에 의한 교환/반품 시 \r\n배송비 6,000원 (주문건 배송비를 낸 경우 3,000원)을 고객님께서 부담하셔야 합니다.','choijihyun7',4),
(18,'주문을 취소하고 싶습니다.','주문 취소는 [주문 완료] 상태일 때만 가능합니다.\r\n\r\n주문내역에서 직접 취소가 가능하며, \r\n부득이 직접 취소가 어려운 상황일 경우 고객센터로 문의 바랍니다.\r\n\r\n배송이 시작된 [배송준비중] 단계부터는 취소가 제한되는 점 \r\n고객님들의 양해 부탁드립니다.','choijihyun7',4),
(19,'교환/반품 처리기간은 얼마나 걸리나요?','교환 및 반품의 처리 기간은 상품에 따라 다를 수 있으며, \r\n재고 유/무 여부(교환 시) 및 택배사 사정에 의해 처리 및 지연이 발생할 수 있습니다.\r\n\r\n- 교환/반품 : 회수 센터에 상품 도착 이후 영업일 기준 약 3일 소요','choijihyun7',4),
(20,'반품상품을 고객센터를 통하지 않고 제가 직접 택배로 보내도 되나요?','고객센터로 문의 후, 회수 안내를 받으시길 바랍니다.\r\n\r\n-상품출고 센터와 회수 물류센터가 다르므로 꼭 고객센터를 통해 접수 바랍니다.\r\n-절차를 통하지 않고 임의로 택배를 보내실 경우, 별도 안내없이 반송처리 되거나 상품이 분실될 위험이 있습니다.\r\n-고객센터로 문의 후, 절차에 따라 진행 부탁드립니다.','choijihyun7',4),
(21,'상품 후기는 어떻게 작성하나요?','배송완료일로부터 30일 동안 상품 후기를 작성하실 수 있습니다. \r\n(30일 경과 시, 후기 작성이 불가능합니다.)\r\n\r\n주문내역에서 구매확정 선택 후, 리뷰작성을 선택해주세요.','choijihyun7',5),
(22,'홈페이지 팝업창 해제를 꼭 해야하나요?','홈페이지에서는 고객님께 유용하고 중요한 정보를 팝업창을 통해 안내드리고 있습니다. (배송 휴무 안내 / 시스템 점검 / 이벤트 등)\r\n\r\n팝업차단을 해제하시면 더 많은 혜택과 쇼핑 기회를 누리실 수 있습니다.','choijihyun7',5),
(23,'장바구니에 담은 상품들은 계속 보존되나요?','상품을 담은 시점부터 최대 90일간 저장이 가능합니다. \r\n\r\n90일 동안 구매하지 않으실 경우, 순차로 장바구니에서 자동 소멸되오니 이용에 참고 부탁드립니다.','choijihyun7',5),
(24,'품절된 상품은 언제 재입고 되나요?','품절 상품들은 각각 재입고 기간이 달라 정확한 안내가 어렵습니다.\r\n이용에 참고 부탁드립니다.','choijihyun7',5),
(25,'1대1 게시판으로 문의 남기는 방법은 없나요?','하기 경로를 통해 문의/불만 내용을 남겨주시면 관리자가 확인하여 빠르게 도움 드리도록 하겠습니다.\r\n\r\n고객센터 > 1대1 문의하기\r\n\r\n[참고]\r\n제품 하자/제품 이상 등으로 반품(환불)이 필요한 경우 사진과 함께 구체적인 내용을 남겨주세요.','choijihyun7',5);
