async function getTokenFromPage() {
    const response = await fetch("http://localhost:8080/json/token");
    const token = await response.text();
    window.localStorage.setItem("token", token);
}