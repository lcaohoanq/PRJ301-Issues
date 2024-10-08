USE [master]
GO

CREATE DATABASE [PE_PRJ301_293] 
GO

USE [PE_PRJ301_293]
GO

CREATE TABLE [dbo].[tblProducts](
	[productID] [char](5) NOT NULL,
	[productName] [varchar](50) NOT NULL,
	[description] [varchar](500) NOT NULL,
	[price] [float] NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblProducts] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'P001 ', N'Mouse', N'chuot may tinh', 10, 1)
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'P002 ', N'KEYBOARD', N'BAN PHIM', 20, 1)
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'P003 ', N'MONITOR', N'MAN HINH MAY TINH', 50, 0)
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'P004 ', N'Phone', N'Dien thoai Iphone', 100, 1)
