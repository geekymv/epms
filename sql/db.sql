create database epms;

/*员工类型：实习，试用，正式员工*/
create table t_emp_types(
	etid_ int primary key auto_increment,
	name_ varchar(20) unique not null
);

/*职位:程序员，项目经理， 部门经理*/
create table t_job_types(
	jtid_ int primary key auto_increment,
	name_ varchar(20) unique not null,
	authority int
);

/*员工*/
create table t_employees(
	empid_ int primary key auto_increment,
	empnum_ varchar(20) unique not null,	/*员工编号*/ 
	password_ varchar(30), /*密码*/
	name_ varchar(20) not null, /*名称*/
	gender_ varchar(5), /*性别*/
	birthday_ date, /*生日*/
	phone_ varchar(20), /*电话号码*/
	email_ varchar(30), /*电子邮箱*/
	address_ varchar(60), /*居住地址*/
	jobtype_ int,/*职位*/
	emptype_ int, /*员工类型*/
	hiredate_ date, /*入职时间*/
	description_ varchar(60),
	
	foreign key(jobtype_) references t_job_types(jtid_),
	foreign key(emptype_) references t_emp_types(etid_)
);

/*客户*/
create table t_customers(
	cusid_ int primary key auto_increment,
	name_ varchar(20), /*公司名称*/
	contacts_ varchar(20), /*联系人*/
	phone_ varchar(20), /*联系电话*/
	address_ varchar(30), /*联系地址*/
	background_ varchar(60), /*公司背景*/
	addtime_ datetime, /*添加时间*/
  	remarks_ varchar(30) /*备注*/
);

/*任务*/
create table t_tasks(
	tasid_ int primary key auto_increment,
	title_ varchar(30) not null, /*任务标题*/
	period_ varchar(10), /*工期*/
	creator_ int, /*任务创建者(发送者)*/
	createtime_ date, /*创建时间*/
	executor_ int, /*任务执行人*/
	starttime_ date, /*计划开始时间*/
	endtime_ date, /*计划结束时间*/
	priority_ varchar(10), /*优先级*/
	explain_ varchar(60), /*任务说明*/
	status_ varchar(10), /*状态*/
	
	foreign key(creator_) references t_employees(empid_),
	foreign key(executor_) references t_employees(empid_)
);

/*项目*/
create table t_projects(
	proid_ int primary key auto_increment,
	name_ varchar(30), /*项目名称*/
	cusid int, /*客户(所属单位)*/
	empid int, /*项目经理*/
	devenum_ int, /*开发人数*/
	setupdate_ date,	/*立项时间*/
	startdate_ date,	/*开始时间*/
	actual_devdate_ date, /*实际开发日期*/
	actual_findate_ date, /*实际完成日期*/
	updatetime_ date, /*更新时间*/
	money varchar(10), /*项目总金额*/
	actual_costs_ varchar(10), /*实际总成本*/
	
	priority_ varchar(10), /*优先级*/
	status_ varchar(10), /*完成状态*/
	remarks_ varchar(30), /*备注*/
	
	foreign key(cusid) references t_customers(cusid_),
	foreign key(empid) references t_employees(empid_)
);

/*项目需求*/
create table t_requirements(
	reqid_ int primary key auto_increment,
	title_ varchar(30), /*需求标题*/
	projectid_ int, /*所属项目*/
	createtime_ date, /*创建时间*/
	updatetime_ date, /*更新时间*/
	remarks_ varchar(30), /*备注*/
	description_ varchar(60), /*需求描述*/
	
	foreign key(projectid_) references t_projects(proid_)
);

/*一个需求可以有多个模块*/
/*模块*/
create table t_modules(
	modid_ int primary key auto_increment,
	name_ varchar(30), /*模块名称*/
	reqid_ int, /*所属需求*/
	createtime_ date, /*创建时间*/
	priority_ varchar(10), /*优先级*/
	description_ varchar(60), /*模块描述*/
	
	foreign key(reqid_) references t_requirements(reqid_)
);


	select * from t_employees e, t_job_types jt, t_emp_types et 
		where jt.jtid_=e.jobtype_ and et.etid_=e.emptype_ and e.empid_=1;

