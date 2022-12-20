/*
DBMS : DB 관리하는 시스템
DDL 
- create(데이터베이스 객체를 생성) 
- alter(데이터베이스 객체를 수정)
- drop(데이터베이스 객체를 삭제)

타입
- date : 날짜 (년,월,일,시,분,초)
- time : 시, 분, 초
- varchar : 문자열
...

join
- inner join : 키값을 기준으로 교집합을 출력하는 방법으로 각 테이블의 null값을 포함하지 않음
- outer join : 여러 테이블 중에서 한 쪽에 데이터가 있고, 
			   한 쪽에는 데이터가 없는 경우 모두 출력하는 방법

문자열 함수
concat : 문자열 이어 붙이기
substring : 부분 문자열 추출

테이블
- 데이터를 일종의 표로 표현한 것

result set
- select를 이용하여 조회한 결과를 표로 나타낸 것

문자열을 날짜로 변환
20221222 -> 2022년 12월 22일 
select date_format(now(), '%y년%m월%d일');

*/
select date_format(now(), '%y년%m월%d일');