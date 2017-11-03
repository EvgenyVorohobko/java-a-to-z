INSERT INTO user(user_login, name, create_information, password) VALUES ('zanoza', 'Alexey', 'VIP-client', 'ambassador1853');
INSERT INTO role(status_role, description_role, id_user) VALUES ('workStatus', 'upWorking', 1);
INSERT INTO rule_role(algoritm, number_rows, id_role) VALUES ('rules_algoritm', 'count_rows', 1);
INSERT INTO attached_files(documents, letters, id_user) VALUES ('documents_add', 'letters_arrive', 1);
INSERT INTO application(applications, description_application, id_user) VALUES ('applications_all', 'description_all', 1);
INSERT INTO comment_application(comments, id_application) VALUES ('commentaries', 1);
INSERT INTO items(date_id, application_id, role_id, create_data) VALUES (1, 1, 1, '2017-11-03 20:45:45');