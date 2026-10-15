document.addEventListener("DOMContentLoaded", initApp);
import {verifyLogin} from "./authApi.js";

async function initApp(){
    document.querySelector("#login-form").addEventListener("submit", handleLogin);
}

async function handleLogin(event){
    event.preventDefault();
    const form = new FormData(event.target);
    const username = form.get("username");
    const password = form.get("password");

    const formData = {username, password};
    try{
        const response = await verifyLogin(formData);
        console.log("Login was a success! "+response);
    } catch (error){
        console.log("### Error message: "+error.message+" ### dThere was an error");
    }

}
