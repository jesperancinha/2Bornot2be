# jee7 Test Drives

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/openjdk-50.png "OpenJDK")](https://openjdk.java.net/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/sdk-man-50.png "SdkMAN!")](https://sdkman.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/wild-fly-50.png "WildFly")](https://www.wildfly.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/tomcat-50.png "Tomcat")](https://tomcat.apache.org/whichversion.html)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/arquillian-50.png "Arquillian")](https://github.com/arquillian)

---

## Introduction

This is a set of study modules that I'm using to study JEE7.
Feel free to use these materials in your studies.
These modules can be used for education purposes or for certain types of exames like the [1z0-900](https://education.oracle.com/java-se-11-developer/pexam_1Z0-900)

-   [JEE Flash-cards](jee-crums) - 💳 A set of Q&A exercises with container independent code and flash cards
    - [jee-flash-1](jee-crums/jee-crums-1) - 💳 Flash 1
-   [JEE Applications](jee-apps) - ⚙️ A set of applications written in JEE using diffeen servers like Glassfish and Weblogic
    - [jee-apps-triad-1](jee-apps/jee-apps-triad-1) - Triad 1
        - [jee-app-1-wildfly](jee-apps/jee-apps-triad-1/jee-app-1-wildfly) - 🎤 Pop stars list, music, lyrics and history - Java 8
        - [jee-app-2-wildfly](jee-apps/jee-apps-triad-1/jee-app-2-wildfly) - 🌿 Kitchen Herbs and History - Java 11
        - [jee-app-3-wildfly](jee-apps/jee-apps-triad-1/jee-app-3-wildfly) - 🦷 A lesson on teeth health and the odd cases - Java 11
    - [jee-apps-triad-2](jee-apps/jee-apps-triad-2) - Triad 2
        - [jee-app-2-1-wildfly](jee-apps/jee-apps-triad-2/jee-app-2-1-wildfly) - 🕺🏻  Boy Bands in the 90's - Java 11
        - [jee-app-2-2-wildfly](jee-apps/jee-apps-triad-2/jee-app-2-2-wildfly) - 💃 Girl Bands - Java 11
        - [jee-app-2-3-wildfly](jee-apps/jee-apps-triad-2/jee-app-2-3-wildfly) - 🎙 Soul Music - Java 11
    - [jee-apps-quad-1](jee-apps/jee-apps-quad-1) - Quad 1
        - [jee-app-3-1-wildfly](jee-apps/jee-apps-quad-1/jee-app-3-1-wildfly) - 🇵🇹 History of Portugal - Java 11
        - [jee-app-3-2-wildfly](jee-apps/jee-apps-quad-1/jee-app-3-2-wildfly) - 🇪🇸 History of Spain - Java 11
        - [jee-app-3-3-wildfly](jee-apps/jee-apps-quad-1/jee-app-3-3-wildfly) - 🇳🇱 History of The Netherlands - Java 11
        - [jee-app-3-4-wildfly](jee-apps/jee-apps-quad-1/jee-app-3-4-wildfly) - 🇬🇧 History of the United Kingdom - Java 11
-   [JEE Mastery Applications](jee-mastery) - ⚔️ A set of modules with a very deep in-depth approach to architecture
    - [jee-mastery-app-1](jee-mastery/jee-mastery-app-1) - 🏳️‍🌈 - PRIDE Edition 1
    - [jee-mastery-app-2](jee-mastery/jee-mastery-app-2) - 🎶 🔉 - Chorus and Arias
-   [JEE Lightning](jee-lightning) - ⚡️ Fast track easy to deploy modules
    - [jee-lightning-1](jee-lightning/jee-lightning-1) - ☕️ No web.xml
    - [jee-lightning-2](jee-lightning/jee-lightning-2) - 🧼 SOAP bare minimal
    - [jee-lightning-3](jee-lightning/jee-lightning-3) - ☕️ JSP exercises
    - [jee-lightning-3](jee-lightning/jee-lightning-4) - 🛼 The All-Together

I switch java versions in this module and sub-modules with [SDK-MAN](https://sdkman.io/), but you can use whichever you like.
For example, you can also use [JEnv](https://www.jenv.be/) or just the regular [update-java-alternatives](https://askubuntu.com/questions/315646/update-java-alternatives-vs-update-alternatives-config-java) or [update-alternatives](https://askubuntu.com/questions/315646/update-java-alternatives-vs-update-alternatives-config-java).
In these modules I am using <b>java version 8.0.242.hs-adpt</b>. You can try other java 8 versions. I cannot guarantee that you'll be able to execute 100% of the examples though.
You can also try to use a version of Java SE 7, but I'm almost 100% sure that none of the modules will work as I'll be using lamdas for the code.

<b>NOTE: JEE7 has nothing to do with the actual Java SE version being used. I chose Java 8 in a few projects for compatibility reasons. You can also find apps developed with Java 11 on top of JEE7.</b>

This repo is here because, amongst other reasons, JEE is still pretty much very relevant.
Alternatives to a [JEE architecture](https://www.oracle.com/java/technologies/java-ee-glance.html), like the [Spring Framework](https://spring.io/) facilitate another way to solve enterprise problems.
Both are very good architectures, and they differ in their approach.
This means that many companies are using either one or the other.
[JEE 7 specifically](https://www.oracle.com/java/technologies/javaee/javaeetechnologies.html#javaee7), is the only way at the moment to get certified via an [Oracle exam](https://education.oracle.com/java-ee-7-application-developer/pexam_1Z0-900).
At the same time, this is still a very popular framework to be used.
[SOAP services and technologies](https://en.wikipedia.org/wiki/SOAP) are also still very much in use these days by many companies and therefore an understanding on how to do this in Java is still very much a necessity.

<i>João Esperancinha, 31st of December 2020</i>

---

# Important Specs

1. Java API for WebSocket 1.1
2. JavaServer Faces (JSF) 2.2
3. JavaServer Pages (JSP) 2.3
4. Java API for RESTful Services (JAX-RS) 2.0
5. Java API for JSON Processing (JSON-P) 1.0
6. Expression Language (EL) 3.0 
7. Java Authentication Service Provider Interface for Containers (JASPIC) 1.1

<b style="color: green">Apache Tomcat 9.0.41 and Wildfly 16.0 seem to follow these standards. This is why I am using them.</b>

<b style="color: red">Glassfish for Java EE 7 unfortunately only supports Java 6 and Java 8 in later versions. Newer versions are ready for JEE 8 and above. We will be using Java 11 in our test modules</b>

# References

-   [Oracle 1Z0-900 Exam: Rise and Shine as an Application Developer with Oracle Certification](https://www.dbexam.com/blog/oracle-1z0-900-exam-rise-and-shine-application-developer-oracle-certification)
-   [1Z0-900: Java EE 7 Application Developer](https://www.dbexam.com/oracle/1z0-900-java-ee-7-application-developer)
-   [Pluralsight](https://www.pluralsight.com/)
-   [Building and Running a Java EE Application by Using Maven](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Maven_EE/MavenEE.html)
-   [Run Maven Java Web Application in Jetty Maven Plugin](https://o7planning.org/en/10335/run-maven-java-web-application-in-jetty-maven-plugin)
-   [Getting Started With Jetty Server](https://www.jrebel.com/blog/jetty-server)
-   [jetty Maven Jetty plugin](https://riptutorial.com/jetty/example/22209/maven-jetty-plugin)
-   [Chapter 6. Getting started with Weld](https://docs.jboss.org/weld/reference/3.0.0.CR1/en-US/html/gettingstarted.html)
-   [Creating a Chat Application using Java EE 7, Websockets and GlassFish 4](https://www.hascode.com/2013/08/creating-a-chat-application-using-java-ee-7-websockets-and-glassfish-4/)
-   [JAVA EE 7 – THE STANDARD FOR ENTERPRISE JAVA](https://turngeek.github.io/javaee7inaweek/chapter/i-1-java-ee-7-the-standard-for-enterprise-java/)
-   [Java Platform, Enterprise Edition (Java EE) 7](https://docs.oracle.com/javaee/7/index.html)

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

## Achievements

[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.youracclaim.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280/public_url)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.youracclaim.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074/public_url)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png)](https://www.youracclaim.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7/public_url)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png)](https://www.youracclaim.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225/public_url)
[![Oracle Certified Juninor Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png)](https://www.youracclaim.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794/public_url)
