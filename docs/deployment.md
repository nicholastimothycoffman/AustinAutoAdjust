
Local Deployment:
	mvn spring-boot:run

Cloud Deployment Options:
	• Docker: Build a Docker image and deploy it.
		docker build -t austin-auto-adjust .
		docker run -p 8080:8080 austin-auto-adjust

	• AWS Lambda / EC2: Deploy via AWS cloud services.
