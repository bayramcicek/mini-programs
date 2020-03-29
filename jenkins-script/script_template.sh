#!/bin/bash

# created by cicek on 16.09.2019 17:36

JENKINS_URL="url"
JOB_NAME="job"
USER_NAME="user.name"     
USER_TOKEN="secret_token" 
JOB_TOKEN="token"

QUEUE_URL=$(
  curl --silent "https://${JENKINS_URL}/job/${JOB_NAME}/build" \
    --user "${USER_NAME}:${USER_TOKEN}" \
    --data "token=${JOB_TOKEN}" -XPOST \
    --dump-header - \
    --output /dev/null |
    grep Location |
    awk '{print $2}' |
    tr -d '\r\n'
)
echo "${QUEUE_URL}api/json"

sleep 5

BUILD_URL='null'
while [ "$BUILD_URL" == "null" ]; do
  BUILD_URL=$(
    curl --silent "${QUEUE_URL}api/json" \
      --user "${USER_NAME}:${USER_TOKEN}" | jq -r '.executable.url'
  )
done

echo "${BUILD_URL}"

RESULT=''
while [ "$RESULT" != "SUCCESS" ]; do
  RESULT=$(curl --silent "${BUILD_URL}api/json" \
    --user "${USER_NAME}:${USER_TOKEN}" | jq -r '.result')
  sleep 1
done

curl --silent "$BUILD_URL/consoleText" \
  --user "${USER_NAME}:${USER_TOKEN}"
