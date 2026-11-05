@echo off
cd /d "%~dp0"
if not exist out mkdir out
javac -encoding UTF-8 -d out src\br\edu\pulso\*.java
if errorlevel 1 (
  echo Falha na compilacao. Verifique se o JDK 17+ esta instalado.
  pause
  exit /b 1
)
java -cp out br.edu.pulso.Servidor
pause
