----------------------------------------Tạo bảng Position------------------------------------------------
USE [QuanLyNhanVien]
GO

/****** Object:  Table [dbo].[Position]    Script Date: 12/13/2024 12:49:20 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Position](
	[positionID] [int] NOT NULL,
	[positionName] [nvarchar](255) NOT NULL,
	[positionSalary] [decimal](10, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[positionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
---------------------------------------------------------------------------------------------------------------
CREATE PROC AddPosition
(
@id INT,
@Posi NVARCHAR(255),
@Salar NVARCHAR(255)
)
AS
BEGIN 
INSERT INTO Position([positionID],[positionName],[positionSalary])
VALUES(@id,@Posi,@Salar);
END;
GO

CREATE PROC DeletePosition
(
@id INT
)
AS
BEGIN DELETE FROM Position
WHERE [positionID]=@id;
END;
GO

CREATE PROC UpdatePosition
(
@id INT,
@Posi NVARCHAR(255),
@Salar NVARCHAR(255)
)
AS 
BEGIN UPDATE Position
SET [positionName] = @Posi , [positionSalary] = @Salar
WHERE @id=[positionID];
END;
GO

CREATE PROC UpdateSal
(
@id INT,
@Posi NVARCHAR(255),
@Salar NVARCHAR(255)
)
AS 
BEGIN UPDATE Salary
SET [positionName] = @Posi , [positionSalary] = @Salar
WHERE @id=positionID;
END;
GO


----------------------------------------Trigger xóa-------------------------------------------------------------
CREATE TRIGGER trg_DeletePosition
ON Position
AFTER DELETE
AS
BEGIN
    DELETE FROM Employee
    WHERE positionID IN (SELECT positionID FROM DELETED);
    PRINT 'Xóa các hàng liên quan thành công!';
END;
GO
----------------------------------------------------------------------------------------------------------------

