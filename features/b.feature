Feature: test_b
Background:
    * Load value tree_value.csv
    * Load object tree_object.csv    

@CASE=site_map
  Scenario: test
    * Print current_sys_date_xyz
    * Print current_sys_date    
    * Modify bigmap current_sys_date value to "20181001"
    * Print current_sys_date
    
@CASE=poem
  Scenario: test
    * Print current_sys_date