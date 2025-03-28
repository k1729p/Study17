@echo off
set JAVA_HOME=C:\PROGRA~1\JAVA\JDK-24
set M2_HOME=c:\\tools\\apache-maven-3.9.9
set PROJECT=study17
set DOCKER_IMAGE=eeengcs/study17:1.0.0-SNAPSHOT
set DOCKER_FILE=docker-config\Dockerfile
set COMPOSE_FILE=docker-config\compose.yaml

pushd %cd%
cd ..
goto :mavenBuildOnDockerAndRun

:mavenBuildOnLocalhost
call %M2_HOME%\bin\mvn clean install
pause
goto :eof

:mavenBuildOnDockerAndRun
docker image rm --force %DOCKER_IMAGE%
docker build -f %DOCKER_FILE% --tag %DOCKER_IMAGE% .
docker push %DOCKER_IMAGE%

docker compose -f %COMPOSE_FILE% -p %PROJECT% up --detach
echo ------------------------------------------------------------------------------------------
docker compose -f %COMPOSE_FILE%  -p %PROJECT% ps
echo ------------------------------------------------------------------------------------------
docker compose -f %COMPOSE_FILE%  -p %PROJECT% images
popd
pause