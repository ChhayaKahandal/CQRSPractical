FROM ubuntu:latest
LABEL authors="user"
ENTRYPOINT ["top", "-b"]


version: '3.8'

services:

  write-db:
    image: postgres:15
    container_name: postgres-write
    environment:
      POSTGRES_DB: write_db
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: admin123
    ports:
      - "5433:5432"

  read-db:
    image: postgres:15
    container_name: postgres-read
    environment:
      POSTGRES_DB: read_db
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: admin123
    ports:
      - "5434:5432"