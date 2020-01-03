package com.biz.todo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.repository.ToDoListDao;

@Service("toServiceV1")
public class ToDoServiceV1 implements ToDoService {

	/*
	 * mybatis-context.xml 파일에 다음 bean을 설정해 두면
	 *  
	 * 	<bean class="org.mybatis.spring.mapper.MapperFactoryBean">
	 * 		<property name="mapperInterface">
	 * 			<value>com.biz.todo.repository.ToDoListDao</value>
	 * 		</property>
	 * 		<property name="sqlSessionFactory" ref="sqlSessionFactory"/>
	 * 	</bean>
	 * 
	 * sqlSession을 경유하여 mapper(dao)를 가져오지 않고
	 * 직접 dao를 사용하여 method를 호출할수 있다. 
	 */
	@Autowired
	protected ToDoListDao toDao;
	
	@Override
	public List<ToDoList> selectAll() {
		return toDao.selectAll();
	}

	@Override
	public int insert(ToDoList toDoList) {
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date); // 문자열형 날짜 생성
		String curTime = st.format(date); // 문자열형 시간 생성
		
		/*
		String strTdComp = toDoList.getTd_complete();
		if(strTdComp == null || strTdComp.isEmpty()) {
			toDoList.setTd_complete("N");
		}

		String strTdAlarm = toDoList.getTd_alarm();
		if(strTdAlarm == null || strTdAlarm.isEmpty()) {
			toDoList.setTd_alarm("N");
		}
		*/
		
		// toDoList.setTd_date(curDate);
		// toDoList.setTd_time(curTime);
		
		int ret = toDao.insert(toDoList);
		return ret;
	
	}

	@Override
	public ToDoList findBySeq(long tdSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToDoList> findBySubject(String tdSubject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ToDoList toDolist) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long tdSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int complete(String strSeq,String tdComplete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alarm(String strSeq, String tdAlarm) {
		return 0;
	}

}
