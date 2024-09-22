USE learn_jpa_dmytro;

-- Table for Heading
CREATE TABLE Heading (
    heading_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table for Email
CREATE TABLE Email (
    email_id INT AUTO_INCREMENT PRIMARY KEY,
    email_address VARCHAR(255) NOT NULL
);

-- Table for Phone
CREATE TABLE Phone (
    phone_id INT AUTO_INCREMENT PRIMARY KEY,
    phone_number VARCHAR(20) NOT NULL
);

-- Table for Author
CREATE TABLE Author (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    FK_Author_Email INT,
    CONSTRAINT fk_author_email FOREIGN KEY (FK_Author_Email) REFERENCES Email(email_id)
);

-- Table for Address
CREATE TABLE Address (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    district VARCHAR(255),
    city VARCHAR(255),
    street VARCHAR(255),
    FK_Author_Address INT UNIQUE,
    CONSTRAINT fk_author_address FOREIGN KEY (FK_Author_Address) REFERENCES Author(author_id)
);

-- Table for Ad
CREATE TABLE Ad (
    ad_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    publication_date DATE,
    content TEXT,
    price DECIMAL(10, 2),
    FK_Ad_Heading INT,
    FK_Ad_Author INT,
    CONSTRAINT fk_ad_heading FOREIGN KEY (FK_Ad_Heading) REFERENCES Heading(heading_id),
    CONSTRAINT fk_ad_author FOREIGN KEY (FK_Ad_Author) REFERENCES Author(author_id)
);

-- Table for MatchingAd
CREATE TABLE MatchingAd (
    matching_ad_id INT AUTO_INCREMENT PRIMARY KEY,
    FK_Matching_ad_Author INT,
    FK_Matching_ad_Heading INT,
    priseFrom DECIMAL(10, 2),
    priseTo DECIMAL(10, 2),
    subject VARCHAR(255),
    CONSTRAINT fk_matching_ad_author FOREIGN KEY (FK_Matching_ad_Author) REFERENCES Author(author_id),
    CONSTRAINT fk_matching_ad_heading FOREIGN KEY (FK_Matching_ad_Heading) REFERENCES Heading(heading_id)
);

-- Table for Author-Phone relationship (ManyToOne)
CREATE TABLE Author_Phone (
    author_id INT,
    phone_id INT,
    CONSTRAINT fk_author_phone_author FOREIGN KEY (author_id) REFERENCES Author(author_id),
    CONSTRAINT fk_author_phone_phone FOREIGN KEY (phone_id) REFERENCES Phone(phone_id),
    PRIMARY KEY (author_id, phone_id)
);