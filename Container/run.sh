echo "Створення Docker-образу для PostgreSQL"
docker image build -t local/postgres:15.1 .

echo "Запуск PostgreSQL-контейнера"
docker container run --name postgres_server -p 5432:5432 -d local/postgres:15.1