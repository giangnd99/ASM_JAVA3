-- Drop the database if it exists
DROP DATABASE IF EXISTS newswebdb;

-- Create a new database
CREATE DATABASE newswebdb;

-- Use the newly created database
USE newswebdb;

-- Table: users
CREATE TABLE users (
  id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(64) NOT NULL,
  password VARCHAR(80) NOT NULL,
  fullname VARCHAR(64) NOT NULL,
  birthday date null,
  phone varchar(11) null,
  gender boolean null,
  role boolean null,
  PRIMARY KEY (id),
  UNIQUE KEY email_UNIQUE (email)
);

-- Insert users data
INSERT INTO users (id, email, password, fullname, birthday, phone, gender, role)
VALUES 
(1,'giang@java3.com','giang1999','Nguyễn Đằng Giang','09-09-1999','0779755739',true,true),
(2,'hung@gmail.com','hung123','Nguyễn Phan Lâm Hùng','01-01-1999','0123423891', true,false),
(3,'haithach@gmail.com','haithach','Nguyễn Dung Hải Thạch','01-01-2002','0234158931',true,false),
(4,'diepminh@gmail.com','minh123','Diệp Minh','01-01-2000','0345239819',true,false),
(5,'lamha@gmail.com','lam123','Hà Vũ Lâm','01-01-1998','0981389123',true,false);

CREATE TABLE category (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO category (id, name) 
VALUES 
(1, 'Java'),
(2, 'Hibernate'),
(3, 'Spring boot'),
(4, 'MySQL'),
(5, 'DevOps');

CREATE TABLE news (
    id int(10) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    image VARCHAR(255),
    posted_date DATE,
    author INT(11) NOT NULL,
    view_count INT DEFAULT 0,
    category_id INT(11),
    home BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_news_user FOREIGN KEY (author) REFERENCES users(id),
    CONSTRAINT fk_news_category FOREIGN KEY (category_id) REFERENCES category(id)
);

INSERT INTO news (id, title, content, image, posted_date, author, category_id) 
VALUES 
(1, 'Những cập nhật trong phiên bản JDK22', 'Cùng nhau tìm hiểu những lợi ích và cải tiến của JDk22...', "image1.png", NOW(), 2, 1),
(2, 'Sự kiện công nghệ lớn nhất năm 2024', 'Khám phá những công nghệ mới tại sự kiện lớn nhất trong năm.', 'image2.png', NOW(), 3, 2),
(3, 'Xu hướng thiết kế web 2024', 'Những xu hướng thiết kế web nổi bật sẽ lên ngôi trong năm 2024.', 'image3.png', NOW(), 2, 3),
(4, 'Phân tích sự phát triển của AI', 'Cùng tìm hiểu sự tiến bộ nhanh chóng của trí tuệ nhân tạo trong thời gian qua.', 'image4.png', NOW(), 3, 4),
(5, 'Các chính sách mới của chính phủ', 'Các chính sách mới được áp dụng trong năm 2024 sẽ ảnh hưởng đến ngành công nghệ.', 'image5.png', NOW(), 4, 5),
(6, 'Cập nhật mới nhất về an ninh mạng', 'Bài viết sẽ cập nhật những mối đe dọa an ninh mạng mới nhất.', 'image6.png', NOW(), 5, 5),
(7, 'Những sản phẩm công nghệ nổi bật', 'Giới thiệu các sản phẩm công nghệ đáng chú ý đã ra mắt gần đây.', 'image7.png', NOW(), 1, 2),
(8, 'Tương lai của blockchain', 'Phân tích xu hướng và tiềm năng của công nghệ blockchain trong tương lai.', 'image8.png', NOW(), 2, 3),
(9, 'Thị trường việc làm công nghệ 2024', 'Đánh giá tình hình tuyển dụng và nhu cầu nhân lực trong ngành công nghệ.', 'image9.png', NOW(), 3, 4),
(10, 'Các công nghệ mới trong ngành y tế', 'Khám phá những công nghệ mới đang thay đổi ngành y tế hiện nay.', 'image10.png', NOW(), 4, 5);
CREATE TABLE newsletter (
    email VARCHAR(255) PRIMARY KEY,
    enabled BOOLEAN DEFAULT TRUE
);

INSERT INTO newsletter (email) 
VALUES 
('diepminh@gmail.com'),
('danggiang@gmail.com'),
('lamhung@gmail.com'),
('haithach@gmail.com'),
('vulam@gmail.com'),
('chitai@gmail.com');