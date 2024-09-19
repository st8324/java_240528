
const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/spring', 
    createProxyMiddleware({
      target: 'http://localhost:8080/spring3',	//스프링 포트
      changeOrigin: true,
    })
  );
};