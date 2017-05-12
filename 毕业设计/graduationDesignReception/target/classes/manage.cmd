@ echo 请输入如下数据：
@ echo ==============================
@ echo 1：重建数据库  2：重建底层代码
@ echo 3：全部重建    4：退出
@ echo ==============================
@ set/p a=
@ if %a%==1 goto a
@ if %a%==2 goto b
@ if %a%==3 goto c
@ if %a%==4 exit

:a
@ echo 数据库のusername：
@ set/p username=
@ echo 数据库のpassword：
@ set/p password=
@ cls
@ echo 请输入如下数据：
@ echo ==============================
@ echo 1：重建数据库  2：重建底层代码
@ echo 3：全部重建    4：退出
@ echo ==============================
@ echo username=
@ echo %username%
@ echo password=
@ echo ********
@ echo 开始进行数据库重置......
@ mysql -h localhost -u %username% --password=%password% < %~dp0%simulation_laboratory.sql
@ echo 结束数据库重置......
@ if %a%==1 goto end

:b
@ %~d0
@ cd %~p0
@ echo 开始进行代码生成......
@ java -jar confige/mybatis-generator-core-1.3.5.jar -configfile confige/generatorConfig.xml -overwrite
@ echo 结束代码生成......
@ if %a%==2 goto end

:c
@ echo 数据库のusername：
@ set/p username=
@ echo 数据库のpassword：
@ set/p password=
@ cls
@ echo 请输入如下数据：
@ echo ==============================
@ echo 1：重建数据库  2：重建底层代码
@ echo 3：全部重建    4：退出
@ echo ==============================
@ echo username=
@ echo %username%
@ echo password=
@ echo ********
@ echo 开始进行数据库重置......
@ mysql -h localhost -u %username% --password=%password% < %~dp0%simulation_laboratory.sql
@ echo 结束数据库重置......
@ %~d0
@ cd %~p0
@ echo 开始进行代码生成......
@ java -jar confige/mybatis-generator-core-1.3.5.jar -configfile confige/generatorConfig.xml -overwrite
@ echo 结束代码生成......
@ if %a%==3 goto end

:end
@ pause