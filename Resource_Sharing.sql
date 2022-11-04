

CREATE DATABASE Resource_Sharing

CREATE TABLE tblRoles(
roleID varchar(10) PRIMARY KEY,
roleName varchar(50) not null,
)

CREATE TABLE tblUsers(
userID varchar(50) PRIMARY KEY,
password varchar(50) not null,
phone varchar(10) not null,
userName varchar(50) not null,
address varchar(70) not null,
roleID varchar(10) FOREIGN KEY REFERENCES tblRoles(roleID) not null, 
gmail varchar(50) not null,
createDate date not null,
status varchar(10) not null,
)


CREATE TABLE tblCategories(
categoryID varchar(50) PRIMARY KEY,
categoryName varchar(50) not null,
)


CREATE TABLE tblResources(
id int PRIMARY KEY,
resourceName varchar(50) not null,
color varchar(20) not null,
categoryID varchar(50) FOREIGN KEY REFERENCES tblCategories(categoryID) not null,
usingDate int not null
)

CREATE TABLE tblRequests(
requestID int PRIMARY KEY,
resourceID int FOREIGN KEY REFERENCES tblResources(id),
categoryID varchar(50) FOREIGN KEY REFERENCES tblCategories(categoryID),
requestStatus varchar(10) not null,
userID varchar(50) FOREIGN KEY REFERENCES tblUsers(userID),
bookingDate date not null,
);


INSERT INTO tblRoles(roleID, roleName)
VALUES ('Mng','Manager'),
	   ('Emp','Employees');

INSERT INTO tblCategories(categoryID, categoryName)
VALUES ('C001','Electronic device'),
       ('C002','Room'),
	   ('C003','Item');

INSERT INTO tblUsers(userID, password, phone, userName, address, roleID, gmail, createDate, status)
VALUES ('namchamvang6','123','1234567890','Trinh Gia Huy','385/46 Bien Hoa','Emp','huyem100720@gmail.com','2021-10-05','Active'),
       ('belenba','123','0987654321','Thai Duc Loi','45/23 tp.HCM','Emp','thaiducloi2000@gmail.com','2021-12-05','Active'),
	   ('concobebe','123','246824682','Duong Kim Long','29/45 tp.HCM','Mng','huyemz123@gmail.com','2020-07-20','Active');

InSERT INTO tblResources(id, resourceName, color, categoryID, usingDate)
VALUES (1, 'Computer', 'Black', 'C001', 5),
       (2, 'Laptop', 'Black', 'C001', 3),
	   (3, 'Printer', 'White', 'C001', 4),
	   (4, 'Projectors', 'Grey', 'C001', 5),
	   (5, 'Meeting Room', 'White', 'C002', 1),
	   (6, 'Meeting Room 2', 'White', 'C002', 2),
	   (7, 'Meeting Room 3', 'green', 'C002', 5),
	   (8, 'Meeting Room 4', 'red', 'C002', 9),
	   (9, 'Meeting Room 5', 'blue', 'C002', 3),
	   (10, 'Meeting Room 6', 'grey', 'C002', 7),
	   (11, 'Meeting Room 7', 'yellow', 'C002', 4);

INSERT INTO tblRequests(requestID, resourceID, categoryID, requestStatus, userID, bookingDate)
VALUES (1,1,'C001','New','namchamvang6','2021-05-10'),
       (2,6,'C002','New','belenba','20210520'),
	   (3,10,'C002','Approve','namchamvang6','2021-04-20');
	  
					 


          