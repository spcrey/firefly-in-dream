import axios from "axios";

const baseURL = "http://localhost:9000";
const instance = axios.create({baseURL})

instance.interceptors.response.use(
    result=>{
        console.log(result);
        return result.data;
    },
    err=>{
        alert("service error");
        return Promise.reject(err)
    }
)

export default instance;
