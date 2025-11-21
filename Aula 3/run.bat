@echo off
REM Script para executar a aplicação Spring Boot
REM Aula 3 - API REST para Gerenciar Contatos

echo 🚀 Iniciando a aplicação Contact API...
echo.

cd /d "%~dp0"

mvn spring-boot:run

pause

