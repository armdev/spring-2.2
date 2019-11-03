# testting new Spring 2.2

1.  run.sh
2. http://localhost:2020/swagger-ui.html#/main-controller/startUsingGET start
3. http://localhost:9411/zipkin/
4. http://localhost:8761/


ab -k -c 10 -n 1000  http://localhost:2020/api/v2/server/one
