//get token
async function getToken() {
    const getToken = await fetch("http://localhost:8080/json/token");
    return await getToken.text();
}

const token = await getToken();

//checking valid
async function isTokenValid() {
    const getValidRequest = await fetch("http://localhost:8080/json/validate?token=" + token)
    const getValid = await getValidRequest.text();

    if (localStorage.length === 0) {
        console.log("Token is null!")
        setTimeout(function () {window.location.href = "http://localhost:8080/logout"}, 3000)
    } else if (getValid === false) {
        console.log("Token is dont work!")
        setTimeout(async function() {await deleteToken();window.location.href = "http://localhost:8080/logout"}, 3000)
    } else if (getValid === true) {
        window.localStorage.setItem("token", token)
        console.log("Token is work!")
    }
}

function logoutButton() {
    const logoutButton = document.getElementById("logoutButton");
    logoutButton.addEventListener('click', function () {
        console.log("You click logout and you token is removed after 5 seconds")
        setTimeout(async function() {await deleteToken()}, 5000)}
    )
}

async function deleteToken(){
    window.localStorage.removeItem("token")
}
//making method infinity
setInterval(isTokenValid, 50000)