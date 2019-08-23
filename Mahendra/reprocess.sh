#!/bin/bash

noOfIdsProcessed=0;
count=1;
list="";
JSESSIONID="$1"
currentMsgIdFile="$2"
while IFS= read -r line
do
    if [ $count -ge 4000 ]
     then
        list="$list,$line"
        #here we can use any one of following curl command, but with JSESSIONID its taking more time to process
        curl -u mkola:Power@5936 -H "Content-Type: text/plain" -X POST -d "$list" -k https://force-admin.maui.expts.net/controls/reprocess
        #curl -H "Content-Type: text/plain" -X POST -d "$list"  --cookie "JSESSIONID=$JSESSIONID" -k https://force-admin.maui.expts.net/controls/reprocess
        noOfIdsProcessed=$((noOfIdsProcessed+count))
        list=""
        count=1
        echo "Till now $noOfIdsProcessed Current Messaged ID's are processed"

    else
        if [ $count == 1 ]
         then
            list="$line"
         else

            list="$list,$line"
         fi
        no=1;
        count=$((count+no))
    fi


done <"$currentMsgIdFile"
#here we can use any one of following curl command, but with JSESSIONID its taking more time to process
curl -u mkola:Power@5936 -H "Content-Type: text/plain" -X POST -d "$list" -k https://force-admin.maui.expts.net/controls/reprocess
#curl -H "Content-Type: text/plain" -X POST -d "$list"  --cookie "JSESSIONID=$JSESSIONID" -k https://force-admin.maui.expts.net/controls/reprocess
noOfIdsProcessed=$((noOfIdsProcessed+count))
echo "Till now $noOfIdsProcessed Current Messaged ID's are processed"

