-- Drop the database if it exists
DROP DATABASE IF EXISTS newswebdb;

-- Create a new database
CREATE DATABASE newswebdb;

-- Use the newly created database
USE newswebdb;

-- Table: users
DROP TABLE IF exists users; 
CREATE TABLE users (
  id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(64) NOT NULL,
  password VARCHAR(80) NOT NULL,
  fullname VARCHAR(64) NOT NULL,
  birthday DATE NULL,
  phone VARCHAR(11) NULL,
  gender BOOLEAN NULL,
  role BOOLEAN NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email_UNIQUE (email)
);

-- Insert users data
INSERT INTO users (id, email, password, fullname, birthday, phone, gender, role)
VALUES 
(1, 'giang@java3.com', 'giang1999', 'Nguyễn Đằng Giang', '1999-09-09', '0779755739', true, true),
(2, 'hung@gmail.com', 'hung123', 'Nguyễn Phan Lâm Hùng', '1999-01-01', '0123423891', true, false),
(3, 'haithach@gmail.com', 'haithach', 'Nguyễn Dung Hải Thạch', '2002-01-01', '0234158931', true, false),
(4, 'diepminh@gmail.com', 'minh123', 'Diệp Minh', '2000-01-01', '0345239819', true, false),
(5, 'lamha@gmail.com', 'lam123', 'Hà Vũ Lâm', '1998-01-01', '0981389123', true, false);		

-- Table: category
CREATE TABLE category (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  PRIMARY KEY (id)
);

-- Insert category data
INSERT INTO category (id, name) 
VALUES 
(1, 'Công nghệ'),
(2, 'Văn hóa'),
(3, 'Chính trị'),
(4, 'Thể thao'),
(5, 'Xã hội');

