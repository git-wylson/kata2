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






public class JavaFileCopier {
 
    public JavaFileCopier() {
    }
    public static void main (String[] args)throws Exception
    {
     String in_File="C:/Users/wylson/Desktop/test/1.doc";
     String out_File="C:/Users/wylson/Desktop/test/2.doc";
 
     copier(in_File,out_File);
    }
    private static void copier(String fichier_source, String fichier_dest)throws IOException
    {
     FileInputStream src = new FileInputStream(fichier_source);
    FileOutputStream dest = new FileOutputStream(fichier_dest,true);
    
    FileChannel inChannel = src.getChannel();
    FileChannel outChannel = dest.getChannel();
 
    for (ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
         inChannel.read(buffer) != -1;
         buffer.clear()) {
       buffer.flip();
       while (buffer.hasRemaining()) outChannel.write(buffer);
    }
 
    inChannel.close();
    outChannel.close();
    }
}
