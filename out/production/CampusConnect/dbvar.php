<?php

$USER_ID = 0;
$STUDENT_ID = 1;
$NAME = 2;
$EMAIL = 3;
$PASSWORD = 4;
$MAJOR = 5;
$BIO = 6;

function connectToCC() {
	$DB_HOST = 'vergil.u.washington.edu';
	$DB_USER = 'cc';
	$DB_PASS = 'ccpassword';
	$DB_NAME = 'cc';
	$DB_PORT = 5624;
	$cc = new MySQLi($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME, $DB_PORT);
	if ( mysqli_connect_errno() ) {
	   echo "Not connected, error: ".$cc -> connect_error;
	   exit;
	}
	
	return $cc;
}

function safeQuery($cc, $sqlStatement) {
	$result =  $cc -> query($sqlStatement);

	if ($result == FALSE) {
		echo "Error: " . $sqlStatement . "<br>" . $cc -> error;
		$cc -> close();
		exit();
	}
	
	return $result;
}

function getPassword($cc, $userid) {
	$passSql = "SELECT password FROM user WHERE userid = '$userid'";
	return mysqli_fetch_row(safeQuery($cc, $passSql))[0];
}

function updatePassword($cc, $userid, $pass) {
	$hash_pass = password_hash($pass, PASSWORD_DEFAULT);
	updateUserVar($cc, $userid, 'password', $hash_pass);
}

function getUserFromSelector($cc, $selector, $identifier) {
	$checkforusersql = "SELECT * FROM user WHERE $selector = '$identifier'";
	return safeQuery($cc, $checkforusersql);
}

function getUserRowFromSelector($cc, $selector, $identifier) {
	return mysqli_fetch_row(getUserFromSelector($cc, $selector, $identifier));
}

function updateUserVar($cc, $userid, $updateCol, $updateVal) {
	$updateSql = "UPDATE user SET $updateCol = '$updateVal' WHERE userid = $userid";
	safeQuery($cc, $updateSql);
}
?>