# JPA Task

## Start command
To create everything from scratch, run:
```
docker-compose rm -v && \
./gradlew assemble && \
docker compose up --build --remove-orphans --force-recreate
```

In order to not recreate mysql, run

```
./gradlew assemble && \                                                                                                                                          ─╯
docker compose up --build --remove-orphans --force-recreate
```

## Comment
We do violate some testing principles here at the moment. We do use a volatile H2 database instead of mocking all repositories properly.

Proper tests would mock each and every repository, not using any database in Unit Tests.