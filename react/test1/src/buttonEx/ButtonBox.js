import { useState } from "react";

/*
버튼 1(현재페이지)/5(최대페이지) 버튼
으로 화면을 구성해서 
이전 버튼을 클릭하면 현재 페이지가 감소하고, 
다음 버튼을 클릭하면 현재 페이지가 증가하도록 작성
1. state 변수 page와 setPage를 추가(초기값 1)
2. 1 대신 page가 화면에 출력되도록 수정
3. 최대 페이지를 변수로 설정(초기값 5)
4. 5대신 최대 페이지가 화면에 출력되도록 수정
5. 이전 버튼 클릭 이벤트를 등록
  - 클릭했을 때 page가 1보다 크면 page를 page-1로 업데이트하고,
	  아니면 page를 최대페이지로 업데이트
6. 다음 버튼 클릭 이벤트를 등록
  - 클릭했을 때 page가 최대 페이지보다 작으면 page를 page+1로 업데이트하고,
	  아니면 page를 1페이지로 업데이트
*/
function ButtonBox(){
	let [page, setPage] = useState(1);
	let maxPage = 5;
	//이전 페이지로
	function prevPage(){
		if(page > 1){
			setPage(page - 1);
		}else{
			setPage(maxPage);
		}
	}
	//다음 페이지로
	function nextPage(){
		if(page < maxPage){
			setPage(page + 1);
		}else{
			setPage(1);
		}
	}
	//amount에 따라 이전 또는 다음 페이지로
	function movePage(amount){
		let currentPage = page + amount;
		if(currentPage == 0){
			currentPage = maxPage;
		}
		if(currentPage == maxPage+1){
			currentPage = 1;
		}
		setPage(currentPage);
	}
	return(
		<div>
			<div>
				<h3>prevPage와 nextPage 함수를 이용</h3>
				<button onClick={prevPage}>&lt;</button>
				<span>
					<span>{page}</span> 
					<span>/</span>
					<span>{maxPage}</span>
				</span>	
				<button onClick={nextPage}>&gt;</button>
			</div>
			<div>
				<h3>movePage 함수를 이용</h3>
				<button onClick={()=>{movePage(-1)}}>&lt;</button>
				<span>
					<span>{page}</span> 
					<span>/</span>
					<span>{maxPage}</span>
				</span>
				<button onClick={()=>{movePage(1)}}>&gt;</button>
			</div>
		</div>
	)
}

export default ButtonBox;