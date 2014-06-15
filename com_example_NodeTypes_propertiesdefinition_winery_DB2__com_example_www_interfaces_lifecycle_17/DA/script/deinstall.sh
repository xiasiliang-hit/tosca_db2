#!/bin/bash

#pwd='123456'
#db2user='db2ins0'
db2path='/opt/ibm/db2/V10.5'
dasuser='db2adm0'
db2user=$(awk 'NR=='1' {print $1}' $namefile)


#cd /home/$db2user
echo $pwd | sudo -u $db2user -H sh -c "~/sqllib/adm/db2stop force"
echo $pwd | sudo -S $db2path/instance/db2idrop $db2user
echo $pwd | sudo -S $db2path/instance/dasdrop $dasuser


echo $pwd | sudo -S ./server/db2_deinstall -a << EOF_TEXT
$db2path
EOF_TEXT
