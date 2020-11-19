# mastery-3-2 - Mastery Module 3.2.

On this 6th mastery module, we will explore Java with a taste of the sea and where I proudly grew up.
We are going to explore all 4 corners of the amazing city of Olhão, its festivals and its sea life.
All the while studying for Java 11.

## Preparation

If you are on a Unix based system or if you are running any sort of BSD, MAC-OS, then you are fine using filr [prepare.sh](./prepare.sh).
If you are using windows, then this will maybe work. I seldom use windows and not always I can test my work there.
The point is that you need to have a `/tmp` folder at this point.

```bash
./prepare.sh
```

## Exercise

1. Serialization and polymorphism
2. Multi-dimensional arrays and ways to create them
3. Sorting Immutable `List`'s
4. Static method inheritance and overriding
5. `final` in `try` with resources
6. `Deque` and `offerLast`, and other methods.
7. Base modules and the rest -> [mastery-3-2-modularity](../mastery-3-2-modularity/Readme.md)
8. A case for `final` `var` in a `for` loop
9. `RandomAccessFile` and `writeUTF`
10. local `DateFormat` and `Locale`
11. Package protected constructors (two classes of different packages)
12. `ExceptionInInitializerError`
13. `thenComparing`
14. `Consumer` in `for` loops
15. `sorted`, `Comparable` and `ClassCastException`
16. Serializing arrays and Lists
17. `noneMatch` vs `anyMatch`
18. `StringBuilder` and `setLength`
19. `Supplier` and `get`
20. `Files.copy` and symbolic links

## Output

