<h2>CRUD spring boot application</h2>

<p>Database name : student_record </p>


<p>sql syntax for the table used </p>

```mysql
    CREATE TABLE `students` (
       `id` int(6) NOT NULL AUTO_INCREMENT,
       `name` varchar(50) NOT NULL,
       `email` varchar(50) NOT NULL,
       `age` int(6) NOT NULL,
       `address` varchar(50) NOT NULL,
       `contact` varchar(50) NOT NULL,
       PRIMARY KEY (`id`)
       ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

```