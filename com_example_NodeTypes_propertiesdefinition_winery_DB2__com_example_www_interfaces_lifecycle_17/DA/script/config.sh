
#!/bin/bash

db2insUser=$1
db2pwd=$2

#pwd='123456'
#pwd=$1
#db2url='http://192.168.209.217:8080/db2/DB2_Svr_10.5.0.1_Linux_x86-64.tar.gz'

logfile='log.txt'
namefile='user.txt'

db2path='/opt/ibm/db2/V10.5'
inspath=${db2path}'/instance'

db2adminGP='db2adm'
db2insGP='db2ins'

db2adminUser='db2adm0'
#db2insUser='db2ins0'

port='50000'



#add user
sudo groupadd $db2adminGP #2> $logfile
sudo groupadd $db2insGP #2> $logfile

sudo useradd $db2adminUser #2> $logfile
sudo useradd $db2insUser #2> $logfile

sudo passwd $db2adminUser << EOF
$pwd
$pwd
EOF

sudo passwd $db2insUser << EOF
$db2pwd
$db2pwd
EOF

#crt instance
echo $pwd | sudo -S $inspath/dascrt $db2adminUser #&>> $logfile
echo $pwd | sudo -S $inspath/db2icrt -p $port -u $db2adminUser $db2insUser #&>> $logfile


echo $pwd | sudo -u $db2insUser -H sh -c "~/sqllib/db2profile"

echo $pwd | sudo -u $db2insUser -H sh -c "~/sqllib/adm/db2set DB2COMM=npipe,tcpip"

rm $namefile
#write username and password
echo $db2insUser >> $namefile
echo $db2pwd >> $namefile
