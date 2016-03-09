# webretail-admin (Under development)
**webretail-admin** is the admin module for the open source e-commerce shopping cart [webretail](https://github.com/susankoruthu/webretail "webretail").


## Features

webretail-admin is an "out of the box" shopping cart solution. You simply install, add products and you're ready to start accepting orders.

Features includes:

- Open Source
- Manage Unlimited Categories
- Manage Unlimited Products
- Manage Multi-Languages
- Manage Multi-Currency
- Product Reviews
- Product Ratings
- Order Management
- Printable Invoices
- Sales Reports
- Error Logging

## Running webretail-admin locally


> git https://github.com/roshantitus/webretail-admin.git
> 
mvn jetty:run


You can then access the shopping cart here: http://localhost:8080/webretail-admin/

## In case you find a bug/suggested improvement for webretail-admin

Our issue tracker is available here: 

```
https://github.com/roshantitus/webretail-admin/issues
```

## Working with webretail-admin in Eclipse/STS

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
git clone https://github.com/roshantitus/webretail-admin.git
```

2) Inside Eclipse

```
File -> Import -> Maven -> Existing Maven project
```

## Interaction with other open source projects

The project uses the free [Bootstrap](http://twitter.github.com/bootstrap/ "bootstrap") template: [joli-admin](https://github.com/sbilly/joli-admin "joli-admin")


