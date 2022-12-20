use shoppingmall;

-- 제품번호, 수량, 배송지, 우편주소, 아이디가 주어지며 제품을 구매하는 프로시저를 작성

drop procedure if exists purchase;
delimiter //
create procedure purchase(
	in _num int,
    in _amount int,
    in _address varchar(50),
    in _post_num varchar(10),
    in _id varchar(15)
)
begin
	declare _pr_amount int default 0;
    set _pr_amount = (select pr_amount from product where pr_num = _num);
	if _pr_amount >= _amount then
		insert into buy(bu_num, bu_amount, bu_address, bu_post_num, bu_me_id,
		bu_pr_num) 
		values(concat(_id,left(now(),10)),_amount, _address, _post_num, 
		_id, _num);
		update product set pr_amount = pr_amount - _amount where pr_num = _num;
	end if;
end //
delimiter ;
call purchase(1, 5, '서울시 강남', '12345', 'asd');

select * from buy;