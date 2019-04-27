<?php 
session_start();
include_once 'dbvar.php';
include 'header.php';

$name;
$email;
$major;
$bio;

if (isset($_POST['profileid'])) {
	$userinfo = getUserRowFromSelector($cc, "userid", $_['userid']);
	
	$name = $userinfo[$NAME];
	$email = $userinfo[$NAME];
	$major = $userinfo[$MAJOR];
	$bio = $userinfo[$BIO];
	
} else {
	$name = $_SESSION['name'];
	$email = $_SESSION['email'];
	$major = $_SESSION['major'];
	$bio = $_SESSION['bio'];
}
?>
			<div id="profile">
				<div id="about">
					<div id="pic">
						<img>
						<div id="quick-icons">
							<img class="profile-pic" src="harryProfile.jpg" alt="Profile picture" height="200px" width="200px">
						</div>
					</div>
					<div id="summary">
						<h1><?= $name; ?></h1>
						<p><?= $major; ?></p>
						<p><?= $bio; ?></p>
						<?php if (!isset($_POST['profileid'])) {
								echo "<form action='editProfile.php'>
									  <button type='submit'>Edit Profile</button>
									  </form>";
							}
						?>
					</div>
				</div>
				<div id="feed">
					<p>Pretending there's a feed</p>
					<p>Yup totally a feed</p>
				</div>
			</div>
<?php include 'footer.php'; ?>