INSERT INTO  skills (`name`)
values ('Vue JS'),
       ('JAVA'),
       ('Angular'),
       ('Python');

INSERT INTO  jobs (description, salary, title)
values ('Job description....', 100.5, 'Junior Java Dev'),
       ('Job description....', 50.5, 'Junior Python Dev');

INSERT INTO  jobs_skills (job_entity_id, skills_id)
values (1, 2),
       (2, 4);

INSERT INTO  recruiters (country, email, experience, first_name,last_name)
values ('Russia', 'recruiter1@gmail.com', 1, 'Vladimir', 'Klichko');

INSERT INTO  candidates (first_name, last_name, email, birth_date, bio, recruiter_id)
values ('John', 'Doe', 'candidate1@gmail.com', '1992-10-10' ,'Biography', 1);

INSERT INTO  candidates_skills (candidate_entity_id, skills_id)
values (1, 2);