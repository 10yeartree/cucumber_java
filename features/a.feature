Feature: test
Background:
    * Load value ngcp_value.csv

@CASE=test_bigmap
  Scenario: test
    * Print current_sys_date_xyz
    * Print current_sys_date    
    * Modify bigmap current_sys_date value to "20181001"
    * Print current_sys_date
    
@CASE=test1
  Scenario: test
    * Print current_sys_date