```text
================== Master Module mastery-3-2 ==================
--- 1. Serialization and polymorphism
============
Case: We are taking info from the "Mercado de Olhão"
When try to get the information from the registration website,
we cannot find the most common material!
Let's see how we register and then get the data.
Construction constructor has been called! Market{marketId=null}Building{height=0.0, dimX=0.0, dimY=0.0}Construction{mainMaterial='bricks'}
Building constructor has been called! Market{marketId=null}Building{height=5.0, dimX=26.0, dimY=11.5}Construction{mainMaterial='bricks'}
Market constructor has been called! Market{marketId=94e7726d-2e19-4332-a374-0e4a3fe68bf8}Building{height=5.0, dimX=26.0, dimY=11.5}Construction{mainMa
terial='bricks'}
We register our data in Market{marketId=94e7726d-2e19-4332-a374-0e4a3fe68bf8}Building{height=5.0, dimX=26.0, dimY=11.5}Construction{mainMaterial='bric
ks'}
We register our data in Market{marketId=94e7726d-2e19-4332-a374-0e4a3fe68bf8}Building{height=5.0, dimX=26.0, dimY=11.5}Construction{mainMaterial='bric
ks'}
We register our data in Market{marketId=94e7726d-2e19-4332-a374-0e4a3fe68bf8}Building{height=5.0, dimX=26.0, dimY=11.5}Construction{mainMaterial='bric
ks'}
Sending data to file system...
Data Sent!
Retrieving data from file system...
Construction (no-args) constructor has been called! Market{marketId=null}Building{height=0.0, dimX=0.0, dimY=0.0}Construction{mainMaterial='null'}
We read our data back from the file system and it is Market{marketId=94e7726d-2e19-4332-a374-0e4a3fe68bf8}Building{height=5.0, dimX=26.0, dimY=11.5}Co
nstruction{mainMaterial='null'}
The takeout here, is that the non-serializable class, does not participate in the serializing process.
Although its constructor is called, no instance members are set.
The compiler needs the empty constructors only to know that the runtime can build these instances without parameters.
The constructors themselves are not called in the serializable instances.
--- 2. Multi-dimensional arrays and ways to create them
============
Case: We are staying at a 5 star hotel in Olhão
The hotel serves us a 2X2 portion of cooked oysters plate.
It also serves 2X2 worldwide known raw oyster plate.
The mussels come fresh uit the fisher's net.
We are buying them as they come along.
Good for us, good for the fisher's and good for the economy.
In how many ways can we serve these plates?
var cookedOysters1 = new String[][]{{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}}; -> [[CookedOyster,CookedOyster],[CookedOyster
,CookedOyster]]
final String[][] cookedOysters2 = {{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}}; -> [[CookedOyster,CookedOyster],[CookedOyster,
CookedOyster]]
final String[][] cookedOysters3 = new String[2][2]; -> [[CookedOyster,CookedOyster],[CookedOyster,CookedOyster]]
final String[] cookedOysters4 [] = {{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}};
final String cookedOysters5 [][] = {{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}};
final String [][] rawOysters = new String[2][2];
final String [] mussels [] = new String[2][];
Big takeouts here for something seemingly simple:
1. All arrays must have at least one dimension
2. The first dimension MUST have a defined size upon initialization
3. var needs to know its type. Therefore an array declared with var can only be created with new
4. Different positions of a multidimensional array may have different array sizes in sub-dimensions
6. The rectangular brackets my follow a C++ or a Java notation. In other workds, brackets can be declared just before or just after the variable name 
with no particular restrictions on how many in the left or the right side
--- 3. Sorting Immutable `List`'s
============
Case: We finally got the listings of the "Festival do Marisco 2019"
We want to keep these listings safe, will anyone be able to change them?
We are attempting to change a well established list.
allArtists.sort(Artist::compare); -> This list is marked as immutable. We get this error: java.lang.UnsupportedOperationException
	java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:71)
	java.base/java.util.ImmutableCollections$AbstractImmutableList.sort(ImmutableCollections.java:110)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise3(Mastery3dot2Runner.java:560)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:61)
Making a copy of immutable also doesn't work
List.copyOf(allArtists).sort(Artist::compare); -> This list is marked as immutable. We get this error: java.lang.UnsupportedOperationException
	java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:71)
	java.base/java.util.ImmutableCollections$AbstractImmutableList.sort(ImmutableCollections.java:110)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise3(Mastery3dot2Runner.java:566)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:61)
new ArrayList<>(allArtists).sort(Artist::compare); -> This is probably the only way to get a changed list and make modifications on it.
We just create a new ArrayList from the immutable list in order to get a mutable list.
Immutability principles are very common and traverse the whole JDK.
When working with collections it is important to understand when to we get immutables and when do we get mutables
--- 4. Static method inheritance and overriding
============
Case: We have a stroll around the market and finally we come across some displays
There we can see how Space's are built across the city.
Construction constructor has been called! Construction{mainMaterial='Cement'}
Construction constructor has been called! Building{height=0.0, dimX=0.0, dimY=0.0}Construction{mainMaterial='bricks'}
Building constructor has been called! Building{height=5.0, dimX=26.0, dimY=11.5}Construction{mainMaterial='bricks'}
Construction constructor has been called! Market{marketId=null}Building{height=0.0, dimX=0.0, dimY=0.0}Construction{mainMaterial='bricks'}
Building constructor has been called! Market{marketId=null}Building{height=5.0, dimX=26.0, dimY=11.5}Construction{mainMaterial='bricks'}
Market constructor has been called! Market{marketId=384fb5f7-6fb9-4067-94ec-0cef56fb1a68}Building{height=5.0, dimX=26.0, dimY=11.5}Construction{mainMa
terial='bricks'}
A Construction has mainMaterial
A Building has a height, dimX and  dimY
A Market has a UUID
mainMaterial='Cement
height=5.0, dimX=26.0, dimY=11.5
marketId=384fb5f7-6fb9-4067-94ec-0cef56fb1a68
A Construction has mainMaterial
A Construction has mainMaterial
A Construction has mainMaterial
Important takes from this exercise:
1. static methods are not really overriden. They are however shadowed by another
2. by upcasting, we can call other static  methods
3. Instance methods can be overriden
4. Upcasting will only call the resulting instance method
--- 5. `final` in `try` with resources
============
Case: We wanted to cook codfish (Bacalhau).
But we made a mistake when creating the input stream!
I think we can't change this, but let's see what happens!
from: https://lifestyle.sapo.pt/sabores/receitas/castanhas-assadas-no-forno
Pré-aqueça o forno a 200 ºC.
Entretanto, lave as castanhas, seque-as e aplique-lhes um golpe de faca na horizontal, evitando cortá-las ao meio (depois do entalhe, pode demolhar as
 castanhas em água fria por dez minutos).
Cubra um tabuleiro que possa ir ao forno com sal grosso.
Espalhe as castanhas sobre o sal, evitando sobrepô-las.
Polvilhe as castanhas com sal grosso e leve o tabuleiro ao forno (nesta fase também pode acrescentar os pezinhos de alecrim ou erva-doce, se for a gos
to).
Dependendo do tamanho das castanhas, vão assar no forno entre 35 a 45 minutos.
Deixe tostar a gosto e sirva ainda quentinhas.
A try clause always creates implicitly final variables
--- 6. `Deque` and `offerLast`, and other methods.
============
Case: There is a list of clients waiting and the fish seller is registering everything
As we ask for the fish request, it goes to a Deque in order to be processed
What can happen?
Note that capacity limit does not show in ArrayDeque, because ArrayDeque grow automatically -> java.lang.IllegalStateException
	Deque full
	java.base/java.util.concurrent.LinkedBlockingDeque.addLast(LinkedBlockingDeque.java:326)
	java.base/java.util.concurrent.LinkedBlockingDeque.add(LinkedBlockingDeque.java:624)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise6(Mastery3dot2Runner.java:486)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:64)
This Deque has now reached its limit of 5 elemenst
With offer, it's essentially giving an offer to the Deque. false
With offerFirst, It's the same. false
false
With offerLast, It's also the same. false
[500gg Sardines, 1Kg Codfish, 800g Swordfish, 2Kg Octopus, 10Kg Clams]
Deque is a collection
It's a circular collection and there are lots of implementations.
ArrayDeque -> Not Thread-Safe and automatically expands
LinkedBlockingDeque -> Thread-Safe and fixed capacity
Only on fixed capacity Deque's can we explore the full capacity of offer functions
--- 7. Base modules and the rest
============
Expected output:
Cataplana dish is being served...
cataplana.jar -> java.base
   org.jesperancinha.console.consolerizer             -> java.io                                            java.base
   org.jesperancinha.console.consolerizer             -> java.lang                                          java.base
   org.jesperancinha.console.consolerizer             -> java.lang.invoke                                   java.base
   org.jesperancinha.console.consolerizer             -> java.util                                          java.base
   org.jesperancinha.console.consolerizer             -> java.util.function                                 java.base
   org.jesperancinha.console.consolerizer             -> java.util.stream                                   java.base
   org.jesperancinha.ocp11.mastery3dot2               -> java.lang                                          java.base
   org.jesperancinha.ocp11.mastery3dot2               -> org.jesperancinha.console.consolerizer             cataplana.jar
Please check module mastery-3-2-modularity for more info...
--- 8. A case for `final` `var` in a `for` loop
============
Case: Let's get some veggies.
We'll go to the supermarket and get some final vegetables.
We'll do this according to our shopping list.
Tomatoes
Potatoes
Kale
Lettuse
1Kg Kidney Beans
Tomatoes with fungus
Potatoes with fungus
Kale with fungus
Lettuse with fungus
1Kg Kidney Beans with fungus
We can use the word final in combination with var to mark it effectively final
Vars are effectively final until they suffer some change.
A final before, makes that change impossible.
final, as a parameter, will not work becaue var isn't supposed to be used as a parameter type
Simple reason that we must remember. var needs to know its types. As a parameter, there is no way it can know that.
--- 9. `RandomAccessFile` and `writeUTF`
============
Case: We want to cook "Bacalhau à Brás"
We went to the market and bought some pieces of raw, dried and salted cod fish
The rest of the ingredients are at home
We get home and read our recipe again:
from: https://salinto.nl/blog/bacalhau-a-bras-recept/
De avond van te voren leg je 250 gram gedroogde kabeljauw in een bak met melk of water. De volgende dag ververs je het water of de melk nog een keer o
f 3. Goed laten uitlekken voordat je deze waanzinnig lekkere maaltijd gaat bereiden.
De avond van te voren leg je 250 gram gedroogde kabeljauw in een bak met melk of water. De volgende dag ververs je het water of de melk nog een keer o
f 3. Goed laten uitlekken voordat je deze waanzinnig lekkere maaltijd gaat bereiden.
I'm corrupting the recipe
eine stukjes evenals 5 teentjes knoflook. Dit mogen er ook 4 zijn, maar niet minder
Je snijdt eveneens 500 gram aardappelen in flinterdunne stukjes/patatjes.
De knoflook en de uien fruit je tot ze goudgeel zijn, vervolgens voeg je de kabeljauw toe.
Bak de patatjes tot ze nog net niet helemaal bruin/gaar zijn.
Voeg de patatjes aan de kabeljauw toe en voeg 2 of 3 eieren toe. Roer het geheel goed door totdat de eiren een beetje gaan stollen.
Voeg 3/4 Peterselie en alle koriander toe en roer het door elkaar heen.
Vul een ovenschaal met de Bacalhau à Brás en plaats deze nog 10 minuten in een hetelucht oven op 175 graden, anders op 220 graden.
Je haalt de schaal uit de oven en je garneert de ovenschaal met het restant peterselie en de olijven.
Wait! I forgot something!
De avond van te voren leg je 250 gram gedroogde kabeljauw in een bak met melk of water. De volgende dag ververs je het water of de melk nog een keer o
f 3. Goed laten uitlekken voordat je deze waanzinnig lekkere maaltijd gaat bereiden.
I'm corrupting the recipe
eine stukjes evenals 5 teentjes knoflook. Dit mogen er ook 4 zijn, maar niet minder
Je snijdt eveneens 500 gram aardappelen in flinterdunne stukjes/patatjes.
De knoflook en de uien fruit je tot ze goudgeel zijn, vervolgens voeg je de kabeljauw toe.
Bak de patatjes tot ze nog net niet helemaal bruin/gaar zijn.
Voeg de patatjes aan de kabeljauw toe en voeg 2 of 3 eieren toe. Roer het geheel goed door totdat de eiren een beetje gaan stollen.
Voeg 3/4 Peterselie en alle koriander toe en roer het door elkaar heen.
Vul een ovenschaal met de Bacalhau à Brás en plaats deze nog 10 minuten in een hetelucht oven op 175 graden, anders op 220 graden.
Je haalt de schaal uit de oven en je garneert de ovenschaal met het restant peterselie en de olijven.
RandomAccessFile uses different interfaces than FileInputStream.
But they are all Closeable.
In RandomAccessFile a pointer is used that can be saved to go back and forth in the same file.
--- 10. local `DateFormat` and `Locale`
============
Case: What is the day of the City of Olhão and on which year did it occur?
16 Jun 1808, 00:00:00
pt
The point here is that Locale and DateFormat are independent.
They can, however be bound together:
DateFormat.getDateTimeInstance(i,0, locale) -> quinta-feira, 16 de junho de 1808 00:00:00 CET
DateFormat.getDateTimeInstance(i,1, locale) -> 16 de junho de 1808 00:00:00 CET
DateFormat.getDateTimeInstance(i,2, locale) -> 16 de jun de 1808 00:00:00 CET
DateFormat.getDateTimeInstance(i,3, locale) -> 16/06/1808 00:00:00 CET
DateFormat.getDateTimeInstance(0,0, locale) -> quinta-feira, 16 de junho de 1808 00:00:00 Horário Padrão da Europa Central
DateFormat.getDateTimeInstance(0,1, locale) -> quinta-feira, 16 de junho de 1808 00:00:00 CET
DateFormat.getDateTimeInstance(0,2, locale) -> quinta-feira, 16 de junho de 1808 00:00:00
DateFormat.getDateTimeInstance(0,3, locale) -> quinta-feira, 16 de junho de 1808 00:00
We can change to different pre-defined styles
````

```text
--- 11. Package protected constructors
============
Case: We are ordering a coffee in Olhão.
In good portuguese tradition we ask for a short coffee by calling it one "garoto".
If we want our coffee to be served in a tall glass cup with lots of milk on it, we call it one "galão'".
In our case we will try to order one "Galão" that is also a "Garoto".
Can we do it?
Garoto is served!
For a starters we can create one Garoto{definition='https://pt.wikipedia.org/wiki/Garoto_(caf%C3%A9)
Garoto é uma bebida à base de café, muito comum em cafeterias portuguesas. Trata-se de uma combinação de uma dose de café forte com uma pequena quanti
dade de leite. Deve ser servido quente em uma xícara de café.[1]'}
Galão is served!
We can also create one create one Galao{definition='https://pt.wikipedia.org/wiki/Gal%C3%A3o_(caf%C3%A9)
Galão é uma bebida quente de Portugal feita de café expresso e espuma de leite. Ao todo semelhante à meia de leite, vem num copo alto com cerca de 1/4
 do café, 3/4 espuma de leite, ao contrário do Garoto (café), mais pequeno, que é servido em uma demitasse / espresso pequena xícara de porcelana. Qua
ndo a proporção é de 1:1 é chamada de "meia de leite" (metade do leite) e vem numa chávena grande. Pode ser considerado como uma cortado (café), mas c
om uma quantidade muito maior de leite, as proporções são mais perto de um café com leite.[1]'}
The point here is that if classes have package protected constructors, and belong to different packages, they can never be sub-classes of eacht other
This makes this:
        var garoto =new Garoto();
and this:
        var galao = new Galao();
an unaccomplishable possibility.
--- 12. `ExceptionInInitializerError`
============
Lingueirão comes out to clean up his house! 🪒
Note we can't catch the Linguerão due to an Error coming from a static initialization -> java.lang.ExceptionInInitializerError
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise12(Mastery3dot2Runner.java:334)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:70)
java.lang.RuntimeException
	Oh no! A bird just caught him! We won't fish this one! 🦅
	org.jesperancinha.ocp11.mastery3dot2.marisco.Lingueirao.<clinit>(Lingueirao.java:10)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise12(Mastery3dot2Runner.java:334)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:70)
