
INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'AGENT'),
(3, 'USER');
INSERT INTO `user` (`user_id`, `enabled`, `password`, `username`) VALUES
(1, b'1', '$2a$10$0DnI9vZYTEfgaYimhQ863ORBJl8fuzxljl0fYjbNaTGilXiw.nEzi', 'admin'),
(2, b'1', '$2a$10$8rDZuGy.3KDzis7DwX5QWOrHvAMqTvbkurTapPkue/29Ku5arfkHi', 'agent'),
(3, b'1', '$2a$10$0DnI9vZYTEfgaYimhQ863ORBJl8fuzxljl0fYjbNaTGilXiw.nEzi', 'user');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(3, 3);