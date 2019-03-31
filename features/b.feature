Feature: test_b
Background:
    * Load value tree_value.csv
   # * Load object tree_object.csv    

@CASE=site_map
  Scenario: web map
    * Open the browser
    * Get url web_site_address
    * Wait 5 seconds
    * Close the browser
    
#@CASE=poem
  #Scenario: web poem
    #* Open the browser