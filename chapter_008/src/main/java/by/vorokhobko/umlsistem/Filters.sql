SELECT * FROM items AS i;
SELECT * FROM users AS u;
INNER JOIN application AS apc ON i.id = apc.id_item = u.id_item;
WHERE i.create_date > '2017-10-03 20:45:45' AND apc.descriptions_application = 'java developer' AND u.user_id;

INNER JOIN attached_files AS af ON u.user_id = af.id_user;
WHERE u.work_date = 'SQL' AND af.documents = 'new Filter';
WHERE u.name LIKE '%IVANOV%' AND af.letters = 'EPAM Systems';

INNER JOIN role AS r ON i.id = r.id_item = i.id_item;
WHERE i.work_role = 'new JOB' AND r.status_role = 'open to ideas';