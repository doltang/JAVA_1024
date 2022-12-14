/*
SELECT select_expr
	[FROM table_references]
	[WHERE where_condition]
	[GROUP BY {col_name | expr | position}]
    [HAVING where_condition]
    [ORDER BY {col_name | expr | position}]
    
group by
- 같은 속성을 가지는 값으로 묶을 때 사용
- 여러 속성을 같이 사용하여, 여러 속성이 같은 행들을 묶어서 사용
- 집계함수와 같이 사용
*/
SET sql_mode=(select replace(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
select pr_pc_num as 카테고리번호, count(pr_num) as '카테고리별 등록된 제품 수'
 from product 
 group by pr_pc_num
 -- having count(pr_num) >= 2;
 having `카테고리별 등록된 제품 수` >= 2;
 
 -- view 사용 시 as를 꼭 써야 한다
 -- 검색할 때 쓰이는 view 성능향상을 위해 쓰이므로 지금은 몰라도 된다
 create view product_view as select * from product;
 select * from product_view;
 drop view product_view;
 
 -- 카테고리별 가장 비싼 제품의 가격을 조회
 select pr_pc_num as 카테고리번호, max(pr_price) as 가격  from product
	group by pr_pc_num;
    
-- 사용자별 총 구매 제품 개수 조회
use shoppingmall;
select bu_me_id as 사용자아이디, sum(bu_amount) as 구매개수 from buy
	group by bu_me_id;
select bu_me_id, bu_amount from buy;