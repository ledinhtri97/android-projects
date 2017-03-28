<?php

include 'connect.inc.php'; 

	$query = "SELECT * FROM users";
	
	$stmt = $db->query($query);
	
	$target_path = 'uploads/';

if (!empty($_POST)) {

	$response = array("error" => FALSE);
	
	function send_gcm_notify($reg_id, $title, $message, $img_url, $tag) {
	
		define("GOOGLE_API_KEY", "AIzaSyAv23NYMxosFEZdEF7kkWxs2Dv_FwdOGqo");

		define("GOOGLE_GCM_URL", "https://fcm.googleapis.com/fcm/send");
	
        $fields = array(
            
			'to'  						=> $reg_id ,
			'priority'					=> "high",
            'notification'              => array( "title" => $title, "body" => $message, "tag" => $tag ),
			'data'						=> array("title" =>$title, "message" =>$message, "image"=> $img_url),
        );
		
        $headers = array(
			GOOGLE_GCM_URL,
			'Content-Type: application/json',
            'Authorization: key=' . GOOGLE_API_KEY 
        );
		
		echo "<br>";

        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, GOOGLE_GCM_URL);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
		
        $result = curl_exec($ch);
        if ($result === FALSE) {
            die('Problem occurred: ' . curl_error($ch));
        }
		
        curl_close($ch);
       // echo $result;
    }
	
    $reg_id = $_POST['fcm_id'];
$title = $_POST['title'];
    $msg = $_POST['msg'];
	$img_url = '';
	$tag = 'text';
	if ($_FILES['image']['name'] != '') {
	
		$tag = 'image';
		$target_file = $target_path . basename($_FILES['image']['name']);
		$img_url = 'http://dev.oxywebs.in/fcm/'.$target_file;
			try {
			// Throws exception incase file is not being moved
			if (!move_uploaded_file($_FILES['image']['tmp_name'], $target_file)) {
				// make error flag true
				//echo json_encode(array('status'=>'fail', 'message'=>'could not move file'));
			}
 
			// File successfully uploaded
			//echo json_encode(array('status'=>'success', 'message'=> $img_url));
		} catch (Exception $e) {
			// Exception occurred. Make error flag true
			//echo json_encode(array('status'=>'fail', 'message'=>$e->getMessage()));
		}
		
		send_gcm_notify($reg_id, $title, $msg, $img_url, $tag);
		
	} else {
		
		send_gcm_notify($reg_id, $title, $msg, $img_url, $tag);
	}

        header("Location: ../push.php");
	
}

        header("Location: ../push.php");
?>