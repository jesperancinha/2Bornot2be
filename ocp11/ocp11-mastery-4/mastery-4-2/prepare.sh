#!/bin/bash

echo "Copying lyric files to /tmp"
rm /tmp/raul_lyrics.txt
cp ./docs/*.* /tmp
ls -l /tmp/raul_lyrics.txt
echo "Done!"
