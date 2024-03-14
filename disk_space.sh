#!/bin/bash

log_file="F:/iti-dm/ALL_prj/disk_log.txt"

threshold=90

disk_space=`df -h | awk ' NR==2 {print $6}' | sed 's/%//'`
echo $disk_space

if [[ $disk_space -gt $threshold ]]; then
	echo "Warning Disk Space Is Above $threshold%" >> F:/iti-dm/ALL_prj/disk_log.txt
else
	echo "Disk Space Is Under $threshold%" >> F:/iti-dm/ALL_prj/disk_log.txt
fi