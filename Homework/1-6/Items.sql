USE master
GO
CREATE DATABASE ItemsDB
GO
USE ItemsDB
GO

DROP TABLE tblItems

CREATE TABLE [dbo].[tblItems](
	[id] [varchar](5) PRIMARY KEY NOT NULL,
	[brand] [varchar] (255) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL
)
GO

CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](50) PRIMARY KEY NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
 )
GO
INSERT [dbo].[tblItems] ([id], [brand] , [name], [price], [quantity]) VALUES (N'00001', N'FPT' , N'a', 1, 2)
GO
INSERT [dbo].[tblItems] ([id], [brand] , [name], [price], [quantity]) VALUES (N'00002', N'Google' , N'b', 2, 3)
GO
INSERT [dbo].[tblItems] ([id], [brand] , [name], [price], [quantity]) VALUES (N'00003', N'Apple' , N'c', 3, 4)
GO
INSERT [dbo].[tblItems] ([id], [brand] , [name], [price], [quantity]) VALUES (N'00004', N'BigC' , N'd', 4, 5)
GO
INSERT [dbo].[tblItems] ([id], [brand] , [name], [price], [quantity]) VALUES (N'00005', N'Vinagame' , N'e', 5, 6)
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'1', N'Minh', N'1')
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'2', N'TNam', N'2')
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'hoang', N'caohoangluu', N'1')
GO

SELECT * FROM tblItems
SELECT * FROM tblUsers