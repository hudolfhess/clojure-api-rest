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
 - [ ] Config a database connection (MySQL)
 - [ ] Making routes (using database)
  - [ ] GET - Retuns a json with list of something
  - [ ] GET/:id - Return something by id
  - [ ] POST - Insert something
  - [ ] PUT/:id - Edit something
  - [ ] DELETE/:id - Delete Something
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
)
```
