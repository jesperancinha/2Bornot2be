# mastery-3-1 - Mastery Module 3.1.

In this fifth master module on route to the Java 11 certification, we are going to use data from some of the most amazing singers who sing in dutch.
Regardless of my musical preferences and of yours, it is undeniable that it is through their music that I ended up learning this amazing language.
I sang these songs from my heart and little by little my dutch speaking goal became a reality.
It should be no surprise that my story would end up being a part of my study materials of some sort and this is their debut.

(... coming soon.)

## Preparation

If you are on a Unix based system or if you are running any sort of BSD, MAC-OS, then you are fine using filr [prepare.sh](./prepare.sh).
If you are using windows, then this will maybe work. I seldom use windows and not always I can test my work there.
The point is that you need to have a `/tmp` folder at this point.

```bash
./prepare.sh
```

## Exercise

1. `Integer` Mathematical Bases `parseInt`
2. Labels and `break` in loops
3. `Files.newDirectoryStream` Listings and the `glob` pattern
4. `@Override` in `equals`
5. How `null` is interpreted in overloading
6. How `getRoot()` exhibits the root `Path`
7. Type of elements in a diamond notation declared `ArrayList` assigned to `var`
8. Initialization of invisible `primitive` members
9. Declaring a `String` array.
10. Passing variables by value and not returning in `Stream`
11. Thread safe `Object` s
12. `Stream` count types
13. How to guarantee Immutability - Java Security Guidelines
14. Accessing `static` `interface` methosd
15. `java.lang.OutOfMemoryError` and `Error` classes
16. Accessibility `@Override`
 
## Output

```text
/Users/jofisaes/.sdkman/candidates/java/11.0.2-open/bin/java -javaagent:/Applications/IntelliJ IDEA 2020.2 EAP.app/Contents/lib/idea_rt.jar=58231:/Applications/IntelliJ IDEA 2020.2 EAP.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/jofisaes/dev/src/jofisaes/java-test-drives/ocp11/ocp11-mastery-3/mastery-3-1/target/classes:/Users/jofisaes/dev/src/jofisaes/java-test-drives/jtd-the-factory/consolerizer/target/classes:/Users/jofisaes/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar:/Users/jofisaes/.m2/repository/org/junit/jupiter/junit-jupiter/5.5.1/junit-jupiter-5.5.1.jar:/Users/jofisaes/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.5.1/junit-jupiter-api-5.5.1.jar:/Users/jofisaes/.m2/repository/org/apiguardian/apiguardian-api/1.1.0/apiguardian-api-1.1.0.jar:/Users/jofisaes/.m2/repository/org/opentest4j/opentest4j/1.2.0/opentest4j-1.2.0.jar:/Users/jofisaes/.m2/repository/org/junit/platform/junit-platform-commons/1.5.1/junit-platform-commons-1.5.1.jar:/Users/jofisaes/.m2/repository/org/junit/jupiter/junit-jupiter-params/5.5.1/junit-jupiter-params-5.5.1.jar:/Users/jofisaes/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.5.1/junit-jupiter-engine-5.5.1.jar:/Users/jofisaes/.m2/repository/org/junit/platform/junit-platform-engine/1.5.1/junit-platform-engine-1.5.1.jar:/Users/jofisaes/.m2/repository/org/assertj/assertj-core/3.13.2/assertj-core-3.13.2.jar org.jesperancinha.ocp11.mastery3dot1.Mastery3Dot1Runner
================== Master Module mastery-3-1 ==================
--- 1. `Integer` Mathematical Bases `parseInt`
============
According to NPO(https://www.nporadio2.nl/song/3230/grote-mannen-worden-klein),  Diggy Dex single, "Grote Mannen Worden Klein" was releases in 2014
Let's see different ways to visualize this:
*** Integer.parseInt(2014)
The single was "Grote Mannen Worden Klein" was released, in Decimal, in the year 2014
*** Integer.parseInt(11111011110, 2)
The single was "Grote Mannen Worden Klein" was released, in Binary, in the year 2014
References
1. https://www.nporadio2.nl/song/3230/grote-mannen-worden-klein
2. https://www.last.fm/music/Diggy+Dex/_/Grote+Mannen+Worden+Klein
3. https://www.metrolyrics.com/grote-mannen-worden-klein-lyrics-diggy-dex.html
--- 2. Labels and `break` in loops
============
Case: You are a fan of "De Jeugd van Tegenwoordig" and you just keep buying their record
You have a shelf with three rows where your records are organized by most favourite less favourite
However, you bought a bunch of repeated records and because your mood wings,
You don't even know anymore which one is your favourite and which one not.
So now you have 2 records on the top shelf, 4 at the second one and 10 at the bottom!
But "De Jeugds van Tegenwoordig" only edited 8 albums!
We will use old fashioned for loops to figure out this mess.
On our example we just want to check how many iteration our for loops will perform.
Our criteria is:
1. For loop will break once a repetition is found
2. The Atomic Integer counts the number of repetitions found
3. Keep in mind that there might be more repetitions in one particular iteration, but those are not counted
4. Remember that the for loop will break and will skip the rest of the albums on that iteration
5. No repetitions will be counted on the same shelf
6. I know its difficult but that's the point 😊
Your goal is to guess how many iterations will the atomic number count
These are your randomized shelves:
Shelf 1 -> [Luek, Manon]
Shelf 2 -> [De Machine, Luek, Luek, Manon]
Shelf 3 -> [De Machine, Manon, Anders (Different), “Ja, Natúúrlijk!”, Manon, X - Viering van het super decennium, Manon, Luek, Parels voor de zwijnen, Parels voor de zwijnen]
Please guess how many repetitions will this method find ->
78
You failed this time, but try again. 6 repetitions were found. Your participation awards you with a medal of courage! 🎖
1. https://nl.wikipedia.org/wiki/De_Jeugd_van_Tegenwoordig_(rapgroep)
2. https://www.youtube.com/watch?v=cNMXSKfWfLQ
--- 3. `Files.newDirectoryStream` Listings and the `glob` pattern
============
Case: We saved a part of Abel's Lyrics somewhere, for our social study work, but we don't know where the file is.
We took the lyrics from https://www.musixmatch.com/lyrics/Abel/Onderweg,
but now we have no access to the internet and we have to deliver our work in 2 hours! Help!
In this exercise we will find Abel's lyrics in our tmp folder. We hope the system hasn't deleted it yet...
We will try to find our file in /tmp. Remember to run ./prepare.sh. Check Readme.md for more details:
If we use a glob filter of *.{gif,jpeg,jpg,bmp} we get:
No file found!
This was the wrong extension! If we use a glob filter of *.{txt} we get:
/tmp/abel.onderweg.txt
/tmp/.ebonwgal.txt
/tmp/ebal.rwegonde.txt
But this may lead to a lot of them! If we use a glob filter of [ebal][ebal][ebal][ebal].[rwegonde][rwegonde][rwegonde][rwegonde][rwegonde][rwegonde][rwegonde][rwegonde].{txt} we get:
/tmp/abel.onderweg.txt
/tmp/ebal.rwegonde.txt
But this may still lead to a lot of them! If we use a glob filter of abel.onderweg.? we get:
/tmp/abel.onderweg.t
But this is not even our file!! If we use a glob filter of abel.onderweg.{txt} we get:
From: https://www.musixmatch.com/lyrics/Abel/Onderweg

Ik doe de deur dicht
Straten lijken te huilen
Wolken lijken te vluchten
Ik stap de bus in
Mensen lijken te kijken
Maar ik wil ze ontwijken
Voordat ze mij zien
Het is al lang verleden tijd
Dat je mijn verjaardag niet vergat
Je onvoorwaardelijk koos voor mij

A study for the music styles at the end of the 90's.
/tmp/abel.onderweg.txt
We finally found it!

Process finished with exit code 0

```
## References

