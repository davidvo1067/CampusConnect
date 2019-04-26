<?php
include_once 'dbvar.php';

function getBio($userid) {
	$cc = connectToCC();
	if (mysqli_connect_errno() ) {
	   echo "Not connected, error: ".$cc -> connect_error;
	   exit;
	}

	$getbiosql = "SELECT bio FROM userbio WHERE userid = $userid";
	$result =  $cc -> query($getbiosql);
	$cc -> close();

	if ($result == FALSE) {
		return ""; //silent error, no user entry in table
	}

	$row = mysqli_fetch_row($result); 
	return $row[0];
}

?>