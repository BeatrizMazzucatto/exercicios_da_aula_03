#!/bin/bash

# Script para executar a aplicação Spring Boot
# Aula 3 - API REST para Gerenciar Contatos

echo "🚀 Iniciando a aplicação Contact API..."
echo ""

cd "$(dirname "$0")"

mvn spring-boot:run

