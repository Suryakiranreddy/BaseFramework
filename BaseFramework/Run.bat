@echo off
cls
echo "Test suite is starting"
set root=D:\POCs\VtigerDemo
CD /D %root%
call mvn test -U
echo Test Suite run has completed... 
echo Please Press anything to exit :D
Pause>Nul