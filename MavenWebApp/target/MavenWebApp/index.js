

window.onload = function() {
	  document.getElementById('settings').style.display = 'none';
	  document.getElementById('keyword').style.display = 'block';
	};

function keywordDisplay() {
	document.getElementById('settings').style.display = 'none';
	  document.getElementById('keyword').style.display = 'block';
}

function SettingsDisplay() {
	  document.getElementById('keyword').style.display = 'none';
	  document.getElementById('settings').style.display = 'block';
	}
function saveKeywordInfo(){
	var keyword_obj = {};
	keyword_obj["key"] = document.getElementById('key').value;
	keyword_obj["valid"] = document.getElementById('valid').value;
	keyword_obj["invalid"] = document.getElementById('invalid').value;
	$.ajax({

	    url : 'http://localhost:8080/MavenWebApp/SimpleDataServlet',
	    type : 'POST',
	    data : keyword_obj,
	    success : function(data) {              
	        console.log('Data: '+data);
	    },
	    error : function(request,error)
	    {
	        console.log("Request: "+JSON.stringify(request));
	    }
	});
	
}
function sendMessages(){
	var request = {};
	request["phone"] = document.getElementById('phone').value;
	request["txtmessage"] = document.getElementById('txtmessage').value;
	request["txtmessage_bulk"] = document.getElementById('txtmessage_bulk').value;
	$.ajax({

	    url : 'http://localhost:8080/MavenWebApp/SendMessages',
	    type : 'POST',
	    data : request,
	    success : function(data) {              
	    	console.log('Data: '+data);
	    },
	    error : function(request,error)
	    {
	    	console.log("Request: "+JSON.stringify(request));
	    }
	});
	
}
