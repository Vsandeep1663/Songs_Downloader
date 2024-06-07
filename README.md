# Song Downloader Application

## Introduction

The Song Downloader application is a simple web-based tool that allows users to download songs by providing their URLs. It is built using Spring Boot, Thymeleaf, and Spring Security to ensure a secure and user-friendly experience.

## Input and Output

### Input

- **Song URLs**: Users provide the URLs of the songs they wish to download. This is done through a web form where URLs can be entered.

### Output

- **Downloaded Songs**: The application processes the provided URLs and downloads the songs to the user's local machine or a specified directory on the server.

## Getting Started

### Prerequisites

Ensure you have the following installed:

- Java 17
- Maven
- MySQL

### Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/yourusername/song-downloader.git
    cd song-downloader
    ```

2. **Set up the MySQL database**:

    ```sql
    CREATE DATABASE song_downloader_db;
    ```

3. **Configure the application**:

    Edit the `src/main/resources/application.properties` file:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/song_downloader_db
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```

4. **Build and run the application**:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    The application will be accessible at [http://localhost:8087](http://localhost:8087).

## Usage

1. Open [http://localhost:8087](http://localhost:8087) in your web browser.
2. Enter the URLs of the songs you want to download in the provided input field.
3. Click the "Download Songs" button.
4. The application will download the songs and provide them for download.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