Notice that there is no class definition found. This makes sense. We actually have no class since initializing  has failed! -> java.lang.NoClassDefFou
ndError
	Could not initialize class org.jesperancinha.ocp11.mastery3dot2.marisco.Lingueirao
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise12(Mastery3dot2Runner.java:339)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:70)
Essentially Lingueirão has gone into the oblivion because of the bird. 🦅
What about this Caranguejo? 🦀
Caranguejo strolls around on the beach! 🦀
In this case, an exception is thrown during an instance initialization. The Exception is thrown as is -> java.lang.RuntimeException
	Oh no! It ran away  in panic!! 💨
	org.jesperancinha.ocp11.mastery3dot2.marisco.Caranguejo.<init>(Caranguejo.java:9)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise12(Mastery3dot2Runner.java:346)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:70)
Trying to catch Caranguejo 🕸
Caranguejo strolls around on the beach! 🦀
The same when calling the fishing factory method -> java.lang.RuntimeException
	Oh no! It ran away  in panic!! 💨
	org.jesperancinha.ocp11.mastery3dot2.marisco.Caranguejo.<init>(Caranguejo.java:9)
	org.jesperancinha.ocp11.mastery3dot2.marisco.Caranguejo.fishCaranguejo(Caranguejo.java:15)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise12(Mastery3dot2Runner.java:351)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:70)
