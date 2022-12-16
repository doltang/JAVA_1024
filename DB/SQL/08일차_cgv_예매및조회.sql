-- 영화 [아바타-물의 길] 상영 시간을 조회하는 쿼리 작성
-- 정렬은 영화관 순으로
select ss_date as 상영일, ss_time as 상영시간, ci_name as 상영관, ss_possible_seat as 예매가능좌석수
	from screen_schedule
    join movie on mo_num = ss_mo_num
    join cinema on ss_ci_num = ci_num
    where mo_title like '아바타-물의 길' 
		and mo_state = '현재 상영중'
        and ss_date >= now()
	order by ss_ci_num;
    
-- 18일 9:50에 상영하는 아바타의 예매 가능 좌석들을 조회
select ss_date as 상영일, ss_time as 상영시간, ci_name as 상영관, 
 se_name as 좌석명,
case 
	when ts_num is null
    then 'O'
    else 'X'
end as 예약가능
from screen_schedule
    join movie on mo_num = ss_mo_num
    join cinema on ss_ci_num = ci_num
    join seat on ci_num = se_ci_num
    left join ticketing_seat on ts_se_num = se_num
    where mo_title like '아바타-물의 길' 
		and mo_state = '현재 상영중'
        and ss_date = '2022-12-18'
        and ss_time = '09:50'
        and se_state = '가능'
	order by ss_ci_num;
    
-- abc 회원이 18일 09:50에 상영하는 아바타를 A1, A2 두 자리를 예매했다.
-- 단, 작업의 편의를 위해, 18일 09:50에 상영하는 아바타라는 정보대신 상영번호 5번으로 활용
-- 예매
insert into ticketing (ti_amount, ti_me_id, ti_ss_num, ti_total_price)
	values(2, 'abc', 5, 20000);
select * from ticketing;

-- 좌석 예매
drop table ticketing_seat;
insert into ticketing_seat (ts_ti_num, ts_se_num)
	select 1, se_num from seat where se_name = 'A1' and se_ci_num = 1;
insert into ticketing_seat (ts_ti_num, ts_se_num)
	select 1, se_num from seat where se_name = 'A2' and se_ci_num = 1;
select * from ticketing_seat;

-- 상영정보에 예매 가능 좌석 수정
update screen_schedule
	set 
		ss_possible_seat = 10
	where ss_num = 6;
select * from screen_schedule;

-- 아바타-물의 길을 상영하는 극장정보를 조회하는 쿼리
select th_name from movie
		join screen_schedule on ss_mo_num = mo_num
        join cinema on ss_ci_num = ci_num
        join theater on ci_th_num = th_num
	 where mo_title like '아바타-물의 길'
     and ss_date >= now()
     group by th_name;

-- cgv강남에서 상영하는 영화를 조회
select mo_title from movie
	join screen_schedule on ss_mo_num = mo_num
	join cinema on ss_ci_num = ci_num
	join theater on ci_th_num = th_num
    where th_name like 'CGV강남'
    group by mo_num;
