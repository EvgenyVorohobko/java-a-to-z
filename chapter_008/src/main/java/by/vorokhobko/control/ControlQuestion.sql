--1) Retrieve in a single query:
--    * names of all persons that are NOT in the company with id = 5
--    * company name for each person
SELECT p.name, c.name FROM person as p LEFT OUTER JOIN company as c ON p.company_id = c.id WHERE p.company_id != 5;
--2) Select the name of the company with the maximum number of persons + number of persons in this company
SELECT person.company_id, COUNT(*) FROM person GROUP BY person.company_id;
SELECT p.name, c.name FROM person as p LEFT OUTER JOIN company as c ON p.company_id = c.id WHERE p.company_id = 4;