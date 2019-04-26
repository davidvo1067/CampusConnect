<!DOCTYPE html>
<html>
	<head>
		<title>Connection Test</title>
	</head>
	<body>
		<div>
					
			<?php

			$mysqli_connection = new MySQLi('vergil.u.washington.edu', 'root', 'frickU2', 'cc', 5624);
			if($mysqli_connection->connect_error){
			   echo "Not connected, error: ".$mysqli_connection->connect_error;
			}
			else{
			   echo "Connected.";
			}

			?>
			
		</div>
	</body>
</html>
