FROM postgres
LABEL description="Test Docker for PostgreSQL"
LABEL mainteiner="Belobrov Arthur, azofer77@gmail.com"
LABEL version="1.0"

ENV POSTGRES_USER belobrov
ENV POSTGRES_PASSWORD 1234
ENV POSTGRES_DATABASE belobrovdb

COPY ./scripts/db_script.sql /docker-entrypoint-initdb.d/

