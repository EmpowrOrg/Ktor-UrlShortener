# Ktor-UrlShortener

Here is a simple url shortener written in Ktor. There is nothing too special about it but it does log each use of a specific url. Empowr created this to mitigate cost of using a paid url shortener with a custom domain name.

This is meant to be hosted on AWS but you can host this anywhere a fatJar is used.

## How To Use
Fork the repo and open it in IntelliJ. 

Setup a postgresql database and write down the username, password, and database name.

Open runConfigurations and edit the values to match your environment. *Please* do you use the default values you find, in a production environment. They are horrible passwords and are only used for local testing.

## Nice-To-Haves
If you would like to contribute, please check out this list of things I would love to still do

- [ ] Test Routers
- [ ] Make UrlShortener Injectable
- [ ] Add Dependency Injection Library
- [ ] Use a Redis Cache
- [ ] Add Google Analytics capabilities

If you would like to use, please feel free. Enjoy.

If you are feeling generous please give a donation to Empowr at
paypal.com/us/fundraiser/charity/3937172
