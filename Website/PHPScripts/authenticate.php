<?php
//verifies that user put in write info for login and then logs in if correct
if ( !isset($_POST['email'], $_POST['password']) ) {
	echo "Error: No email or username.";
	exit;
}

if (session_status() == PHP_SESSION_ACTIVE) {
	session_destroy();
}
session_start();

include 'dbvar.php';

$cc = connectToCC();

$userinfo = getUserRowFromSelector($cc, "email", $_POST['email']);
$pass = $userinfo[$PASSWORD]; 

if (!password_verify($_POST['password'], $pass)) {
	echo "Incorrect password.";
	exit();
}

session_regenerate_id();
$_SESSION['loggedin'] = TRUE;
$_SESSION['userid'] = $userinfo[$USER_ID];
$_SESSION['studentid'] = $userinfo[$STUDENT_ID];
$_SESSION['name'] = $userinfo[$NAME];
$_SESSION['email'] = $userinfo[$EMAIL];
$_SESSION['major'] = $userinfo[$MAJOR];
$_SESSION['bio'] = $userinfo[$BIO];

$cc -> close();
header("Location: ../Content/profile.php");
die();

?>