# usage:

1. add your feature files to ./features

2. add your java step_defination file to ./steps

3. Run in eclipse:
   Install eclipse cucumber plugin, Run feature file As 'Cucumber Feature' in eclipse.
   
4. Run using command line:
   sh compile.sh
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'ngcp'
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'ngcp' -t @CASE=test   
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'ngcp' -p pretty
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'ngcp' -p json:Result/result.json
   -> java -cp "lib/*;bin" cucumber.api.cli.Main features -g 'ngcp' -p html:Result/htmlResult
   