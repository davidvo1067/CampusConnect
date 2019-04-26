<?php

$USER_ID = 0;
$STUDENT_ID = 1;
$NAME = 2;
$EMAIL = 3;
$PASSWORD = 4;
$MAJOR = 5;

function connectToCC() {
	$DB_HOST = 'vergil.u.washington.edu';
	$DB_USER = 'cc';
	$DB_PASS = 'ccpassword';
	$DB_NAME = 'cc';
	$DB_PORT = 5624;
	
	return new MySQLi($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME, $DB_PORT);
}
?>