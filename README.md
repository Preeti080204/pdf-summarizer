# PDF Summarizer

A full-stack Java web application that extracts and summarizes text from uploaded PDF documents using Spring Boot and Thymeleaf. The project provides a clean UI for uploading files and viewing summarized content directly in the browser.

## Live Demo

Live Application: https://pdf-summarizer-nmxn.onrender.com

---

## Features

- Upload PDF documents through a web interface
- Extract text content from PDF files
- Generate concise summaries from uploaded documents
- Responsive and clean frontend using Thymeleaf + Bootstrap
- Dockerized deployment for cloud hosting
- Deployed publicly on Render

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Maven

### Frontend
- Thymeleaf
- HTML5
- Bootstrap 5

### Deployment & DevOps
- Docker
- Render
- Git & GitHub

### PDF Processing
- Apache PDFBox

---

## Project Architecture

```plaintext
pdf-summarizer/
│
├── src/
│   ├── main/
│   │   ├── java/com/pdfsummarizer/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   └── PdfSummarizerApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       └── application.properties
│
├── Dockerfile
├── pom.xml
└── README.md
```


---

## Installation & Local Setup

### 1. Clone Repository

```bash
git clone https://github.com/Preeti080204/pdf-summarizer.git
cd pdf-summarizer
```

---

### 2. Run the Application

#### Using Maven

```bash
mvn clean package
mvn spring-boot:run
```

#### OR Using JAR

```bash
java -jar target/*.jar
```

---

### 3. Open in Browser

```plaintext
http://localhost:8080
```

---

## Docker Setup

### Build Docker Image

```bash
docker build -t pdf-summarizer .
```

### Run Docker Container

```bash
docker run -p 8080:8080 pdf-summarizer
```

---

## Deployment

The application is deployed using:

- Docker
- Render Cloud Platform

Live URL:

https://pdf-summarizer-nmxn.onrender.com

---

## Future Improvements

- AI-powered summarization using OpenAI/Gemini APIs
- Authentication & user accounts
- Summary history tracking
- Drag & drop PDF uploads
- Multi-language summarization
- PDF preview support
- Export summarized text

---

## Learning Outcomes

This project helped strengthen understanding of:

- Spring Boot architecture
- MVC pattern
- File handling in Java
- Docker containerization
- Cloud deployment workflows
- Git/GitHub version control
- Backend + frontend integration

---

## Author

### Preeti Gorial

- GitHub: https://github.com/Preeti080204


---

