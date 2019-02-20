var stompClient = null;

$(function(){
	$('form').on('submit', function(e){
		e.preventDefault();
	});
	
	$('#connect').click(function(){
		connect();
	});
	
	$('#disconnect').click(function(){
		disconnect();
	});
	
	$('#send').click(function(){
		sendName();
	});
});

function setConnected(connected){
	$('#connect').prop("disabled", connected);
	$('#disconnect').prop('disabled', !connected);
	
	if(connected){
		$('#conversation').show();
	}else {
		$('#conversation').hide();
	}
	
	$('#greetings').html('');
}

function connect(){
	//连接SockJS的endpoint名称为"/yiibai-websocket"
	var socket = new SockJS('/yiibai-websocket');
	//使用STMOP子协议的WebSocket客户端
	stompClient = Stomp.over(socket);
	//连接WebSocket服务端
	stompClient.connect({}, function(frame){
		setConnected(true);
		console.log('Connected: ' + frame);
		//通过stompClient.subscribe订阅/topic/greetings 目标(destination)发送的消息,这个是在控制器的@SentTo中定义的
		stompClient.subscribe('/topic/greetings', function(greeting){
			showGreeting(JSON.parse(greeting.body).content);
		});
	});
}

function disconnect(){
	if(stompClient != null){
		stompClient.disconnect();
	}
	setConnected(false);
	console.log('Disconnect');
}

function sendName(){
	//通过stompClient.send向/hello 目标(destination)发送消息,这个是在控制器的@MessageMapping中定义的
	stompClient.send("/app/hello", {}, JSON.stringify({'name': $('#name').val()}));
}

function showGreeting(message){
	$('#greetings').append("<tr><td>" + message + "</tr></td>");
}