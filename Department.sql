---------------------------------------------------------Tạo bảng Department---------------------------------------------------
USE [QuanLyNhanVien]
GO

/****** Object:  Table [dbo].[Department]    Script Date: 12/13/2024 12:45:59 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Department](
	[departmentID] [int] NOT NULL,
	[departmentName] [nvarchar](255) NOT NULL,
	[departmentAddress] [nvarchar](255) NULL,
	[departmentPhoneNumber] [nvarchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[departmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


----------------------------------------------------------PROCEDURE Thêm Sửa Xóa---------------------------------------------------
--CREATE PROC AddDepartment (
--    @deptid INT,
--    @deptname NVARCHAR(255),
--    @deptaddress VARCHAR(255),
--    @deptphone NVARCHAR(15)
--)
--AS
--BEGIN
--    INSERT INTO dbo.Department(departmentID, departmentName, departmentAddress, departmentPhoneNumber)
--    VALUES (@deptid, @deptname, @deptaddress, @deptphone);
--END;
--GO

--CREATE PROC DeleteDepartment (
--    @deptid INT
--)
--AS
--BEGIN
--    DELETE FROM Department
--	WHERE departmentID = @deptid;
--END;
--GO

--GO
--CREATE PROC UpdateDepartment (
--    @deptid INT,
--    @deptname NVARCHAR(255),
--    @deptaddress VARCHAR(255),
--    @deptphone NVARCHAR(15)
--)
--AS
--BEGIN
--    UPDATE dbo.Department
--    SET departmentName = @deptname,
--        departmentAddress = @deptaddress,
--        departmentPhoneNumber = @deptphone
--    WHERE departmentID = @deptid;
--END;
--GO


--CREATE PROC GetAllDepartment
--AS
--BEGIN
--    Select * from Department;
--END;
--GO
-------------------------------------------------Trigger xóa-----------------------------------------------------
CREATE TRIGGER trg_DeleteDepartment
ON Department
AFTER DELETE
AS
BEGIN
    DELETE FROM Employee
    WHERE departmentID IN (SELECT departmentID FROM DELETED);
    
    PRINT 'Xóa các hàng liên quan thành công!';
END;
GO
