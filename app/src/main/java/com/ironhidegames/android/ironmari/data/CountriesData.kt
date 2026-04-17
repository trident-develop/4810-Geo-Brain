package com.ironhidegames.android.ironmari.data

object CountriesData {

    private val northAmerica = listOf(
        Country(
            id = "us", name = "United States", flagEmoji = "🇺🇸", continentId = "north_america",
            capital = "Washington, D.C.", population = "333 million",
            area = "9.83 million km²", language = "English",
            currency = "US Dollar (USD)",
            landmarks = listOf("Statue of Liberty", "Grand Canyon", "Mount Rushmore", "Golden Gate Bridge"),
            neighbors = listOf("Canada", "Mexico"),
            climate = "Varied: from tropical in Florida to arctic in Alaska",
            facts = listOf(
                "The US has 50 states and is the third-largest country by area.",
                "Alaska is the largest state, while Rhode Island is the smallest.",
                "The national anthem is 'The Star-Spangled Banner'."
            )
        ),
        Country(
            id = "ca", name = "Canada", flagEmoji = "🇨🇦", continentId = "north_america",
            capital = "Ottawa", population = "40 million",
            area = "9.98 million km²", language = "English, French",
            currency = "Canadian Dollar (CAD)",
            landmarks = listOf("Niagara Falls", "CN Tower", "Banff National Park", "Old Quebec"),
            neighbors = listOf("United States"),
            climate = "Cold winters, mild summers, arctic in the north",
            facts = listOf(
                "Canada is the second-largest country in the world by area.",
                "It has the longest coastline of any country on Earth.",
                "Hockey is Canada's official winter sport."
            )
        ),
        Country(
            id = "mx", name = "Mexico", flagEmoji = "🇲🇽", continentId = "north_america",
            capital = "Mexico City", population = "128 million",
            area = "1.96 million km²", language = "Spanish",
            currency = "Mexican Peso (MXN)",
            landmarks = listOf("Chichen Itza", "Teotihuacan", "Tulum Ruins", "Copper Canyon"),
            neighbors = listOf("United States", "Guatemala", "Belize"),
            climate = "Tropical in the south, desert in the north",
            facts = listOf(
                "Mexico City is built on the ruins of the Aztec capital Tenochtitlan.",
                "Chocolate, chili peppers, and corn originated in Mexico.",
                "Mexico has 35 UNESCO World Heritage sites."
            )
        ),
        Country(
            id = "cu", name = "Cuba", flagEmoji = "🇨🇺", continentId = "north_america",
            capital = "Havana", population = "11 million",
            area = "109,884 km²", language = "Spanish",
            currency = "Cuban Peso (CUP)",
            landmarks = listOf("Old Havana", "Varadero Beach", "Viñales Valley", "Trinidad"),
            neighbors = listOf("None (island nation)"),
            climate = "Tropical, moderated by trade winds",
            facts = listOf(
                "Cuba is the largest island in the Caribbean.",
                "Famous for cigars, salsa music, and classic cars.",
                "Baseball is the most popular sport in Cuba."
            )
        ),
        Country(
            id = "pa", name = "Panama", flagEmoji = "🇵🇦", continentId = "north_america",
            capital = "Panama City", population = "4.4 million",
            area = "75,417 km²", language = "Spanish",
            currency = "Panamanian Balboa, US Dollar",
            landmarks = listOf("Panama Canal", "Casco Viejo", "San Blas Islands", "Biomuseo"),
            neighbors = listOf("Costa Rica", "Colombia"),
            climate = "Tropical maritime",
            facts = listOf(
                "The Panama Canal connects the Atlantic and Pacific oceans.",
                "Panama uses the US dollar alongside the Balboa.",
                "It is a major biodiversity hotspot."
            )
        )
    )

