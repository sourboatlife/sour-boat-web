#!/bin/bash

# before running, in a separate terminal run 'export PORT=5000 && mvn compile exec:java'

while [ true ]; do
	mvn resources:resources && echo "Sleeping..." && sleep 1;
done
