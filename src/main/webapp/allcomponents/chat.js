/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const chatBox = document.getElementById("chat-box");
const messageForm = document.getElementById("message-form");
const messageInput = document.getElementById("message-input");
const sendButton = document.getElementById("send-button");

function getMessages() {
    fetch("ChatServlet")
        .then(response => response.json())
        .then(data => {
            chatBox.innerHTML = data;
            chatBox.scrollTop = chatBox.scrollHeight;
            setTimeout(getMessages, 1000);
        });
}

getMessages();

messageForm.addEventListener("submit", event => {
    event.preventDefault();
    const message = messageInput.value;
    fetch("ChatServlet", {
        method: "POST",
        body: new URLSearchParams({
            message: message
        })
    });
    messageInput.value = "";
});

sendButton.addEventListener("click", () => {
    messageForm.dispatchEvent(new Event("submit"));
});
