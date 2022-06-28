
 SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
 START TRANSACTION;
 SET time_zone = "+00:00";


 /*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
 /*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
 /*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 /*!40101 SET NAMES utf8mb4 */;



 -- --------------------------------------------------------


 CREATE TABLE `category` (
 `category_id` int(11) NOT NULL,
 `name` varchar(255) DEFAULT NULL
);


 INSERT INTO `category` (`category_id`, `name`) VALUES
 (1, 'Meals'),
 (2, 'Dessert'),
 (3, 'Drinks');

 -- --------------------------------------------------------



 -- --------------------------------------------------------


 CREATE TABLE `product` (
`id` int(11) NOT NULL,
`description` varchar(255) DEFAULT NULL,
`image_name` varchar(255) DEFAULT NULL,
`name` varchar(255) DEFAULT NULL,
`price` double NOT NULL,
`category_id` int(11) DEFAULT NULL
);


 INSERT INTO `product` (`id`, `description`, `image_name`, `name`, `price`, `category_id`) VALUES
 (1, 'A delicious plate of salmon paired with our famous, somali rendition of pasta.', 'salmon.jpg', 'salmon', 22.99, 1),
 (2, 'Philly steak marinated in a house blend of spices', 'philly.jpg', 'philly steak', 13.99, 1),
 (3, 'T-bone steak served on a bed of rice', 'ricetbone.jpg', 't-bone & rice', 26.99, 1),
 (4, 'fresh, handmade, flaky flat bread', 'japati.jpg', 'japati', 2.99, 2),
 (9, 'deep fried, ground beef filled triangles', 'backgroud.jpg', 'sambuus', 2.99, 2),
 (10, 'mango juice', 'mango.jpg', 'mango juice', 0.99, 3);

 -- --------------------------------------------------------


 CREATE TABLE `roles` (
`id` int(11) NOT NULL,
`name` varchar(255) NOT NULL
 );



 INSERT INTO `roles` (`id`, `name`) VALUES
 (1, 'ROLE_ADMIN'),
 (2, 'ROLE_USER');

 -- --------------------------------------------------------


 CREATE TABLE `users` (
`id` int(11) NOT NULL,
`email` varchar(255) NOT NULL,
`first_name` varchar(255) NOT NULL,
`last_name` varchar(255) DEFAULT NULL,
`password` varchar(255) DEFAULT NULL
) ;



 INSERT INTO `users` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
 (1, 'test@test', 'test', 'test', 'test');
 -- --------------------------------------------------------


 CREATE TABLE `user_role` (
                                `user_id` int(11) NOT NULL,
                                `role_id` int(11) NOT NULL
                                    ) ;

 INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
 (1, 1);


 ALTER TABLE `category`
     ADD PRIMARY KEY (`category_id`);


 ALTER TABLE `product`
     ADD PRIMARY KEY (`id`),
     ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);


 ALTER TABLE `roles`
     ADD PRIMARY KEY (`id`),
     ADD UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`) USING HASH;


 ALTER TABLE `users`
     ADD PRIMARY KEY (`id`),
     ADD UNIQUE KEY `UK` (`email`) USING HASH;


 ALTER TABLE `user_role`
     ADD KEY `FK` (`role_id`),
     ADD KEY `FK` (`user_id`);



 ALTER TABLE `category`
     MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
 COMMIT;

 /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
 /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
 /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
