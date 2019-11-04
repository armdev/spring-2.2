#!/bin/bash



if [ $# -lt 1 ]
then
        echo "Usage : ./health.sh url"
        exit
fi
echo "Basic latency test:"

echo "The basic latency will run continuously and display the round-trip transit time for each request to the server. You can stop the command by typing ^C.  When the command stops you'll see a summary for the test showing failures, fastest request, average time and the longest request time."


#sudo docker run --rm bretfisher/httping $1

sudo docker run --rm bretfisher/httping -i .1 -G -s -Y  $1

