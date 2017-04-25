<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Chat</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>

 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</head>
<body>
<style>
body {
	font-size: 13px;
	font-family: Monaco, monospace;
}

.chat {
  height: 200px;
  width: 600px;
  overflow-y: scroll;
  background-color: black;
  border: 3px solid #778899;
  border-radius: 5px;
  color: #FFFFFF;
  font-size: 12px;
  font-weight: normal;
  left: -1px;
  padding: 10px 7px 5px;
}

.chat-sender {
	color: #89BDFF;
}

.chat-recipient {
	color: #65B042;
}

#userList {
	float: left;
	width: 100px;
	height: 254px;
	margin-right: 10px;
	overflow-y: scroll;
  overflox-x: scroll;
  border: 3px solid #6495ED;
  border-radius: 5px;
}

.chat-container {
	position: relative;
	float: left;
}

.chat-input {
	bottom: 0;
	float: left;
	border-radius: 5px;
	border: 3px solid #9932CC;
	outline: none;
}

.chat-submit {
  bottom: 0;
  height: 34px;
  width: 60px;
  float: right;
  margin-top: 2px;
  background-color: #f38709;
  border: 3px solid #f38709;
  border-radius: 5px;
  font-family: Helvetica, Verdana, sans-serif;
  font-size: 13px;
  font-weight: bold;
  color: white;
}

#users {
	height: 200%;
	width: 100%;
	overflow: auto;
	border: 0px;
}

.user-selected {
	background-color: #6495ED;
	color: white;
}

.user-unselected {
	background-color: white;
  color: black;
}

.newmessage {
	float: right;
	font-size: 20px;
	line-height: 70%;
}

</style>
  <div>
    <div id="userList">
    </div>
  </div>
  <script type="text/javascript">
      var stompClient = null;
      var socket = null;
      var whoami = null;
      
      function connect() {
        socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect('', '', function(frame) {
          whoami = frame.headers['user-name'];
          console.log('Connected: ' + frame);
          stompClient.subscribe('/user/queue/messages', function(message) {
            showMessage(JSON.parse(message.body));
          });
          stompClient.subscribe('/topic/active', function(activeMembers) {
            showActive(activeMembers);
          });
        });
      }
      
      function showActive(activeMembers) {
        renderActive(activeMembers.body);
        stompClient.send('/app/activeUsers', {}, '');
      }
      
      function renderActive(activeMembers) {
        var previouslySelected = $('.user-selected').text();
        var usersWithPendingMessages = new Object();
        $.each($('.pending-messages'), function(index, value) {
          usersWithPendingMessages[value.id.substring(5)] = true; // strip the user-
        });
        var members = $.parseJSON(activeMembers);
        var userDiv = $('<div>', {id: 'users'});
        $.each(members, function(index, value) {
          if (value === whoami) {
            return true;
          }
          var userLine = $('<div>', {id: 'user-' + value});
          userLine.addClass('user-entry');
          if (previouslySelected === value) {
            userLine.addClass('user-selected');
          }
          else {
            userLine.addClass('user-unselected');
          }
          var userNameDisplay = $('<span>');
          userNameDisplay.html(value);
          userLine.append(userNameDisplay);
          userLine.click(function() {
            var foo = this;
            $('.chat-container').hide();
            $('.user-entry').removeClass('user-selected');
            $('.user-entry').addClass('user-unselected');
            userLine.removeClass('user-unselected');
            userLine.removeClass('pending-messages');
            userLine.addClass('user-selected');
            userLine.children('.newmessage').remove();
            var chatWindow = getChatWindow(value);
            chatWindow.show();
          });
          if (value in usersWithPendingMessages) {
            userLine.append(newMessageIcon());
            userLine.addClass('pending-messages');
          }
          userDiv.append(userLine);
        });
        $('#userList').html(userDiv);
      }
      
      function disconnect() {
        stompClient.disconnect();
        console.log("Disconnected");
      }

      function sendMessageTo(user) {
        var chatInput = '#input-chat-' + user;
        var message = $(chatInput).val();
        if (!message.length) {
          return;
        }
        stompClient.send("/app/chat", {}, JSON.stringify({
          'recipient': user,
          'message' : message
        }));
        $(chatInput).val('');
        $(chatInput).focus();
      }
      
      function getChatWindow(userName) {
        var existingChats = $('.chat-container');
        var elementId = 'chat-' + userName.substring(0, 4);
        var containerId = elementId + '-container';
        var selector = '#' + containerId;
        var inputId = 'input-' + elementId;
        if (!$(selector).length) {
          var chatContainer = $('<div>', {id: containerId, class: 'chat-container'});
          var chatWindow = $('<div>', {id: elementId, class: 'chat'});
          var chatInput = $('<textarea>', {id: inputId, type: 'text', class: 'chat-input', rows: '2', cols: '75', 
            placeholder: 'Enter a message'});
          var chatSubmit = $('<button>', {id: 'submit-' + elementId, type: 'submit', class: 'chat-submit'})
          chatSubmit.html('Send');
          
          chatInput.keypress(function(event) {
            if (event.which == 13) {
              var user = event.currentTarget.id.substring(11); // gets rid of 'input-chat-'
              event.preventDefault();
              sendMessageTo(user);
            }
          });
          
          chatSubmit.click(function(event) {
            var user = event.currentTarget.id.substring(12); // gets rid of 'submit-chat-'
            sendMessageTo(user);
          });
          
          chatContainer.append(chatWindow);
          chatContainer.append(chatInput);
          chatContainer.append(chatSubmit);
          
          if (existingChats.length) {
            chatContainer.hide();
          }
          
          $('body').append(chatContainer);
        }
        return $(selector);
      }
      
      function showMessage(message) {
        var chatWindowTarget = (message.recipient === whoami) ? message.sender : message.recipient;
        var chatContainer = getChatWindow(chatWindowTarget);
        var chatWindow = chatContainer.children('.chat');
        var userDisplay = $('<span>', {class: (message.sender === whoami ? 'chat-sender' : 'chat-recipient')});
        userDisplay.html(message.sender + ' says: ');
        var messageDisplay = $('<span>');
        messageDisplay.html(message.message);
        chatWindow.append(userDisplay).append(messageDisplay).append('<br/>');
        chatWindow.animate({ scrollTop: chatWindow[0].scrollHeight}, 1);
        if (message.sender !== whoami) {
          var sendingUser = $('#user-' + message.sender);
          if (!sendingUser.hasClass('user-selected') && !sendingUser.hasClass('pending-messages')) {
            sendingUser.append(newMessageIcon());
            sendingUser.addClass('pending-messages');
          }
        }
      }
      
      function newMessageIcon() {
        var newMessage = $('<span>', {class: 'newmessage'});
        newMessage.html('&#x2709;');
        return newMessage;
      }
      
      $(document).ready(function() {
          alert("ceva");
        connect();
      });
  </script>
</body>
</html>