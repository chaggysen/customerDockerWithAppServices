# customerDockerWithAppServices
Custom Docker Image with App Services

Prerequisistes:
- Java 11 or higher
- Maven
- Docker
- jjmpeg.exe inside project folder

To run:
1. Build jar file: ```mvn package```
2. Build Docker image: ```docker build -t custom-docker-with-appservices:latest .```
3. Run Docker container: ```docker run -p 8080:8080 custom-docker-with-appservices```
