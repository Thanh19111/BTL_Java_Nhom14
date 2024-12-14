------------------------------------------------Tạo bảng nhân viên---------------------------------------------------
USE [QuanLyNhanVien]
GO

/****** Object:  Table [dbo].[Employee]    Script Date: 12/13/2024 12:41:56 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Employee](
	[employeeId] [int] NOT NULL,
	[employeeName] [varchar](255) NOT NULL,
	[birthDate] [date] NOT NULL,
	[gender] [nvarchar](10) NOT NULL,
	[hometown] [nvarchar](255) NULL,
	[phoneNumber] [nvarchar](15) NULL,
	[hireDate] [date] NOT NULL,
	[salary] [decimal](10, 2) NOT NULL,
	[overtimeHours] [float] NOT NULL,
	[positionID] [int] NOT NULL,
	[departmentID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[employeeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Employee]  WITH CHECK ADD FOREIGN KEY([departmentID])
REFERENCES [dbo].[Department] ([departmentID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Employee]  WITH CHECK ADD FOREIGN KEY([positionID])
REFERENCES [dbo].[Position] ([positionID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

--------------------------------------------------------PROCEDUCE Thêm Sửa Xóa---------------------------------------------------------------------
CREATE PROC AddEmployee (
    @empid INT,
    @empname VARCHAR(255),
	@birthDate date,
	@gender NVARCHAR(10),
	@hometown NVARCHAR(255),
	@phoneNumber NVARCHAR(15),
	@hireDate date,
	@salary decimal(10,2),
	@overtimeHours float,
	@employeePosition int,
	@employeeDepartment int
    
)
AS
BEGIN
    INSERT INTO dbo.Employee( employeeId,  employeeName,  birthDate,  gender,  hometown,  phoneNumber,hireDate, salary ,  overtimeHours,  positionID,  departmentID)
    VALUES (@empID, @empname, @birthDate, @gender,@hometown,@phoneNumber,@hireDate,@salary,@overtimeHours,@employeePosition,@employeeDepartment);
END;
GO

CREATE PROC DeleteEmployee (
    @empid INT
)
AS
BEGIN
    DELETE FROM Employee
	WHERE employeeId = @empid;
END;
GO

GO
CREATE PROC UpdateEmployee (
    @empid INT,
    @empname VARCHAR(255),
	@birthDate date,
	@gender NVARCHAR(10),
	@hometown NVARCHAR(255),
	@phoneNumber NVARCHAR(15),
	@hireDate date,
	@salary decimal(10,2),
	@overtimeHours float,
	@employeePosition int,
	@employeeDepartment int
)
AS
BEGIN
    UPDATE dbo.Employee
    SET employeeId = @empid,
		employeeName = @empname ,
        birthDate = @birthDate,
        gender = @gender,
		hometown =  @hometown,
		phoneNumber = @phoneNumber,
		hireDate = @hireDate,
		salary   = @salary,
		overtimeHours = @overtimeHours,
		positionID =  @employeePosition,
		departmentID = @employeeDepartment
    WHERE employeeId = @empid;
END;
GO
-----------------------SUA LUONG THEO ID--------------------------
CREATE PROC EditSalary (
    @empid INT,
	@salary decimal(10,2)
)

AS
BEGIN
    UPDATE dbo.Employee
    SET salary   =  @salary
    WHERE employeeId = @empid;
END;
GO
Execute AddEmployee 4, thanh, "2/2/2000", nam,hd,445,"3/3/2004",6.7,6,1,2