Take-aways:
1. Static initialization can fail, but don't stop a program from running.
2. SI fail results in and initialization failure.
3. SI failure results in the absence of a class definition.
4. Instance initialization failure does not present any unusual behaviour.
5. We can try/catch any throwable that compatible with the originating throwable.
--- 13. `thenComparing`
============
Case: We receive a whole lot of fish by DocaPesca
We have to tag all of them, sort them by size and then sort them by species.
This is the ideal case to use the `thenCompare` method.
These are all our catches: [Peixe{commonName='Carapau', size=21.0, uuid=d1e5e854-aee5-439c-84d6-35779b1d6259, crateSize=null}, Peixe{commonName='Atúm'
, size=17.0, uuid=030e7704-e4f1-4984-96bd-fdee67965cc5, crateSize=null}, Peixe{commonName='Dourada', size=13.0, uuid=fd895514-86ff-4f3d-88be-4d9bf86e3
982, crateSize=null}, Peixe{commonName='Xarroco', size=23.0, uuid=12e6490e-0d1f-4b0c-9de0-bcfd54e0fd2c, crateSize=null}, Peixe{commonName='Atúm', size
=5.0, uuid=7abb69b1-8df1-4841-888b-674234edbfd6, crateSize=null}, Peixe{commonName='Peixe Espada', size=4.0, uuid=e3977b32-a776-45f5-8310-0e2f764c622d
, crateSize=null}, Peixe{commonName='Peixe Espada', size=13.0, uuid=74b00be4-1ea1-478c-bd8c-ab949ff24513, crateSize=null}, Peixe{commonName='Sardinha'
, size=17.0, uuid=9ad6462c-b778-4226-97e7-0b633abe168e, crateSize=null}, Peixe{commonName='Peixe Raia', size=14.0, uuid=76f44ee2-f018-45ba-a611-2d683a
dfe974, crateSize=null}, Peixe{commonName='Robalo', size=26.0, uuid=9dabb26c-aa06-49b9-a465-d0ee88292578, crateSize=null}]
Let's organize them!
This is our organized catch -> [Peixe{commonName='Atúm', size=5.0, uuid=7abb69b1-8df1-4841-888b-674234edbfd6, crateSize=null}, Peixe{commonName='Atúm'
, size=17.0, uuid=030e7704-e4f1-4984-96bd-fdee67965cc5, crateSize=null}, Peixe{commonName='Carapau', size=21.0, uuid=d1e5e854-aee5-439c-84d6-35779b1d6
259, crateSize=null}, Peixe{commonName='Dourada', size=13.0, uuid=fd895514-86ff-4f3d-88be-4d9bf86e3982, crateSize=null}, Peixe{commonName='Peixe Espad
a', size=4.0, uuid=e3977b32-a776-45f5-8310-0e2f764c622d, crateSize=null}, Peixe{commonName='Peixe Espada', size=13.0, uuid=74b00be4-1ea1-478c-bd8c-ab9
49ff24513, crateSize=null}, Peixe{commonName='Peixe Raia', size=14.0, uuid=76f44ee2-f018-45ba-a611-2d683adfe974, crateSize=null}, Peixe{commonName='Ro
balo', size=26.0, uuid=9dabb26c-aa06-49b9-a465-d0ee88292578, crateSize=null}, Peixe{commonName='Sardinha', size=17.0, uuid=9ad6462c-b778-4226-97e7-0b6
33abe168e, crateSize=null}, Peixe{commonName='Xarroco', size=23.0, uuid=12e6490e-0d1f-4b0c-9de0-bcfd54e0fd2c, crateSize=null}]
Finally we can put our fishes in the matching boxes in a mutch faster way!.
[Peixe{commonName='Atúm', size=5.0, uuid=7abb69b1-8df1-4841-888b-674234edbfd6, crateSize=TYPE1}, Peixe{commonName='Atúm', size=17.0, uuid=030e7704-e4f
1-4984-96bd-fdee67965cc5, crateSize=TYPE2}, Peixe{commonName='Carapau', size=21.0, uuid=d1e5e854-aee5-439c-84d6-35779b1d6259, crateSize=TYPE3}, Peixe{
commonName='Dourada', size=13.0, uuid=fd895514-86ff-4f3d-88be-4d9bf86e3982, crateSize=TYPE2}, Peixe{commonName='Peixe Espada', size=4.0, uuid=e3977b32
-a776-45f5-8310-0e2f764c622d, crateSize=TYPE1}, Peixe{commonName='Peixe Espada', size=13.0, uuid=74b00be4-1ea1-478c-bd8c-ab949ff24513, crateSize=TYPE2
}, Peixe{commonName='Peixe Raia', size=14.0, uuid=76f44ee2-f018-45ba-a611-2d683adfe974, crateSize=TYPE2}, Peixe{commonName='Robalo', size=26.0, uuid=9
dabb26c-aa06-49b9-a465-d0ee88292578, crateSize=TYPE3}, Peixe{commonName='Sardinha', size=17.0, uuid=9ad6462c-b778-4226-97e7-0b633abe168e, crateSize=TY
PE2}, Peixe{commonName='Xarroco', size=23.0, uuid=12e6490e-0d1f-4b0c-9de0-bcfd54e0fd2c, crateSize=TYPE3}]
Take-aways
1. thenCompare works cumulatively
2. thenCompare sections each comparison in separate groups
--- 14. `Consumer` in `for` loops
============
Case: A bunch of cats is eating left over fish from the fishermen
Cat eats Peixe{commonName='Xaputa', size=16.0, uuid=d5f37553-8eb3-4483-84e7-60add5d140c4, crateSize=null}
Cat eats Peixe{commonName='Peixe Raia', size=25.0, uuid=4cf021fa-4feb-40fe-8f47-26da9e45e31c, crateSize=null}
Cat eats Peixe{commonName='Carapau', size=21.0, uuid=ad66bc30-6d45-4058-935a-d709ac048be3, crateSize=null}
Cat eats Peixe{commonName='Bacalhau', size=10.0, uuid=ada6213d-8eb6-4173-85a6-748b1c3975bb, crateSize=null}
Cat eats Peixe{commonName='Peixe Espada', size=0.0, uuid=a0b2855c-a150-4a25-b52c-6d5cafbfba45, crateSize=null}
Var Cat eats Peixe{commonName='Xaputa', size=16.0, uuid=d5f37553-8eb3-4483-84e7-60add5d140c4, crateSize=null}
Var Cat eats Peixe{commonName='Peixe Raia', size=25.0, uuid=4cf021fa-4feb-40fe-8f47-26da9e45e31c, crateSize=null}
Var Cat eats Peixe{commonName='Carapau', size=21.0, uuid=ad66bc30-6d45-4058-935a-d709ac048be3, crateSize=null}
Var Cat eats Peixe{commonName='Bacalhau', size=10.0, uuid=ada6213d-8eb6-4173-85a6-748b1c3975bb, crateSize=null}
Var Cat eats Peixe{commonName='Peixe Espada', size=0.0, uuid=a0b2855c-a150-4a25-b52c-6d5cafbfba45, crateSize=null}
Take-aways
1. For loops use consumers
2. Consumer receive parameters and consume them. No value is returned
3. var declared consumers need to specify type (of course)
4. traditionally declared consumers can use diamond notation and lambdas
--- 15. `sorted`, `Comparable` and `ClassCastException`
============
Case: During the sorting of the fish bait, one fisher dropped some real fishes
Now we are going to organize this. Will this work?
First we organize the current baits
We get -> [Isca{commonName='Atúm', size=29.0, uuid=5bb44208-744a-4170-bb9f-b731c0a4fa3e, crateSize=null}, Isca{commonName='Bezugo', size=18.0, uuid=bd
73722b-b94b-482f-83a6-0552ff35798d, crateSize=null}, Isca{commonName='Bezugo', size=20.0, uuid=985bb53a-0490-4126-ab75-22262e339f91, crateSize=null}, 
Isca{commonName='Peixe Espada', size=5.0, uuid=8b61564f-d0aa-49fd-b9c6-d0a3b3689829, crateSize=null}, Isca{commonName='Sardinha', size=28.0, uuid=c625
330b-7dda-4044-8045-ff0644fc9acf, crateSize=null}] 
As we expected, we cannot run a default comparator if it is not defined in the objects of a list
The fisher has to wash all of their baits -> java.lang.ClassCastException
	class org.jesperancinha.ocp11.mastery3dot2.pesca.Peixe cannot be cast to class java.lang.Comparable (org.jesperancinha.ocp11.mastery3dot2.pesca.Peixe
 is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
	java.base/java.util.Comparators$NaturalOrderComparator.compare(Comparators.java:47)
	java.base/java.util.TimSort.countRunAndMakeAscending(TimSort.java:360)
	java.base/java.util.TimSort.sort(TimSort.java:220)
	java.base/java.util.Arrays.sort(Arrays.java:1515)
	java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:353)
	java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
	java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
	java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.exercise15(Mastery3dot2Runner.java:244)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:73)
