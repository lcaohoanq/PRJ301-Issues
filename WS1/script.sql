CREATE DATABASE MobileCRUD
USE MobileCRUD;

CREATE TABLE [tbl_Mobile] (
	[mobileId] varchar(10) Primary key,
	[description] varchar(250) NOT NULL,
	[price] float,
	[mobileName] varchar(20) NOT NULL,
	[yearOfProduction] int,
	[quantity] int,
	[notSale] bit --0: sale,1,NULL
)

CREATE TABLE [tbl_User] (
	[userId] varchar(20) Primary Key,
	[password] VARCHAR(255) NOT NULL,
	[fullName] varchar(50) NOT NULL,
	[role] int --0: user, 1: manager, 2: staff
)

-- Insert sample data into tbl_Mobile
INSERT INTO [tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale])
VALUES 
('MOB001', 'High-end smartphone with OLED display', 999.99, 'Smartphone X', 2023, 50, 0),
('MOB002', 'Budget smartphone with good camera', 199.99, 'Budget Phone A', 2022, 150, 1),
('MOB003', 'Mid-range phone with long battery life', 399.99, 'Midrange Y', 2023, 75, NULL),
('MOB004', 'Flagship phone with excellent performance', 799.99, 'Flagship Z', 2023, 30, 0),
('MOB005', 'Compact phone with powerful features', 499.99, 'Compact V', 2021, 60, 1),
('MOB006', 'Foldable phone with dual screen', 1200.00, 'Foldable W', 2024, 20, 0),
('MOB007', 'Gaming phone with high refresh rate', 899.99, 'Gaming G', 2023, 40, 0),
('MOB008', 'Entry-level phone with basic features', 150.00, 'Entry E', 2021, 200, 1),
('MOB009', 'Camera-centric phone with optical zoom', 649.99, 'Camera C', 2022, 80, NULL),
('MOB010', 'Eco-friendly phone made with recycled materials', 299.99, 'EcoPhone', 2023, 120, 0);

-- Insert sample data into tbl_User
INSERT INTO [tbl_User] ([userId], [password], [fullName], [role])
VALUES 
('US001', '123456', 'John Doe', 0),
('MN001', '789012', 'Jane Smith', 1),
('ST001', '345678', 'Alice Johnson', 2),
('US002', '901234', 'Bob Brown', 0),
('ST002', '567890', 'Charlie Davis', 2);

SELECT * FROM tbl_Mobile