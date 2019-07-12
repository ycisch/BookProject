# BookProject

小组阶段项目<br>
:key:

:man_student:<strong>学生的书海世界</strong>:school:

:+1:<strong>基于jsp+servlet+css+html+js</strong>

### 目录<br>

项目结构

```
│  .gitattributes
│  LICENSE
│  README.md
│
├─database file
│      bookshop.sql
│
├─demonstration_picture
│      SMS-ClassInfo-view.PNG
│      SMS-GradeInfo-view.PNG
│      SMS-Login-view.PNG
│      SMS-ModifyPwd-view.PNG
│      SMS-Student-permission.PNG
│      SMS-StudentInfo-view.PNG
│      SMS-Teacher-permission.PNG
│      SMS-TeacherInfo-view.PNG
│      SSM-AdminInfo-view.PNG
│      SSM-Main-view.PNG
│
└─src
|    │  
|    │
|    └─com
|        └─nuc
|            ├─dao
|            |	└─impl
|            |		 |	AdminDaoImpl.java
|            |		 |	BookDaoImpl.java
|            |		 |	OrderDaoImpl.java
|            |		 |	ShopDaoImpl.java
|            |		 |	UserDaoImpl.java
|            |	AdminDao.java
|            |	BookDao.java	
|            |	OrderDao.java
|            |	ShopDao.java
|            |	UserDao.java
|            |
|            ├─entiy
|            |	Admin
|            |	Book
|            |	Order
|            |	Shop
|            |	Style
|            |	User
|            |
|            ├─Listener
|            |
|            ├─service
|            |	└─impl
|            |		 |	AdminServiceImpl.java
|            |		 |	BookServiceImpl.java
|            |		 |	OrderServiceImpl.java
|            |		 |	ShopServiceImpl.java
|            |		 |	UserServiceImpl.java
|            |	AdminService.java
|            |	BookService.java	
|            |	OrderService.java
|            |	ShopService.java
|            |	UserService.java
|            |
|            ├─servlet
|            |	AdminServlet
|            |	BookServlet
|            |	OrderServlet
|            |	ShopServlet
|            |	UserServlet
|            |
|            ├─util
|            |	BaseDao
|            |	DatabaseUtil
|            |	FileUpload
|            |	MD5Tools
└─web
	├─admin
	|	  admin.jsp
	|─static
	|	  ├─css	
    |	  |		省略
	|	  ├─img	
	|	  |		省略
	|	  ├─js	
	|	  |		省略
	├─system
	|	  login.jsp
	|	  menu.jsp
	|	  regist.jsp
	├─upload
	|	  省略
	├─WEB-INF
	|	  web.xml

```