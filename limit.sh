#!/bin/bash

# http://10.20.0.61:2021/actuator/health

if [ $# -lt 1 ]
then
        echo "Usage : ./health.sh url"
        exit
fi
echo "Basic latency test:"

echo "The basic latency will run continuously and display the round-trip transit time for each request to the server. You can stop the command by typing ^C.  When the command stops you'll see a summary for the test showing failures, fastest request, average time and the longest request time."


echo "Colorized response, with limits:"

echo "Ping every .5s, use GET not HEAD, color responses over 299msec Red, 275msec Yellow"


sudo docker run --rm bretfisher/httping -i .5 -G -s -Y --threshold-red 3.0 --threshold-yellow 2.75  $1


#echo "Ping 3 times, use GET not HEAD, show status codes, use pretty colors"

#sudo docker run --rm bretfisher/httping -c 3  -G -s -Y  $1