    private val southAmerica = listOf(
        Country(
            id = "br", name = "Brazil", flagEmoji = "🇧🇷", continentId = "south_america",
            capital = "Brasília", population = "215 million",
            area = "8.51 million km²", language = "Portuguese",
            currency = "Brazilian Real (BRL)",
            landmarks = listOf("Christ the Redeemer", "Amazon Rainforest", "Iguazu Falls", "Copacabana Beach"),
            neighbors = listOf("Argentina", "Uruguay", "Paraguay", "Bolivia", "Peru", "Colombia", "Venezuela", "Guyana", "Suriname", "French Guiana"),
            climate = "Tropical, with a temperate zone in the south",
            facts = listOf(
                "Brazil is the largest country in South America.",
                "The Amazon River flows through Brazil.",
                "Portuguese is the official language, a legacy of colonization."
            )
        ),
        Country(
            id = "ar", name = "Argentina", flagEmoji = "🇦🇷", continentId = "south_america",
            capital = "Buenos Aires", population = "46 million",
            area = "2.78 million km²", language = "Spanish",
            currency = "Argentine Peso (ARS)",
            landmarks = listOf("Perito Moreno Glacier", "Iguazu Falls", "Tango halls of Buenos Aires", "Patagonia"),
            neighbors = listOf("Chile", "Bolivia", "Paraguay", "Brazil", "Uruguay"),
            climate = "Temperate, with arid zones and cold in the south",
            facts = listOf(
                "Argentina is the birthplace of tango.",
                "Aconcagua, the highest peak in the Americas, is here.",
                "Argentina is famous for beef and football."
            )
        ),
        Country(
            id = "cl", name = "Chile", flagEmoji = "🇨🇱", continentId = "south_america",
            capital = "Santiago", population = "19 million",
            area = "756,102 km²", language = "Spanish",
            currency = "Chilean Peso (CLP)",
            landmarks = listOf("Atacama Desert", "Easter Island", "Torres del Paine", "Valparaíso"),
            neighbors = listOf("Peru", "Bolivia", "Argentina"),
            climate = "Desert in the north, Mediterranean in the center, cold in the south",
            facts = listOf(
                "Chile is one of the longest countries in the world.",
                "The Atacama is the driest non-polar desert on Earth.",
                "Easter Island is a Chilean territory in the Pacific."
            )
        ),
        Country(
            id = "pe", name = "Peru", flagEmoji = "🇵🇪", continentId = "south_america",
            capital = "Lima", population = "33 million",
            area = "1.29 million km²", language = "Spanish, Quechua",
            currency = "Peruvian Sol (PEN)",
            landmarks = listOf("Machu Picchu", "Lake Titicaca", "Nazca Lines", "Cusco"),
            neighbors = listOf("Ecuador", "Colombia", "Brazil", "Bolivia", "Chile"),
            climate = "Varied: coastal desert, Andean highlands, Amazon rainforest",
            facts = listOf(
                "Machu Picchu is one of the New Seven Wonders of the World.",
                "Peru is the birthplace of the potato.",
                "The Inca Empire was centered here."
            )
        ),
        Country(
            id = "co", name = "Colombia", flagEmoji = "🇨🇴", continentId = "south_america",
            capital = "Bogotá", population = "52 million",
            area = "1.14 million km²", language = "Spanish",
            currency = "Colombian Peso (COP)",
            landmarks = listOf("Cartagena Old Town", "Cocora Valley", "Tayrona Park", "Caño Cristales"),
            neighbors = listOf("Venezuela", "Brazil", "Peru", "Ecuador", "Panama"),
            climate = "Tropical along the coast, cooler in the Andes",
            facts = listOf(
                "Colombia is the world's leading producer of emeralds.",
                "It has coastlines on both the Pacific and Caribbean.",
                "Colombian coffee is world-renowned."
            )
        )
    )

