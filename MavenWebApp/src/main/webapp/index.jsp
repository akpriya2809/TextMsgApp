<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message Service</title>

<script type="text/javascript" src="index.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>



<link type = "text/css" href="index.css" rel = "stylesheet"></link>
</head>
<body>
	<div style = "background-color:white; padding: 2%;" >
			<span style="margin-left:30%;"><a onclick = "keywordDisplay();">KeyWords</a></span>
				<span style="margin-left:10%;"><a onclick = "SettingsDisplay();">Settings</a></span>
	</div>
	<hr/>
	<div class = "container">
			<div id ="keyword">
				<div style = "margin-bottom: 3%;">Keyword</div>
				
				<div><label>Keyword Text</label></div>
				<div class = "inp_data"><input id = "key" type = "text" /></div>
				
				<div><label>Opt-In Auto Response</label></div>
				<div class = "inp_data"><input  id = "valid" type = "text"/></div>
				
				<div><label>Invalid Keyword Response</label></div>
				<div class = "inp_data"><input id = "invalid"type = "text"/></div>
				
				<input class = "btn" type = "button" value = "Save" style = "color:blue" onclick = "saveKeywordInfo()"></input>
			</div> 
			
			<div id ="settings">
			
			<span class = "left">
				<label>Blast (Entire Opt-In List)</label><br/>
				<label>Message</label><br/>
				<textarea id="txtmessage"></textarea><br/>
				<input class = "btn_send" type = "button" value = "Send" style = "color:blue" onclick ="sendMessages()"></input>
			</span>
			<span class = "right">
				<label>Phone Number</label><br/>
				<span class = "inp_data"><input id = "phone" type = "text" /></span><br/>
				
				<label>Message</label><br/>
				<textarea id="txtmessage_bulk"></textarea><br/>
				<input class = "btn-send" type = "button" value = "Send" style = "color:blue" onclick="sendMessages()"></input>
			</span>
			
			
			</div>
	</div>
	
</body>
</html>