-- 아바타-물의 길에 출현한 감독 및 배우들을 조회하는 쿼리
use cgv;
select mo_title as 영화, mp_name as 이름, mc_role as 역할 
	from movie_person
	join movie_casting on mc_mp_num = mp_num
    join movie on mc_mo_num = mo_num
    where mc_mo_num = 1;
    
-- 제임스 카메론의 참여 영화 리스트를 조회 쿼리
select mo_title as 영화, mp_name as 이름, mc_role as 역할
	from movie_person
    join movie_casting on mc_mp_num = mp_num
    join movie on mc_mo_num = mo_num
    where mp_name like '제임스 카메론'
    and mc_role like '감독';

-- 아바타 누적 관객 수를 조회하는 쿼리
select sum(ti_amount) as '아바타 누적관객수'from ticketing
	join screen_schedule on ti_ss_num = ss_num
    join movie on ss_mo_num = mo_num
    where mo_num = 1 and ss_date <= now();
    
-- 누적 관객 수가 1명 이상인 영화를 조회하는 쿼리
select sum(ti_amount) as '누적관객수', mo_title as 영화 from ticketing
	join screen_schedule on ti_ss_num = ss_num
    join movie on ss_mo_num = mo_num
    where ss_date <= now()
	group by mo_num
    having `누적관객수` >= 1;
    
    