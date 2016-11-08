#!/bin/sh

MQSIPROFILE=$2/mqsiprofile

source "$MQSIPROFILE" > /dev/null 2>&1

mqsideploy $3 -i $4 -p $5 -a $6 -e $7
