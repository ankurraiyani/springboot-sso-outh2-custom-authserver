# Spring Boot OAuth 2 SSO Client with Custom Authentication Server

In Spring Security 5 a new OAuth2LoginConfigurer class has been introduces which we can use for configuring an external Authorization Server.
Spring Security project contains default configurations for Google, Facebook, GitHub and Okta.
Please refer to [this](https://www.baeldung.com/spring-security-5-oauth2-login) article for more information.

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

You need to ask above information from your authentication provider and replace it over here.
Once you complete the configuration just execute below command
`````
mvn clean install spring-boot:run
`````

That's it !! 

## Additional Information
Here all the autoconfiguration is managed by one annotation `@EnableOAuth2Sso`. This annotation will read the configuration from `application.propeties` file and prepare OAuth2 flow.

Please notice the class called `PepstoreAuthoritiesExtractor`. This class is required to manage user authorities or roles in your application if you are using 3rd party authentication server for SSO. When your application has multiple roles, you can use this class to assign roles in your application database for users logged in through SSO.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Ankur Raiyani**