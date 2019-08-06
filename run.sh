## server start sh
nohup java -jar -Dspring.config.location=config-server/src/main/resources/peer-1.yml -Dserver.port=8761 config-server/target/config-server-0.0.1.jar /dev/null 2>&1 &
nohup java -jar -Dspring.config.location=config-server/src/main/resources/peer-2.yml -Dserver.port=8762 config-server/target/config-server-0.0.1.jar /dev/null 2>&1 &
nohup java -jar -Dspring.config.location=config-server/src/main/resources/peer-3.yml -Dserver.port=8763 config-server/target/config-server-0.0.1.jar /dev/null 2>&1 &      

## client start sh
nohup java -jar -Dspring.config.location=config-server/src/main/resources/application.yml -Dserver.port=8764 config-client/target/config-client-0.0.1.jar /dev/null 2>&1 &      