    private val europe = listOf(
        Country(
            id = "de", name = "Germany", flagEmoji = "🇩🇪", continentId = "europe",
            capital = "Berlin", population = "84 million",
            area = "357,022 km²", language = "German",
            currency = "Euro (EUR)",
            landmarks = listOf("Brandenburg Gate", "Neuschwanstein Castle", "Cologne Cathedral", "Black Forest"),
            neighbors = listOf("France", "Poland", "Czech Republic", "Austria", "Switzerland", "Netherlands", "Belgium", "Luxembourg", "Denmark"),
            climate = "Temperate maritime to continental",
            facts = listOf(
                "Germany is Europe's largest economy.",
                "Oktoberfest is held every year in Munich.",
                "There are over 1,500 types of sausage produced."
            )
        ),
        Country(
            id = "fr", name = "France", flagEmoji = "🇫🇷", continentId = "europe",
            capital = "Paris", population = "68 million",
            area = "643,801 km²", language = "French",
            currency = "Euro (EUR)",
            landmarks = listOf("Eiffel Tower", "Louvre Museum", "Mont Saint-Michel", "French Riviera"),
            neighbors = listOf("Spain", "Andorra", "Belgium", "Luxembourg", "Germany", "Switzerland", "Italy", "Monaco"),
            climate = "Oceanic in the west, Mediterranean in the south",
            facts = listOf(
                "France is the most visited country in the world.",
                "The Louvre is the largest art museum on Earth.",
                "France produces over 1,500 cheeses."
            )
        ),
        Country(
            id = "it", name = "Italy", flagEmoji = "🇮🇹", continentId = "europe",
            capital = "Rome", population = "59 million",
            area = "301,340 km²", language = "Italian",
            currency = "Euro (EUR)",
            landmarks = listOf("Colosseum", "Leaning Tower of Pisa", "Venice canals", "Amalfi Coast"),
            neighbors = listOf("France", "Switzerland", "Austria", "Slovenia", "Vatican City", "San Marino"),
            climate = "Mediterranean, alpine in the north",
            facts = listOf(
                "Italy has more UNESCO World Heritage sites than any other country.",
                "Pizza and pasta originated here.",
                "Rome is known as the 'Eternal City'."
            )
        ),
        Country(
            id = "es", name = "Spain", flagEmoji = "🇪🇸", continentId = "europe",
            capital = "Madrid", population = "48 million",
            area = "505,990 km²", language = "Spanish",
            currency = "Euro (EUR)",
            landmarks = listOf("Sagrada Família", "Alhambra", "Park Güell", "Plaza Mayor"),
            neighbors = listOf("Portugal", "France", "Andorra"),
            climate = "Mediterranean, oceanic in the north",
            facts = listOf(
                "Spain produces nearly half of the world's olive oil.",
                "Flamenco music and dance originated in Andalusia.",
                "Spanish is the second most spoken native language in the world."
            )
        ),
        Country(
            id = "gb", name = "United Kingdom", flagEmoji = "🇬🇧", continentId = "europe",
            capital = "London", population = "67 million",
            area = "243,610 km²", language = "English",
            currency = "Pound Sterling (GBP)",
            landmarks = listOf("Big Ben", "Stonehenge", "Tower Bridge", "Edinburgh Castle"),
            neighbors = listOf("Ireland (land border)"),
            climate = "Temperate maritime, often rainy",
            facts = listOf(
                "The UK consists of England, Scotland, Wales, and Northern Ireland.",
                "English is spoken worldwide thanks to the British Empire.",
                "London has the world's oldest underground metro system."
            )
        ),
        Country(
            id = "pl", name = "Poland", flagEmoji = "🇵🇱", continentId = "europe",
            capital = "Warsaw", population = "38 million",
            area = "312,696 km²", language = "Polish",
            currency = "Polish Złoty (PLN)",
            landmarks = listOf("Wawel Castle", "Auschwitz Memorial", "Main Market Square in Kraków", "Białowieża Forest"),
            neighbors = listOf("Germany", "Czech Republic", "Slovakia", "Ukraine", "Belarus", "Lithuania"),
            climate = "Temperate continental",
            facts = listOf(
                "Poland has the oldest salt mine in Europe — Wieliczka.",
                "Chopin was born in Poland.",
                "It has one of Europe's last primeval forests."
            )
        ),
        Country(
            id = "nl", name = "Netherlands", flagEmoji = "🇳🇱", continentId = "europe",
            capital = "Amsterdam", population = "17.8 million",
            area = "41,850 km²", language = "Dutch",
            currency = "Euro (EUR)",
            landmarks = listOf("Canals of Amsterdam", "Keukenhof Gardens", "Kinderdijk Windmills", "Rijksmuseum"),
            neighbors = listOf("Germany", "Belgium"),
            climate = "Temperate maritime",
            facts = listOf(
                "About 25% of the country is below sea level.",
                "The Netherlands is the world's second-largest exporter of food.",
                "Bicycles outnumber people in many Dutch cities."
            )
        ),
        Country(
            id = "se", name = "Sweden", flagEmoji = "🇸🇪", continentId = "europe",
            capital = "Stockholm", population = "10.5 million",
            area = "450,295 km²", language = "Swedish",
            currency = "Swedish Krona (SEK)",
            landmarks = listOf("Vasa Museum", "Gamla Stan", "Icehotel", "Abisko National Park"),
            neighbors = listOf("Norway", "Finland"),
            climate = "Temperate in the south, subarctic in the north",
            facts = listOf(
                "Sweden has over 267,000 islands.",
                "The Nobel Prizes are awarded in Stockholm.",
                "ABBA and IKEA come from Sweden."
            )
        ),
        Country(
            id = "no", name = "Norway", flagEmoji = "🇳🇴", continentId = "europe",
            capital = "Oslo", population = "5.5 million",
            area = "385,207 km²", language = "Norwegian",
            currency = "Norwegian Krone (NOK)",
            landmarks = listOf("Geirangerfjord", "Preikestolen", "Bryggen in Bergen", "North Cape"),
            neighbors = listOf("Sweden", "Finland"),
            climate = "Temperate along the coast, arctic inland and north",
            facts = listOf(
                "Norway is famous for fjords carved by glaciers.",
                "The midnight sun shines in northern Norway in summer.",
                "The Nobel Peace Prize is awarded in Oslo."
            )
        ),
        Country(
            id = "gr", name = "Greece", flagEmoji = "🇬🇷", continentId = "europe",
            capital = "Athens", population = "10.4 million",
            area = "131,957 km²", language = "Greek",
            currency = "Euro (EUR)",
            landmarks = listOf("Acropolis", "Santorini", "Meteora", "Delphi"),
            neighbors = listOf("Albania", "North Macedonia", "Bulgaria", "Turkey"),
            climate = "Mediterranean",
            facts = listOf(
                "Greece is the birthplace of democracy and the Olympics.",
                "There are about 6,000 Greek islands and islets.",
                "Greek mythology has shaped Western literature for millennia."
            )
        )
    )

