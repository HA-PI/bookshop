#!/usr/bin/env sh

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd $DIR

/bin/rm -rf release/*
proj_name=$(cat project_name)

[ -d release ] || mkdir release
[ -d release/"$proj_name" ] || mkdir release/"$proj_name"
[ -d release/"$proj_name"/WEB-INF ] || mkdir release/"$proj_name"/WEB-INF
[ -d release/"$proj_name"/WEB-INF/classes ] || mkdir release/"$proj_name"/WEB-INF/classes


cp -r web/* release/"$proj_name"/

tomcat_home=$(cat tomcat_home)

find src -name "*.java" > sources.txt

javac -cp $tomcat_home"lib/servlet-api.jar" -cp $tomcat_home"lib/jsp-api.jar" -d release/"$proj_name"/WEB-INF/classes \
@sources.txt
