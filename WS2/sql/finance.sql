CREATE DATABASE personal_finance

GO

USE personal_finance

GO

CREATE TABLE Users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(50) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    email NVARCHAR(100) NOT NULL
);

CREATE TABLE Categories (
    id INT IDENTITY(1,1) PRIMARY KEY,
    userId INT,
    name NVARCHAR(100) NOT NULL,
    type NVARCHAR(10) CHECK (type IN ('Income', 'Expense')),
    FOREIGN KEY (userId) REFERENCES Users(id)
);

CREATE TABLE Transactions (
    id INT IDENTITY(1,1) PRIMARY KEY,
    userId INT,
    categoryId INT,
    date DATE,
    amount DECIMAL(10, 2),
    description NVARCHAR(255),
    status NVARCHAR(10) CHECK (status IN ('Active', 'Deleted')),
    FOREIGN KEY (userId) REFERENCES Users(id),
    FOREIGN KEY (categoryId) REFERENCES Categories(id)
);