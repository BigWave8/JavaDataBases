CREATE SCHEMA IF NOT EXISTS oryshchak;
USE oryshchak;

DROP TABLE IF EXISTS user_operator;
DROP TABLE IF EXISTS parcel;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS password;
DROP TABLE IF EXISTS parcel_on_way;
DROP TABLE IF EXISTS operator;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS adress;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS region;
DROP TABLE IF EXISTS courier;
DROP TABLE IF EXISTS name;

CREATE TABLE name
(
    id          INT         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(45) NOT NULL,
    surname     VARCHAR(45) NOT NULL,
    middle_name VARCHAR(45) NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE courier
(
    id      INT NOT NULL AUTO_INCREMENT,
    name_id INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_courier_UNIQUE (id ASC) VISIBLE,
    INDEX fk_courier_name1_idx (name_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE region
(
    id     INT         NOT NULL AUTO_INCREMENT,
    region VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE city
(
    id        INT         NOT NULL AUTO_INCREMENT,
    city      VARCHAR(45) NULL,
    region_id INT         NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_city_region1_idx (region_id ASC) VISIBLE,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE adress
(
    id               INT         NOT NULL AUTO_INCREMENT,
    street           VARCHAR(45) NULL,
    house_number     VARCHAR(45) NULL,
    apartment_number VARCHAR(45) NOT NULL,
    `index`          VARCHAR(45) NOT NULL,
    city_id          INT         NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    INDEX fk_adress_city1_idx (city_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE department
(
    id        INT NOT NULL AUTO_INCREMENT,
    `index`   INT NULL DEFAULT NULL,
    adress_id INT NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_department_adress1_idx (adress_id ASC) VISIBLE,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE operator
(
    id      INT NOT NULL AUTO_INCREMENT,
    name_id INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_operator_UNIQUE (id ASC) VISIBLE,
    INDEX fk_operator_name1_idx (name_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE parcel_on_way
(
    id         INT NOT NULL AUTO_INCREMENT,
    courier_id INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX route_number_UNIQUE (id ASC) VISIBLE,
    INDEX fk_parcel_on_way_courier1_idx (courier_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE password
(
    id       INT         NOT NULL AUTO_INCREMENT,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE user
(
    id           INT         NOT NULL AUTO_INCREMENT,
    phone_number VARCHAR(12) NULL DEFAULT NULL,
    adress_id    INT         NOT NULL,
    name_id      INT         NOT NULL,
    password_id  INT         NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_user_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX phone_number_UNIQUE (phone_number ASC) VISIBLE,
    INDEX fk_user_adress1_idx (adress_id ASC) VISIBLE,
    INDEX fk_user_name1_idx (name_id ASC) VISIBLE,
    INDEX fk_user_password1_idx (password_id ASC) VISIBLE,
    UNIQUE INDEX password_id_UNIQUE (password_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE parcel
(
    order_number               VARCHAR(45)   NOT NULL,
    category                   VARCHAR(45)   NOT NULL,
    mass_in_kilogram           DECIMAL(8, 3) NOT NULL,
    fragility                  TINYINT       NOT NULL,
    date_of_receiving          VARCHAR(45)   NOT NULL,
    sender                     INT           NOT NULL,
    recepient                  INT           NOT NULL,
    sender_id_department       INT           NOT NULL,
    recepient_id_department    INT           NOT NULL,
    parcel_on_way_route_number INT           NULL DEFAULT NULL,
    PRIMARY KEY (order_number),
    UNIQUE INDEX order_number_UNIQUE (order_number ASC) VISIBLE,
    UNIQUE INDEX date_of_receiving_UNIQUE (date_of_receiving ASC) VISIBLE,
    INDEX fk_parcel_user1_idx (sender ASC) VISIBLE,
    INDEX fk_parcel_user2_idx (recepient ASC) VISIBLE,
    INDEX fk_parcel_department1_idx (sender_id_department ASC) VISIBLE,
    INDEX fk_parcel_department2_idx (recepient_id_department ASC) VISIBLE,
    INDEX fk_parcel_parcel_on_way1_idx (parcel_on_way_route_number ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE user_operator
(
    id          INT NOT NULL AUTO_INCREMENT,
    user_id     INT NOT NULL,
    operator_id INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_dialogue_UNIQUE (id ASC) VISIBLE,
    INDEX fk_user_operator_user1_idx (user_id ASC) VISIBLE,
    INDEX fk_user_operator_operator1_idx (operator_id ASC) VISIBLE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 0;

CREATE INDEX order_number ON parcel (order_number);
CREATE INDEX mass_in_kilogram ON parcel (mass_in_kilogram);

ALTER TABLE courier
    ADD CONSTRAINT fk_courier_name1
        FOREIGN KEY (name_id)
            REFERENCES name (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE city
    ADD CONSTRAINT fk_city_region1
        FOREIGN KEY (region_id)
            REFERENCES region (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE adress
    ADD CONSTRAINT fk_adress_city1
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE department
    ADD CONSTRAINT fk_department_adress1
        FOREIGN KEY (adress_id)
            REFERENCES adress (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE operator
    ADD CONSTRAINT fk_operator_name1
        FOREIGN KEY (name_id)
            REFERENCES name (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE parcel_on_way
    ADD CONSTRAINT fk_parcel_on_way_courier1
        FOREIGN KEY (courier_id)
            REFERENCES courier (id);

ALTER TABLE user
    ADD CONSTRAINT fk_user_adress1
        FOREIGN KEY (adress_id)
            REFERENCES adress (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_user_name1
        FOREIGN KEY (name_id)
            REFERENCES name (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_user_password1
        FOREIGN KEY (password_id)
            REFERENCES password (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE parcel
    ADD CONSTRAINT fk_parcel_department1
        FOREIGN KEY (sender_id_department)
            REFERENCES department (id),
    ADD CONSTRAINT fk_parcel_department2
        FOREIGN KEY (recepient_id_department)
            REFERENCES department (id),
    ADD CONSTRAINT fk_parcel_parcel_on_way1
        FOREIGN KEY (parcel_on_way_route_number)
            REFERENCES parcel_on_way (id),
    ADD CONSTRAINT fk_parcel_user1
        FOREIGN KEY (sender)
            REFERENCES user (id),
    ADD CONSTRAINT fk_parcel_user2
        FOREIGN KEY (recepient)
            REFERENCES user (id);

ALTER TABLE user_operator
    ADD CONSTRAINT fk_user_operator_operator1
        FOREIGN KEY (operator_id)
            REFERENCES operator (id),
    ADD CONSTRAINT fk_user_operator_user1
        FOREIGN KEY (user_id)
            REFERENCES user (id);

INSERT INTO region (region)
VALUES ('Cherkasy oblas'),
       ('Kharkiv oblast'),
       ('Kherson oblast'),
       ('Khmelnytsk oblast'),
       ('Kyiv oblast'),
       ('Lviv oblast'),
       ('Mykolaiv oblast'),
       ('Odesa oblast'),
       ('Sumy oblast'),
       ('Zakarpattia oblast');

INSERT INTO city (city, region_id)
VALUES ('Lviv', '6'),
       ('Mykolaiv', '6'),
       ('Yavoriv', '6'),
       ('Sokilnyky', '6'),
       ('Jidachiv', '6'),
       ('Kyiv', '5'),
       ('Mykolaiv', '7'),
       ('Zymna Voda', '6'),
       ('Sumy', '9'),
       ('Odesa', '8');

INSERT INTO adress (street, house_number, apartment_number, `index`, city_id)
VALUES ('Shevchenka', '1', '1', '79000', '1'),
       ('Shevchenka', '2', '1', '79000', '1'),
       ('Shevchenka', '3', '1', '79000', '1'),
       ('Shevchenka', '4', '1', '79000', '1'),
       ('Shevchenka', '5', '1', '79043', '2'),
       ('Shevchenka', '6', '1', '79002', '1'),
       ('Shevchenka', '7', '1', '79000', '1'),
       ('Zelena', '88', '23', '79000', '1'),
       ('Zelena', '99', '23', '79000', '1'),
       ('Zelena', '111', '4', '79000', '2');

INSERT INTO password (password)
VALUES ('123'),
       ('1234'),
       ('12345'),
       ('12344321'),
       ('1111'),
       ('1122'),
       ('111'),
       ('1'),
       ('2'),
       ('3');

INSERT INTO name (name, surname, middle_name)
VALUES ('Dima', 'Veres', NULL),
       ('Dima', 'Oryshchak', NULL),
       ('Dima', 'Oryshchak', 'Batkiovych'),
       ('Dima', 'Oryshchak', 'Tarasovych'),
       ('Dima', 'Oryshchak', 'Zenoviovych'),
       ('Dima', 'Buchkovski', NULL),
       ('Taras', 'Veres', NULL),
       ('Taras', 'Oryshchak', 'Tarasovych'),
       ('Sofia', 'Veres', 'Tarasivna'),
       ('Sofia', 'Oryshchak', NULL);

INSERT INTO courier (name_id)
VALUES ('2'),
       ('2'),
       ('2'),
       ('2'),
       ('3'),
       ('3'),
       ('4'),
       ('4'),
       ('4'),
       ('4');

INSERT INTO operator (name_id)
VALUES ('5'),
       ('7'),
       ('7'),
       ('7'),
       ('8'),
       ('8'),
       ('8'),
       ('9'),
       ('9'),
       ('9');

INSERT INTO user (phone_number, adress_id, name_id, password_id)
VALUES ('380961234567', '4', '4', '1'),
       ('380961234568', '7', '3', '2'),
       ('380961234569', '8', '2', '3'),
       ('380961234560', '6', '1', '4'),
       ('380931234567', '9', '5', '5'),
       ('380931234568', '5', '6', '6'),
       ('380931234569', '1', '7', '7'),
       ('380931234560', '2', '8', '8'),
       ('380961234566', '3', '9', '9'),
       ('380961234565', '9', '1', '10');

INSERT INTO user_operator (user_id, operator_id)
VALUES ('1', '6'),
       ('3', '1'),
       ('5', '2'),
       ('7', '3'),
       ('9', '6'),
       ('2', '5'),
       ('4', '7'),
       ('6', '6'),
       ('8', '9'),
       ('3', '8');

INSERT INTO parcel_on_way (courier_id)
VALUES ('3'),
       ('5'),
       ('7'),
       ('9'),
       ('1'),
       ('2'),
       ('3'),
       ('4'),
       ('7'),
       ('7');

INSERT INTO department(`index`, adress_id) VALUE
    ('11111', '4'),
    ('22222', '5'),
    ('33333', '6'),
    (NULL, '7'),
    ('55555', '8'),
    (NULL, '9'),
    (NULL, '10'),
    (NULL, '1'),
    (NULL, '2'),
    (NULL, '3');

INSERT INTO parcel(order_number, category, mass_in_kilogram, fragility, date_of_receiving, sender,
                   recepient, sender_id_department, recepient_id_department,
                   parcel_on_way_route_number) VALUE
    ('ikmyujtnhybtrgvrc', 'Sport', '32.320', '1', '01.01.2010 11:21:01', '5', '3', '3', '2', '3'),
    ('likmyujnhbtrg', 'Sport', '31.320', '1', '01.01.2020 11:21:01', '5', '3', '9', '2', '3'),
    ('5tegrefcsdfergr', 'Kosmetic', '21.000', '1', '01.01.2020 11:21:31', '6', '3', '5', '2', '7'),
    ('cdevfrgthy', 'Sport', '3.320', '1', '01.01.2021 11:21:01', '5', '1', '3', '8', '3'),
    ('eyrthdf', 'Kosmetic', '321.300', '0', '01.01.2020 11:21:1', '6', '1', '4', '7', '5'),
    ('hiuo', 'Kosmetic', '321.120', '1', '01.01.2020 11:21:13', '6', '1', '5', '7', '5'),
    ('jnuh', 'Sport', '321.321', '1', '01.01.2030 11:21:01', '5', '9', '3', '6', '4'),
    ('o8ikuxcdsewf', 'Sport', '321.322', '0', '01.01.2020 11:2:01', '4', '8', '4', '6', '9'),
    ('rwefsd', 'Sport', '321.323', '0', '01.01.2020 1:21:01', '4', '5', '3', '5', '8'),
    ('xzbfdtry', 'Sport', '1.000', '0', '01.01.2020 11:1:01', '3', '4', '6', '3', '6');