-- Table: news
DROP TABLE IF exists news; 
CREATE TABLE news (
  id INT(10) auto_increment PRIMARY KEY,
  title VARCHAR(255) NOT NULL unique,
  content TEXT NOT NULL,
  image VARCHAR(255),
  postedDate DATE,
  author INT(11) NOT NULL,
  viewCount INT DEFAULT 0,
  categoryId INT(11),
  home BOOLEAN DEFAULT FALSE,
  CONSTRAINT fk_news_user FOREIGN KEY (author) REFERENCES users(id) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
  CONSTRAINT fk_news_category FOREIGN KEY (categoryId) REFERENCES category(id)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

-- Insert news data
INSERT INTO news (id, title, content, image, postedDate, author, categoryId) 
VALUES 
(1, 'Những biểu tượng của Thủ đô vẹn nguyên sau trăm năm', 'Hồ Gươm rộng 12 hecta được ví như trái tim của Thủ đô, bao quanh là cụm công trình, di tích lịch sử lâu đời như tháp Bút, đài Nghiên, cầu Thê Húc, đền Ngọc Sơn.

Với mục tiêu biến Hà Nội thành một thành thị kiểu châu Âu, vào cuối thế kỷ 19 đầu 20 người Pháp đã quy hoạch, xây dựng nhiều công trình kiến trúc. Đại lộ bao quanh Hồ Gươm có tòa thị chính, bưu điện, điện lực, sở cẩm… Vòng ngoài xa hơn là ngân hàng, nhà thờ, nhà hát lớn, trường đại học, tòa án, nhà tù.

Thủ đô ngày nay mở rộng, phố phường thay đổi với nhiều công trình kiến trúc hiện đại, song hình hài khu vực Hồ Gươm gần như nguyên vẹn.', "image1.png", NOW(), 2, 2),
(2, 'Sự kiện công nghệ lớn nhất năm 2024', 'Khám phá những công nghệ mới tại sự kiện lớn nhất trong năm.', 'image2.png', NOW(), 3, 1),
(3, 'Keanu Reeves đua ôtô', 'Theo CNN, sao Matrix có mặt tại đường đua Indianapolis Motor Speedway, Indiana cuối tuần trước. Cuộc thi là sự kiện dành cho cộng đồng yêu xe hơi và những tay đua nghiệp dư. Qua hai ngày thi đấu, Keanu Reeves lần lượt đạt hạng 25 và 24 trong số 33 thí sinh.', 'image3.png', NOW(), 2, 4),
(4, 'Phân tích sự phát triển của AI', 'Cùng tìm hiểu sự tiến bộ nhanh chóng của trí tuệ nhân tạo trong thời gian qua.', 'image4.png', NOW(), 3, 1),
(5, 'Các chính sách mới của chính phủ', 'Các chính sách mới được áp dụng trong năm 2024 sẽ ảnh hưởng đến ngành công nghệ.', 'image5.png', NOW(), 4, 3),
(6, 'Cập nhật mới nhất về an ninh mạng', 'Bài viết sẽ cập nhật những mối đe dọa an ninh mạng mới nhất.', 'image6.png', NOW(), 5, 1),
(7, 'Những sản phẩm công nghệ nổi bật', 'Giới thiệu các sản phẩm công nghệ đáng chú ý đã ra mắt gần đây.', 'image7.png', NOW(), 1, 1),
(8, 'Tương lai của blockchain', 'Phân tích xu hướng và tiềm năng của công nghệ blockchain trong tương lai.', 'image8.png', NOW(), 2, 1),
(9, 'Thị trường việc làm công nghệ 2024', 'Đánh giá tình hình tuyển dụng và nhu cầu nhân lực trong ngành công nghệ.', 'image9.png', NOW(), 3, 5),
(10, 'Các công nghệ mới trong ngành y tế', 'Khám phá những công nghệ mới đang thay đổi ngành y tế hiện nay.', 'image10.png', NOW(), 4, 5);

-- Table: newsletter
CREATE TABLE newsletter (
  email VARCHAR(255) PRIMARY KEY,
  enabled BOOLEAN DEFAULT TRUE
);

-- Insert newsletter data
INSERT INTO newsletter (email) 
VALUES 
('diepminh@gmail.com'),
('danggiang@gmail.com'),
('lamhung@gmail.com'),
('haithach@gmail.com'),
('vulam@gmail.com'),
('chitai@gmail.com');


DELIMITER $$
CREATE PROCEDURE spInsertCategory(
    IN p_name VARCHAR(255)
)
BEGIN
    INSERT INTO Category (name)
    VALUES (p_name);
END$$

CREATE PROCEDURE spUpdateCategoryById(
    IN p_id INT,
    IN p_name VARCHAR(255)
)
BEGIN
    UPDATE Category
    SET name = p_name
    WHERE id = p_id;
END$$

CREATE PROCEDURE spUpdateViewCount(
    IN p_id INT,
    IN p_viewcount INT
)
BEGIN
    UPDATE News
    SET viewcount = p_viewcount
    WHERE id = p_id;
END$$

CREATE PROCEDURE spSelectAllCategory()
BEGIN
    SELECT * FROM Category;
END$$

CREATE PROCEDURE spSelectAll()
BEGIN
    SELECT * FROM News;
END$$

CREATE PROCEDURE spDeleteById(
    IN p_id INT
)
BEGIN
    DELETE FROM News WHERE id = p_id;
END$$

CREATE PROCEDURE spSelectTop3ByViewCount()
BEGIN
    SELECT * FROM News
    ORDER BY viewCount DESC
    LIMIT 3;
END$$

CREATE PROCEDURE spSelectTop3Newest()
BEGIN
    SELECT * FROM News
    ORDER BY postedDate DESC
    LIMIT 3;
END$$

CREATE PROCEDURE spSelectByUserId(
    IN p_user_id INT
)
BEGIN
    SELECT * FROM News WHERE author = p_user_id;
END$$

CREATE PROCEDURE spSelectByCategoryId(
    IN p_category_id INT
)
BEGIN
    SELECT * FROM News WHERE categoryId = p_category_id;
END$$

DELIMITER ;