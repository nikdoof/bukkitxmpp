#!/bin/sh

rm -rf out; mkdir out;
rm bukkitxmpp.jar

export CLASSPATH=$CLASSPATH:./libs/
javac -cp ./lib/bukkit-0.0.1-SNAPSHOT.jar:./lib/smack.jar:./lib/smackx.jar -d ./out/ ./src/com/pleaseignore/BukkitXMPP/*.java
jar -cvfm bukkitxmpp.jar MANIFEST.MF -C out/ . -C resources/ .
