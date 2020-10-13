#!/bin/bash
rm -r /tmp/src
rm -r /tmp/out
mkdir -p /tmp/src/oepsie.so
mkdir -p /tmp/out/oepsie.so
touch /tmp/src/oepsie.so/precious.txt
touch /tmp/src/oepsie.so/precious2.txt
touch /tmp/out/precious.txt
cp /tmp/src/oepsie.so/precious2.txt /tmp/out/oepsie.so/precious2.txt
