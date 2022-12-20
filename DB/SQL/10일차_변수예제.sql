use shoppingmall;

set @num = 10;	-- @num에 10을 저장, 세션 변수
select @num := 20; -- @num에 20을 저장한 후, 출력, 세션변수
select @num;
select @@sql_mode; -- 시스템 변수(글로벌 변수) sqlmode를 조회

show variables;-- 시스템 변수들을 조회

-- 실수 1.23을 정수 1로 변환
select cast(1.23 as signed integer);
select convert(1.23, signed integer);

