import requests

BASE_URL = "http://localhost:9000"

import argparse

def get_args():
    parser = argparse.ArgumentParser()
    parser.add_argument("--action", type=str)
    args = parser.parse_args()
    return args

def get_authorization():
    with open("Authorization.cookie", "r") as file:
        Authorization = file.read()
    return Authorization

def register():
    username = input("username: ")
    password = input("password: ")
    re_password = input("confirmed password: ")
    data = {
        "username": username,
        "password": password,
        "rePassword": re_password,
    }
    url = BASE_URL + "/user/register"
    response = requests.post(url, json=data)
    return response

def login():
    url = BASE_URL + "/user/login"
    username = input("username: ")
    password = input("password: ")
    data = {
        "username": username,
        "password": password,
    }
    response = requests.post(url, json=data)
    Authorization = response.json()["data"]
    if Authorization:
        with open("Authorization.cookie", "w") as file:
            file.write(Authorization)
    return response

def info():
    url = BASE_URL + "/user/info"
    with open("Authorization.cookie", "r") as file:
        Authorization = file.read()
    headers = {"Authorization": Authorization}
    response = requests.get(url, headers=headers)
    return response

def update():
    url = BASE_URL + "/user/update"
    nickname = input("nickname: ")
    email = input("email: ")
    data = {}
    if not nickname == "":
        data["nickname"] = nickname
    if not email == "":
        data["email"] = email
    response = requests.post(url, json=data)
    Authorization = response.json()["data"]
    if Authorization:
        with open("Authorization.cookie", "w") as file:
            file.write(Authorization)
    return response

def main():
    args = get_args()
    action_dict = {
        "register": register,
        "login": login,
        "info": info,
        "update": update,
    }
    response = action_dict[args.action]
    result = response()
    if not result == None:
        print(f"status: {result.status_code}")
        text = result.text
        if text=="":
            print("text: None")
        else:
            print(f"text: {text}")

if __name__ == "__main__":
    main()
