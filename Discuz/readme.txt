1. download discuz from http://download.comsenz.com/DiscuzX
2. vi /etc/apache2/httpd.conf
    set DocumentRoot and Directory to the location of "Discuz"
    uncomment: LoadModule php5_module libexec/apache2/libphp5.so
3. Create database in mysql
    create database discuz;
    grant all on discuz.* to 'root'@'localhost' identified by '[yourpassword]';

4. Start apache sudo apachectl start
5. access: http://localhost/index.php

Reference:
http://www.phplinux.net/php/discuz/21627221425497908075.html
