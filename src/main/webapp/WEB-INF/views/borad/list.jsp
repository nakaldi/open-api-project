<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
</head>
<body>
    <h1>📋 게시판 목록</h1>

    <button onclick="location.href='/board/write'">글쓰기</button>
    <button onclick="logout()">로그아웃</button>

    <table border="1" style="width: 100%; margin-top: 20px;">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody id="board-list-body">
            </tbody>
    </table>

    <script>
        // 페이지 열리자마자 실행
        window.onload = function() {
            loadBoardList();
        };

        function loadBoardList() {
            fetch('/api/boards')
            .then(res => res.json())
            .then(data => {
                const tbody = document.getElementById('board-list-body');
                tbody.innerHTML = ''; // 초기화

                data.forEach(board => {
                    const row = `
                        <tr>
                            <td>${board.id}</td>
                            <td>${board.title}</td>
                            <td>${board.writerName}</td>
                            <td>${board.createdAt}</td>
                        </tr>
                    `;
                    tbody.innerHTML += row;
                });
            });
        }

        function logout() {
            fetch('/api/logout', { method: 'POST' })
            .then(() => location.href = '/login');
        }
    </script>
</body>
</html>