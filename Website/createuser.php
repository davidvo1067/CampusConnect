<?php

if (!isset($_POST['email'])) {
	echo "No data";
	exit;
} 

include 'dbvar.php';


//session_start();

$cc = connectToCC();
if($cc -> connect_error){
   echo "Not connected, error: ".$cc -> connect_error;
   exit;
}

$email =$_POST['email'];
$pass = $_POST['password'];
$studentid = $_POST['studentid'];
$name = $_POST['name'];
$major = $_POST['major'];

$insertsql = "INSERT INTO user (studentid, name, email, password, major)
VALUES ($studentid, '$name', '$email', '$pass', '$major');";

if ($cc -> query($insertsql) == FALSE) {
	echo "Error: " . $insertsql . "<br>" . $cc -> error;
	$cc -> close();
	exit;
}

echo "now we gotta do session start stuff";


$cc -> close();

?>