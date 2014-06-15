#!/bin/bash

#pwd='123456'
#db2user='db2ins0'

namefile='user.txt'

db2user=$(awk 'NR=='1' {print $1}' $namefile)
pwd=$(awk 'NR=='2' {print $1}' $namefile)



cd /home/$db2user
echo $pwd | sudo -u $db2user -H sh -c "/home/$db2user/sqllib/adm/db2stop force"
