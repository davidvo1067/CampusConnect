<?php
//given the correct password, updates database on user with user-given info

if (session_status() != PHP_SESSION_ACTIVE) {
	session_start();
}

if (!isset($_POST['oldpassword'])) {
	echo 'No password';
	exit();
}

include 'dbvar.php';

$cc = connectToCC();
$pass = getPassword($cc, $_SESSION['userid']); 

if (!password_verify($_POST['oldpassword'], $pass)) {
	echo 'Wrong password';
	exit();
}
session_regenerate_id();

if (isset($_POST['newpassword'])) {
	updatePassword($cc, $_SESSION['userid'], $_POST['newpassword']);
}

$fields = array("email", "name", "major", "bio");

for ($i = 0; $i < count($fields); $i++) {
	if (isset($_POST[$fields[$i]])) {
		updateUserVar($cc, $_SESSION['userid'], $fields[$i], $_POST[$fields[$i]]);
		$_SESSION[$fields[$i]] = $_POST[$fields[$i]];
	}
}

$cc -> close();

header('Location: ../Content/profile.php');
exit();
?>