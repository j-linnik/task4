Feature: CarsComFeature

  Scenario: Get compare page of two random cars on Cars.com

    When i navigate to main page 'cars-com'
    Then i go to 'Read Specs & Reviews' tab
    And i insert data to get random car and press 'search'
    And i record base configuration for first car
    Then i go to trim-section and press 'cars trim'
    Then i record 'engine' and 'transmission' data of the first car

    Then i navigate to main page 'cars-com'
    And i go to 'Read Specs & Reviews' tab
    And i insert data to get random car and press 'search'
    And i record base configuration for second car
    Then i go to trim-section and press 'cars trim'
    Then i record 'engine' and 'transmission' data of the second car

    Then i navigate to main page 'cars-com'
    And i press 'buy' and 'Research New Car Models'
    Then i press 'compare cars' button
    Then i insert data of first car for comparing
    Then i press 'add one more comparing car' button
    And i insert data of second car for comparing
    Then i check compare page for both cars

