

Scenario: Riga Scenario
Given open the browser and maximize it
And switch language to 'RU'
When go to the section 'electronics'
And open search and in Search enter the search phrase 'Computer'
And select a different search parameters and click Search button:
|region|period|
|Riga  |30    |
And Sort the results by price
And select option 'sell' in 'Operation' dropdown
And open advanced search
And enter search option price between '1' and '500'
And choose at least '3' random ads
And press add to memo
And open favorites
Then check that the ads on the page match the previously selected