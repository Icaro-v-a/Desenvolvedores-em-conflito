#!/usr/bin/env sh
set -eu
cd "$(dirname "$0")"
mkdir -p out
javac -encoding UTF-8 -d out src/br/edu/pulso/*.java
java -cp out br.edu.pulso.Servidor
