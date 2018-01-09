INSERT INTO PRODUCT(ProductId, NAME, DESCRIPTION,UNITPRICE, MANUFACTURER, CATEGORY, UNITSINSTOCK, UNITSINORDER, DISCONTINUED) VALUES ('P1234', 'iPhone 6s', 'Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera',500,'Apple','Smartphone',450,0,false);
INSERT INTO PRODUCT(ProductId, NAME, DESCRIPTION,UNITPRICE, MANUFACTURER, CATEGORY, UNITSINSTOCK, UNITSINORDER, DISCONTINUED) VALUES ('P1235', 'Dell Inspiron', 'Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors',700,'Dell','Laptop',1000,0,false);
INSERT INTO PRODUCT(ProductId, NAME, DESCRIPTION,UNITPRICE, MANUFACTURER, CATEGORY, UNITSINSTOCK, UNITSINORDER, DISCONTINUED) VALUES ('P1236', 'Nexus 7', 'Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor', 300,'Google','Tablet',1000,0,false);

/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(type)
VALUES ('USER');

INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');

INSERT INTO USER_PROFILE(type)
VALUES ('DBA');


/* Populate one Admin User which will further create other users for the application using GUI */
INSERT INTO APP_USER(username, password, first_name, last_name, email)
VALUES ('sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Sam','Smith','samy@xyz.com');


/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, user_profile.id FROM app_user user, user_profile user_profile where user.username='sam' and user_profile.type='ADMIN';

/* Create persistent_logins Table used to store rememberme related stuff*/
CREATE TABLE persistent_logins (
  username VARCHAR(64) NOT NULL,
  series VARCHAR(64) NOT NULL,
  token VARCHAR(64) NOT NULL,
  last_used TIMESTAMP NOT NULL,
  PRIMARY KEY (series)
);
