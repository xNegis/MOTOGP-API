
# MotoGP API

I use the API provided by [sportradar](https://developer.sportradar.com/docs/read/racing/MotoGP_v2) and treat his jsons to obtain different interesting information.

## Explanation of the different parametters
First, we can call methods i've done to get competitors results. 
We have to filter them by : 


Parameters | Values samples
------------ | -------------
**Category**| MotoGP, Moto 2 or Moto 3.
**Session** | Practices 1 to 4, Qualifying and Races.
**Racecodes**| codes to obtain a concrete Gran Premio as QAT  for Grand Prix of Qatar, ARG for Gran Premio de la Republica Argentina....
## Taking a glance at main methods
The method **getCompetitorAndItsResultsByCategoryRaceCodeYearAndSession** calls to the API and return a list of competitors. You can iterate over this list to get information about the result of each competitor as **name**, **gender**, **nationality**, or **results** about the race

This code sample, which is at Main.java class, returns the following list containing competitors, and I printed the result position.
```java
List<Competitor> competitors =APIGetters.getCompetitorAndItsResultsByCategoryRaceCodeYearAndSession(2019, RaceCode.QAT, Category.MotoGP, Session.Qualifying);
		
		for(Competitor c:competitors) {
			System.out.println(c.getName()+ " - " + c.getResult().getPosition())
		}
```
**Printed** 

Vinales, Maverick - 1º
Dovizioso, Andrea - 2º
Marquez, Marc - 3º
Miller, Jack - 4º
Quartararo, Fabio - 5º
Crutchlow, Cal - 6º
Petrucci, Danilo - 7º
Morbidelli, Franco - 8º
Nakagami, Takaaki - 9º
Rins, Alex - 10º
Mir, Joan - 11º
Espargaro, Aleix - 12º
Bagnaia, Francesco - 13º
Rossi, Valentino - 14º
Lorenzo, Jorge - 15º
Espargaro, Pol - 16º
Oliveira, Miguel - 17º
Rabat, Esteve - 18º
Iannone, Andrea - 19º
Abraham, Karel - 20º
Zarco, Johann - 21º
Syahrin Abdullah, Hafizh - 22º
Smith, Bradley - 23º

The method **getDetailsOfASeasonGPs** calls to the API and return a list of Venues. You can iterate over this list to get information about the information of each Venue (Gran Premio) as **city**, **country**, **country code**,  **name**, **curves left**, **curves right**, **debut** or even the **lenght** of the circuit

This code sample, which is at Main.java class, returns the following list containing Venues, and I printed the name.

```java
List<Venue> detailedGps = APIGetters.getDetailsOfASeasonGPs(2013, Category.MotoGP);
		
		for(Venue v:detailedGps) {
			System.out.println(v.getName());
		}
```

**Printed**

Losail International Circuit
Circuit of The Americas
Circuit de Jerez
Le Mans Bugatti Circuit
Autodromo Internazionale del Mugello
Circuit de Catalunya
TT Circuit Assen
Sachsenring
Mazda Raceway Laguna Seca
Automotodrom Brno
Silverstone Circuit
Misano World Circuit
Motorland Aragon
Sepang International Circuit
Phillip Island Circuit
Twin Ring Motegi
Circuit de la Comunitat Valenciana Ricardo Tormo

This two methods are depending of more methods that you can found and read inside this proyect. If you are not interested at what these two methods returns, you can use more methods that are coded inside for your own benefit, you only have to take a glance at them.

Anyways, if you dont understand what am I doing inside here you can contact me via gmail (xnegis@gmail.com) or take a glance about the official [documentation](https://developer.sportradar.com/files/Sportradar_MotoGP_v2_Statistics_Feeds.pdf) 
## Exceptions that could be thrown
Different exceptions could be thrown and here you got them all explained

Exception | Caused by
------------ | -------------
**emptyResponseException**| It is caused when the API returns an empty json. It returns it for various reasons as for example a bad request.
**raceCodeUnabaliableException** | It is caused when introducing a race code that is not avaliable for that year. For example if you request QAT for year 2020, it may be possible that in 2020 no races were been ran in Qatar ,and so, you get this exception.
**sessionNotFoundException**| It is caused when the session that have been introduced as parametter has not been found mixed with the other parameters. Similar to race code unabaliable but for instance, you are requesting Qualifying to race code Qatar and there is not anything API can return.
**yearNotValidException**| It is caused when you introduce an invalid. It only admits years between **2012** and **actual** year
**403 error**| This error is not controlled by the application, but it will appear in the case that you overpass the limited querys per second or by the expiration of your api key.


## Notes
You will see throughtout all the clases the following instance :
`TimeUnit.SECONDS.sleep(1)`
This is simply there to not overpass the limit of querys per second. If your key is a trial, it will have this restrinction.

You can put your Api key at the **APIGetters.java** class.
