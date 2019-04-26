<?php

exit();//prevent rehash

include 'dbvar.php';

$cc = connectToCC();
if($cc -> connect_error){
   echo "Not connected, error: ".$cc -> connect_error;
   exit;
}

$getpasssql = "SELECT password FROM user";
$result = $cc -> query($getpasssql);
if ($result == FALSE) {
	echo "Error: " . $insertsql . "<br>" . $cc -> error;
	$cc -> close();
	exit;
}

while ($row = $result -> fetch_array(MYSQLI_ASSOC)) {
	$pass = $row['password'];
	$hashed = password_hash($pass, PASSWORD_DEFAULT);
	$hashpasssql = "UPDATE user SET password = '$hashed' WHERE password = '$pass'";
	if (($updateResult = $cc -> query($hashpasssql)) == FALSE) {
		echo "Error: " . $hashpasssql. "<br>" . $cc -> error;
		$cc -> close();
		exit;
	}
}

echo "Success!";

$cc -> close();

?>