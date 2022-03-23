INSERT INTO public.person (name) VALUES ('Sergei');
INSERT INTO public.person (name) VALUES ('Ivan');

INSERT INTO public.polls (name, description, start_date, end_date) VALUES ('Survey #1', 'Survey #1 description', '2022-03-23 16:55:35.874907', '2022-04-02 16:55:35.874907');
INSERT INTO public.polls (name, description, start_date, end_date) VALUES ('Survey #2', 'Survey #2 description', '2022-03-24 14:00:00.000000', '2022-04-24 14:00:00.000000');

INSERT INTO public.questions (question_type, name, poll_id) VALUES (1, 'Qurstion #1 of survey #1', 1);
INSERT INTO public.questions (question_type, name, poll_id) VALUES (0, 'Qurstion #2 of survey #1', 1);
INSERT INTO public.questions (question_type, name, poll_id) VALUES (2, 'Qurstion #3 of survey #1', 1);

INSERT INTO public.choices (answer, question_id) VALUES ('Question #1 of survey #1 - choice 1', 1);
INSERT INTO public.choices (answer, question_id) VALUES ('Question #1 of survey #1 - choice 2', 1);
INSERT INTO public.choices (answer, question_id) VALUES ('Question #1 of survey #1 - choice 3', 1);
INSERT INTO public.choices (answer, question_id) VALUES ('Question #1 of survey #1 - choice 4', 1);
INSERT INTO public.choices (answer, question_id) VALUES ('Question #1 of survey #1 - choice 5', 1);
INSERT INTO public.choices (answer, question_id) VALUES ('Question #2 of survey #1 - choice 1', 2);
INSERT INTO public.choices (answer, question_id) VALUES ('Question #2 of survey #1 - choice 2', 2);
INSERT INTO public.choices (answer, question_id) VALUES ('Question #2 of survey #1 - choice 3', 2);
INSERT INTO public.choices (answer, question_id) VALUES ('Question #2 of survey #1 - choice 4', 2);