Take-aways
1. We can provide a comparator to the sorted intermediate operation of sorted
2. Alternatively we can use Comparable in the type definition itself
3. All objects need to be Comparable, if we want sorted without parameters to work
4. During a sorted operation, without parameters, there will be a ClassClassException thrown, if at least one element is not Comparable
```


```text
--- 16. Serializing arrays and Lists
============
Case: Sometimes we register a fish catch in a List.
Other times we register this info in an array
Do we know how serialize this data so that the fisher knows how too find the records of their catch?
The fisher catches Pesca{peixes=[Peixe{commonName='Atúm', size=4.0, uuid=68d54004-8430-48e9-80f0-20e8bc910c39, crateSize=null}, Peixe{commonName='Roba
lo', size=23.0, uuid=b0036baa-9705-484d-8a71-0058589da2d7, crateSize=null}], peixeArray=[Peixe{commonName='Atúm', size=4.0, uuid=68d54004-8430-48e9-80
f0-20e8bc910c39, crateSize=null}, Peixe{commonName='Robalo', size=23.0, uuid=b0036baa-9705-484d-8a71-0058589da2d7, crateSize=null}], peixesHidden=[Isc
a{commonName='Sardinha', size=45.0, uuid=421c6f3f-5fa9-4038-979c-f3aa452c5517, crateSize=null}], peixeArrayHidden=[Isca{commonName='Sardinha', size=45
.0, uuid=342d29c9-0c7d-4c16-bb39-1257b185c9dc, crateSize=null}]}
We got the data! And the fisher catched Pesca{peixes=[Peixe{commonName='Atúm', size=4.0, uuid=68d54004-8430-48e9-80f0-20e8bc910c39, crateSize=null}, P
eixe{commonName='Robalo', size=23.0, uuid=b0036baa-9705-484d-8a71-0058589da2d7, crateSize=null}], peixeArray=[Peixe{commonName='Atúm', size=4.0, uuid=
68d54004-8430-48e9-80f0-20e8bc910c39, crateSize=null}, Peixe{commonName='Robalo', size=23.0, uuid=b0036baa-9705-484d-8a71-0058589da2d7, crateSize=null
}], peixesHidden=null, peixeArrayHidden=null}
Take-aways
1. We don't need a serialVersionUID. It can work without it
2. However not strictly necessary, a serialVersionUID identifies the version of the object
3. All serialized objects need to be serializable
4. This also includes all elements of the array or of a list
5. The `transient` keyword makes sure that elements aren't going to be serializable.
6. This would happen for non serializable members with no transient -> java.io.NotSerializableException
	org.jesperancinha.ocp11.mastery3dot2.pesca.Isca
	java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1185)
	java.base/java.io.ObjectOutputStream.writeArray(ObjectOutputStream.java:1379)
	java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1175)
	java.base/java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java:1553)
	java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1510)
	java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
	org.jesperancinha.ocp11.mastery3dot2.Mastery3dot2Runner.main(Mastery3dot2Runner.java:82).
