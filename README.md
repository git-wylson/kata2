# kata2
#Bonnes pratiques et découpage en couche*

#http://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/

#http://rostislav-matl.blogspot.fr/2014/05/testing-rest-service-in-spring-boot.html

connect           = require('gulp-connect'),
gulp.task('connect', ['watch'], function() {
	var port = process.argv[4] || '7080';
    
    console.log('===> Input value port : '+process.argv[4]);
    console.log('===> Yes listening on port: '+port);
    
	var proxyMiddleware = require('http-proxy-middleware');
	var options = {
        target: 'http://localhost:'+port,
        ws: true		
    };
	var proxy = proxyMiddleware('/ratkin-web', options);
	connect.server({
		root: 'src/main/web',  
		host: '0.0.0.0',
		port: 3000,
		livereload: true, 
		middleware : function(connect, o) {
			return [ (function() {
				return proxy;
			})()];
		}
	}); 
});

