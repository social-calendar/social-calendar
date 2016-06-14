#社交日历
##clone项目到本地
1. 安装git
2. 初始化配置git username and email
3. 打开Git Bash命令窗口(如果安装了git，鼠标右键就可以找到Git Bash Here)
	git clone https://github.com/social-calendar/social-calendar.git
4. 克隆完之后，在本地创建dev分支
	git checkout -b dev origin/dev
5. 为确保是在dev分之下修改，每次提交修改前执行
	git checkout dev	
##将修改同步到github
1. 提交修改
	git add -A
	git commit -m "提交说明"
2. 获取远程更改
	git fetch
3. 本地和远程更改合并
	git pull origin dev
4.  上传到github
	git push origin dev	
##前端环境配置
1. 下载安装nodejs
[nodejs下载地址](https://nodejs.org/)
##运行前端代码
1. 安装项目依赖
在项目根目录下打开终端或者命令窗口，运行命令 
	npm install
2. 打开浏览器，输入localhost:1234 查看前端页面
   按F12跳出开发者工具，点击开发者工具左上角的手机图标可以看到手机上的模拟页面
