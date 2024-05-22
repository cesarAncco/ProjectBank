#!/bin/bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=ClientProject \
  -Dsonar.projectName='ClientProject' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_83c9eb3c40d0a853dbd56d24e6012d6676f3cf47