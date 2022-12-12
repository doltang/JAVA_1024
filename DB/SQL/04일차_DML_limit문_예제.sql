/*
select now(); -- 현재 시각 출력
select '123'; -- 123
select 123 + 456; -- 579

select 속성 | 식 등..
	[from 테이블명]
    [where 조건절] -- 조건에 맞는 결과를 조회, ==가 아닌 =를,같지 않은 경우는 !=를 이용하여 비교
    -- 속성명1로 정렬(오름차순|내림차순)한 후, 속성명1의 값이 같은 행들을 속성명2로 정렬(오른|내림)
    -- 정렬방법이 생략되면 asc(오름차순)
    [order by 속성명 [asc | desc], 속성명2[asc | desc]]
    -- 검색 결과의 개수를 제한
    -- limit 번지, 개수 : 지정번지부터 개수
    -- limit 개수 : 0번지부터 개수
    [limit 절]
*/
use shoppingmall;

-- member 테이블의 me_id와 me_pw 조회
select me_id, me_pw -- ,를 통해 여러 개 입력 가능
	from member;
    
-- member 테이블에 있는 모든 회원 정보를 조회
select * from member; -- * = all

-- member 테이블에 아이디가 abc인 회원 정보를 조회
select * from member where me_id = 'abc';

-- 관리자의 아이디를 조회
select me_id from member where me_authority = 'ADMIN';

-- 일반 회원의 아이디를 조회
select me_id from member where me_authority = 'MEMBER';
select me_id from member where me_authority != 'ADMIN';
select me_id from member where me_authority <> 'ADMIN';

-- 회원들을 아이디순으로 오름차순으로 정렬
select * from member order by me_id;

-- 회원들을 아이디순으로 내림차순으로 정렬
select * from member order by me_id desc;

-- 회원들을 생일순으로 내림차순으로 정렬
select * from member order by me_birth desc;

-- 회원들을 아이디순으로 오름차순으로 정렬하여 처음 2명만 조회
select * from member 
	order by me_id
    limit 0, 2;
    
-- 회원들을 아이디순으로 오름차순으로 정렬하여 2번째 2명만 조회
select * from member 
	order by me_id
    limit 2, 2;
    
-- 회원들을 아이디순으로 오름차순으로 정렬하여 3번째 2명만 조회
select * from member 
	order by me_id
    limit 3, 2;
    
-- n번째 x명 조회 limit(n-1)*x , x