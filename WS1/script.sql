CREATE DATABASE MobileCRUD

GO

USE MobileCRUD;

GO

CREATE TABLE [tbl_Mobile] (
	[mobileId] varchar(10) Primary key,
	[description] varchar(250) NOT NULL,
	[price] float,
	[mobileName] varchar(20) NOT NULL,
	[yearOfProduction] int,
	[quantity] int,
	[notSale] bit,--0: sale,1,NULL,
	[url] varchar(255)
)

CREATE TABLE [tbl_User] (
	[userId] varchar(20) Primary Key,
	[password] VARCHAR(255) NOT NULL,
	[fullName] varchar(50) NOT NULL,
	[role] int --0: user, 1: manager, 2: staff
)

CREATE TABLE [tbl_Order] (
	[orderId] varchar(20) PRIMARY KEY,
	[time] datetime,
	[userId] varchar(20),
	FOREIGN KEY ([userId]) REFERENCES [tbl_User]([userId])
)

CREATE TABLE [tbl_OrderDetail] (
    [orderId] varchar(20),
    [mobileId] varchar(10),
    [quantity] int,
    PRIMARY KEY ([orderId], [mobileId]), -- Composite primary key
    FOREIGN KEY ([orderId]) REFERENCES [tbl_Order]([orderId]),
    FOREIGN KEY ([mobileId]) REFERENCES [tbl_Mobile]([mobileId])
);

-- Insert sample data into tbl_Mobile
INSERT INTO [tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale], [url])
VALUES 
('MOB001', 'High-end smartphone with OLED display', 999.99, 'Smartphone X', 2023, 50, 0, 'resources/phone.jpg'),
('MOB002', 'Budget smartphone with good camera', 199.99, 'Budget Phone A', 2022, 150, 1, 'resources/phone.jpg'),
('MOB003', 'Mid-range phone with long battery life', 399.99, 'Midrange Y', 2023, 75, NULL, 'resources/phone.jpg'),
('MOB004', 'Flagship phone with excellent performance', 799.99, 'Flagship Z', 2023, 30, 0, 'resources/phone.jpg'),
('MOB005', 'Compact phone with powerful features', 499.99, 'Compact V', 2021, 60, 1, 'resources/phone.jpg'),
('MOB006', 'Foldable phone with dual screen', 1200.00, 'Foldable W', 2024, 20, 0, 'resources/phone.jpg'),
('MOB007', 'Gaming phone with high refresh rate', 899.99, 'Gaming G', 2023, 40, 0, 'resources/phone.jpg'),
('MOB008', 'Entry-level phone with basic features', 150.00, 'Entry E', 2021, 200, 1, 'resources/phone.jpg'),
('MOB009', 'Camera-centric phone with optical zoom', 649.99, 'Camera C', 2022, 80, NULL, 'resources/phone.jpg'),
('MOB010', 'Eco-friendly phone made with recycled materials', 299.99, 'EcoPhone', 2023, 120, 0, 'resources/phone.jpg');

-- Insert sample data into tbl_User
INSERT INTO [tbl_User] ([userId], [password], [fullName], [role])
VALUES 
('US001', '123456', 'John Doe', 0),
('MN001', '789012', 'Jane Smith', 1),
('ST001', '345678', 'Alice Johnson', 2),
('US002', '901234', 'Bob Brown', 0),
('ST002', '567890', 'Charlie Davis', 2),
('US123', '$31$16$YgGVBhunuFPPHv3geroMdPFT10U6o7jfwwauloxwabY', 'hoang', 0),
('ST123', '$31$16$r9EOiLvbvqPA7absbi_-c_8bBlAIlY516LcX4g6Q9CQ', 'hoang', 2);

-- Insert sample data into tbl_Order
INSERT INTO [tbl_Order] ([orderId], [time], [userId])
VALUES 
('ORD001', '2024-05-01 10:00:00', 'US001'),
('ORD002', '2024-05-02 11:00:00', 'US002'),
('ORD003', '2024-05-03 12:00:00', 'US001'),
('ORD004', '2024-05-04 13:00:00', 'US002'),
('ORD005', '2024-05-05 14:00:00', 'US001'),
('ORD006', '2024-05-06 15:00:00', 'US002'),
('ORD007', '2024-05-07 16:00:00', 'US001'),
('ORD008', '2024-05-08 17:00:00', 'US002'),
('ORD009', '2024-05-09 18:00:00', 'US001'),
('ORD010', '2024-05-10 19:00:00', 'US001');

-- Insert sample data into tbl_OrderDetail
INSERT INTO [tbl_OrderDetail] ([orderId], [mobileId], [quantity])
VALUES 
('ORD001', 'MOB001', 1),
('ORD001', 'MOB004', 2),
('ORD002', 'MOB002', 1),
('ORD002', 'MOB005', 1),
('ORD003', 'MOB003', 3),
('ORD003', 'MOB006', 1),
('ORD004', 'MOB007', 1),
('ORD004', 'MOB008', 2),
('ORD005', 'MOB009', 1),
('ORD005', 'MOB010', 2),
('ORD006', 'MOB001', 2),
('ORD006', 'MOB003', 1),
('ORD007', 'MOB004', 1),
('ORD007', 'MOB006', 1),
('ORD008', 'MOB002', 1),
('ORD008', 'MOB008', 1),
('ORD009', 'MOB005', 1),
('ORD009', 'MOB009', 1),
('ORD010', 'MOB001', 1),
('ORD010', 'MOB010', 1);

-- ----------------------------TEST-------------------------------------------

SELECT * FROM tbl_Mobile
SELECT * FROM tbl_Order
SELECT * FROM tbl_OrderDetail
SELECT * FROM tbl_User

SELECT * FROM tbl_Mobile mb
WHERE mb.mobileId in (SELECT od.mobileId FROM tbl_OrderDetail od)
