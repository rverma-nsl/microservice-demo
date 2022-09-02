# Build the project
```shell
mvn clean install
```
# Run the docker containers
```shell
docker-compose up -d
```

# Do some tests
```shell
sleep 5
curl -X GET http://localhost:8081/order
curl -X GET http://localhost:8081/feed
...
sleep 5

```

# Pull the individual coverage reports

```shell
java -jar ~/dev/jacoco/lib/jacococli.jar dump --address localhost --port 36321 --destfile order.exec
java -jar ~/dev/jacoco/lib/jacococli.jar dump --address localhost --port 36322 --destfile shipping.exec
java -jar ~/dev/jacoco/lib/jacococli.jar dump --address localhost --port 36323 --destfile invoicing.exec

```

# Merge the individual coverage reports
```shell

java -jar ~/dev/jacoco/lib/jacococli.jar merge order.exec shipping.exec invoicing.exec --destfile merged.exec
```

# Generate the html report
```shell

java -jar ~/dev/jacoco/lib/jacococli.jar report merged.exec \
--classfiles microservice-istio-order/target/classes/com --sourcefiles microservice-istio-order/src/main/java \
--classfiles microservice-istio-shipping/target/classes/com --sourcefiles microservice-istio-shipping/src/main/java \
--classfiles microservice-istio-invoicing/target/classes/com --sourcefiles microservice-istio-invoicing/src/main/java/ \
--csv report.csv
# --html report
```
