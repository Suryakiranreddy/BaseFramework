Set oShell = CreateObject ("Wscript.Shell") 
Dim strArgs
strArgs = "cmd /c D:\POCs\VtigerDemo\Run.bat"
oShell.Run strArgs, 0, false