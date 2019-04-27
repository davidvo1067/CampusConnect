<?php 
session_start();
include_once 'dbvar.php';
include 'header.php';
?>
			<div id="profile">
				<div id="about">
					<div id="pic">
						<img>
						<div id="quick-icons">
							<img class="profile-pic" src="harryProfile.jpg" alt="Profile picture" height="200px" width="200px">
						</div>
					</div>
					<div id="edit">
						<form action="changeuser.php" method="post">
							<table>
								<tr>
									<td><label for="oldpassword">Old Password (Required): </label></td>
									<td><input type="password" name="oldpassword" placeholder="••••••••••" required></td>
								</tr>
								<tr>
									<td><label for="newpassword">New Password: </label></td>
									<td><input type="password" name="newpassword" placeholder="••••••••••"></td>
								</tr>
								<tr>
									<td><label for="email">Email: </label></td>
									<td><input type="email" name="email" value="<?= $_SESSION['email'] ?>"></td>
								</tr>
								<tr>
									<td><label for="name">Name: </label></td>
									<td><input type="text" name="name" value="<?= $_SESSION['name'] ?>" required></td>
								</tr>
								<tr>
									<td><label for="major">Major: </label></td>
									<td><input type="text" name="major" value="<?= $_SESSION['major'] ?>"></td>
								</tr>
								<tr>
									<td><label for="bio">Bio: </label></td>
									<td><textarea name="bio" id="biobox"><?= $_SESSION['bio'] ?></textarea></td>
								</tr>
							</table>
							<br>
							<button type="submit">Change Profile</button>
							</form>
					</div>
				</div>
			</div>
<?php include 'footer.php'; ?>