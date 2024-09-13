const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
  	//리액트에서 /spring/test로 요청하면 스프링에서는 /test로 맵핑
    '/spring', 
    createProxyMiddleware({
      target: 'http://localhost:8080/spring3',	//스프링 포트
      changeOrigin: true,
    })
  );
};