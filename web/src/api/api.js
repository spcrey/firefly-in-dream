import request from "@/util/request.js";

export function getData(){
    return request.get("/");
}
