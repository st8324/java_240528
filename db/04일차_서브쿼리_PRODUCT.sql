# ANY(SOME), IN, ALL은 서브쿼리와 함께 사용 
# 속성 비교 ANY(값1, 값2, ...), 속성 비교 SOME(값1, 값2, ...)
# 속성 비교 ANY(서브쿼리)
# 값들 중 하나 이상의 값들을 만족할 때 사용 

# 속성 IN(값1, 값2, ...)
# 속성 IN(서브쿼리)
# IN은 = ANY와 같음 
# 속성값이 값1, 값2,... 중에 있으면 참 

# 속성 비교 ALL(값1, 값2, ...) 
# 속성 비교 ALL(서브쿼리)
# 속성값이 모든 값들을 만족할 때 사용 



# 가전 제품들의 가격들보다 비싼 제품들을 조회
# 가장 비싼 가전 제품보다 가격이 비싼 제품인가? ALL
# 가장 싼 가전 제품보다 가격이 비싼 제품인가? ANY
SELECT 
    *
FROM
    PRODUCT
WHERE 
	PR_PRICE > ALL(SELECT PR_PRICE FROM PRODUCT WHERE PR_CA_CODE = 'AB');

# 의류의 가장 싼 제품보다 비싼 제품을 조회하는 쿼리(단, 의류는 CD, 의류 제품은 제외) 
SELECT 
	* 
FROM 
	PRODUCT 
WHERE 
	PR_PRICE > ANY(SELECT PR_PRICE FROM PRODUCT WHERE PR_CA_CODE = 'CD')
    AND PR_CA_CODE != 'CD';
SELECT 
	* 
FROM 
	(SELECT * FROM PRODUCT WHERE PR_CA_CODE != 'CD') PRODUCT2
WHERE 
	PR_PRICE > ANY(SELECT PR_PRICE FROM PRODUCT WHERE PR_CA_CODE = 'CD');

# 가전 제품과 가격이 일치하는 제품들을 조회하는 쿼리(가전 제품은 제외)
SELECT 
    *
FROM
    PRODUCT
WHERE
    PR_PRICE = ANY (SELECT 
            PR_PRICE
        FROM
            PRODUCT
        WHERE
            PR_CA_CODE = 'AB')
	AND PR_CA_CODE != 'AB';
SELECT 
    *
FROM
    PRODUCT
WHERE
    PR_PRICE IN(SELECT 
            PR_PRICE
        FROM
            PRODUCT
        WHERE
            PR_CA_CODE = 'AB')
	AND PR_CA_CODE != 'AB';


