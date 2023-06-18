# Automate Customer Onboarding process (Docker Compose Spring Boot , Maven , MySQL, JPA )


### 1. Prerequisite - Docker installation

a. Optionally if you need to remove all containers, images, volume used by any service in <em>docker-compose.yml</em> file, use the below 
command:
```bash
docker volume prune              // remove unused volumes
docker rm -vf $(docker ps -aq)   //  remove containers
docker rmi -f $(docker images -aq) // remove images

```


## 2. Set up a environement
a. Clone the project in your system with
 ```bash
git clone https://github.com/siddkorg/CustomerOnboarding.git
```

b. Make sure project get IDE support with JDK.

c. Environment can be easily available with below command which 
need to be fire at the level, where docker-compose.yaml is present

```bash
docker-compose up
```

d. Check db (optional)

Through data.sql, 2 tables are pre-filled while making db container up. 
In case if you are interested to see those tables fire below commands 1 by 1.

```bash
docker exec -it customer-onboarding_mysqldb_1 mysql -uroot -p123456 -D onboarding -e "SELECT * FROM customer_details;"

docker exec -it customer-onboarding_mysqldb_1 mysql -uroot -p123456 -D onboarding -e "SELECT * FROM customer_account_overview;"
```

## 3. Postman setup

a. Download postman collection and try out different scenarios.

b. We will be running on localhost:6868 so make sure no other process are running on 6868.
 In case if it is running then that can be stop with below commands
 
 ```bash
 netstat -ano | findstr :6868 
 taskkill /PID <PID> /F
```

## 4. Stop the System
a. Stopping all the running containers and remove the volumes:
```bash
docker-compose down -v
```

