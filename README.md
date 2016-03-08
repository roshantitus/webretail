# Webretail (Under development)
**webretail** is a complete, open source, B2B, e-commerce shopping cart solution in Java/J2EE.


## Features

Webretail is an "out of the box" shopping cart solution. You simply install, add products and you're ready to start accepting orders.

Features includes:

- Open Source
- Unlimited Categories
- Unlimited Products
- Multi-Language
- Multi-Currency
- Product Reviews
- Product Ratings
- Order Management
- Printable Invoices
- Sales Reports
- Error Logging

## Running Webretail locally


> git https://github.com/roshantitus/webretail.git
> 
mvn jetty:run


You can then access the shopping cart here: http://localhost:8080/webretail/

## In case you find a bug/suggested improvement for webretail

Our issue tracker is available here: 

```
https://github.com/roshantitus/webretail/issues
```

## Working with Webretail in Eclipse/STS

### Pre requisites:
The following items should be installed in your system:

* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps:

1) In the command line

```
git clone https://github.com/roshantitus/webretail.git
```

2) Inside Eclipse

```
File -> Import -> Maven -> Existing Maven project
```

## Interaction with other open source projects

The project uses the free [Bootstrap](http://twitter.github.com/bootstrap/ "bootstrap") template: [joli-admin](https://github.com/sbilly/joli-admin "joli-admin")


