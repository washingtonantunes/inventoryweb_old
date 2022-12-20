INSERT INTO tb_projects (id, city, cost_center, name, date_entry, status) VALUES (1, 'São Paulo', 'BR0152', 'SINQIA', '2021-10-05', 'ACTIVE');
INSERT INTO tb_projects (id, city, cost_center, name, date_entry, status) VALUES (2, 'São Paulo', 'BR08544', 'IFOOD', '2021-08-05', 'ACTIVE');

INSERT INTO tb_users (id, registration, name, cpf, project_id, date_entry, status) VALUES (1, '125622', 'João da Silva Alves', '24839872309', 1, '2022-10-27', 'ACTIVE');
INSERT INTO tb_users (id, registration, name, cpf, date_entry, status) VALUES (2, '005622', 'Washington Antunes', '03228223434', '2022-02-20', 'ACTIVE');
INSERT INTO tb_users (id, registration, name, cpf, project_id, date_entry, status) VALUES (3, '123322', 'João Paulo Pereira', '69123454415', 2, '2022-05-10', 'ACTIVE');

INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status) VALUES (1, 'HP', '2021-12-22 11:00:54', 'TI', 'HP 240 G7 Notebook PC', 'NOTEBOOK', '25416', 'BRJ132NBSY', 102544,  'STAND_BY');
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status) VALUES (2, 'HP', '2021-12-23 11:00:54', 'TI', 'PRODESK 400 G4', 'DESKTOP', '25416', 'BRJ742KBDK', 005426, 'STAND_BY');
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status) VALUES (3, 'HP', '2021-12-23 13:00:54', 'TI', 'PRODESK 400 G4', 'NOTEBOOK', '25416', 'BRJ831TSWN', 010254, 'STAND_BY');
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status) VALUES (4, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRJ93047RM', 000245, 'STAND_BY');
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status, project_id) VALUES (5, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRJ934521', 000444, 'IN_USE', 1 );
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status, project_id, user_id) VALUES (6, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRJ93000RM', 100245, 'IN_USE', 1, 1);
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status, project_id) VALUES (7, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRJ83000RM', 000205, 'IN_USE', 2);
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status) VALUES (8, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRJ71047RM', 002245, 'STAND_BY');
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status) VALUES (9, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRJ93049RM', 003345, 'STAND_BY');
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status) VALUES (10, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRL93187RM', 001145, 'STAND_BY');
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status, project_id, user_id) VALUES (11, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRJ0101RM', 004245, 'STAND_BY', 2, 3);
INSERT INTO tb_computers (id, brand, date_entry, location, model, type, note_entry, serial_number, patrimony_number, status) VALUES (12, 'HP', '2021-12-27 11:00:54', 'TI', 'PRODESK 400 G5', 'NOTEBOOK', '25416', 'BRJ14327RM', 001245, 'STAND_BY');

INSERT INTO tb_changes_project (author, description, date, type, project_id) VALUES ('Washington Antunes', 'Projeto Cadastrado no Sistema', '2022-05-10', 'ENTRY', 1);
INSERT INTO tb_changes_project (author, description, date, type, project_id) VALUES ('Washington Antunes', 'Projeto Cadastrado no Sistema', '2020-02-10', 'ENTRY', 2);

INSERT INTO tb_changes_user (author, description, date, type, user_id) VALUES ('Washington Antunes', 'Usuário Cadastrado no Sistema', '2020-05-05', 'ENTRY', 1);
INSERT INTO tb_changes_user (author, description, date, type, user_id) VALUES ('Washington Antunes', 'Usuário Cadastrado no Sistema', '2021-04-10', 'ENTRY', 2);
INSERT INTO tb_changes_user (author, description, date, type, user_id) VALUES ('Washington Antunes', 'Usuário Cadastrado no Sistema', '2022-05-18', 'ENTRY', 3);

INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 1);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 2);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 3);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 4);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 5);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 6);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 7);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 8);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 9);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 10);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 11);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Computador Cadastrado no Sistema', '2021-05-10', 'ENTRY', 12);

INSERT INTO tb_changes_user (author, description, date, type, user_id) VALUES ('Washington Antunes', 'Entrega de Equipamento: BRJ934521', '2022-12-05', 'DELIVERY_TO_USER', 1);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Saida de Equipamento do Estoque para Usuário', '2022-01-05', 'DELIVERY_TO_USER', 6);

INSERT INTO tb_changes_user (author, description, date, type, user_id) VALUES ('Washington Antunes', 'Entrega de Equipamento: BRJ0101RM', '2022-12-05', 'DELIVERY_TO_USER', 3);
INSERT INTO tb_changes_computer (author, description, date, type, computer_id) VALUES ('Washington Antunes', 'Saida de Equipamento do Estoque para Usuário', '2022-01-05', 'DELIVERY_TO_USER', 11);

INSERT INTO tb_items (identification, type, value, id_user) VALUES ('BRJ934521', 'NOTEBOOK', '0', '1');
INSERT INTO tb_items (identification, type, value, id_user) VALUES ('BRJ0101RM', 'NOTEBOOK', '0', '3');
