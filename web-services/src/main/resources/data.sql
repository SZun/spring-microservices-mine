insert into user(id, name, birth_date) values(10001, 'AB', sysdate());
insert into user(id, name, birth_date) values(10002, 'Jack', sysdate());
insert into user(id, name, birth_date) values(10003, 'Jill', sysdate());

insert into post(id, description, user_id) values(11001, 'My First Post', 10001)
insert into post(id, description, user_id) values(11002, 'My Second Post', 10001)