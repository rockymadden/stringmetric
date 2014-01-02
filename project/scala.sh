#!/bin/bash
dir="`dirname \"$0\"`"
dir="`( cd \"$dir\" && pwd )`"
cp=`echo $dir/*.jar|sed 's/ /:/g'`
exec scala -classpath "$cp" -savecompiled "$0" "$@"
!#
//