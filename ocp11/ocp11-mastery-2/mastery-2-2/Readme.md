# mastery-2-2 - Mastery Module 2.2.

## Exercise

In this fourth mastery exercise we'll look at a few important key aspects:

1. Serializing `FileOutputStream` and `FileInputStream` -> [mastery-2-2-deserializer](../mastery-2-2-deserializer) and [mastery-2-2](.)
2. `compare` and `mismatch` in arrays
3. TYPE_USE and TYPE_PARAMETER
4. Switch valid numeric types and their limits
5. Float value declaration
6. Conflicting exports in modularization
7. Multi interface inheritance
8. `Function`'s and `ToFunction`'s
9. `--add-exports` and `--add-reads` in modularization
10. Security guidelines: [Read, Write, Memorize, Understand (R.W.M.U.)](https://www.oracle.com/java/technologies/javase/seccodeguide.html)
11. Project Jigsaw: [R.W.M.U](http://cr.openjdk.java.net/~mr/jigsaw/ea/module-summary.html)
12. `AutoCloseable`close method and exception handling
13. `Files` list and walk
14. Reading sub-paths `Path.subpath`
15. Prepared statement different types `BLOB` and `CLOB`
16. Non-deterministic nature of `findAny`
17. Loops and Labels for `do`, `while`, `for` and `if`
18. Overriding `CharSequence`.

## Output

```text
/Users/jofisaes/.sdkman/candidates/java/11.0.2-open/bin/java -javaagent:/Applications/IntelliJ IDEA 2020.2 EAP.app/Contents/lib/idea_rt.jar=64890:/Applications/IntelliJ IDEA 2020.2 EAP.app/Contents/bin -Dfile.encoding=UTF-8 -p /Users/jofisaes/dev/src/jofisaes/java-test-drives/ocp11/ocp11-mastery-2/mastery-2-2/target/classes:/Users/jofisaes/dev/src/jofisaes/java-test-drives/jtd-the-factory/consolerizer/target/classes:/Users/jofisaes/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar:/Users/jofisaes/.m2/repository/org/junit/jupiter/junit-jupiter/5.5.1/junit-jupiter-5.5.1.jar:/Users/jofisaes/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.5.1/junit-jupiter-api-5.5.1.jar:/Users/jofisaes/.m2/repository/org/apiguardian/apiguardian-api/1.1.0/apiguardian-api-1.1.0.jar:/Users/jofisaes/.m2/repository/org/opentest4j/opentest4j/1.2.0/opentest4j-1.2.0.jar:/Users/jofisaes/.m2/repository/org/junit/platform/junit-platform-commons/1.5.1/junit-platform-commons-1.5.1.jar:/Users/jofisaes/.m2/repository/org/junit/jupiter/junit-jupiter-params/5.5.1/junit-jupiter-params-5.5.1.jar:/Users/jofisaes/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.5.1/junit-jupiter-engine-5.5.1.jar:/Users/jofisaes/.m2/repository/org/junit/platform/junit-platform-engine/1.5.1/junit-platform-engine-1.5.1.jar:/Users/jofisaes/.m2/repository/org/assertj/assertj-core/3.13.2/assertj-core-3.13.2.jar -m $mastery22$/org.jesperancinha.ocp11.mastery2dot2.Master2Dot2Runner
================== Master Module mastery-2-2 ==================
1. Serializing 'FileOutputStream' and 'FileInputStream'
============
### Creating Apollo 13 Mission but missing a few details
File has been created on this location -> /tmp/destination
Data -> MissionData{mission='Apollo 13', destination='The Moon', origin='Earth'}
Please run module mastery-2-2-deserializer to realize that default fields are read with Java default values and not the assigned ones,
if they are not part of the serialized data
2. 'compare' and 'mismatch' in arrays
============
### We compare two arrays defining the crew and test mismatch and compare
comparing [James A. Lovell,John L. Swigert, Jr.,Fred W. Haise, Jr.] with [Jim Lovell,Jack Swigert,Fred Haise] -> result is: -8
comparing James A. Lovell with Jim Lovell -> result is: -8
comparing [James A. Lovell,John L. Swigert, Jr.,Fred W. Haise, Jr.] with [James A. Lovell,Jack Swigert,Fred W. Haise, Jr.] -> result is: 14
comparing John L. Swigert, Jr. with Jack Swigert -> result is: 14
comparing Jack Swigert with John L. Swigert, Jr. -> result is: -14
comparing Fred W. Haise, Jr. with Fred W. Haise, Jr. -> result is: 0
comparing [Jim Lovell,Jack Swigert,Fred Haise] with [James A. Lovell,Jack Swigert,Fred W. Haise, Jr.] -> result is: 8
### We mismatch two arrays defining the crew and test mismatch and compare
mismatching [James A. Lovell,John L. Swigert, Jr.,Fred W. Haise, Jr.] with [Jim Lovell,Jack Swigert,Fred Haise] -> result is: 0
mismatching James A. Lovell with Jim Lovell -> result is: -8
mismatching [James A. Lovell,John L. Swigert, Jr.,Fred W. Haise, Jr.] with [James A. Lovell,Jack Swigert,Fred W. Haise, Jr.] -> result is: 1
comparing John L. Swigert, Jr. with Jack Swigert -> result is: 14
comparing Jack Swigert with John L. Swigert, Jr. -> result is: -14
comparing Fred W. Haise, Jr. with Fred W. Haise, Jr. -> result is: 0
mismatching [Jim Lovell,Jack Swigert,Fred Haise] with [James A. Lovell,Jack Swigert,Fred W. Haise, Jr.] -> result is: 0
### Note that comparing is different with integers
comparing [1,2,3,4,5,6,7,8,1] with [1,2,3,4,5,6,7,8,9] -> result is: -1
mismatching [1,2,3,4,5,6,7,8,1] with [1,2,3,4,5,6,7,8,9] -> result is: 8
comparing [1,2,3,4,5,6,7,8,11] with [1,2,3,4,5,6,7,8,9] -> result is: 1
comparing [1,2,3] with [1,2,3,4,5,6,7,8,9] -> result is: -6
3. TYPE_USE and TYPE_PARAMETER
============
### A TYPE_USE case
@Rocket String rocket1 = "Saturn V";
var rocket2 = (@Rocket String) "Saturn V";
Function<Integer, String> f = ( @Rocket Integer val ) -> Integer.toHexString(val);
### A TYPE_PARAMETER case
var missionModified = new MissionDataTyped<String>();
### Not that TYPE_PARAMETER is a part of TYPE_USE. If you have TYPE_USE, you don't need TYPE_PARAMETER
4. Switch valid numeric types and their limits
============
### Permitted Values
### short
-128 <= byte <= 127
### byte
-32768 <= short <= 32767
### int
-2147483648 <= short <= 2147483647
### char
0 <= char <= 65535
null <= char <= ￿
### Not permitted Values
### bool
false <= bool <= true
### long
-9223372036854775808 <= long <= 9223372036854775807
### float
1.4E-45 <= float <= 3.4028235E38
### double
4.9E-324 <= double <= 1.7976931348623157E308
5. Float value declaration
============
### We try to assign an absolute number
1000.0
### We try to assign a number with decimals. Think that by default they are double
100.12345
### With a double, we do not need to cast
100.45677
6. Conflicting exports in modularization
============
### Check the module definitions of this module
7. Multi interface inheritance
============
### Check the two interfaces. There is a subclass which overrides the superclass method. This is Ok
public interface BriefingTrajectory {
    String getOriginLocation();
    String getDestinationLocation();
}
### And this is the sub interface
public interface MissionBriefingControl extends BriefingDate, BriefingTrajectory {
    String getDestinationLocation();
    String getDestinationLocation(MissionData missionData);
    LocalDateTime getBriefingDate();
    String getOriginLocation();
}
8. 'Function''s and 'ToFunction''s
============
### A ToDoubleFunction uses an Object parameter, but always returns a primitve
### The name is self-exlanatory. To<>Function's always return a primitive type
4371.0
-1.0
### A DoubleFunction uses an double parameter, but always returns an object
### The name is self-exlanatory. <>Function's always receive a primitive type
SATCAT
null
9. '--add-exports' and '--add-reads' in modularization
============
### Check module mastery-2-2-modularity for an example in action
10. Security guidelines
============
### Check https://www.oracle.com/java/technologies/javase/seccodeguide.html for more info on java security
11. Project Jigsaw
============
### Check http://cr.openjdk.java.net/~mr/jigsaw/ea/module-summary.html for more info on java.base
12. 'AutoCloseable'close method and exception handling
============
### AutoCloseable interface and exception handling
java.lang.NullPointerException
	See? I can throw NullPointerException whenever I want!
	$mastery22$/org.jesperancinha.ocp11.mastery2dot2.Master2Dot2Runner.main(Master2Dot2Runner.java:207)
2,949,136
### We re-close the FileInputStream, but note that, that one also throws IOException.
🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄🦄


Process finished with exit code 0
```

## References

-   [Apollo 13 (film)](https://nl.wikipedia.org/wiki/Apollo_13_(film))
-   [Apollo_13](https://en.wikipedia.org/wiki/Apollo_13)
-   [Commons:Licensing](https://commons.wikimedia.org/wiki/Commons:Licensing)
-   [Creative Commons](https://creativecommons.org/)
-   [Five Command Line Options To Hack The Java Module System](https://nipafx.dev/five-command-line-options-hack-java-module-system)
-   [Secure Coding Guidelines for Java SE](https://www.oracle.com/java/technologies/javase/seccodeguide.html)

<div align="center">
      <a href="https://www.youtube.com/watch?v=MdvoA-sjs0A">
     <img 
          src="https://img.youtube.com/vi/MdvoA-sjs0A/0.jpg" 
          style="width:10%;">
      </a>
</div>

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