    private val africa = listOf(
        Country(
            id = "eg", name = "Egypt", flagEmoji = "🇪🇬", continentId = "africa",
            capital = "Cairo", population = "109 million",
            area = "1.01 million km²", language = "Arabic",
            currency = "Egyptian Pound (EGP)",
            landmarks = listOf("Pyramids of Giza", "Sphinx", "Karnak Temple", "Valley of the Kings"),
            neighbors = listOf("Libya", "Sudan", "Israel"),
            climate = "Hot desert",
            facts = listOf(
                "The Great Pyramid of Giza is the only surviving Wonder of the Ancient World.",
                "The Nile is the longest river in Africa.",
                "Ancient Egyptian civilization lasted over 3,000 years."
            )
        ),
        Country(
            id = "za", name = "South Africa", flagEmoji = "🇿🇦", continentId = "africa",
            capital = "Pretoria (executive), Cape Town, Bloemfontein", population = "60 million",
            area = "1.22 million km²", language = "11 official languages",
            currency = "South African Rand (ZAR)",
            landmarks = listOf("Table Mountain", "Kruger National Park", "Robben Island", "Cape of Good Hope"),
            neighbors = listOf("Namibia", "Botswana", "Zimbabwe", "Mozambique", "Eswatini", "Lesotho"),
            climate = "Mostly temperate, semi-arid inland",
            facts = listOf(
                "South Africa has three capital cities.",
                "It is home to the Big Five safari animals.",
                "The country produces much of the world's gold and diamonds."
            )
        ),
        Country(
            id = "ng", name = "Nigeria", flagEmoji = "🇳🇬", continentId = "africa",
            capital = "Abuja", population = "223 million",
            area = "923,768 km²", language = "English",
            currency = "Nigerian Naira (NGN)",
            landmarks = listOf("Zuma Rock", "Olumo Rock", "Yankari National Park", "Lekki Conservation Centre"),
            neighbors = listOf("Benin", "Niger", "Chad", "Cameroon"),
            climate = "Tropical, with savannah in the north",
            facts = listOf(
                "Nigeria is the most populous country in Africa.",
                "Nollywood is one of the largest film industries in the world.",
                "Lagos is a major African economic hub."
            )
        ),
        Country(
            id = "ke", name = "Kenya", flagEmoji = "🇰🇪", continentId = "africa",
            capital = "Nairobi", population = "54 million",
            area = "580,367 km²", language = "Swahili, English",
            currency = "Kenyan Shilling (KES)",
            landmarks = listOf("Maasai Mara", "Mount Kenya", "Amboseli National Park", "Lake Nakuru"),
            neighbors = listOf("Tanzania", "Uganda", "South Sudan", "Ethiopia", "Somalia"),
            climate = "Tropical along the coast, temperate inland",
            facts = listOf(
                "Kenya is famous for its wildlife safaris.",
                "It has produced many of the world's best long-distance runners.",
                "The Great Rift Valley crosses the country."
            )
        ),
        Country(
            id = "ma", name = "Morocco", flagEmoji = "🇲🇦", continentId = "africa",
            capital = "Rabat", population = "37 million",
            area = "446,550 km²", language = "Arabic, Berber",
            currency = "Moroccan Dirham (MAD)",
            landmarks = listOf("Medina of Fes", "Marrakesh", "Sahara Desert", "Chefchaouen"),
            neighbors = listOf("Algeria", "Mauritania (via Western Sahara)", "Spain (via exclaves)"),
            climate = "Mediterranean in the north, desert in the south",
            facts = listOf(
                "Morocco's Fes el-Bali is the world's largest car-free urban zone.",
                "Mint tea is the national drink.",
                "The Atlas Mountains run through the country."
            )
        ),
        Country(
            id = "et", name = "Ethiopia", flagEmoji = "🇪🇹", continentId = "africa",
            capital = "Addis Ababa", population = "120 million",
            area = "1.10 million km²", language = "Amharic",
            currency = "Ethiopian Birr (ETB)",
            landmarks = listOf("Rock-hewn Churches of Lalibela", "Simien Mountains", "Danakil Depression", "Axum"),
            neighbors = listOf("Eritrea", "Djibouti", "Somalia", "Kenya", "South Sudan", "Sudan"),
            climate = "Tropical monsoon with highland and desert variations",
            facts = listOf(
                "Ethiopia is believed to be the birthplace of coffee.",
                "It uses its own calendar with 13 months.",
                "It is one of the oldest nations in the world."
            )
        )
    )

