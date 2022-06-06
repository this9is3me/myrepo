# "ARG" is the only keyword to put before "FROM"
ARG VER=18.2.0 

# normally this is the first line of Dockerfile
FROM node:${VER}

LABEL developer=HE

## START: BUILDING THE IMAGE ##
#  create a working directory
WORKDIR /app

# make sure that curl is installed
RUN apt & apt install curl

# copy the files from local into container
ADD package.json .
ADD package-lock.json .
# for directory, have to state the name of the folder, unlike files above just put dot
ADD public public
ADD views views
# the frequently changed files put towards the bottom of this dockerfile
ADD main.js .

# install the packages
RUN npm ci
## END: BUILDING THE IMAGE ##

## START: RUN THE IMAGE ##
ENV APP_PORT=3000 
EXPOSE ${APP_PORT}


# periodic health check; return value is 0 - success, 1 - fail
HEALTHCHECK --interval=30s --timeout=5s --retries=3 \
    CMD curl -s http://localhost:${APP_PORT}/healthz || exit 1

# run the application
ENTRYPOINT ["node", "main.js"]

## END: RUN THE IMAGE ##