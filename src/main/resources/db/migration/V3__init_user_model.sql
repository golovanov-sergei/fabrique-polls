CREATE TABLE roles
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    role VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (role_id, user_id)
);

CREATE TABLE users
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    username  VARCHAR(255),
    password  VARCHAR(255),
    person_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE roles
    ADD CONSTRAINT uc_roles_role UNIQUE (role);

ALTER TABLE user_roles
    ADD CONSTRAINT uc_user_roles_role UNIQUE (role_id);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES users (id);