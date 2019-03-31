# usage:

1. add your feature files to ./features

2. add your java step_defination file to ./steps

3. Run in eclipse:
   Install eclipse cucumber plugin, Run feature file As 'Cucumber Feature' in eclipse.
   
4. Run using command line:
   sh compile.sh
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'tree'
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'tree' -t @CASE=test   
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'tree' -p pretty
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'tree' -p json:Result/result.json
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'tree' -p html:Result/htmlResult
   
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'tree' -g 'wabi'
   -> java -DBROWSER=Firefox -cp "lib/*;bin" cucumber.api.cli.Main features -g 'tree' -g 'wabi'
   