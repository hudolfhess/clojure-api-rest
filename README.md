# Clojure API Rest

This is a study case to create an API Rest using Clojure.

The objective is learn more about how Clojure works and principally, concepts of functional programming.

## Usage
First install Leiningen in http://leiningen.org/.
On Ubuntu, follow de instructions:
```
$ wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
$ chmod +x lein
$ sudo mv lein /usr/local/bin
```

After download this repository, open `clojure-api-rest` and run `lein ring server`.

## TO DO List
 - [X] Config HTTP server
 - [X] Create a sample route
 - [X] Config a database connection (MySQL)
 - [ ] Making routes (using database)
  - [ ] GET /product/ - Return a json with list of products
  - [ ] GET /product/:id - Return product by id
  - [ ] POST /product/ - Insert new product
  - [ ] PUT /product/:id - Edit product by id
  - [ ] DELETE /product/:id - Delete product by id
 - [ ] Config Datomic

## Database

Create database

```sql
create database clojure_api_rest;
```

Create table `product`

```sql
CREATE TABLE `product` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(55) NOT NULL,
 `description` text NOT NULL,
 PRIMARY KEY (`id`)
);
```
