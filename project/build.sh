#!/bin/sh
mkdir ./target/cli

cp ./cli/src/main/scala/com/rockymadden/stringmetric/cli/**/*.scala ./target/cli/
cp ./cli/target/scala-2.10/*.jar ./target/cli/
cp ./core/target/scala-2.10/*.jar ./target/cli/

for f in ./target/cli/*.scala; do cat ./project/scala.sh "$f" > "${f%.*}"; done

rm ./target/cli/*.scala
chmod +x ./target/cli/*
