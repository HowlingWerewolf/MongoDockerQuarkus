echo clean up the prev state if there's any
cd docker
call docker compose down
cd ..

echo building quarkus image
cd core
call mvn clean package
call quarkus image build docker
cd ..

echo creating containers
cd docker
call docker compose up