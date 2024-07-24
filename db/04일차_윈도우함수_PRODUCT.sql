# ROW_NUMBER : 같이 같더라도 순위를 다르게 부여 
SELECT 
	ROW_NUMBER() OVER(ORDER BY PR_PRICE DESC) 순위, 
    PR_CODE 제품코드,
    PR_NAME 제품명,
    FORMAT(PR_PRICE,0) 가격
FROM 
	PRODUCT;
# RANK : 값이 같으면 순위가 같게, 다음 순위는 연속된 수가 아님
SELECT 
	RANK() OVER(ORDER BY PR_PRICE DESC) 순위, 
    PR_CODE 제품코드,
    PR_NAME 제품명,
    FORMAT(PR_PRICE,0) 가격
FROM 
	PRODUCT;
# DENSE_RANK : 값이 같으면 순위가 같게, 다음 순위는 연속된 수 
SELECT 
	DENSE_RANK() OVER(ORDER BY PR_PRICE DESC) 순위, 
    PR_CODE 제품코드,
    PR_NAME 제품명,
    FORMAT(PR_PRICE,0) 가격
FROM 
	PRODUCT;