    private val asia = listOf(
        Country(
            id = "cn", name = "China", flagEmoji = "🇨🇳", continentId = "asia",
            capital = "Beijing", population = "1.41 billion",
            area = "9.6 million km²", language = "Mandarin Chinese",
            currency = "Chinese Yuan (CNY)",
            landmarks = listOf("Great Wall", "Forbidden City", "Terracotta Army", "Li River"),
            neighbors = listOf("Mongolia", "Kazakhstan", "Kyrgyzstan", "Tajikistan", "Afghanistan", "Pakistan", "India", "Nepal", "Bhutan", "Myanmar", "Laos", "Vietnam"),
            climate = "Very diverse: from subarctic to tropical",
            facts = listOf(
                "China has the world's second largest economy.",
                "The Great Wall stretches over 21,000 km.",
                "Tea, paper, and gunpowder were invented in China."
            )
        ),
        Country(
            id = "jp", name = "Japan", flagEmoji = "🇯🇵", continentId = "asia",
            capital = "Tokyo", population = "125 million",
            area = "377,975 km²", language = "Japanese",
            currency = "Japanese Yen (JPY)",
            landmarks = listOf("Mount Fuji", "Fushimi Inari Shrine", "Tokyo Skytree", "Itsukushima Shrine"),
            neighbors = listOf("None (island nation)"),
            climate = "Temperate with four seasons, subtropical in the south",
            facts = listOf(
                "Japan consists of 14,000+ islands.",
                "Mount Fuji is the highest peak at 3,776 m.",
                "Japan has the world's oldest continuous monarchy."
            )
        ),
        Country(
            id = "in", name = "India", flagEmoji = "🇮🇳", continentId = "asia",
            capital = "New Delhi", population = "1.43 billion",
            area = "3.29 million km²", language = "Hindi, English and 20+ others",
            currency = "Indian Rupee (INR)",
            landmarks = listOf("Taj Mahal", "Red Fort", "Jaipur City Palace", "Varanasi Ghats"),
            neighbors = listOf("Pakistan", "China", "Nepal", "Bhutan", "Bangladesh", "Myanmar"),
            climate = "Tropical monsoon, arid in the west, alpine in the north",
            facts = listOf(
                "India is the world's most populous country.",
                "Yoga and chess originated in India.",
                "It is the largest democracy in the world."
            )
        ),
        Country(
            id = "kr", name = "South Korea", flagEmoji = "🇰🇷", continentId = "asia",
            capital = "Seoul", population = "52 million",
            area = "100,210 km²", language = "Korean",
            currency = "South Korean Won (KRW)",
            landmarks = listOf("Gyeongbokgung Palace", "Jeju Island", "Bukhansan", "Busan Beach"),
            neighbors = listOf("None land-only to the south (peninsula)"),
            climate = "Temperate with four distinct seasons",
            facts = listOf(
                "South Korea is a global leader in technology and K-pop.",
                "Seoul is one of the largest metropolitan areas in the world.",
                "The Korean alphabet, Hangul, was created in the 15th century."
            )
        ),
        Country(
            id = "th", name = "Thailand", flagEmoji = "🇹🇭", continentId = "asia",
            capital = "Bangkok", population = "70 million",
            area = "513,120 km²", language = "Thai",
            currency = "Thai Baht (THB)",
            landmarks = listOf("Grand Palace", "Wat Arun", "Phi Phi Islands", "Ayutthaya"),
            neighbors = listOf("Myanmar", "Laos", "Cambodia", "Malaysia"),
            climate = "Tropical",
            facts = listOf(
                "Thailand is the only Southeast Asian country never colonized by Europeans.",
                "It is known as the 'Land of Smiles'.",
                "Thai cuisine is one of the most popular in the world."
            )
        ),
        Country(
            id = "id", name = "Indonesia", flagEmoji = "🇮🇩", continentId = "asia",
            capital = "Jakarta (Nusantara planned)", population = "277 million",
            area = "1.90 million km²", language = "Indonesian",
            currency = "Indonesian Rupiah (IDR)",
            landmarks = listOf("Borobudur Temple", "Bali beaches", "Komodo Island", "Mount Bromo"),
            neighbors = listOf("Malaysia", "Papua New Guinea", "Timor-Leste"),
            climate = "Tropical, hot and humid year-round",
            facts = listOf(
                "Indonesia is the world's largest archipelago with 17,000+ islands.",
                "It is home to Komodo dragons.",
                "It has more volcanoes than any other country."
            )
        ),
        Country(
            id = "sa", name = "Saudi Arabia", flagEmoji = "🇸🇦", continentId = "asia",
            capital = "Riyadh", population = "36 million",
            area = "2.15 million km²", language = "Arabic",
            currency = "Saudi Riyal (SAR)",
            landmarks = listOf("Masjid al-Haram (Mecca)", "Al-Masjid an-Nabawi", "Diriyah", "Edge of the World"),
            neighbors = listOf("Jordan", "Iraq", "Kuwait", "Qatar", "UAE", "Oman", "Yemen"),
            climate = "Hot desert",
            facts = listOf(
                "Saudi Arabia holds about 17% of the world's proven oil reserves.",
                "Mecca and Medina are the holiest cities in Islam.",
                "The Empty Quarter is the largest sand desert in the world."
            )
        ),
        Country(
            id = "vn", name = "Vietnam", flagEmoji = "🇻🇳", continentId = "asia",
            capital = "Hanoi", population = "99 million",
            area = "331,212 km²", language = "Vietnamese",
            currency = "Vietnamese Dong (VND)",
            landmarks = listOf("Ha Long Bay", "Hoi An Ancient Town", "Phong Nha Caves", "Hue Imperial City"),
            neighbors = listOf("China", "Laos", "Cambodia"),
            climate = "Tropical in the south, monsoonal in the north",
            facts = listOf(
                "Vietnam is the world's largest exporter of cashew nuts and black pepper.",
                "Ha Long Bay is a UNESCO World Heritage Site.",
                "Pho is the national dish."
            )
        ),
        Country(
            id = "my", name = "Malaysia", flagEmoji = "🇲🇾", continentId = "asia",
            capital = "Kuala Lumpur", population = "33 million",
            area = "330,803 km²", language = "Malay",
            currency = "Malaysian Ringgit (MYR)",
            landmarks = listOf("Petronas Towers", "Batu Caves", "Langkawi", "Mount Kinabalu"),
            neighbors = listOf("Thailand", "Indonesia", "Brunei"),
            climate = "Tropical, hot and humid",
            facts = listOf(
                "Malaysia is split between Peninsular Malaysia and Borneo.",
                "The Petronas Towers were the tallest buildings in the world until 2004.",
                "It is one of the world's most biodiverse countries."
            )
        ),
        Country(
            id = "sg", name = "Singapore", flagEmoji = "🇸🇬", continentId = "asia",
            capital = "Singapore", population = "5.9 million",
            area = "728 km²", language = "English, Malay, Mandarin, Tamil",
            currency = "Singapore Dollar (SGD)",
            landmarks = listOf("Marina Bay Sands", "Gardens by the Bay", "Sentosa Island", "Merlion Park"),
            neighbors = listOf("Malaysia (by bridge)", "Indonesia (by strait)"),
            climate = "Tropical rainforest",
            facts = listOf(
                "Singapore is both a city and a country.",
                "It is one of the cleanest and safest cities in the world.",
                "It has four official languages."
            )
        )
    )

