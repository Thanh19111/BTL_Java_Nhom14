# BTL_Java_Nhom14  
HƯỚNG DẪN SỬ DỤNG  
B1: Khởi động SQL SERVER Management Studio hoặc bất kì hệ quản trị cơ sở dữ liệu SQL SERVER nào tương đương trước tiên tạo 1 Database QuanLyNhanVien sau đó tạo một tài khoản mới trong cơ sở dữ liệu mới tạo
- Thực thi script tạo bảng, chạy Procedure và trigger (nếu có) lần lượt trong các file sql trên, theo thứ tự lần lượt Account.sql, Department.sql, Position.sql và Employee để đẩm bảo khóa chính và khóa ngoại  
B2: Cấu hình lại kết nối trong class DatabaseConnection trong gói Data của dự án  
VD: 	String url = "jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true";  
	String username = "sa";  
	String password = "abc123";  
- Thay thế DESKTOP-9JGGVQQ\\SQLEXPRESS bằng tên của SQLSERVER cần truy cập  
- Thay thế 1433 bằng cổng của SQLSEVER cần truy cập  
- Thay thế sa là tên tài khoản đăng nhập SQL Server  
- Thay thế abc123 bằng mật khẩu của tài khoản sa  

*) Nếu gặp lỗi  
1) Enable tài khoản đang sử dụng trong mục Security/Login  
2) Chuyển chế độ xác thực SQL SERVER Sang SQL SEVER and Authenication mode  
3) Kiểm tra lại tên SQL Server kết nối và cổng kết nối  