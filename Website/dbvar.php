<?php
function connectToCC() {
	$DB_HOST = 'vergil.u.washington.edu';
	$DB_USER = 'cc';
	$DB_PASS = 'ccpassword';
	$DB_NAME = 'cc';
	$DB_PORT = 5624;
	
	return new MySQLi($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME, $DB_PORT);
}
?>