    private val oceania = listOf(
        Country(
            id = "au", name = "Australia", flagEmoji = "🇦🇺", continentId = "oceania",
            capital = "Canberra", population = "26 million",
            area = "7.69 million km²", language = "English",
            currency = "Australian Dollar (AUD)",
            landmarks = listOf("Sydney Opera House", "Uluru", "Great Barrier Reef", "Great Ocean Road"),
            neighbors = listOf("None (island continent)"),
            climate = "Arid inland, tropical in the north, temperate in the south",
            facts = listOf(
                "Australia is both a country and a continent.",
                "It is home to unique animals like kangaroos and koalas.",
                "The Great Barrier Reef is the largest coral reef system on Earth."
            )
        ),
        Country(
            id = "nz", name = "New Zealand", flagEmoji = "🇳🇿", continentId = "oceania",
            capital = "Wellington", population = "5.2 million",
            area = "268,021 km²", language = "English, Māori",
            currency = "New Zealand Dollar (NZD)",
            landmarks = listOf("Milford Sound", "Hobbiton", "Tongariro National Park", "Bay of Islands"),
            neighbors = listOf("None (island nation)"),
            climate = "Temperate maritime",
            facts = listOf(
                "New Zealand consists of two main islands and many smaller ones.",
                "It was the first country to grant women the right to vote (1893).",
                "The Lord of the Rings films were shot here."
            )
        ),
        Country(
            id = "fj", name = "Fiji", flagEmoji = "🇫🇯", continentId = "oceania",
            capital = "Suva", population = "900,000",
            area = "18,272 km²", language = "English, Fijian, Hindi",
            currency = "Fijian Dollar (FJD)",
            landmarks = listOf("Mamanuca Islands", "Yasawa Islands", "Garden of the Sleeping Giant", "Bouma Falls"),
            neighbors = listOf("None (island nation)"),
            climate = "Tropical maritime",
            facts = listOf(
                "Fiji is made up of over 330 islands.",
                "Rugby is the most popular sport.",
                "Its coral reefs are world-renowned."
            )
        ),
        Country(
            id = "pg", name = "Papua New Guinea", flagEmoji = "🇵🇬", continentId = "oceania",
            capital = "Port Moresby", population = "10 million",
            area = "462,840 km²", language = "English, Tok Pisin, Hiri Motu",
            currency = "Papua New Guinean Kina (PGK)",
            landmarks = listOf("Kokoda Track", "Mount Wilhelm", "Tufi Fjords", "Sepik River"),
            neighbors = listOf("Indonesia"),
            climate = "Tropical rainforest",
            facts = listOf(
                "Papua New Guinea has over 800 languages — the most of any country.",
                "It shares the island of New Guinea with Indonesia.",
                "It has some of the world's most biodiverse rainforests."
            )
        )
    )

