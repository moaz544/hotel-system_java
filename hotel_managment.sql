-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12 يونيو 2020 الساعة 23:52
-- إصدار الخادم: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_managment`
--

-- --------------------------------------------------------

--
-- بنية الجدول `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `client`
--

INSERT INTO `client` (`id`, `user_name`, `password`) VALUES
(1, 'm', 'm'),
(2, 'a', 'a');

-- --------------------------------------------------------

--
-- بنية الجدول `reservations`
--

CREATE TABLE `reservations` (
  `id` int(15) NOT NULL,
  `resident_id` int(11) NOT NULL,
  `room_number` int(15) NOT NULL,
  `date_in` date NOT NULL,
  `date_Out` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `reservations`
--

INSERT INTO `reservations` (`id`, `resident_id`, `room_number`, `date_in`, `date_Out`) VALUES
(22, 10, 21, '2020-06-07', '2020-06-08'),
(23, 12, 11, '2020-06-09', '2020-06-10'),
(24, 11, 210, '2020-06-09', '2020-06-10'),
(26, 10, 11, '2020-08-12', '2020-11-17'),
(29, 13, 210, '2020-08-03', '2020-10-12'),
(30, 13, 11, '2020-07-07', '2020-11-23'),
(31, 13, 11, '2020-09-08', '2020-12-14'),
(32, 13, 11, '2020-07-21', '2020-12-21'),
(33, 13, 210, '2020-09-08', '2020-11-11'),
(34, 13, 21, '2020-07-06', '2020-09-16'),
(35, 13, 21, '2020-08-04', '2020-09-01'),
(36, 13, 21, '2020-06-19', '2020-06-26');

-- --------------------------------------------------------

--
-- بنية الجدول `resident`
--

CREATE TABLE `resident` (
  `id` int(11) NOT NULL,
  `FName` varchar(100) NOT NULL,
  `LName` varchar(100) NOT NULL,
  `PhoneNo` varchar(11) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `pass` varchar(10) NOT NULL,
  `numroom` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `resident`
--

INSERT INTO `resident` (`id`, `FName`, `LName`, `PhoneNo`, `Email`, `pass`, `numroom`) VALUES
(10, 'moham', 'samy', '01118945712', 'NMJJ@mail.com', '0', 0),
(11, 'mohand', 'sagy', '11118945712', 'NMJJ@mail.com', '0', 0),
(12, 'mooaa', 'sagy', '11118945712', 'NMJJ@mail.com', '0', 1),
(13, 'sagy', 'mooaa', '11118945712', 'a', '0', 0);

-- --------------------------------------------------------

--
-- بنية الجدول `rooms`
--

CREATE TABLE `rooms` (
  `r_number` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `reserved` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `rooms`
--

INSERT INTO `rooms` (`r_number`, `type`, `phone`, `reserved`) VALUES
(11, 1, '0118961998', 'yes'),
(21, 1, '555555555', 'No'),
(210, 1, '11111111111', 'yes');

-- --------------------------------------------------------

--
-- بنية الجدول `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `label` varchar(100) NOT NULL,
  `price` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `type`
--

INSERT INTO `type` (`id`, `label`, `price`) VALUES
(1, 'Single', '300'),
(2, 'Double', '500'),
(3, 'Trible', '700'),
(4, 'Family', '1000'),
(5, 'Suite', '650');

-- --------------------------------------------------------

--
-- بنية الجدول `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `users`
--

INSERT INTO `users` (`id`, `user_name`, `password`) VALUES
(1, '1', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_resident_id` (`resident_id`),
  ADD KEY `fk_room_number` (`room_number`);

--
-- Indexes for table `resident`
--
ALTER TABLE `resident`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`r_number`),
  ADD KEY `fk_type_number` (`type`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `resident`
--
ALTER TABLE `resident`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- قيود الجداول المحفوظة
--

--
-- القيود للجدول `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `fk_resident_id` FOREIGN KEY (`resident_id`) REFERENCES `resident` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_room_number` FOREIGN KEY (`room_number`) REFERENCES `rooms` (`r_number`) ON DELETE CASCADE;

--
-- القيود للجدول `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `fk_type_id` FOREIGN KEY (`type`) REFERENCES `type` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_type_number` FOREIGN KEY (`type`) REFERENCES `type` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
