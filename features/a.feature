Feature: test_a
Background:
    * Load value tree_value.csv

@CASE=test_bigmap
  Scenario: test
    * Print current_sys_date_xyz
    * Print current_sys_date    
    * Modify bigmap current_sys_date value to "20181001"
    * Print current_sys_date
    
@start    
@CASE=test1
  Scenario: test1
    * Verify ("20180201" == current_sys_date)