#!/bin/bash

#first argument is the database name
#pwd='123456'
db2user='db2ins0'

namefile='user.txt'


	db2user=$(awk 'NR=='1' {print $1}' $namefile)
	db2pwd=$(awk 'NR=='2' {print $1}' $namefile)
	


dbname=$1

cd /home/$db2user
echo $pwd | sudo -u $db2user -H sh -c "~/sqllib/bin/db2 create database "$dbname