```

## References

-   [Bird watching in Ria Formosa - Quinta de Marim - Olhão](http://birdwatching.spea.pt/en/where-to-watch/ria-formosa/)
-   [DocaPesca - Olhão](http://www.docapesca.pt/pt/rede-lotas-e-postos-vendagem/item/olhao.html)
-   [Caranguejo - Wikipedia - PT](https://pt.wikipedia.org/wiki/Caranguejo)
-   [Razor Clam](https://en.wikipedia.org/wiki/Razor_clam)
-   [Solen marginatus](https://pt.wikipedia.org/wiki/Solen_marginatus)
-   [Lingueirão à bulhão pato](https://pt.petitchef.com/receitas/entrada/lingueirao-a-bulhao-pato-fid-1547851)
-   [Split a string to equal length substrings in Java](https://www.techiedelight.com/split-string-to-equal-length-substrings-java/)
-   [Garoto (café)](https://pt.wikipedia.org/wiki/Garoto_(caf%C3%A9))
-   [Galão (café)](https://pt.wikipedia.org/wiki/Gal%C3%A3o_(caf%C3%A9))
-   [Koffiecultuur in Portugal](https://zininportugal.com/2015/05/17/koffie-wordt-het-een-bica-meia-de-leite-direita-americano-abatanado-galao-of-garoto/)
-   [Olhão](https://pt.wikipedia.org/wiki/Olh%C3%A3o)
-   [BACALHAU À BRÁS RECEPT](https://salinto.nl/blog/bacalhau-a-bras-recept/)
-   [Saudades de Portugal - Recept Bacalhau à Brás](https://saudadesdeportugal.nl/bacalhau-a-bras/)
-   [Difference between the File and RandomAccessFile classes](https://www.careerride.com/Java-file-vs-RandomAccessFile-classes.aspx#:~:text=%2D%20The%20File%20class%20encapsulates%20the,%2D%20The%20java.&text=%2D%20Unlike%20the%20input%20and%20output,inherit%20from%20InputStream%20or%20OutputStream.)
-   [Castanhas assadas no forno - SAPO - Lifestyle](https://lifestyle.sapo.pt/sabores/receitas/castanhas-assadas-no-forno)
-   [Castanhas assadas e Feira de São Martinho prometem atrair milhares a Portimão](https://postal.pt/economia/2019-10-31-Castanhas-assadas-e-Feira-de-Sao-Martinho-prometem-atrair-milhares-a-Portimao)
-   [Festival do Marisco 2019](http://www.festivaldomarisco.com/artistas)
-   [Portugese ‘ontdekking’ in onze keuken: chuchu](https://campersmuikjegaatlos.nl/portugese-ontdekking-in-onze-keuken-chuchu/)
-   [Mercados De Olhão, E.E.M](https://www.visitalgarve.pt/pt/7353/mercados-de-olhao-eem.aspx)
-   [Mercado de Olhao](https://www.tripadvisor.nl/Attraction_Review-g312714-d3923506-Reviews-Mercado_de_Olhao-Olhao_Faro_District_Algarve.html)
-   [MUNICÍPIO - Espaços Municipais - Mercados Municipais - Olhão](http://www.cm-olhao.pt/pt/municipio/espacos-municipais/mercados-municipais)

<div align="center">
      <a href="https://www.youtube.com/watch?v=sfAE1ojKrPw">
         <img 
              src="https://img.youtube.com/vi/sfAE1ojKrPw/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=GyyamiSLio8">
         <img 
              src="https://img.youtube.com/vi/GyyamiSLio8/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=uFDfFN3rCXA">
         <img 
              src="https://img.youtube.com/vi/uFDfFN3rCXA/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=-ks7qIokECY">
         <img 
              src="https://img.youtube.com/vi/-ks7qIokECY/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=nfUPDxW4Ao8">
         <img 
              src="https://img.youtube.com/vi/nfUPDxW4Ao8/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=nnE3DEIZ_sA">
         <img 
              src="https://img.youtube.com/vi/nnE3DEIZ_sA/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=1IdZUXqM3rE">
         <img 
              src="https://img.youtube.com/vi/1IdZUXqM3rE/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=2Mzf4g5exKc">
         <img 
              src="https://img.youtube.com/vi/2Mzf4g5exKc/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=9VeMAZ_a_P0">
         <img 
              src="https://img.youtube.com/vi/9VeMAZ_a_P0/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=Mu0wBrNFNhA">
         <img 
              src="https://img.youtube.com/vi/Mu0wBrNFNhA/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=U04qgT231pE">
         <img 
              src="https://img.youtube.com/vi/U04qgT231pE/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=noubIxTD0P4">
         <img 
              src="https://img.youtube.com/vi/noubIxTD0P4/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=6Kg0kzLIWto">
         <img 
              src="https://img.youtube.com/vi/6Kg0kzLIWto/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=ySIznKDMyp8">
         <img 
              src="https://img.youtube.com/vi/ySIznKDMyp8/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=73Mo-niPcJc">
         <img 
              src="https://img.youtube.com/vi/73Mo-niPcJc/0.jpg" 
              style="width:10%;">
      </a>
</div>

---

## References

-   [OCP11 1z0-817](https://education.oracle.com/upgrade-ocp-java-6-7-8-to-java-se-11-developer/pexam_1Z0-817)
-   [OCP11 1z0-819](https://education.oracle.com/java-se-11-developer/pexam_1Z0-819)
-   [Enthuware](https://enthuware.com/)
-   [OCP 11 study guide](https://www.goodreads.com/book/show/51132641-ocp-oracle-certified-professional-java-se-11-programmer-i-study-guide)
-   [A JDeps Tutorial - Analyze Your Project's Dependencies](https://nipafx.dev/jdeps-tutorial-analyze-java-project-dependencies)
-   [Whizlabs](https://www.whizlabs.com/)

---

## Java 11 Specs

-   [Qualified Exports](https://www.logicbig.com/tutorials/core-java-tutorial/modules/qualified-exports.html)
-   [The modular JDK](https://openjdk.java.net/jeps/200)
-   [JLink](https://docs.oracle.com/javase/9/tools/jlink.htm)

---

## The module graph

[![alt text](https://bugs.openjdk.java.net/secure/attachment/72525/jdk.png "The module graph")](https://openjdk.java.net/jeps/200)
 
---

## Achievements

[![alt text](../../../badges/oracle-certified-associate-java-se-7-programmer-100.png "OCA SE 7")](https://www.youracclaim.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225/public_url)
[![alt text](../../../badges/oracle-certified-associate-java-se-8-programmer-100.png "OCA SE 8")](https://www.youracclaim.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7/public_url)
[![alt text](../../../badges/oracle-certified-professional-java-se-8-programmer-100.png "OCP SE 8")](https://www.youracclaim.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074/public_url)
  
---

## About me 👨🏽‍💻🚀

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/acclaim-20.png "Acclaim")](https://www.youracclaim.com/users/joao-esperancinha/badges)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bintray-20.png "BinTray")](https://bintray.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeforces-20.png "Code Forces")](https://codeforces.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=6495ED)](http://tds.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=6495ED)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Badges.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-android)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-modules/tree/master/itf-chartizate-java)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate/tree/master/itf-chartizate-api)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/instagram-20.png "Instagram")](https://www.instagram.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
