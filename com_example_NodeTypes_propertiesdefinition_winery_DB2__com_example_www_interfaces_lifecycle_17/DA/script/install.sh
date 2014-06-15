#!/bin/bash

pwd='123456'

db2url='http://192.168.209.217:8080/db2/DB2_Svr_10.5.0.1_Linux_x86-64.tar.gz'

logfile='log.txt'


db2path='/opt/ibm/db2/V10.5'
inspath=${db2path}'/instance'

#db2adminGP='db2adm'
#db2insGP='db2ins'

#db2adminUser='db2adm0'
#db2insUser='db2ins0'

port='50000'


#logfile='log.txt'

#pwd=$1




echo $pwd | sudo -S yum -y install wget #&>> $logfile 
echo $pwd | sudo -S yum -y install libpam.so.0 #&>> $logfile
echo $pwd | sudo -S yum -y install libaio #&>> $logfile
echo $pwd | sudo -S yum -y install libnuma.so.1 #&>> $logfile
echo $pwd | sudo -S yum -y install numactl #&>> $logfile


wget -N $db2url

tar -zxf DB2_Svr_10.5.0.1_Linux_x86-64.tar.gz

echo $pwd | sudo -S ./server/db2_install << EOF_TEXT
yes
SERVER
no
EOF_TEXT


# db2set DB2_EXTENDED_OPTIMIZATION=ON
# db2set DB2_DISABLE_FLUSH_LOG=ON
# db2set AUTOSTART=YES
# db2set DB2_STRIPED_CONTAINERS=ON
# db2set DB2_HASH_JOIN=Y
# db2set DB2COMM=tcpip
# db2set DB2_PARALLEL_IO=*
# db2set DB2CODEPAGE=819
# db2 update dbm cfg using SVCENAME db2ins0
# db2 update dbm cfg using INDEXREC ACCESS



# #add user
# sudo groupadd $db2adminGP #2> $logfile
# sudo groupadd $db2insGP #2> $logfile

# sudo useradd $db2adminUser #2> $logfile
# sudo useradd $db2insUser #2> $logfile

# sudo passwd $db2adminUser << EOF
# $pwd
# $pwd
# EOF

# sudo passwd $db2insUser << EOF
# $pwd
# $pwd
# EOF

# #crt instance
# echo $pwd | sudo -S $inspath/dascrt $db2adminUser #&>> $logfile
# echo $pwd | sudo -S $inspath/db2icrt -p $port -u $db2adminUser $db2insUser #&>> $logfile


# echo $pwd | sudo -u db2ins0 -H sh -c "~/sqllib/db2profile"

# echo $pwd | sudo -u db2ins0 -H sh -c "~/sqllib/adm/db2set DB2COMM=npipe,tcpip"