    val continents: List<Continent> = listOf(
        Continent(
            id = "north_america",
            name = "North America",
            emoji = "🌎",
            description = "From arctic tundra to tropical shores.",
            countries = northAmerica
        ),
        Continent(
            id = "south_america",
            name = "South America",
            emoji = "🌄",
            description = "Home of the Amazon and the Andes.",
            countries = southAmerica
        ),
        Continent(
            id = "europe",
            name = "Europe",
            emoji = "🏰",
            description = "A continent rich in history and culture.",
            countries = europe
        ),
        Continent(
            id = "africa",
            name = "Africa",
            emoji = "🦁",
            description = "The cradle of humankind and endless savannahs.",
            countries = africa
        ),
        Continent(
            id = "asia",
            name = "Asia",
            emoji = "🏯",
            description = "The largest and most populous continent.",
            countries = asia
        ),
        Continent(
            id = "oceania",
            name = "Australia / Oceania",
            emoji = "🏝️",
            description = "Islands, reefs, and unique wildlife.",
            countries = oceania
        ),
        Continent(
            id = "antarctica",
            name = "Antarctica",
            emoji = "❄️",
            description = "A frozen wilderness without countries.",
            countries = emptyList(),
            isSpecial = true,
            specialInfo = "Antarctica is the southernmost continent on Earth. It has no permanent population and is not divided into countries. " +
                    "Instead, it is governed by the Antarctic Treaty of 1959, which preserves the continent for peaceful scientific research. " +
                    "It is the coldest, driest, and windiest place on Earth, and holds about 70% of the world's fresh water in its ice sheet."
        )
    )

    val allCountries: List<Country> = continents.flatMap { it.countries }

    fun findCountry(id: String): Country? = allCountries.firstOrNull { it.id == id }
    fun findContinent(id: String): Continent? = continents.firstOrNull { it.id == id }
}
