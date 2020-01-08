#!/bin/sh
process=`ps -ef | grep -v awk | awk -e '/api.*/ { print $2 }'`
kill ${process}