-   [Maaike Ouboter](https://nl.wikipedia.org/wiki/Maaike_Ouboter)
-   [Musixmatch - Abel, Onderweg, Lyrics](https://www.musixmatch.com/lyrics/Abel/Onderweg)
-   [Glob pattern](https://en.wikipedia.org/wiki/Glob_(programming))
-   [De Jeugd van Tegenwoordig - Wikipedia NL](https://nl.wikipedia.org/wiki/De_Jeugd_van_Tegenwoordig_(rapgroep))
-   [Diggy Dex - Wikipedia NL](https://nl.wikipedia.org/wiki/Diggy_Dex)
-   [Jan Willem Roy - Wikipedia NL](https://nl.wikipedia.org/wiki/JW_Roy)

<div align="center">
      <a href="https://www.youtube.com/watch?v=bY-F4sCQz1E">
         <img 
              src="https://img.youtube.com/vi/bY-F4sCQz1E/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=d3Bbu2H7x_s">
         <img 
              src="https://img.youtube.com/vi/d3Bbu2H7x_s/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=-WNo6YdN8u0">
         <img 
              src="https://img.youtube.com/vi/-WNo6YdN8u0/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=T6YE5h2Xtow">
         <img 
              src="https://img.youtube.com/vi/T6YE5h2Xtow/0.jpg" 
              style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=cNMXSKfWfLQ">
         <img 
              src="https://img.youtube.com/vi/cNMXSKfWfLQ/0.jpg" 
              style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=MZRw9NiVUuM">
         <img 
              src="https://img.youtube.com/vi/MZRw9NiVUuM/0.jpg" 
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

[![alt text](../../badges/oracle-certified-associate-java-se-7-programmer-100.png "OCA SE 7")](https://www.youracclaim.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225/public_url)
[![alt text](../../badges/oracle-certified-associate-java-se-8-programmer-100.png "OCA SE 8")](https://www.youracclaim.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7/public_url)
[![alt text](../../badges/oracle-certified-professional-java-se-8-programmer-100.png "OCP SE 8")](https://www.youracclaim.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074/public_url)
  
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
