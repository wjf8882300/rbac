# rbac
权限管理系统

基于spring boot + spring security + thymeleaf + data jpa，session通过spring session存在redis，可以分布式部署。

src/main/resources/static目录可以删除，这个目录的文件是通过src/main/resources/build构建出来的，执行node r.js -o build.js将生成static目录，src/main/resources/src表示原目录，编辑也在这目录编辑。