<?php
function connectToCC() {
	$DB_HOST = 'vergil.u.washington.edu';
	$DB_USER = 'root';
	$DB_PASS = 'frickU2';
	$DB_NAME = 'cc';
	$DB_PORT = 5624;
	
	return new MySQLi($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME, $DB_PORT);
}
?>