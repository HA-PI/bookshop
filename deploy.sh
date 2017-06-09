#!/usr/bin/env sh

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd $DIR

tomcat_home=$(cat tomcat_home)
proj_name=$(cat project_name)

sh compile.sh $@

rm -rf "$tomcat_home"webapps/"$proj_name"
echo cp -rf release/"$proj_name"/ \""$tomcat_home"webapps/"$proj_name"\"
cp -rf release/"$proj_name"/ "$tomcat_home"webapps/"$proj_name"