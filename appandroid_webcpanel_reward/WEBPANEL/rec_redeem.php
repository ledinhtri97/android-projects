<?php

 include_once 'connect_database.php';

if (!empty($_POST)) {
////////////////////////////////////////////////////////////////////////////////////////////////////
$response = array("error" => FALSE);

$username = $_POST['username'];
$ui = $_POST['user_input'];
$dn = $_POST['deviceName'];
$dm = $_POST['deviceMan'];
$gn = $_POST['gift_name'];
$am = $_POST['amount'];
$po = $_POST['points'];
$cd = $_POST['Current_Date'];

  $sql = "insert into Requests (request_from,dev_name,dev_man,gift_name,req_amount,points_used,date,username) values ('$ui','$dn','$dm','$gn','$am','$po','$cd','$username')";
  
  if(mysqli_query($connect,$sql)){
  
		$response["error"] = FALSE;
		$response["error_msg"] = "Redeemed Successfully!";
		echo json_encode($response);
		// echo "Redeemed Successfully!";
		
}
  else{
			$response["error"] = TRUE;
			$response["error_msg"] = "Something's Wrong.. Please Try Again or Update the App !";
			 echo json_encode($response);
			// echo "Something's Wrong.. Please Try Again or Update the App!";

  }




/////////////////////////////////////////////////////////////////////////////////////////////////
} else {
?>

	<h1>404 - Not Found</h1>
No script Kiddies !!
<!--
	<h1>Register</h1> 
	<form action="register.php" method="post"> 
	    name:<br /> 
	    <input type="text" name="name" value="" /> 
	    <br /><br /> 
		email:<br /> 
	    <input type="text" name="email" value="" /> 
	    <br /><br />
		fcm_id:<br /> 
	    <input type="text" name="fcm_id" value="" /> 
	    <br /><br />
	    <input type="submit" value="Register" /> 
	</form>
-->
	<?php
}

?>