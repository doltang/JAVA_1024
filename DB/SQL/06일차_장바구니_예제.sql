-- abc회원이 반집업 맨투맨(1번 제품) 빨강을 2개 장바구니에 담았다. 이때 쿼리는?
-- selecr/insert/update/delete
-- 주소록/장바구니/메인카/서브카/회원/주문/주문리/제품/제품옵

select * from product;
select * from product_option;

use shoppingmall2;
insert into basket(ba_amount, ba_me_id, ba_po_num) 
values(2, 'abc', 1);
select * from basket;

-- abc 회원이 장바구니에 담긴 모든 제품을 구매, 이때 실행되어야 하는 쿼리를 작성
-- 적립 포인트는 제품 금액의 10%, 사용 포인트는 X, 배송지는 집
-- 주문 내역에 데이터 추가
insert into `order`
(or_total_price, or_price, or_use_pt, or_add_pt, or_ab_num, or_me_id) 
values(17000*2, 17000*2, 0, 17000*2/10, 1, 'abc');
select * from `order`;
-- 주문 리스트에 데이터 추가
insert into order_list
(ol_amount, ol_price, ol_po_num, ol_or_num) 
values(2, 17000, 1, 1);
select * from order_list;

-- 제품 옵션에 재고를 변경
update product_option
	set 
		po_amount = po_amount - 2
	where
		po_num = 1;