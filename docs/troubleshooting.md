Common Issues and Fixes:

1. Application fails to start (port in use).

	• Fix: Run lsof -i :8080 and kill the process using kill -9 <PID>.

2. Kafka messaging issues.

	• Fix: Ensure Kafka is running using kafka-server-start.sh.
