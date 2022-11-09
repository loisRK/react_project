use pgdb;

DESC user;
DESC post;
select * from post;
insert into post(user_id, post_contents, post_date) values('123@naver.com', "첫 번째 게시글 입니다.", now());
insert into post(user_id, post_contents, post_date) values('456@naver.com', "두 번째 게시글 입니다.", now());
insert into post(user_id, post_contents, post_date) values('789@naver.com', "세 번째 게시글 입니다.", now());

select * from user;
insert into user(user_email, user_nickname, user_pw, user_name, user_birth, user_mbti) 
values('123@naver.com', '닉네임', '123', '일이삼', '1999-01-01', 'ENFP');
insert into user(user_email, user_nickname, user_pw, user_name, user_birth, user_mbti) 
values('456@naver.com', '피죤', '123', '김비둘', '2000-07-01', 'INTP');
insert into user(user_email, user_nickname, user_pw, user_name, user_birth, user_mbti) 
values('789@naver.com', '일론마스크', '123', '박일론', '1991-11-09', 'ENSJ');

SELECT * FROM user;

commit;