INSERT INTO public.roles (role) values ('ROLE_ADMIN');
INSERT INTO public.roles (role) values ('ROLE_USER');

INSERT INTO public.person (name) VALUES ('Sergei');

INSERT INTO public.users(username, password, person_id) values ('admin', '$2a$12$AA0wnkqIpbW/CCNHEfrOCOShoYkHrqyERUzuMjNWTme.guwIVkSoC', 1);

INSERT INTO public.user_roles(user_id, role_id) values (1, 1);

