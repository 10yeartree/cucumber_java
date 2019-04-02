Feature: test_a
Background:
    * Load value tree_value.csv

@CASE=test_bigmap
  Scenario: test
    * Print current_sys_date_xyz
     
    * Print current_sys_date    
    * Modify bigmap current_sys_date value to "20181001"
    * Verify ("20181001" == current_sys_date)
    * Modify bigmap current_sys_date value to 100.9
    * Verify ("20181001" != current_sys_date)    
    
@start    
@CASE=test_assign
  Scenario: test1
    * Assign "ABC" to var1
    * Assign "DEF" to var2
    * Verify (var1 != var2)
    
    * Assign 10 to num1
    * Assign 10.0 to num2
    * Verify (num1 == num2)
    
    * AssignExp (1.2 + 8.5) to exp1
    * AssignExp (7 + 2.7) to exp2
    * Verify (exp1 == exp2)
    
    * AssignExp ("Good " + "book") to exp1
    * Assign "Good book" to exp2
    * Verify (exp1 == exp2)    