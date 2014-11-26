package com.epms.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.epms.dao.ProjectDAO;
import com.epms.pojo.Pager;
import com.epms.pojo.Project;
import com.epms.service.ProjectService;
import com.epms.util.MyBatisUtil;

public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO projectDAO;
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	@Override
	public Pager<Project> list(int pageOffset, int pageSize) {
		return null;
	}

	@Override
	public Project query(Integer id) {
		return null;
	}

	@Override
	public int update(Project t) {
		return 0;
	}

	@Override
	public int add(Project project) {
		SqlSession session = MyBatisUtil.getSqlSession();
		ProjectDAO projectDAO = session.getMapper(ProjectDAO.class);
		
		int res = projectDAO.add(project);
		
		session.commit();
		session.close();
		
		return res;
	}

}
