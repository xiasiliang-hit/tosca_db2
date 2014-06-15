#!/bin/bash

#db2path='/opt/ibm/db2/V10.5'
#inspath=${db2path}'/instance'

#db2adminGP='db2adm'
#db2insGP='db2ins'

#db2adminUser='db2adm0'
#db2insUser='db2ins0'


#port='50000'


#logfile='log.txt'

#pwd='123456'
namefile='user.txt'

db2user=$(awk 'NR=='1' {print $1}' $namefile)
db2pwd=$(awk 'NR=='2' {print $1}' $namefile)


echo $db2pwd | sudo -u $db2user -H sh -c "~/sqllib/adm/db2start"
