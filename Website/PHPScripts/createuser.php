<?php
//verifies new user gave good info and then registers new user if so

if (!isset($_POST['email'])) {
	echo "No data";
	exit();
} 

include 'dbvar.php';

$cc = connectToCC();
if($cc -> connect_error){
   echo "Not connected, error: ".$cc -> connect_error;
   exit();
}

$email =$_POST['email'];
$pass = password_hash($_POST['password'], PASSWORD_DEFAULT);
$studentid = $_POST['studentid'];
$name = $_POST['name'];
$major = isset($_POST['major']) ? $_POST['major'] : "";

$insertsql = "INSERT INTO user (studentid, name, email, password, major, bio)
VALUES ($studentid, '$name', '$email', '$pass', '$major', '');";

if ($cc -> query($insertsql) == FALSE) {
	echo "Error: " . $insertsql . "<br>" . $cc -> error;
	$cc -> close();
	exit();
}

$cc -> close();

header("Location: ../Content/login.php");
exit();
?>