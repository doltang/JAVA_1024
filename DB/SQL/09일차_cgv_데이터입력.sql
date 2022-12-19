
insert into movie (mo_title, mo_contents, mo_age, mo_run, 
	mo_opening_date, mo_state)
    values ('올빼미', '맹인이지만 뛰어난 침술 실력을 지닌 ‘경수’는 
	어의 ‘이형익’에게 그 재주를 인정받아 궁으로 들어간다...', 15, 118, 
    '2022-11-23','현재상영중');
select * from movie;

insert into movie_person (mp_name, mp_birth, mp_contry)
	 values('안태진','1986-09-02', '한국'),('류준열', '1986-09-25', '한국'),
     ('유해진','1970-01-04', '한국'),('최무성','1968-01-12', '한국');
select * from movie_person;

insert into movie_casting (mc_mp_num, mc_mo_num, mc_role)
	values(9, 2, '감독'),(10, 2, '배우'),(10, 2, '배우'),(11, 2, '배우'),(12, 2, '배우');

select * from genre;
insert into movie_genre (mg_ge_name, mg_mo_num)
	values('스릴러', 2);
    
insert into stillcut (st_file_name, st_mo_num)
	values('https://img.cgv.co.kr/Movie/Thumbnail/StillCut/000086/86481/86481210724_727.jpg',
    2);
    
insert into trailer (tr_title, tr_file_name, tr_mo_num)
	values('메인 예고편', 'https://img.cgv.co.kr/Movie/Thumbnail/Trailer/86481/86481208327_1024.jpg',
    2);

select * from cinema;

insert into screen_schedule (ss_date, ss_time, ss_total_seat, 
	ss_possible_seat, ss_mo_num, ss_ci_num)
    values('2022-12-20', '13:50', 10, 10, 2, 2),
    ('2022-12-20', '11:00', 10, 10, 2, 6),
    ('2022-12-20', '17:10', 10, 10, 2, 6);
select * from screen_schedule;