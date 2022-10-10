INSERT INTO `user`(username, email, password) VALUE ('nika', 'nika@planner.pl', '$2a$12$u329jke.zRABSiNaBhW8RelHL7ULjjfJE1vZp2NBe1qRoYB9Sky42');  /*12345*/
INSERT INTO `user`(username, email, password) VALUE ('admin', 'admin@planner.pl', '$2a$12$u329jke.zRABSiNaBhW8RelHL7ULjjfJE1vZp2NBe1qRoYB9Sky42');  /*12345*/
INSERT INTO `user`(username, email, password) VALUE ('adam', 'adam@planner.pl', '$2a$12$u329jke.zRABSiNaBhW8RelHL7ULjjfJE1vZp2NBe1qRoYB9Sky42');  /*12345*/

INSERT INTO `role` (name) values ('ADMIN');
INSERT INTO `role` (name) values ('USER');

INSERT INTO `user_roles`(user_id, roles_id) VALUE (1, 2);
INSERT INTO `user_roles`(user_id, roles_id) VALUE (2, 1);
INSERT INTO `user_roles`(user_id, roles_id) VALUE (3, 2);