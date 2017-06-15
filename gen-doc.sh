#!/usr/bin/env sh

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd $DIR

find src -name "*.java" > sources.txt

javadoc -d "web/doc/java" @sources.txt