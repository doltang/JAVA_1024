use shoppingmall2;
-- select * from member where me_name = null; (X)
-- null 체크는 is null 또는 is not null
select * from member where me_name is not null;

-- 문자열에서 특수문자(역할이 있는 특수문자) 표현
-- select * from member where me_id like'%_%'; (X) -- _는 한글자 이상을 의미
select * from member where me_id like'%\_%'; -- \를 이용!