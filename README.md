# Sales-Website_BTL_Servlet Project_08

# MÔ TẢ TRANG WEB
  Trang web được xây dựng phục vụ cho việc mua bán giày. Mục đích có thể sử dụng để order giày online (sử dụng cho người dùng không thể đến được của hàng), hoặc quản lý cho việc mua bán giày tại của hàng (sử dụng cho người bán hàng). Cũng như việc quản lý cả trang web (Admin). Với mục đích để sử dụng cho những cửa hàng vừa và nhỏ. Trang wed này chắc chắn sẽ đáp ứng được nhu cầu của người dùng với những chức năng cơ bản của một trang web bán giày.

# CÁC CÔNG NGHỆ SỬ DỤNG
  Những công nghệ được sử dụng trong trang web:
  1.	Java servlet.
  2.	JSP.
  3.	Bootstrap3.
  4.	SQL Server 2021
  5.	Tomcat v8.5

# CHỨC NĂNG TRANG WEB
  1.	Đăng nhập:
  -	Màn hình đăng nhập sử dụng chung cho nhiều người dùng
  -	Cụ thể là 3 Roles:
    o	Admin
    o	Saller
    o	User
  2.	Đăng kí:
  -	Với mỗi tài khoản đăng kí mặc định người dùng sẽ được đăng kí với Role là User
  3.	Hiện thị Sản phẩm:
  4.	Hiện thị chi tiết Sản phẩm:
  5.	Hiện thị Sản phẩm phân loại theo Danh mục:
  -	Những danh mục sản phẩm sẽ được hiện thị bên góc trái màn hình, với chức năng tìm kiếm nhanh những sản phẩm thuộc danh mục chỉ định:
  Sản phẩm sẽ được lọc ra theo danh mục chỉ định
  6.	Search sản phầm theo tên:
  Chức năng này có thể search những kí tự hoặc từ trùng với tên sản phẩm:
  7.	Giới thiệu sản phẩm mới nhất:
  8.	Giỏ hàng:
  -	Ở phần giỏ hàng có thể lưu trữ sản phẩm của user và tính tổng tiền của tất cả sản phẩm
  Các chức năng của giỏ hàng:
  -	Xử lý sản phẩm trùng khi thêm vào giỏ hàng
  -	Có thể lưu trữ giỏ hàng theo user (khi sản phẩm được thêm vào giỏ hàng khi thoát ra)
  -	Ví dụ khi đăng nhập vào tài khoản user (xuan)
  -	Hiện tại người dùng này chưa có sản phẩm nào trong giỏ hàng. Khi ta add một sản phẩm bất kì thì sản phẩm đó sẽ được đưa vào giỏ hàng
  -	Cũng như ta có thể thấy được tổng tiền, cũng như số tiền phải thanh toán
  -	Ta có thể tăng giảm số lượng sản phẩm muốn đặt bằng cách nhấn dấu cộng (+) hoặc trừ ở ô Số Lượng
  -	Khi ta thay đổi số lượng ở đây tổng tiền sẽ được cập nhật lại
  -	Nếu bạn thêm 2 sản phẩm giống nhau vào giỏ hàng số lượng của sản phẩm đó sẽ tăng lên 1.
  -	Nút delete để xóa sản phẩm khỏi giỏ hàng
  Khi này những sản phầm trong giỏ hàng sẽ được lưu vào Session với Attribute (cart_IDUser), và Cookie sẽ lưu trữ tài khoản người dùng với mục đích khi đăng nhập tài khoản nào ta sẽ có được giỏ hàng của tài khoản đó.
  Ở đây ta có tài khoản User Xuân được lưu trong giở hàng 1 sản phầm với số lượng là 3
  Login và đăng nhập tài khoản khác User Huy
  Ở đây ta có thể thấy sản phẩm ở trong giỏ hàng của User Xuân không được hiện thị ở User Huy
  Khi quay lại User Xuân:
  Ta có thể thấy sản phẩm của tài khoản này không bị mất đi.
  	Tách biệt giỏ hàng của các User
  Khi ta mua hàng, thì sản phẩm trong giỏ hàng sẽ được xóa và lưu trữ xuống database, và di chuyển đến màn hình mua hàng thành công:
  Giỏ hàng đã được xóa:
  9.	Quản lý sản phầm:
  Quản lý sản phẩm chỉ có những người thuộc Role Saler hoặc Admin mới có:
  Ở đây ta có Huy và Admin có thể thấy được Quản lý sản phẩm, còn Xuân thì không
  Trang quản lý sản phẩm như sau: 
  Ở đây ta có thể Chỉnh sủa sản phẩm   hoặc Xóa sản phẩm   hoặc thêm mới  
  Form chỉnh sửa sản phẩm sẽ được fill những giá trị có sẵn: 
  Còn trang thêm mới sản phầm sẽ được giữ trắng:
  10.	 Quản lý người dùng:
  Với chức năng quản lý người dùng, chỉ cho phép Admin được phép truy cập
  Ở trang quản lý người dùng, Admin chỉ có thể chỉnh sửa role cho người dùng, hoặc xóa người dùng khỏi hệ thống.
  Ở đây tất cả người dùng sẽ được hiển thị (Trừ tài khoản Admin)
# CHỨC NĂNG CHƯA HOÀN THIỆN
  -	Phân trang cho các trang hiện thị danh sách (sản phẩm, người dùng)
  -	Chưa có chức năng Voucher
  -	Chưa có chức năng xuất hóa đơn cho tài khoản Seller cũng như cho Admin 
  -	Chưa có chức năng thêm 1 sản phẩm với số lượng lớn hơn 1 vào giỏ hàng. Hiện tại chỉ có thể thêm vào giỏ hàng và tăng số lượng sản phẩm ngay bên trong giỏ hàng.
