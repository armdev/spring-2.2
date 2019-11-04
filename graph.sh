#!/bin/bash

# http://10.20.0.61:2021/actuator/health

if [ $# -lt 1 ]
then
        echo "Usage : ./health.sh url"
        exit
fi
echo "Basic latency test:"

echo "The basic latency will run continuously and display the round-trip transit time for each request to the server. You can stop the command by typing ^C.  When the command stops you'll see a summary for the test showing failures, fastest request, average time and the longest request time."


echo "Fancy graphs:"

echo "add a -it to run command and a -K"


sudo docker run --rm bretfisher/httping -i .5 -GsYK  $1

