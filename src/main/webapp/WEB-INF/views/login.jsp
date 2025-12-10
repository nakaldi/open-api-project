<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>시스템 로그인</title>
    <style>
        body { display: flex; justify-content: center; align-items: center; height: 100vh; background-color: #f5f5f5; }
        .login-container { background: white; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); text-align: center; width: 300px; }
        input { width: 100%; padding: 10px; margin: 10px 0; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <div class="login-container">
        <h2></h2>
        <input type="text" id="username" placeholder="아이디">
        <input type="password" id="password" placeholder="비밀번호">
        <button onclick="login()">로그인</button>
    </div>

    <script>
        function login() {
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;

            // 포스트맨이 보내던 그 JSON 그대로 보냅니다.
            fetch('/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ username: username, password: password })
            })
            .then(response => {
                if (response.ok) {
                    // 성공하면 게시판 메인으로 이동
                    location.href = "/board";
                } else {
                    // 실패하면 에러 메시지 띄우기 (400, 401, 500 등)
                    return response.json().then(data => {
                        alert(data.message || "로그인 실패");
                    });
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert("서버 통신 오류");
            });
        }
    </script>
</body>
</html>