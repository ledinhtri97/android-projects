<?php

    /*!
	 * POCKET v1.1
	 *
	 * http://droid.oxywebs.in
	 * droid@oxywebs.com, yash@oxywebs.com
	 *
	 * Copyright 2016 yashDev (http://yash.oxywebs.in/)
 */

	try {

		$sth = $dbo->prepare("CREATE TABLE IF NOT EXISTS tracker (
  id int(255) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  points varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
  date date NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM CHARACTER SET utf8 COLLATE utf8_unicode_ci");

		$sth->execute();
		
		$sth = $dbo->prepare("ALTER TABLE Requests ADD username VARCHAR( 255 ) NOT NULL");

		$sth->execute(); 
		
		$sth = $dbo->prepare("ALTER TABLE Completed ADD username VARCHAR( 255 ) NOT NULL");

		$sth->execute(); 
		
		$sth = $dbo->prepare("ALTER TABLE users ADD points VARCHAR(255) NOT NULL DEFAULT  '0'");

		$sth->execute(); 
		
		$sth = $dbo->prepare("CREATE TABLE IF NOT EXISTS track_red (
  id int(255) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  points varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
  date varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM CHARACTER SET utf8 COLLATE utf8_unicode_ci");

		$sth->execute();
		

	} catch (Exception $e) {

		die ($e->getMessage());
	}
