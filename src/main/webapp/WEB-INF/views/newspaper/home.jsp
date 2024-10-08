<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
/* 전체 컨테이너 */
.container {
    width: 100%;
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f9f9f9;
}

/* 메인 랩 */
.main_wrap {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
}

/* 날짜 선택 버튼 */
.news-date {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 1.2rem;
    margin-bottom: 20px;
}

.date-btn {
    background-color: #fff;
    border: 1px solid #ccc;
    padding: 10px 15px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.date-btn:hover {
    background-color: #e0e0e0;
}

#selected-date {
    margin: 0 20px;
    font-weight: bold;
}

/* 뉴스 박스 */
.news-container {
    width: 100%;
}

.news-list {
    list-style: none;
    padding: 0;
    margin: 0;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 20px;
}

/* 뉴스 아이템 */
.news-item {
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 8px;
    transition: box-shadow 0.3s;
    height: 238px;
}

.news-item:hover {
    box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
}

.news-heading-box a {
    font-weight: bold;
    color: #333;
    text-decoration: none;
    font-size: 1.1rem;
}

.news-content-box a {
    font-size: 0.9rem;
    color: #666;
    text-decoration: none;
}

.news-heading-box a:hover, .news-content-box a:hover {
    color: #0078ff;
}

.news-box{
	padding: 30px 30px 58px;
}

.news-heading-box{
	padding: 16px 23px 0 0;
}

.news-content-box{
	padding:12px 0 21px;
}

.news-content a {
	/* 한 줄 자르기 */
	display: inline-block;
	width: 490px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	/* 여러 줄 자르기 추가 스타일 */
	white-space: normal;
	line-height: 1.2;
	height: 3.6em;
	font-size: 20px;
	text-align: left;
	word-wrap: break-word;
	display: -webkit-box;
	-webkit-line-clamp: 3;
	-webkit-box-orient: vertical;
}

/* 반응형 디자인 */
@media screen and (max-width: 768px) {
    .news-list {
        grid-template-columns: 1fr;
    }
}
</style>
</head>
<body>
	<h1>뉴스 게시판</h1>
	<div class="container">
	    <div class="main_wrap">
	        <!-- 날짜 선택 버튼 영역 -->
	        <div class="news-date">
	            <button id="prev-date-btn" class="date-btn">◀</button>
	            <span id="selected-date"></span>
	            <button id="next-date-btn" class="date-btn">▶</button>
	        </div>
	        <!-- 뉴스 리스트 박스 -->
	        <div class="news-container">
	            <ul class="news-list">
	                <li class="news-item">
	                	<div class="news-box">
		                    <div class="news-heading-box">
		                        <a href="#">신문사</a>
		                    </div>
		                    <div class="news-content-box">
		                    	<div class="news-title">
		                    		<a href="#" style="font-size: 20px;">헤드라인 제목</a>
		                    	</div>
		                    	<div class="news-content">
			                        <a href="#">헤드라인 내용</a>                   		
		                    	</div>
		                    </div>
	                    </div>
	                </li>
	            </ul>
	        </div>
	    </div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			let today = new Date();
			let currentDate = new Date(today);
			
			$('#selected-date').text(formatDate(currentDate).substr(0,7));
			
			function formatDate(date){
				const year = date.getFullYear();
				const month = (date.getMonth() + 1).toString().padStart(2, '0');
				// 서버에 데이터 형식에 맞추기 위해 추가
				const day = '01';
				const yyyy_mm_dd = `\${year}-\${month}-\${day}`;
				return yyyy_mm_dd;
			} // 날짜를 문자열로 포맷팅
			
			$('#prev-date-btn').click(function(){
				currentDate.setMonth(currentDate.getMonth() - 1);
				update();
			}); // 이전 버튼 클릭 이벤트
			
			$('#next-date-btn').click(function(){
				currentDate.setMonth(currentDate.getMonth() + 1);
				update();
				
			}); // 다음 버튼 클릭 이벤트
			
			function buttonStatus(){
				if(formatDate(currentDate) == formatDate(today)){
					$('#next-date-btn').prop('disabled', true);
				}else{
					$('#next-date-btn').prop('disabled', false);
				}
			} // 현재 월을 넘어가지 못하게 하기위한 함수
			
			function update(){
				$('#selected-date').text(formatDate(currentDate).substr(0,7));
				fetchNews(currentDate);
				buttonStatus();
			} // 날짜, 기사, 버튼 활성화/비활성화를 업데이트 하는 함수
			
			function fetchNews(date){
				let ne_datetime = formatDate(date);
				console.log(ne_datetime);
				let news = {
					ne_datetime : ne_datetime
				}
				$.ajax({
					async : true, // 비동기 : true(비동기), false(동기)
					url : '<c:url value="/newspaper/views" />', 
					type : 'post', 
					data : JSON.stringify(news), 
					contentType : "application/json; charset=utf-8",
					dataType : "json", 
					success : function (data){
						displayNewsList(data.newsList);
					}, 
					error : function(jqXHR, textStatus, errorThrown){
						console.log(jqXHR);
					}
				});
			} // ajax 통신하여 기사를 가져오는 함수
			
			function displayNewsList(list){
				if(list == null || list.length == 0){
					$('.news-list').html('<li class="news-item text-center"><b>발행된 종이 신문이 없거나<br>신문게재 정보가 입력되지 않았습니다.</b></li>');
					return;
				}
				let str = '';
				for(news of list){
					str += `
						<li class="news-item">
		                	<div class="news-box">
			                    <div class="news-heading-box">
			                    	// newspaper/list/{np_num}으로 보내주면됨
			                        <a href="#">\${news.np_name}</a>
			                    </div>
			                    <div class="news-content-box">
			                    	<div class="news-title">
			                    		// newspaper/detail/{ne_num}으로 보내주면 됨
			                    		<a href="#" style="font-size: 20px;">\${news.ne_title}</a>
			                    	</div>
			                    	<div class="news-content">
			                    	    // newspaper/detail/{ne_num}으로 보내주면 됨
				                        <a href="#">\${news.ne_content}</a>                   		
			                    	</div>
			                    </div>
		                    </div>
		                </li>
					`;
				}
				$('.news-list').html(str);
			} // 서버에서 가져온 데이터로 html을 새로 생성하는 함수
			fetchNews(currentDate);
			buttonStatus();
		});
	</script>
</body>
</html>
