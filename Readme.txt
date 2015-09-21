gradle clean
gradle build
gradle tomcatRunWar

.idea和.settings分别是intelliJ和eclipse的相关依赖。build目录是class文件输出路径，这一点默认和eclipse是一样的。out目录是所谓artifact输出路径，即提供给tomcat的web程序目录，具体的web根目录就是下级的web_test_Web_explorded。接着下面就是src和WebContent两个开发目录也很常规。

那么，当你点击运行tomcat时，在默认设置下，就开始做以下事情


1、编译， intelliJ在保存/自动保存后不会做编译，不像eclipse的保存即编译，因此在运行server前会做一次编译。图标是一个含有00 01 10字样的，非常形象。编译后class文件存放在build目录下。
2、创建Artifact目录结构
3、拷贝web根目录（WebContent）下的所有文件到out/artifacts/web_test_Web_explorded/下,即artifact目录下
4、拷贝build下的classes目录到artifact下的WEB-INF下
5、拷贝lib目录下所需的jar包到artifact下的WEB_INF下
6、运行server，运行成功后，如有需要，会自动打开浏览器访问指定url

String querySql="select * from raw_report;";
            rs=stmt.executeQuery(querySql);

String insertSql ="INSERT raw_report(myname, mysex, myage, mybirthday) VALUES('a', 'a', 'a', 'a');";
            rs=stmt.execute(querySql);


String insertSql ="INSERT raw_report(myname, mysex, myage, mybirthday) VALUES(?, ?, 'a', 'b');";
PreparedStatement pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setString(2, request.getParameter("sex"));
            pstmt.executeUpdate();
