#!bin/bash

baseParameter="-cp \"lib/*;bin\" cucumber.api.cli.Main features -g tree -g wabi -p pretty"
javaParameter=""
cucumberParameter=""

for i in $*
do
	if [ ${i:0:2} = '-D' ]; then
		javaParameter="${javaParameter}${i} "
	else
		cucumberParameter="${cucumberParameter}${i} "
	fi
done

finalCommand="java ${javaParameter} ${baseParameter} ${cucumberParameter}"
eval $finalCommand