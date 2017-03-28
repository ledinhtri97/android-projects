<?php

    /*!
	 * POCKET v1.1
	 *
	 * http://droid.oxywebs.in
	 * droid@oxywebs.com, yash@oxywebs.com
	 *
	 * Copyright 2016 yashDev (http://yash.oxywebs.in/)
 */

class api extends db_connect
{
    public function __construct($dbo = NULL)
    {
        parent::__construct($dbo);

    }

    static function printError($error_code, $error_description = "unknown")
    {
        $result = array("error" => true,
                        "error_code" => $error_code,
                        "error_description" => $error_description);

        echo json_encode($result);
        exit;
    }
}
