FROM golang:alpine3.16 AS executable

LABEL developer=HE

## START: COMPILE EXECUTABLE ##
#  create a working directory
WORKDIR /app


# copy the files from local into container
ADD go.mod .
ADD go.sum .
# the frequently changed files put towards the bottom of this dockerfile
ADD main.go .

# compile to get the binary file main executable (like java .jar file)
RUN go build -o main main.go
## END: COMPILE EXECUTABLE ##

## START: COPY EXECUTABLE TO CONTAINER DIRECTORY ##
FROM alpine:3.16

LABEL org.opencontainers.image.source=https://github.com/this9is3me/dov-bear-golang:v1

WORKDIR /app

COPY --from=executable /app/main main
ADD public public
ADD templates templates


ENV ENV_PORT=3000 
EXPOSE ${ENV_PORT}

ENV INSTANCE_NAME="golang app"

# # make sure that curl is installed
# RUN apt & apt install curl

# # periodic health check; return value is 0 - success, 1 - fail
# HEALTHCHECK --interval=30s --timeout=5s --retries=3 \
#     CMD curl -s http://localhost:${ENV_PORT}/healthz || exit 1

# run the application
ENTRYPOINT [ "./main" ]

## END ##