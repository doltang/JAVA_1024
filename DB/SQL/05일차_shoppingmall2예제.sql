drop database if exists `shoppingmall2`;

create database if not exists `shoppingmall2`;
use shoppingmall2;

create table if not exists member (
	-- 기본키에는 not null 생략 가능
	me_id varchar(15) primary key, -- 아이디
    me_pw varchar(20) not null, -- 비번
	me_name varchar(20), -- 이름
    me_birth date, -- 생년월일
    me_authority varchar(6) not null default 'MEMBER', -- 권한
    me_point int not null default 0
);

create table if not exists main_category (
	mc_num int auto_increment primary key, -- 제품 대분류 번호
    mc_title varchar(20) not null -- 제품 대분류명
);

create table if not exists sub_category (
	sc_num int auto_increment primary key, -- 제품 중분류 번호
    sc_title varchar(20) not null, -- 제품 중분류명
	sc_mc_num int not null, -- 제품 대분류명(FK)
	foreign key(sc_mc_num) references main_category(mc_num)
);

create table if not exists product (
	pr_num int auto_increment primary key, -- 제품 번호
    pr_title varchar(50) not null, -- 제품 이름
    pr_contents longtext not null, -- 제품 상세
    pr_reg_date datetime not null default now(),
    pr_amount int not null default 0, -- 수량
    pr_price int not null default 0, -- 가격
    pr_sc_num int not null, -- 제품 중분류명(FK)
	foreign key(pr_sc_num) references sub_category(sc_num)
);

create table if not exists product_option (
	po_num int auto_increment primary key, -- 옵션 번호
    po_title varchar(50) not null, -- 옵션 이름
    po_amount int not null default 1, -- 옵션 수량
    po_pr_num int not null, -- 제품 번호(FK)
	foreign key(po_pr_num) references product(pr_num)
);

create table if not exists address_book (
	ab_num int auto_increment primary key, -- 주소록 번호
    ab_name varchar(15) not null, -- 기본 주소
    ab_address varchar(100) not null, -- 상세주소
    ab_post_num char(5) not null, -- 우편 번호
    ab_me_id varchar(15), -- 아이디(FK)
	foreign key(ab_me_id) references member(me_id)
);

create table if not exists basket(
	ba_num int auto_increment primary key,
    ba_amount int not null default 0,
    ba_me_id varchar(15) not null,
    ba_po_num int not null,
    foreign key(ba_me_id) references member(me_id),
    foreign key(ba_po_num) references product_option(po_num)
);

create table if not exists `order` (
	or_num int auto_increment primary key, -- 주문 번호
    or_total_price int not null, -- 총 가격
    or_price int not null, -- 결제 금액
    or_use_pt int not null, -- 사용 포인트
	or_add_pt int not null, -- 적립 포인트
    or_state varchar(10) not null default '결제 완료', -- 구매 상태
    or_ab_num int not null, -- 주소록 번호(FK)
    or_me_id varchar(15), -- 아이디(FK)
	foreign key(or_ab_num) references address_book(ab_num),
    foreign key(or_me_id) references member(me_id)
);

create table if not exists order_list(
	ol_num int auto_increment primary key,
    ol_amount int not null, 
    ol_price int not null,
    ol_po_num int not null,
    ol_or_num int not null,
    foreign key(ol_po_num) references product_option(po_num),
    foreign key(ol_or_num) references `order`(or_num)
);