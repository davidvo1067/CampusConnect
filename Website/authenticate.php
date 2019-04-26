<?php

if ( !isset($_POST['email'], $_POST['password']) ) {
	echo "Error: No email or username.";
	exit;
}

session_start();

include 'dbvar.php';

$cc = connectToCC();
if ( mysqli_connect_errno() ) {
   echo "Not connected, error: ".$cc -> connect_error;
   exit;
}

$checkforusersql = "SELECT * FROM user WHERE email = '" . $_POST['email'] . "'";
$result =  $cc -> query($checkforusersql);

if ($result == FALSE) {
	echo "Incorrect email.";
	exit();
}

$userinfo = mysqli_fetch_row($result); 
$pass = $userinfo[$PASSWORD]; 

if (!password_verify($_POST['password'], $pass)) {
	echo "Incorrect password.";
	exit();
}


// Create sessions so we know the user is logged in, they basically act like cookies but remember the data on the server.
session_regenerate_id();
$_SESSION['loggedin'] = TRUE;
$_SESSION['userid'] = $userinfo[$USER_ID];
$_SESSION['studentid'] = $userinfo[$STUDENT_ID];
$_SESSION['name'] = $userinfo[$NAME];
$_SESSION['email'] = $userinfo[$EMAIL];
$_SESSION['major'] = $userinfo[$MAJOR];

$cc -> close();
header("Location: profile.php");
die();

?>