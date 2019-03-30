#!bin/bash

rm -rf bin/*
find . -name "*.java" -type f | awk '{printf "\"%s\"\n", $0}' | xargs javac -cp "lib/*" -d bin