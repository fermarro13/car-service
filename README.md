# car-service

### Command for run without Docker:
| Profile | Command                        |
|---------|--------------------------------|
| dev     | `gradle bootRun -Penvironment=dev` |
| prod    | `gradle bootRun -Penvironment=prod` |
### Command for build:
| Profile | Command                        |
|---------|--------------------------------|
| dev     | `gradle clean build -Penvironment=dev` |
| prod    | `gradle clean build -Penvironment=prod` |
### Command for build Docker image:
``` 
docker build -t car-api:latest  -f Dockerfile .
``` 

### Docker run:
| Profile | Command                                                                                                          |
|---------|------------------------------------------------------------------------------------------------------------------|
| dev     | `docker run -p 8080:8080  car-api:latest`                                                                        |
| prod    | `docker run -p 9080:8080 -e db_url= -e user= -e pass=  car-api:latest` |
