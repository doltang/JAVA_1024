-- abc 회원이 올빼미 12월 20일 13:50을 3장 예매 A1, B1, C1
insert into ticketing(ti_amount, ti_me_id, ti_ss_num, ti_total_price)
	values(3, 'abc', 25, 10000 * 3);

select * from ticketing_seat;
select * from seat;
delete from ticketing_seat where ts_num >= 2;
select * from screen_schedule;

insert into ticketing_seat (ts_ti_num, ts_se_num)
	values(2, 11),(2, 13), (2, 15);

update screen_schedule set ss_possible_seat = ss_possible_seat - 3
	where ss_num = 25;
    
update seat
	set 
		se_state = '불가능'
	where 
		se_num = 15;
    
select * from seat where se_ci_num = 2;

-- abc 회원이 예매한 올빼미 상영좌석을 조회(관이름과 좌석번호 조회)
select ci_name as 관이름, se_name as 좌석이름 from ticketing	
    join screen_schedule on ti_ss_num = ss_num
    join movie on mo_num = ss_mo_num
    join ticketing_seat on ts_ti_num = ti_num
    join seat on ts_se_num = se_num
    join cinema on ss_ci_num = ci_num
    where ss_mo_num = 2 and ti_me_id = 'abc';
    
-- 올빼미 12월 20일 13:50 상영에 예매 가능한 좌석을 조회
-- screen_schedule, movie, ticketing, ticketing_seat, seat
select mo_title as 영화, se_name as 좌석명,
	case 
		when ts_num is null
        then 'O'
        else 'X'
	end as 가능여부
from
 (select * from screen_schedule 
where ss_date = '2022-12-20' and ss_time = '13:50') as ss
	join (select * from movie where mo_title like '올빼미') as mo 
		on ss_mo_num = mo_num
	join cinema 
		on ss_ci_num = ci_num
    join seat 
		on se_ci_num = ci_num
	left join ticketing
		on ti_ss_num = ss_num
	left join ticketing_seat
		on ts_se_num = se_num;
-- screen_schedule에 영화 제목 속성을 추가하면 movie 테이블과 join을 하지않아도 됨. 
-- 단, 데이터는 중복
-- ticketing_seat에 좌석 이름을 추가하면 좌석명을 알기 위해 
-- seat 테이블과 join하지 않아도 됨

-- 영화별 누적 관객 수를 조회
select mo_title as '영화', ifnull(sum(ti_amount), 0) as '누적 관객 수' from movie
	-- 아직 현재 시각에 있지 않은 영화 스케줄의 관객 수는 제외
	left join (select * from screen_schedule where ss_date <= now()) as ss
		on ss_mo_num = mo_num
    left join ticketing on ti_ss_num = ss_num
    group by mo_num;

-- 영화 순위(누적별 관객 수)를 조회
select mo_title as '영화', ifnull(sum(ti_amount), 0) as '누적 관객 수' from movie
	left join (select * from screen_schedule where ss_date <= now()) as ss
		on ss_mo_num = mo_num
    left join ticketing on ti_ss_num = ss_num
    group by mo_num
    order by `누적 관객 수` desc;
    
-- 날짜가 지났을 때 변경되어야 할 쿼리
-- 회원이 본 영화 수를 체크
update member
	set 
		me_movie_count = (select count(distinct ss_mo_num) 
        as '영화 목록 개수' from ticketing
		join screen_schedule on ti_ss_num = ss_num
		where ss_date < now())
	where 
		me_id = 'abc';
        
-- 'abc'회원이 본 영화 목록 개수
select count(distinct ss_mo_num) as '영화 목록 개수' from ticketing
	join screen_schedule on ti_ss_num = ss_num
    where ss_date < now();
select * from member;

-- abc회원이 예매한 올빼미 12월 20일 12:50 예매를 취소하는 쿼리
-- delete 예약 내역을 삭제
-- 예약 좌석을 삭제(외래키 때문에 얘를 먼저 삭제 해야함)
delete from ticketing_seat
	where ts_ti_num = (select ti_num 
		from ticketing 
        join screen_schedule on ti_ss_num = ss_num
        where ss_date = '2022-12-20' and ss_time = '13:50' and ss_mo_num = 2);
        
select * from ticketing_seat;
select * from ticketing;
-- 예약 내역을 삭제
delete from ticketing 
	 where ti_ss_num = (select ss_num from screen_schedule
    where ss_date = '2022-12-20' and ss_time = '13:50');
    