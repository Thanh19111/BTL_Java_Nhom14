---------------------------------------------Tạo bảng Account------------------------------------------------------
USE [QuanLyNhanVien]
GO

/****** Object:  Table [dbo].[Account]    Script Date: 12/13/2024 12:45:00 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Account](
	[username] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

-------------------------------------------------PROCEDURE Thêm Sửa Xóa--------------------------------------------
CREATE PROC AddAccount (
    @username NVARCHAR(255),
    @password NVARCHAR(255)
)
AS
BEGIN
    INSERT INTO Account( username,password)
    VALUES (@username, @password);
END;
GO

CREATE PROC DeleteAccount (
    @username NVARCHAR(255)
)
AS
BEGIN
    DELETE FROM Account
	WHERE username = @username;
END;
GO

GO
CREATE PROC UpdateAccount (
    @username NVARCHAR(255),
    @password NVARCHAR(255)
)
AS
BEGIN
    UPDATE Account
    SET username = @username,
        password = @password
    WHERE username = @username;
END;
GO 
