# Spring Boot OAuth 2 SSO Client with Custom Authentication Server

In Spring Security 5 a new OAuth2LoginConfigurer class has introduces which we can use for configuring an external Authorization Server.
Spring Security project contains default configurations for Google, Facebook, GitHub and Okta.
Please refer [this](https://www.baeldung.com/spring-security-5-oauth2-login) article for more information.

This project is about implementing SSO client with oauth2 and custom authentication server for which default configuration is not available in Spring Security project.

## Getting Started
The only thing which needs to be modified is `application.properties` file.
`````
security.oauth2.client.client-id=<YOUR CLIENT ID>
security.oauth2.client.client-secret=<YOUR SECRET ID>
security.oauth2.client.scope=<SCOPE>
#Replace below URL with the given URL by your auth server provider
security.oauth2.client.access-token-uri=https://XXXXX.com/oauth2/token
#Replace below URL with the given URL by your auth server provider
security.oauth2.client.user-authorization-uri=https://XXXXX.com/oauth2/authorize
#Replace below URL with the given URL by your auth server provider
security.oauth2.resource.user-info-uri=https://XXXXX.com/oauth2/userinfo
`````

You need to ask above information from you authentication provider and replace over here.
Once you complete the configuration just execute below command
`````
mvn clean install spring-boot:run
`````

That's it !! 

## Additional Information
Here all the autoconfiguration is managed by one annotation `@EnableOAuth2Sso`. This annotation will read the configuration from `application.propeties` file and prepare OAuth2 flow.

Please also notice one class called `PepstoreAuthoritiesExtractor`. This class is only require if you want to manage authorities based on your application.
For example using SSO user is logged in successfully but that user is might an ADMIN or SUPER ADMIN user for your application. So when you have different roles in your application you can use this class to assign role based on your application database.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Ankur Raiyani**