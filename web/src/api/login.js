import request from "@/util/request.js";

export function userLogin(username, password){
    const url = "/user/login";
    const data = {
        username: username.value,
        password: password.value,
    }    
    console.log(data);
    const result = request.post("/user/login", data);
    return result;
}