dev:
	mvn spring-boot:run -Dspring-boot.run.profiles=dev

test:
	mvn test

# -Dspring.profiles.active=dev