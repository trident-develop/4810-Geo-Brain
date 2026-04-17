package com.ironhidegames.android.ironmari.data

object TestsData {

    private fun q(text: String, options: List<String>, correct: Int) =
        Question(text, options, correct)

    val tests: List<GeoTest> = listOf(
        GeoTest(
            id = 1, title = "Capitals of Europe", emoji = "🏛️",
            description = "Match European countries to their capitals.",
            questions = listOf(
                q("What is the capital of Germany?", listOf("Munich", "Berlin", "Hamburg", "Frankfurt"), 1),
                q("What is the capital of France?", listOf("Lyon", "Marseille", "Paris", "Nice"), 2),
                q("What is the capital of Italy?", listOf("Milan", "Rome", "Naples", "Turin"), 1),
                q("What is the capital of Spain?", listOf("Barcelona", "Seville", "Madrid", "Valencia"), 2),
                q("What is the capital of the United Kingdom?", listOf("Manchester", "Liverpool", "Edinburgh", "London"), 3),
                q("What is the capital of Poland?", listOf("Kraków", "Warsaw", "Gdańsk", "Wrocław"), 1),
                q("What is the capital of the Netherlands?", listOf("Rotterdam", "The Hague", "Utrecht", "Amsterdam"), 3),
                q("What is the capital of Sweden?", listOf("Gothenburg", "Malmö", "Stockholm", "Uppsala"), 2),
                q("What is the capital of Norway?", listOf("Bergen", "Oslo", "Trondheim", "Stavanger"), 1),
                q("What is the capital of Greece?", listOf("Thessaloniki", "Patras", "Athens", "Heraklion"), 2),
                q("What is the capital of Portugal?", listOf("Porto", "Lisbon", "Braga", "Coimbra"), 1),
                q("What is the capital of Austria?", listOf("Salzburg", "Graz", "Vienna", "Linz"), 2),
                q("What is the capital of Belgium?", listOf("Antwerp", "Bruges", "Ghent", "Brussels"), 3),
                q("What is the capital of Denmark?", listOf("Aarhus", "Copenhagen", "Odense", "Aalborg"), 1),
                q("What is the capital of Finland?", listOf("Turku", "Tampere", "Helsinki", "Espoo"), 2),
                q("What is the capital of Ireland?", listOf("Cork", "Dublin", "Galway", "Limerick"), 1)
            )
        ),
        GeoTest(
            id = 2, title = "Flags of Asia", emoji = "🚩",
            description = "Identify Asian countries by their flag description.",
            questions = listOf(
                q("Which country has a red circle on a white background?", listOf("China", "Japan", "South Korea", "Vietnam"), 1),
                q("Which flag has a yellow star on red background?", listOf("Vietnam", "China", "Malaysia", "Indonesia"), 0),
                q("The Chinese flag has how many yellow stars?", listOf("3", "4", "5", "6"), 2),
                q("Which country's flag has the yin-yang in the center?", listOf("Japan", "China", "South Korea", "Thailand"), 2),
                q("Indonesia's flag has which two colors?", listOf("Red-White", "Red-Blue", "Green-White", "Blue-White"), 0),
                q("Thailand's flag has how many horizontal stripes?", listOf("3", "4", "5", "6"), 2),
                q("Singapore's flag features which symbols?", listOf("Sun and moon", "Crescent and 5 stars", "Crown and stars", "Star and wheel"), 1),
                q("Saudi Arabia's flag features what symbol?", listOf("Cedar tree", "Sword and shahada", "Eagle", "Crescent moon"), 1),
                q("India's flag has how many colors?", listOf("2", "3", "4", "5"), 1),
                q("Malaysia's flag is similar in style to which other flag?", listOf("Russia", "USA", "Brazil", "Germany"), 1),
                q("Which Asian flag has a cedar tree in the center?", listOf("Jordan", "Lebanon", "Syria", "Yemen"), 1),
                q("The Philippine flag has a sun with how many rays?", listOf("6", "7", "8", "12"), 2),
                q("Which country's flag has a dragon on it?", listOf("China", "Nepal", "Bhutan", "Mongolia"), 2),
                q("Nepal's flag is unique because it is:", listOf("Square", "Not rectangular", "All black", "Triangular-stacked"), 3),
                q("The flag of Sri Lanka prominently features:", listOf("A lion", "An elephant", "A tiger", "A peacock"), 0),
                q("The South Korean flag's central symbol is called:", listOf("Taegeuk", "Hinomaru", "Bagua", "Mandala"), 0)
            )
        ),
        GeoTest(
            id = 3, title = "African Countries", emoji = "🦁",
            description = "Test your knowledge of Africa.",
            questions = listOf(
                q("What is the largest country in Africa by area?", listOf("Egypt", "Sudan", "Algeria", "DR Congo"), 2),
                q("In which country are the Pyramids of Giza?", listOf("Libya", "Egypt", "Sudan", "Ethiopia"), 1),
                q("Nairobi is the capital of which country?", listOf("Kenya", "Tanzania", "Uganda", "Ethiopia"), 0),
                q("Which African country has 11 official languages?", listOf("Nigeria", "Morocco", "South Africa", "Ghana"), 2),
                q("Table Mountain overlooks which city?", listOf("Johannesburg", "Cape Town", "Durban", "Pretoria"), 1),
                q("The Sahara Desert covers part of which country?", listOf("Kenya", "South Africa", "Morocco", "Ethiopia"), 2),
                q("Which is the most populous country in Africa?", listOf("Ethiopia", "Egypt", "DR Congo", "Nigeria"), 3),
                q("Addis Ababa is the capital of which country?", listOf("Kenya", "Ethiopia", "Somalia", "Sudan"), 1),
                q("Marrakesh is located in which country?", listOf("Egypt", "Algeria", "Tunisia", "Morocco"), 3),
                q("The Nile River flows through which country?", listOf("Ghana", "Egypt", "Kenya", "Nigeria"), 1),
                q("Which African country is entirely surrounded by South Africa?", listOf("Eswatini", "Lesotho", "Botswana", "Zimbabwe"), 1),
                q("The Serengeti National Park is mostly in:", listOf("Kenya", "Tanzania", "Uganda", "Rwanda"), 1),
                q("Accra is the capital of which country?", listOf("Nigeria", "Senegal", "Ghana", "Ivory Coast"), 2),
                q("Which African island nation is located in the Indian Ocean?", listOf("Madagascar", "Iceland", "Cuba", "Cyprus"), 0),
                q("The currency of Egypt is the:", listOf("Dirham", "Dinar", "Pound", "Shilling"), 2),
                q("Mount Kilimanjaro is located in:", listOf("Kenya", "Tanzania", "Uganda", "Rwanda"), 1)
            )
        ),
        GeoTest(
            id = 4, title = "South American Capitals", emoji = "🗺️",
            description = "Capitals from Brazil to Chile.",
            questions = listOf(
                q("What is the capital of Brazil?", listOf("Rio de Janeiro", "São Paulo", "Brasília", "Salvador"), 2),
                q("What is the capital of Argentina?", listOf("Córdoba", "Buenos Aires", "Rosario", "Mendoza"), 1),
                q("What is the capital of Chile?", listOf("Valparaíso", "Concepción", "Santiago", "Antofagasta"), 2),
                q("What is the capital of Peru?", listOf("Cusco", "Arequipa", "Trujillo", "Lima"), 3),
                q("What is the capital of Colombia?", listOf("Medellín", "Bogotá", "Cali", "Cartagena"), 1),
                q("What is the capital of Venezuela?", listOf("Maracaibo", "Valencia", "Caracas", "Barquisimeto"), 2),
                q("What is the capital of Uruguay?", listOf("Salto", "Montevideo", "Paysandú", "Rivera"), 1),
                q("What is the capital of Ecuador?", listOf("Guayaquil", "Cuenca", "Quito", "Manta"), 2),
                q("What is the capital of Bolivia (seat of government)?", listOf("Sucre", "Santa Cruz", "Cochabamba", "La Paz"), 3),
                q("What is the capital of Paraguay?", listOf("Asunción", "Ciudad del Este", "Encarnación", "Lambaré"), 0),
                q("What is the capital of Guyana?", listOf("Paramaribo", "Georgetown", "Cayenne", "Port of Spain"), 1),
                q("What is the capital of Suriname?", listOf("Paramaribo", "Georgetown", "Cayenne", "Belmopan"), 0),
                q("Which South American capital is at the highest altitude?", listOf("Bogotá", "Quito", "La Paz", "Lima"), 2),
                q("Brasília replaced which city as Brazil's capital?", listOf("São Paulo", "Salvador", "Rio de Janeiro", "Recife"), 2),
                q("Buenos Aires is located on the banks of which river?", listOf("Amazon", "Paraná", "Río de la Plata", "Orinoco"), 2),
                q("Which capital is also a country's largest city in population?", listOf("Brasília", "La Paz", "Lima", "Sucre"), 2)
            )
        ),
        GeoTest(
            id = 5, title = "Oceans and Seas", emoji = "🌊",
            description = "Waters of the world.",
            questions = listOf(
                q("Which is the largest ocean on Earth?", listOf("Atlantic", "Indian", "Pacific", "Arctic"), 2),
                q("Which ocean lies between Africa and Australia?", listOf("Atlantic", "Pacific", "Indian", "Southern"), 2),
                q("Which sea is between Europe and Africa?", listOf("Mediterranean", "Caspian", "Black", "Red"), 0),
                q("The Red Sea separates Africa from which continent?", listOf("Europe", "Asia", "Australia", "Antarctica"), 1),
                q("Which is the deepest ocean?", listOf("Atlantic", "Indian", "Pacific", "Arctic"), 2),
                q("Which sea is bordered by Turkey, Ukraine, and Bulgaria?", listOf("Aegean", "Adriatic", "Black Sea", "Baltic"), 2),
                q("The Caribbean Sea is part of which ocean?", listOf("Pacific", "Indian", "Atlantic", "Arctic"), 2),
                q("The Arabian Sea is part of which ocean?", listOf("Pacific", "Indian", "Atlantic", "Southern"), 1),
                q("Which is the saltiest sea/lake?", listOf("Black Sea", "Dead Sea", "Red Sea", "Baltic Sea"), 1),
                q("The North Sea lies between the UK and which country?", listOf("France", "Germany", "Norway", "Ireland"), 2),
                q("The Aegean Sea lies between Greece and which country?", listOf("Italy", "Turkey", "Egypt", "Libya"), 1),
                q("The Baltic Sea is connected to which ocean?", listOf("Atlantic", "Arctic", "Mediterranean", "Indian"), 0),
                q("The Adriatic Sea lies between Italy and:", listOf("Spain", "Greece", "The Balkans", "Turkey"), 2),
                q("The Sargasso Sea is located in which ocean?", listOf("Atlantic", "Pacific", "Indian", "Arctic"), 0),
                q("Which strait connects the Mediterranean with the Atlantic?", listOf("Bosphorus", "Gibraltar", "Hormuz", "Dover"), 1),
                q("The Bering Sea lies between Alaska and:", listOf("Canada", "Greenland", "Russia", "Japan"), 2)
            )
        ),
        GeoTest(
            id = 6, title = "Mountains of the World", emoji = "⛰️",
            description = "Peaks, ranges, and summits.",
            questions = listOf(
                q("What is the highest mountain on Earth?", listOf("K2", "Kangchenjunga", "Everest", "Lhotse"), 2),
                q("Which mountain range contains Everest?", listOf("Andes", "Alps", "Himalayas", "Rockies"), 2),
                q("The Alps are found in which region?", listOf("Asia", "Europe", "North America", "Africa"), 1),
                q("The Andes are located on which continent?", listOf("North America", "South America", "Asia", "Europe"), 1),
                q("Mount Kilimanjaro is in which country?", listOf("Kenya", "Uganda", "Tanzania", "Ethiopia"), 2),
                q("The Rocky Mountains are primarily in which countries?", listOf("Canada and USA", "USA and Mexico", "Canada and Mexico", "USA only"), 0),
                q("Which is the highest peak in the Americas?", listOf("Denali", "Aconcagua", "Fitz Roy", "Chimborazo"), 1),
                q("Mount Fuji is located in which country?", listOf("China", "South Korea", "Japan", "Taiwan"), 2),
                q("K2 is the second-highest peak on Earth. Where is it?", listOf("Nepal/China", "Pakistan/China", "India/China", "Bhutan/China"), 1),
                q("The Ural Mountains divide which two continents?", listOf("Europe and Africa", "Asia and Europe", "Asia and North America", "Europe and North America"), 1),
                q("Mont Blanc is the highest peak of which range?", listOf("Pyrenees", "Alps", "Apennines", "Carpathians"), 1),
                q("Denali, North America's highest peak, is in:", listOf("Canada", "Alaska", "Montana", "Colorado"), 1),
                q("Which country has the highest proportion of land above 3000 m?", listOf("Nepal", "Bhutan", "Switzerland", "Peru"), 0),
                q("Mount Elbrus is the highest peak of which continent?", listOf("Asia", "Europe", "Africa", "Antarctica"), 1),
                q("The Atlas Mountains are located in:", listOf("Europe", "Africa", "Asia", "South America"), 1),
                q("The Scandinavian Mountains run through Norway and:", listOf("Finland", "Sweden", "Denmark", "Iceland"), 1)
            )
        ),
        GeoTest(
            id = 7, title = "Rivers of the World", emoji = "🏞️",
            description = "Mighty rivers across continents.",
            questions = listOf(
                q("Which is the longest river in the world?", listOf("Amazon", "Nile", "Yangtze", "Mississippi"), 1),
                q("Which river flows through Egypt?", listOf("Niger", "Congo", "Nile", "Zambezi"), 2),
                q("The Amazon River is mostly in which country?", listOf("Peru", "Colombia", "Brazil", "Venezuela"), 2),
                q("The Yangtze is the longest river in which country?", listOf("India", "China", "Vietnam", "Mongolia"), 1),
                q("The Mississippi River is in which country?", listOf("Canada", "Mexico", "USA", "Brazil"), 2),
                q("The Danube flows through how many countries?", listOf("5", "7", "10", "4"), 2),
                q("The Ganges is sacred in which country?", listOf("Nepal", "India", "Bangladesh", "Sri Lanka"), 1),
                q("The Mekong River flows through how many countries?", listOf("3", "5", "6", "8"), 2),
                q("The Thames river flows through which city?", listOf("Manchester", "London", "Birmingham", "Liverpool"), 1),
                q("The Seine flows through which capital?", listOf("Brussels", "Paris", "Berlin", "Rome"), 1),
                q("The Rhine flows through which countries?", listOf("France and Italy", "Germany and Netherlands", "Spain and France", "Poland and Germany"), 1),
                q("The Tiber river is famous because it flows through:", listOf("Athens", "Rome", "Madrid", "Istanbul"), 1),
                q("The Volga, Europe's longest river, empties into the:", listOf("Black Sea", "Baltic Sea", "Caspian Sea", "Mediterranean"), 2),
                q("The Niger River flows primarily in which region?", listOf("North Africa", "West Africa", "East Africa", "Southern Africa"), 1),
                q("The Congo River is the second-longest in Africa, after the:", listOf("Niger", "Zambezi", "Nile", "Limpopo"), 2),
                q("The Colorado River carved which famous landmark?", listOf("Niagara Falls", "Grand Canyon", "Yosemite Valley", "Great Salt Lake"), 1)
            )
        ),
        GeoTest(
            id = 8, title = "Deserts and Climates", emoji = "🏜️",
            description = "From the Sahara to Atacama.",
            questions = listOf(
                q("Which is the largest hot desert on Earth?", listOf("Gobi", "Kalahari", "Sahara", "Arabian"), 2),
                q("The Atacama Desert is in which country?", listOf("Peru", "Argentina", "Chile", "Bolivia"), 2),
                q("The Gobi Desert is in which region?", listOf("South Asia", "East Asia", "Central Asia", "Middle East"), 1),
                q("The Kalahari Desert is in which continent?", listOf("Asia", "Africa", "Australia", "South America"), 1),
                q("Which is the largest desert overall (including cold)?", listOf("Sahara", "Antarctic", "Gobi", "Arabian"), 1),
                q("A Mediterranean climate is known for:", listOf("Cold wet winters, hot dry summers", "Year-round rain", "Cold all year", "Hot all year"), 0),
                q("A tropical rainforest climate is:", listOf("Cold and dry", "Hot and humid all year", "Seasonal", "Arid"), 1),
                q("The driest non-polar desert is:", listOf("Sahara", "Atacama", "Gobi", "Namib"), 1),
                q("Tundra is found mostly:", listOf("Near equator", "Near poles", "In tropics", "At sea level"), 1),
                q("A savanna climate is typical of:", listOf("Siberia", "Central Africa", "Sahara", "Amazon"), 1),
                q("The Namib Desert is located on the coast of:", listOf("Angola", "Namibia", "South Africa", "Mozambique"), 1),
                q("Death Valley is famous for being:", listOf("The wettest place in USA", "The hottest place in USA", "The coldest place in USA", "The highest place in USA"), 1),
                q("A taiga climate is dominated by:", listOf("Tropical forests", "Coniferous forests", "Grasslands", "Deserts"), 1),
                q("An oasis is most commonly found in a:", listOf("Forest", "Tundra", "Desert", "Savanna"), 2),
                q("The Australian Outback is mostly:", listOf("Tropical", "Semi-arid / arid", "Temperate", "Subarctic"), 1),
                q("A monsoon climate is typical of:", listOf("Scandinavia", "South Asia", "Antarctica", "Central Europe"), 1)
            )
        ),
        GeoTest(
            id = 9, title = "US Geography Basics", emoji = "🇺🇸",
            description = "Know your US states and landmarks.",
            questions = listOf(
                q("How many states are in the USA?", listOf("48", "49", "50", "52"), 2),
                q("Which is the largest US state by area?", listOf("Texas", "California", "Montana", "Alaska"), 3),
                q("Which is the smallest US state by area?", listOf("Delaware", "Rhode Island", "Connecticut", "Vermont"), 1),
                q("The Statue of Liberty is located in:", listOf("Boston", "Philadelphia", "New York", "Washington"), 2),
                q("The Grand Canyon is in which state?", listOf("Utah", "Arizona", "Nevada", "Colorado"), 1),
                q("Which river forms part of the US-Mexico border?", listOf("Colorado", "Rio Grande", "Mississippi", "Missouri"), 1),
                q("Mount Rushmore is in which state?", listOf("Wyoming", "Montana", "South Dakota", "Nebraska"), 2),
                q("The capital of the USA is:", listOf("New York", "Washington, D.C.", "Los Angeles", "Chicago"), 1),
                q("Which US state is a chain of islands?", listOf("Florida", "California", "Hawaii", "Alaska"), 2),
                q("Lake Superior is one of the:", listOf("Great Lakes", "Finger Lakes", "Great Salt Lakes", "Great Rift Lakes"), 0),
                q("Yellowstone National Park is mostly in:", listOf("Montana", "Wyoming", "Idaho", "Colorado"), 1),
                q("Which US state shares a border with Canada?", listOf("Arkansas", "Kentucky", "Minnesota", "Alabama"), 2),
                q("The Mississippi River empties into:", listOf("Pacific Ocean", "Atlantic Ocean", "Gulf of Mexico", "Lake Michigan"), 2),
                q("Silicon Valley is located in:", listOf("Oregon", "Washington", "California", "Nevada"), 2),
                q("The Everglades are in which state?", listOf("Texas", "Florida", "Georgia", "Louisiana"), 1),
                q("Which state's nickname is 'The Lone Star State'?", listOf("Texas", "Oklahoma", "Kansas", "Nevada"), 0)
            )
        ),
        GeoTest(
            id = 10, title = "Countries by Continent", emoji = "🌐",
            description = "Place countries in the right continent.",
            questions = listOf(
                q("Japan belongs to which continent?", listOf("Asia", "Oceania", "Europe", "Africa"), 0),
                q("Egypt is in which continent?", listOf("Asia", "Africa", "Middle East", "Europe"), 1),
                q("Brazil is in which continent?", listOf("Central America", "North America", "South America", "Caribbean"), 2),
                q("Germany is in which continent?", listOf("Asia", "Africa", "North America", "Europe"), 3),
                q("Australia is in which continent?", listOf("Asia", "Oceania", "Africa", "Antarctica"), 1),
                q("Kenya is in which continent?", listOf("Asia", "Africa", "Oceania", "Europe"), 1),
                q("Canada is in which continent?", listOf("North America", "Central America", "Caribbean", "Europe"), 0),
                q("Thailand is in which continent?", listOf("Oceania", "Africa", "Asia", "Europe"), 2),
                q("Greece is in which continent?", listOf("Africa", "Asia", "Europe", "Oceania"), 2),
                q("Fiji is in which continent?", listOf("Asia", "Oceania", "Africa", "South America"), 1),
                q("Morocco is in which continent?", listOf("Asia", "Africa", "Europe", "Middle East"), 1),
                q("Argentina is in which continent?", listOf("North America", "South America", "Central America", "Antarctica"), 1),
                q("New Zealand is in which continent?", listOf("Asia", "Oceania", "Antarctica", "Africa"), 1),
                q("India is in which continent?", listOf("Asia", "Africa", "Europe", "Oceania"), 0),
                q("Mexico is in which continent?", listOf("North America", "Central America", "South America", "Caribbean"), 0),
                q("South Africa is in which continent?", listOf("Asia", "Africa", "Oceania", "Antarctica"), 1)
            )
        ),
        GeoTest(
            id = 11, title = "Famous Landmarks", emoji = "🗽",
            description = "Iconic places around the world.",
            questions = listOf(
                q("In which city is the Eiffel Tower?", listOf("Rome", "London", "Paris", "Madrid"), 2),
                q("The Colosseum is located in:", listOf("Athens", "Rome", "Cairo", "Istanbul"), 1),
                q("Machu Picchu is in which country?", listOf("Bolivia", "Peru", "Ecuador", "Colombia"), 1),
                q("The Sydney Opera House is in:", listOf("Melbourne", "Brisbane", "Sydney", "Perth"), 2),
                q("The Great Wall is a landmark of which country?", listOf("Japan", "Korea", "China", "Vietnam"), 2),
                q("Christ the Redeemer overlooks which city?", listOf("São Paulo", "Rio de Janeiro", "Salvador", "Brasília"), 1),
                q("The Taj Mahal is located in which country?", listOf("Pakistan", "India", "Bangladesh", "Nepal"), 1),
                q("The Acropolis is a famous landmark of:", listOf("Rome", "Athens", "Cairo", "Jerusalem"), 1),
                q("Big Ben is located in:", listOf("Edinburgh", "Manchester", "London", "Dublin"), 2),
                q("The Pyramids of Giza are in:", listOf("Sudan", "Egypt", "Libya", "Tunisia"), 1),
                q("Stonehenge is located in:", listOf("Ireland", "England", "Scotland", "Wales"), 1),
                q("The Leaning Tower is in which city?", listOf("Florence", "Pisa", "Milan", "Naples"), 1),
                q("Angkor Wat is a temple complex in:", listOf("Thailand", "Vietnam", "Cambodia", "Laos"), 2),
                q("Petra, the rose-red city, is in:", listOf("Egypt", "Jordan", "Saudi Arabia", "Israel"), 1),
                q("The Brandenburg Gate is in:", listOf("Vienna", "Munich", "Berlin", "Hamburg", ), 2),
                q("The Parthenon sits on top of the:", listOf("Capitoline Hill", "Acropolis", "Palatine Hill", "Temple Mount"), 1)
            )
        ),
        GeoTest(
            id = 12, title = "World Currencies", emoji = "💱",
            description = "Match countries to their money.",
            questions = listOf(
                q("What is the currency of Japan?", listOf("Yuan", "Won", "Yen", "Ringgit"), 2),
                q("What is the currency of the UK?", listOf("Euro", "Pound sterling", "Dollar", "Krona"), 1),
                q("The Euro is used by:", listOf("All EU members", "Many EU members", "All of Europe", "Only France"), 1),
                q("What is the currency of India?", listOf("Rupee", "Taka", "Rupiah", "Ringgit"), 0),
                q("What is the currency of Brazil?", listOf("Peso", "Real", "Sol", "Boliviano"), 1),
                q("What is the currency of Mexico?", listOf("Dollar", "Peso", "Quetzal", "Real"), 1),
                q("What is the currency of South Korea?", listOf("Yen", "Yuan", "Won", "Baht"), 2),
                q("What is the currency of Thailand?", listOf("Baht", "Kip", "Dong", "Rupiah"), 0),
                q("What is the currency of South Africa?", listOf("Dollar", "Rand", "Kwanza", "Shilling"), 1),
                q("What is the currency of Switzerland?", listOf("Euro", "Franc", "Krone", "Schilling"), 1),
                q("What is the currency of China?", listOf("Yen", "Won", "Yuan", "Rupee"), 2),
                q("What is the currency of Turkey?", listOf("Lira", "Dinar", "Euro", "Drachma"), 0),
                q("What is the currency of Sweden?", listOf("Euro", "Krona", "Pound", "Franc"), 1),
                q("What is the currency of Egypt?", listOf("Dinar", "Dirham", "Pound", "Shilling"), 2),
                q("What is the currency of Vietnam?", listOf("Baht", "Kip", "Dong", "Peso"), 2),
                q("What is the currency of Canada?", listOf("Pound", "Dollar", "Peso", "Euro"), 1)
            )
        ),
        GeoTest(
            id = 13, title = "Largest Countries", emoji = "📏",
            description = "By area and population.",
            questions = listOf(
                q("Which is the largest country by area?", listOf("Canada", "China", "USA", "Russia"), 3),
                q("Which is the second-largest country by area?", listOf("USA", "China", "Canada", "Brazil"), 2),
                q("Which is the largest country in South America?", listOf("Argentina", "Peru", "Brazil", "Colombia"), 2),
                q("Which is the largest country in Africa?", listOf("Egypt", "DR Congo", "Sudan", "Algeria"), 3),
                q("Which is the most populous country?", listOf("China", "India", "USA", "Indonesia"), 1),
                q("Which is the largest country in Europe by area (excluding Russia)?", listOf("Germany", "France", "Ukraine", "Spain"), 2),
                q("Which is the largest country in Oceania?", listOf("New Zealand", "Papua New Guinea", "Australia", "Fiji"), 2),
                q("Which is the most populous country in Africa?", listOf("Egypt", "Nigeria", "Ethiopia", "DR Congo"), 1),
                q("Which is the largest country in Central America?", listOf("Nicaragua", "Honduras", "Guatemala", "Panama"), 0),
                q("Which country has the largest English-speaking population?", listOf("USA", "UK", "India", "Canada"), 2),
                q("Which is the fourth-largest country by area?", listOf("Brazil", "USA", "Australia", "Argentina"), 1),
                q("Which is the third-largest by population?", listOf("Brazil", "USA", "Indonesia", "Pakistan"), 1),
                q("Which is the largest country in North America?", listOf("USA", "Mexico", "Canada", "Greenland"), 2),
                q("Which is the largest island country?", listOf("Japan", "Philippines", "Indonesia", "Madagascar"), 2),
                q("Which is the largest country in the Middle East?", listOf("Saudi Arabia", "Iraq", "Turkey", "Egypt"), 0),
                q("Which Asian country has the largest area (excluding Russia)?", listOf("India", "China", "Kazakhstan", "Mongolia"), 1)
            )
        ),
        GeoTest(
            id = 14, title = "Smallest Countries", emoji = "🔬",
            description = "Microstates and tiny nations.",
            questions = listOf(
                q("Which is the smallest country in the world?", listOf("Monaco", "Vatican City", "San Marino", "Nauru"), 1),
                q("Monaco is located on the coast of:", listOf("Atlantic", "Mediterranean", "Adriatic", "Baltic"), 1),
                q("San Marino is surrounded by which country?", listOf("France", "Spain", "Italy", "Switzerland"), 2),
                q("Liechtenstein sits between which two countries?", listOf("Germany and France", "Austria and Switzerland", "Italy and Switzerland", "Austria and Germany"), 1),
                q("Andorra is located in which mountain range?", listOf("Alps", "Carpathians", "Pyrenees", "Apennines"), 2),
                q("Nauru is located in:", listOf("Atlantic", "Caribbean", "Pacific", "Indian Ocean"), 2),
                q("Tuvalu is in which region?", listOf("Caribbean", "Mediterranean", "Pacific", "Indian Ocean"), 2),
                q("Which tiny country is a city-state in Asia?", listOf("Brunei", "Singapore", "Qatar", "Bahrain"), 1),
                q("Malta is located in which sea?", listOf("Adriatic", "Aegean", "Mediterranean", "Black Sea"), 2),
                q("Which is the smallest country in Africa?", listOf("Djibouti", "Gambia", "Seychelles", "Rwanda"), 2),
                q("Vatican City is located within which city?", listOf("Florence", "Venice", "Rome", "Milan"), 2),
                q("Which is the smallest country in South America?", listOf("Uruguay", "Guyana", "Suriname", "Ecuador"), 2),
                q("Barbados is an island nation in which sea?", listOf("Mediterranean", "Caribbean", "Atlantic only", "Pacific"), 1),
                q("Palau is a small island nation in the:", listOf("Caribbean", "Pacific", "Indian Ocean", "Mediterranean"), 1),
                q("Luxembourg borders France, Germany, and:", listOf("Netherlands", "Belgium", "Switzerland", "Denmark"), 1),
                q("The Seychelles are located in which ocean?", listOf("Pacific", "Atlantic", "Indian", "Arctic"), 2)
            )
        ),
        GeoTest(
            id = 15, title = "Island Nations", emoji = "🏝️",
            description = "Countries surrounded by sea.",
            questions = listOf(
                q("Which of these is an island nation?", listOf("Austria", "Iceland", "Switzerland", "Czech Republic"), 1),
                q("Japan is:", listOf("A peninsula", "An island nation", "A landlocked country", "A continent"), 1),
                q("Which country consists of 17,000+ islands?", listOf("Philippines", "Indonesia", "Japan", "Malaysia"), 1),
                q("Cuba is located in which sea?", listOf("Mediterranean", "Caribbean", "Atlantic only", "Pacific"), 1),
                q("Madagascar is off the coast of:", listOf("India", "Africa", "South America", "Australia"), 1),
                q("Sri Lanka is near which country?", listOf("Bangladesh", "India", "Pakistan", "Myanmar"), 1),
                q("New Zealand is:", listOf("One island", "Two main islands", "Three main islands", "Four main islands"), 1),
                q("Iceland is in which ocean?", listOf("Atlantic", "Arctic", "Pacific", "Mediterranean"), 0),
                q("The Maldives are in which ocean?", listOf("Atlantic", "Pacific", "Indian", "Arctic"), 2),
                q("Which of these is NOT an island nation?", listOf("Fiji", "Mongolia", "Malta", "Jamaica"), 1),
                q("The Philippines consist of how many islands?", listOf("1,000+", "3,000+", "7,000+", "10,000+"), 2),
                q("Cyprus is an island in which sea?", listOf("Adriatic", "Aegean", "Mediterranean", "Black Sea"), 2),
                q("Taiwan is an island located near:", listOf("Japan", "Philippines", "Mainland China", "Vietnam"), 2),
                q("Which island nation's capital is Port Louis?", listOf("Seychelles", "Mauritius", "Madagascar", "Comoros"), 1),
                q("Greenland is a territory of which country?", listOf("Norway", "Iceland", "Denmark", "Sweden"), 2),
                q("The Bahamas are located in the:", listOf("Mediterranean", "Pacific", "Caribbean/Atlantic", "Indian Ocean"), 2)
            )
        ),
        GeoTest(
            id = 16, title = "Population Facts", emoji = "👥",
            description = "People around the world.",
            questions = listOf(
                q("Approximate world population in 2024?", listOf("6 billion", "7 billion", "8 billion", "10 billion"), 2),
                q("Which country has the most people?", listOf("China", "India", "USA", "Indonesia"), 1),
                q("Which continent has the largest population?", listOf("Africa", "Asia", "Europe", "Americas"), 1),
                q("Which city is one of the most populous in the world?", listOf("Tokyo", "Oslo", "Dublin", "Wellington"), 0),
                q("Which country has the third-largest population?", listOf("Indonesia", "USA", "Pakistan", "Brazil"), 1),
                q("Which continent has the smallest population?", listOf("Oceania", "Antarctica", "South America", "Europe"), 1),
                q("Nigeria's population is about:", listOf("60 million", "100 million", "220 million", "400 million"), 2),
                q("Which European country has the largest population?", listOf("France", "Germany", "UK", "Italy"), 1),
                q("Which country has a very low population density despite a huge area?", listOf("Canada", "India", "Japan", "Bangladesh"), 0),
                q("Approximately what % of people live in Asia?", listOf("30%", "45%", "60%", "80%"), 2),
                q("Which city has a metropolitan population of ~20+ million?", listOf("Reykjavik", "Delhi", "Canberra", "Bern"), 1),
                q("Which is among the least densely populated countries?", listOf("Mongolia", "Bangladesh", "Netherlands", "South Korea"), 0),
                q("The most densely populated country is often considered:", listOf("India", "Monaco", "Japan", "China"), 1),
                q("Which country has roughly the same population as the USA?", listOf("Pakistan", "Indonesia", "Brazil", "Russia"), 1),
                q("Bangladesh is known for:", listOf("Low density", "High density", "Empty deserts", "Small population"), 1),
                q("About how many countries are there in the world?", listOf("~100", "~150", "~195", "~300"), 2)
            )
        ),
        GeoTest(
            id = 17, title = "Borders and Neighbors", emoji = "🧭",
            description = "Who borders whom?",
            questions = listOf(
                q("Which country borders both the USA and Guatemala?", listOf("Cuba", "Mexico", "Belize", "Honduras"), 1),
                q("Which country shares a land border with the UK?", listOf("France", "Ireland", "Iceland", "Norway"), 1),
                q("Which country does NOT border Germany?", listOf("France", "Austria", "Italy", "Netherlands"), 2),
                q("Spain borders which country to the west?", listOf("France", "Portugal", "Andorra", "Morocco"), 1),
                q("Brazil borders how many countries?", listOf("5", "7", "9", "10"), 3),
                q("Which country borders Egypt to the west?", listOf("Libya", "Sudan", "Chad", "Algeria"), 0),
                q("India shares a border with which country?", listOf("Thailand", "Nepal", "Japan", "Indonesia"), 1),
                q("Which two countries are separated by the Pyrenees?", listOf("France and Italy", "Spain and France", "Spain and Portugal", "Italy and Switzerland"), 1),
                q("Argentina shares its longest border with:", listOf("Brazil", "Chile", "Bolivia", "Paraguay"), 1),
                q("Canada's only land border is with:", listOf("Greenland", "Russia", "USA", "Iceland"), 2),
                q("Which country borders the most other countries in Africa?", listOf("Egypt", "DR Congo", "Sudan", "Ethiopia"), 1),
                q("Poland shares a border with which of these?", listOf("Italy", "Germany", "France", "Greece"), 1),
                q("Which country borders both Thailand and Vietnam?", listOf("Myanmar", "Cambodia", "Malaysia", "Indonesia"), 1),
                q("Which country is a neighbor of Kenya?", listOf("Nigeria", "Tanzania", "Ghana", "Senegal"), 1),
                q("Which country borders Portugal?", listOf("France", "Spain", "Morocco", "Italy"), 1),
                q("The longest international land border runs between:", listOf("USA and Mexico", "USA and Canada", "Brazil and Argentina", "China and Mongolia"), 1)
            )
        ),
        GeoTest(
            id = 18, title = "World Map Regions", emoji = "🗺️",
            description = "Regions and directions.",
            questions = listOf(
                q("Scandinavia includes which of these?", listOf("Germany", "Norway", "Netherlands", "Estonia"), 1),
                q("The Balkans are in which part of Europe?", listOf("North", "South", "West", "East"), 1),
                q("The Middle East is mostly part of which continent?", listOf("Africa", "Asia", "Europe", "Oceania"), 1),
                q("Central America connects which two continents?", listOf("North and South America", "Asia and Africa", "Europe and Africa", "Africa and South America"), 0),
                q("The Iberian Peninsula contains:", listOf("Italy and Greece", "Spain and Portugal", "France and Spain", "Spain and Morocco"), 1),
                q("Southeast Asia includes:", listOf("Japan", "Vietnam", "Pakistan", "Mongolia"), 1),
                q("Patagonia is located in:", listOf("Europe", "Southern South America", "Asia", "Australia"), 1),
                q("The Maghreb region is in:", listOf("East Africa", "North Africa", "West Africa", "Southern Africa"), 1),
                q("Micronesia is part of:", listOf("Africa", "Oceania", "Asia", "Europe"), 1),
                q("The Caucasus region lies between:", listOf("Black and Caspian Seas", "Mediterranean and Red Seas", "Atlantic and Pacific", "Baltic and Black Seas"), 0),
                q("The Horn of Africa refers to countries including:", listOf("Morocco and Algeria", "Ethiopia and Somalia", "Kenya and Tanzania", "Nigeria and Ghana"), 1),
                q("Polynesia is a region of:", listOf("Caribbean", "Pacific", "Indian Ocean", "Atlantic"), 1),
                q("Mesopotamia is a historical region in the modern-day:", listOf("Egypt", "Iraq area", "Greece", "Turkey"), 1),
                q("The Sahel region lies just south of:", listOf("Mediterranean", "Sahara", "Atlas Mountains", "Red Sea"), 1),
                q("The Benelux includes Belgium, Netherlands, and:", listOf("Luxembourg", "Liechtenstein", "Switzerland", "Austria"), 0),
                q("The Arabian Peninsula contains countries like:", listOf("Morocco", "Saudi Arabia", "Egypt", "Turkey"), 1)
            )
        ),
        GeoTest(
            id = 19, title = "Natural Wonders", emoji = "🌋",
            description = "Marvels of nature.",
            questions = listOf(
                q("The Great Barrier Reef is in:", listOf("Indonesia", "Australia", "Philippines", "Fiji"), 1),
                q("The Amazon rainforest is mostly in:", listOf("Colombia", "Peru", "Brazil", "Venezuela"), 2),
                q("Victoria Falls is on the border of:", listOf("Zambia and Zimbabwe", "Kenya and Uganda", "Ethiopia and Sudan", "Angola and Namibia"), 0),
                q("Iguazu Falls lies between:", listOf("Chile and Peru", "Argentina and Brazil", "Colombia and Venezuela", "Ecuador and Peru"), 1),
                q("The Grand Canyon was carved by which river?", listOf("Mississippi", "Colorado", "Rio Grande", "Missouri"), 1),
                q("Mount Everest is between:", listOf("India and China", "Nepal and China", "Nepal and India", "Bhutan and China"), 1),
                q("The Dead Sea is known for:", listOf("High altitude", "Freezing temperatures", "Extreme salinity", "Strong currents"), 2),
                q("Lake Baikal is in which country?", listOf("Mongolia", "Kazakhstan", "Russia", "China"), 2),
                q("Uluru (Ayers Rock) is in:", listOf("New Zealand", "Australia", "Fiji", "Samoa"), 1),
                q("The Northern Lights are best seen near:", listOf("Equator", "Tropics", "Polar regions", "Deserts"), 2),
                q("Niagara Falls is on the border of:", listOf("USA and Mexico", "USA and Canada", "Canada and Greenland", "USA and Cuba"), 1),
                q("The Great Blue Hole is a natural wonder in:", listOf("Mexico", "Belize", "Bahamas", "Cuba"), 1),
                q("Mount Vesuvius is a volcano near:", listOf("Rome", "Naples", "Florence", "Palermo"), 1),
                q("The Ha Long Bay is famous in:", listOf("Thailand", "Vietnam", "Indonesia", "Philippines"), 1),
                q("The largest waterfall by volume, Victoria Falls, is on which river?", listOf("Nile", "Zambezi", "Congo", "Niger"), 1),
                q("The Salar de Uyuni, the world's largest salt flat, is in:", listOf("Chile", "Bolivia", "Argentina", "Peru"), 1)
            )
        ),
        GeoTest(
            id = 20, title = "Mixed Geography Challenge", emoji = "🏆",
            description = "A little bit of everything.",
            questions = listOf(
                q("Which country has the most time zones?", listOf("USA", "France", "Russia", "China"), 1),
                q("Which is the smallest continent?", listOf("Europe", "Oceania", "Antarctica", "South America"), 1),
                q("Which canal connects the Mediterranean and Red Seas?", listOf("Panama", "Suez", "Kiel", "Corinth"), 1),
                q("Which canal connects the Atlantic and Pacific Oceans?", listOf("Suez", "Panama", "Kiel", "Erie"), 1),
                q("Istanbul spans which two continents?", listOf("Europe and Asia", "Europe and Africa", "Asia and Africa", "Asia and Oceania"), 0),
                q("The equator passes through which country?", listOf("Nigeria", "Mexico", "Ecuador", "South Africa"), 2),
                q("Which is the flattest continent?", listOf("Africa", "Asia", "Europe", "Australia"), 3),
                q("The prime meridian passes through which city?", listOf("Paris", "London", "Madrid", "Rome"), 1),
                q("Which country is known as the 'Land of the Rising Sun'?", listOf("China", "South Korea", "Japan", "Thailand"), 2),
                q("Which landlocked country is famous for the Alps?", listOf("Switzerland", "Netherlands", "Sweden", "Denmark"), 0),
                q("The deepest known point in the ocean is the:", listOf("Puerto Rico Trench", "Mariana Trench", "Java Trench", "Tonga Trench"), 1),
                q("Which country is completely surrounded by one other country?", listOf("Andorra", "Lesotho", "Monaco", "San Marino"), 1),
                q("Which is the hottest continent on average?", listOf("Asia", "Africa", "South America", "Oceania"), 1),
                q("Which is the coldest continent?", listOf("Arctic", "Antarctica", "Europe", "Greenland"), 1),
                q("Which imaginary line divides Earth into Northern and Southern hemispheres?", listOf("Prime meridian", "Equator", "Tropic of Cancer", "Arctic Circle"), 1),
                q("How many continents are there on Earth?", listOf("5", "6", "7", "8"), 2)
            )
        )
    )

    fun findTest(id: Int): GeoTest? = tests.firstOrNull { it.id == id }
}
