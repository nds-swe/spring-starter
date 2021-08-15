# JPA Task

## Start command
To create everything from scratch, run:
```
docker-compose rm -v && \
./gradlew assemble && \
docker compose up --build --remove-orphans --force-recreate
```